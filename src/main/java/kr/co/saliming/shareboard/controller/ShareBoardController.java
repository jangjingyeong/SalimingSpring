package kr.co.saliming.shareboard.controller;

import java.io.File;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.saliming.shareboard.domain.PageInfo;
import kr.co.saliming.shareboard.domain.Reply;
import kr.co.saliming.shareboard.domain.ShareBoard;
import kr.co.saliming.shareboard.service.ReplyService;
import kr.co.saliming.shareboard.service.ShareBoardService;

@Controller
public class ShareBoardController {
	
	@Autowired
	private ShareBoardService sbService;
	
	@Autowired
	private ReplyService rService;
	
	@RequestMapping(value = "/shareBoard/insert.do", method = RequestMethod.GET)
	public ModelAndView showInsertForm(ModelAndView mv) {
		mv.setViewName("community/insert");
		return mv;
	}
	
	@RequestMapping(value = "/shareBoard/insert.do", method = RequestMethod.POST)
	public ModelAndView insertShareBoard(
			@ModelAttribute ShareBoard shareBoard
			, @RequestParam(value="uploadFile", required = false) MultipartFile uploadFile
			, HttpServletRequest request
			, ModelAndView mv) {
		try {
			if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
				// 파일 정보(이름, 리네임, 경로, 크기) 및 파일 저장 
				Map<String, Object> bMap = this.saveFile(request, uploadFile);
				shareBoard.setBoardFilename((String)bMap.get("fileName"));
				shareBoard.setBoardFileRename((String)bMap.get("fileRename"));
				shareBoard.setBoardFilepath((String)bMap.get("filePath"));
				shareBoard.setBoardFilelength((long)bMap.get("fileLength"));
			}
			int result = sbService.insertShareBoard(shareBoard);
			if(result > 0) {
				mv.setViewName("redirect:/shareBoard/list.do");
			} else {
				mv.addObject("msg", "게시글 등록이 완료되지 않았습니다.");
				mv.addObject("error", "게시글 등록 실패");
				mv.addObject("url", "/shareBoard/insert.do");
				mv.setViewName("common/serviceFailed");
			}
		} catch (Exception e) {
			mv.addObject("msg", "등록이 완료되지 않았습니다.");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", "/shareBoard/insert.do");
			mv.setViewName("common/serviceFailed");
		}
		return mv;
	}
	
	@RequestMapping(value = "/shareBoard/modify.do", method = RequestMethod.GET)
	public String showModifyShareBoard(
			@RequestParam("boardNo") int boardNo
			, Model model) {
		try {
			ShareBoard shareBoard = sbService.selectShareBoardByNo(boardNo);
			if(shareBoard != null) {
				model.addAttribute("shareBoard", shareBoard);
				return "community/modify";
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
	
	@RequestMapping(value = "/shareBoard/modify.do", method = RequestMethod.POST)
	public String modifyShareBoard(
			@ModelAttribute ShareBoard shareBoard
			, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			// required=false 필수가 아니도록 false 해줌  
			, HttpServletRequest request
			, Model model
			, RedirectAttributes redirect) {
		try {
			if(uploadFile != null && !uploadFile.isEmpty()) {
				String fileName = shareBoard.getBoardFileRename();
				if(fileName != null) {
					// 있으면 기존 파일 삭제 
					this.deleteFile(request, fileName);
				}
				// 없으면 새로 업로드 하려는 파일 저장 
				Map<String, Object> infoMap = this.saveFile(request, uploadFile);
				String boardFilename = (String)infoMap.get("fileName");
				long boardFilelength = (long)infoMap.get("fileLength");
				String boardFileRename = (String)infoMap.get("fileRename");
				shareBoard.setBoardFilename(boardFilename);
				shareBoard.setBoardFileRename(boardFileRename);
				shareBoard.setBoardFilepath((String)infoMap.get("filePath"));
				shareBoard.setBoardFilelength(boardFilelength);		
			}
			int result = sbService.updateShareBoard(shareBoard);
			if(result > 0) {
				redirect.addAttribute("boardNo", shareBoard.getBoardNo());
				return "redirect:/shareBoard/detail.do";
			} else {
				model.addAttribute("msg", "게시글 수정이 완료되지 않았습니다.");
				model.addAttribute("error", "게시글 수정 실패");
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
	
	@RequestMapping(value = "/shareBoard/delete.do", method = RequestMethod.GET)
	public String deleteNotice(
			@RequestParam("boardNo") int boardNo
			, Model model) {
		try {
			int result = sbService.deleteShareBoard(boardNo);
			if(result > 0) {
				return "redirect:/shareBoard/list.do";
			} else {
				model.addAttribute("msg", "게시글 삭제가 완료되지 않았습니다.");
				model.addAttribute("error", "게시글 삭제 실패");
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
	
	
	
	@RequestMapping(value = "/shareBoard/list.do", method = RequestMethod.GET)
	public String showNoticeList(
			@RequestParam(value="page", required=false, defaultValue = "1") Integer currentPage
			, Model model) {
		try {
			int totalCount = sbService.getListCount();
			PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
			List<ShareBoard> sbList = sbService.selectShareBoardList(pInfo);
			if(sbList.size() > 0) {
				model.addAttribute("pInfo", pInfo);
				model.addAttribute("sbList", sbList);
				return "community/list";
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
		pi= new PageInfo(currentPage, totalCount, naviTotalCount, recordCountPerPage, naviCountPerPage, startNavi, endNavi);
		return pi;
	}
	
	
	@RequestMapping(value = "/shareBoard/detail.do", method = RequestMethod.GET)
	public ModelAndView showDetailShareBoard(
			@RequestParam("boardNo") Integer boardNo
			, ModelAndView mv) {
		try {
			ShareBoard shareBoard = sbService.selectShareBoardByNo(boardNo);
			if(shareBoard != null) {
				List<Reply> replyList = rService.selectReplyList(boardNo);
				if(replyList.size() > 0) {
					mv.addObject("replyList", replyList);
				}
				mv.addObject("shareBoard", shareBoard);
				mv.setViewName("community/detail");
			} else {
				mv.addObject("msg", "게시글 조회가 완료되지 않았습니다.");
				mv.addObject("error", "게시글 상세 조회 실패");
				mv.addObject("url", "/shareBoard/list.do");
				mv.setViewName("common/serviceFailed");
			}
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의해주세요.");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", "/shareBoard/list.do");
			mv.setViewName("common/serviceFailed");
		}
		return mv;
	}
	
	@RequestMapping(value="/shareBoard/search.do", method = RequestMethod.GET)
	public String searchNoticeList(
			@RequestParam("searchCondition") String searchCondition
			, @RequestParam("searchKeyword") String searchKeyword
			, @RequestParam(value="page", required=false, defaultValue="1") Integer currentPage
			, Model model			) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchKeyword", searchKeyword);
		int totalCount = sbService.getListCount(paramMap);
		PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
		List<ShareBoard> searchList = sbService.searchShareBoardByKeyword(pInfo, paramMap);
		if(!searchList.isEmpty()) {
			model.addAttribute("paramMap", paramMap);
			model.addAttribute("pInfo", pInfo);
			model.addAttribute("sList", searchList);
			return "community/search";
		} else {
			model.addAttribute("msg", "데이터 조회가 완료되지 않았습니다.");
			model.addAttribute("error", "검색 조회 실패");
			model.addAttribute("url", "/shareBoard/list.do");
			return "common/serviceFailed";
		}
	}
	

	private void deleteFile(HttpServletRequest request, String fileName) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String delFilepath = root + "\\sbuploadFiles\\" + fileName;
		File file = new File(delFilepath);
		if(file.exists()) { // 파일이 존재하는지 확인 
			file.delete(); // 존재하면 삭제 
		}
		
	}

	private Map<String, Object> saveFile(HttpServletRequest request, MultipartFile uploadFile) throws Exception {
		Map<String, Object> fileMap = new HashMap<String, Object>();
		// resources 경로 구하기
		String root = request.getSession().getServletContext().getRealPath("resources");
		// 파일 저장 경로 구하기
		String savePath = root + "\\sbuploadFiles";
		// 파일 이름 
		String fileName = uploadFile.getOriginalFilename(); 
		// 파일 확장자 구하기
		String extension = fileName.substring(fileName.lastIndexOf(".")+1);
		// 시간으로 파일 리네임, 리네임을 위한 포맷 만들기 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String fileRename = "SB" + sdf.format(new Date(System.currentTimeMillis())) + "." + extension;
		// 파일 저장 전폴더 만들기 
		File saveFolder = new File(savePath);
		if(!saveFolder.exists()) {
			saveFolder.mkdir();
		}
		// 파일 저장
		File saveFile = new File(savePath+"\\"+fileRename); // 업로드 파일 
		uploadFile.transferTo(saveFile);
		// 파일 크기
		long fileLength = uploadFile.getSize();
		// 파일 정보 리턴
		fileMap.put("fileName", fileName);
		fileMap.put("fileRename", fileRename);
		fileMap.put("filePath", "../resources/sbuploadFiles/"+fileRename);
		fileMap.put("fileLength", fileLength);
		return fileMap;
	}
	
	
	
}
