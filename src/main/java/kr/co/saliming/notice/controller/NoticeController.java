package kr.co.saliming.notice.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.saliming.notice.domain.Notice;
import kr.co.saliming.notice.domain.PageInfo;
import kr.co.saliming.notice.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	@RequestMapping(value = "/notice/insert.do", method = RequestMethod.GET)
	public String showInsertForm() {
		return "help/insert";
	}
	
	@RequestMapping(value = "/notice/insert.do", method = RequestMethod.POST)
	public String insertNotice(@ModelAttribute Notice notice
			, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			// required=false 필수가 아니도록 false 해줌  
			, HttpServletRequest request
			, Model model) {
		try {
			if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
				Map<String, Object> nMap = this.saveFile(uploadFile, request);
				String fileName = (String)nMap.get("fileName");
				String fileRename = (String)nMap.get("fileRename");
				String savePath = (String)nMap.get("filePath");
				long fileLength = (long)nMap.get("fileLength");				
				// DB에 저장하기 위해 notice에 데이터를 Set하는 부분임.
				notice.setNoticeFilename(fileName);
				notice.setNoticeFileRename(fileRename);
				notice.setNoticeFilepath(savePath);
				notice.setNoticeFilelength(fileLength);
			}
			int result = service.insertNotice(notice);
			if(result > 0) {
				
				return "redirect:/notice/list.do";
			} else {
				model.addAttribute("msg", "공지사항 등록이 완료되지 않았습니다.");
				model.addAttribute("error", "공지사항 등록 실패");
				model.addAttribute("url", "/index.jsp");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("error", e.getMessage());
			model.addAttribute("url", "/index.jsp");
			return "common/serviceFailed";
		}
	}
	
	@RequestMapping(value = "/notice/modify.do", method = RequestMethod.POST)
	public String modifyNotice(
			@ModelAttribute Notice notice
			, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			// required=false 필수가 아니도록 false 해줌  
			, HttpServletRequest request
			, Model model
			, RedirectAttributes redirect) {
		try {
			if(uploadFile != null && !uploadFile.isEmpty()) {
				String fileName = notice.getNoticeFileRename();
				if(fileName != null) {
					// 있으면 기존 파일 삭제 
					this.deleteFile(request, fileName);
				}
				// 없으면 새로 업로드 하려는 파일 저장 
				Map<String, Object> infoMap = this.saveFile(uploadFile, request);
				String noticeFilename = (String)infoMap.get("fileName");
				long noticeFilelength = (long)infoMap.get("fileLength");
				String noticeFileRename = (String)infoMap.get("fileRename");
				notice.setNoticeFilename(noticeFilename);
				notice.setNoticeFileRename(noticeFileRename);
				notice.setNoticeFilepath((String)infoMap.get("filePath"));
				notice.setNoticeFilelength(noticeFilelength);				
			}
			int result = service.updateNotice(notice);
			if(result > 0) {
				redirect.addAttribute("noticeNo", notice.getNoticeNo());
				return "redirect:/notice/detail.do";
			} else {
				model.addAttribute("msg", "공지사항 수정이 완료되지 않았습니다.");
				model.addAttribute("error", "공지사항 수정 실패");
				model.addAttribute("url", "/index.jsp");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("error", e.getMessage());
			model.addAttribute("url", "/index.jsp");
			return "common/serviceFailed";
		}
	}
	
	

	@RequestMapping(value = "/notice/delete.do", method = RequestMethod.GET)
	public String deleteNotice(
			@RequestParam("noticeNo") int noticeNo
			, Model model) {
		try {
			int result = service.deleteNotice(noticeNo);
			if(result > 0) {
				return "redirect:/notice/list.do";
			} else {
				model.addAttribute("msg", "공지사항 삭제가 완료되지 않았습니다.");
				model.addAttribute("error", "공지사항 삭제 실패");
				model.addAttribute("url", "/index.jsp");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("error", e.getMessage());
			model.addAttribute("url", "/index.jsp");
			return "common/serviceFailed";
		}
	}

	@RequestMapping(value = "/notice/modify.do", method = RequestMethod.GET)
	public String showModifyNotice(
			@RequestParam("noticeNo") int noticeNo
			, Model model) {
		try {
			Notice notice = service.selectNoticeByNo(noticeNo);
			if(notice != null) {
				model.addAttribute("notice", notice);
				return "help/modify";
			} else {
				model.addAttribute("msg", "데이터 조회가 완료되지 않았습니다.");
				model.addAttribute("error", "데이터 조회 실패");
				model.addAttribute("url", "/index.jsp");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("error", e.getMessage());
			model.addAttribute("url", "/index.jsp");
			return "common/serviceFailed";
		}
	}

	@RequestMapping(value = "/notice/list.do", method = RequestMethod.GET)
	public String showNoticeList(
			@RequestParam(value="page", required=false, defaultValue = "1") Integer currentPage
			, Model model) {
		try {
			int totalCount = service.getListCount();
			PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
			List<Notice> nList = service.selectNoticesList(pInfo);
			if(nList.size() > 0) {
				model.addAttribute("pInfo", pInfo);
				model.addAttribute("nList", nList);
				return "help/list";
			} else {
				model.addAttribute("msg", "데이터 조회가 완료되지 않았습니다.");
				model.addAttribute("error", "공지사항 목록 조회 실패");
				model.addAttribute("url", "/index.jsp");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("error", e.getMessage());
			model.addAttribute("url", "/index.jsp");
			return "common/serviceFailed";
		}
	}
	
	
	public PageInfo getPageInfo(int currentPage, int totalCount) {
		PageInfo pi = null;
		int recordCountPerPage = 10; 
		int naviCountPerPage = 5;
		int naviTotalCount;
		int startNavi;
		int endNavi; 
		
		naviTotalCount = (int)((double)totalCount / recordCountPerPage + 0.9);
		// currentPage값이 1~5일 때 startNavi가 1로 고정되도록 구해주는 식 
		startNavi = (((int)((double)currentPage / naviCountPerPage + 0.9))-1) * naviCountPerPage + 1;
		endNavi = startNavi + naviCountPerPage -1;
		// endNavi는 startNavi에 무조건 naviCountPerPage값을 더하므로 
		// 실제 최대값보다 커질 수 있음 
		if(endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		pi= new PageInfo(currentPage, recordCountPerPage, naviCountPerPage, startNavi, endNavi, totalCount, naviTotalCount);
		return pi;
	}
	
	@RequestMapping(value = "/notice/detail.do", method = RequestMethod.GET)
	public String showDetailNotice(
			@RequestParam("noticeNo") int noticeNo
			, Model model) {
		try {
			Notice notice = service.selectNoticeByNo(noticeNo);
			if(notice != null) {
				model.addAttribute("notice", notice);
				return "help/detail";
			} else {
				model.addAttribute("msg", "데이터 조회가 완료되지 않았습니다.");
				model.addAttribute("error", "공지사항 목록 조회 실패");
				model.addAttribute("url", "/index.jsp");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("error", e.getMessage());
			model.addAttribute("url", "/index.jsp");
			return "common/serviceFailed";
		}
	}
	
	@RequestMapping(value="/notice/search.do", method = RequestMethod.GET)
	public String searchNoticeList(
			@RequestParam("searchCondition") String searchCondition
			, @RequestParam("searchKeyword") String searchKeyword
			, @RequestParam(value="page", required=false, defaultValue="1") Integer currentPage
			, Model model			) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchKeyword", searchKeyword);
		int totalCount = service.getListCount(paramMap);
		PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
		List<Notice> searchList = service.searchNoticesByKeyword(pInfo, paramMap);
		if(!searchList.isEmpty()) {
			model.addAttribute("paramMap", paramMap);
			model.addAttribute("pInfo", pInfo);
			model.addAttribute("sList", searchList);
			return "help/search";
		} else {
			model.addAttribute("msg", "데이터 조회가 완료되지 않았습니다.");
			model.addAttribute("error", "공지사항 제목으로 조회 실패");
			model.addAttribute("url", "/notice/list.kh");
			return "common/errorPage";
		}
	}
	
	
	public Map<String, Object> saveFile(
			MultipartFile uploadFile
			, HttpServletRequest request) throws Exception {
		Map<String, Object> infoMap = new HashMap<String, Object>();
		
		// =================== 파일 이름 ===================
		String fileName = uploadFile.getOriginalFilename();
		// 내가 저장한 후 그 경로를 DB에 저장하도록 준비 
		String root = request.getSession().getServletContext().getRealPath("resources");
		// 폴더 없을 경우 자동 생성(내가 업로드한 파일 저장할 폴더) 
		String saveFolder = root + "\\nuploadFiles";
		File folder = new File(saveFolder); // java.io
		if(!folder.exists()) {
			folder.mkdir();
		}
		// 동일한 이름의 파일 있을 경우 리네임 해주는 코드 추가 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		// 나중에 SS랑 ss 비교 
		String strResult = sdf.format(new Date(System.currentTimeMillis()));
		// 연월일시분초로 파일 이름 쓰려고 만들었음
		String ext = fileName.substring(fileName.lastIndexOf(".")+1); // +1하면 .을 포함하지 않고 자름
		String fileRename = "N" + strResult + "." + ext;
		// =================== 파일 경로 ===================
		String savePath = saveFolder + "\\" + fileRename;
		File file = new File(savePath);
		// ******************** 파일저장 ********************
		uploadFile.transferTo(file);
		// =================== 파일 크기 ===================
		long fileLength = uploadFile.getSize();
		
		// 파일 이름, 경로, 크기를 넘겨주기 위해 Map에 정보를 저장한 후 return 함
		// 왜 return 하는가? DB에 저장하기 위해서 필요한 정보라서
		infoMap.put("fileName", fileName);
		infoMap.put("fileRename", fileRename);
		infoMap.put("filePath", savePath);
		infoMap.put("fileLength", fileLength);
		return infoMap;
	}
	
	
	private void deleteFile(HttpServletRequest request, String fileName) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String delFilepath = root + "\\nuploadFiles\\" + fileName;
		File file = new File(delFilepath);
		if(file.exists()) { // 파일이 존재하는지 확인 
			file.delete(); // 존재하면 삭제 
		}
		
	}
	
	
	
}
