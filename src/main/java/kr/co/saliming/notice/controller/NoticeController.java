package kr.co.saliming.notice.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.saliming.notice.domain.Notice;
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
			if(!uploadFile.getOriginalFilename().equals("")) {
				// =================== 파일 이름 ===================
				String fileName = uploadFile.getOriginalFilename();
				// (내가 저장한 후 그 경로를 DB에 저장하도록 준비하는 것) 
				String root = request.getSession().getServletContext().getRealPath("resources");
				// 폴더가 없을 경우 자동 생성(내가 업로드한 파일을 저장할 폴더)
				String saveFolder = root + "\\nuploadFiles";
				File folder = new File(saveFolder); // java.io
				if(!folder.exists()) {
					folder.mkdir();
				}
				// =================== 파일 경로 ===================
				String savePath = saveFolder + "\\" + fileName;
				File file = new File(savePath);
				// ******************** 파일저장 ********************
				uploadFile.transferTo(file);
				
				// =================== 파일 크기 ===================
				long fileLength = uploadFile.getSize();
				
				// DB에 저장하기 위해 notice에 데이터를 Set하는 부분임.
				notice.setNoticeFilename(fileName);
				notice.setNoticeFilepath(savePath);
				notice.setNoticeFilelength(fileLength);
			}
			int result = service.insertNotice(notice);
			if(result > 0) {
				
				return "redirect:/notice/list.kh";
			} else {
				model.addAttribute("msg", "공지사항 등록이 완료되지 않았습니다.");
				model.addAttribute("error", "공지사항 등록 실패");
				model.addAttribute("url", "/index.jsp");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("error", e.getMessage());
			model.addAttribute("url", "/index.jsp");
			return "common/serviceFailed.jsp";
		}
	}
	
	
	
	
	
	
	
	
	
	
}
