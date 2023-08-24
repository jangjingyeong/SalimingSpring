package kr.co.saliming.shareboard.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.saliming.shareboard.domain.ShareBoard;
import kr.co.saliming.shareboard.service.ShareBoardService;

@Controller
public class ShareBoardController {
	
	@Autowired
	private ShareBoardService sbService;
	
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
		fileMap.put("filePath", "../resources/buploadFiles/"+fileRename);
		fileMap.put("fileLength", fileLength);
		return fileMap;
	}
	
	
	
}
