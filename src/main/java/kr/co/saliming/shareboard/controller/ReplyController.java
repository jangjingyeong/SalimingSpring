package kr.co.saliming.shareboard.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.saliming.shareboard.domain.Reply;
import kr.co.saliming.shareboard.service.ReplyService;

@Controller
@RequestMapping("/reply")
public class ReplyController {
	
	@Autowired
	private ReplyService rService;
	
	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public ModelAndView insertReply(ModelAndView mv
			, @ModelAttribute Reply reply
			, HttpSession session) {
		String url = "";
		try {
			String replyWriter = (String)session.getAttribute("memberNickname");
			reply.setReplyWriter(replyWriter);
			int result = rService.insertReply(reply);
			url = "/shareBoard/detail.do?boardNo="+reply.getRefBoardNo();
			if(result > 0) {
				mv.setViewName("redirect:"+url);
			} else {
				mv.addObject("msg", "댓글 등록이 완료되지 않았습니다.");
				mv.addObject("error", "댓글 등록 실패");
				mv.addObject("url", url);
				mv.setViewName("common/serviceFailed.jsp");
			}
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의 바랍니다.");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", url);
			mv.setViewName("common/serviceFailed");
		}
		return mv;
	}
	
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public ModelAndView updateReply(ModelAndView mv
			, @ModelAttribute Reply reply
			, HttpSession session) {
		String url = "";
		try {
			String replyWriter = (String)session.getAttribute("memberNickname");
			if(replyWriter != null && !replyWriter.equals("")) {
				reply.setReplyWriter(replyWriter);
				url = "/shareBoard/detail.do?boardNo="+reply.getRefBoardNo();
				int result = rService.updateReply(reply);
				if(result > 0) {
					mv.setViewName("redirect:"+url);
				} else {
					mv.addObject("msg", "댓글 수정이 완료되지 않았습니다.");
					mv.addObject("error", "댓글 수정 실패");
					mv.addObject("url", url);
					mv.setViewName("common/serviceFailed.jsp");
				}
			}
			
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의 바랍니다.");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", url);
			mv.setViewName("common/serviceFailed");
		}
		return mv;
	}
	
	
	public ModelAndView deleteReply(ModelAndView mv
			, @ModelAttribute Reply reply
			, HttpSession session) {
		String url = "";
		try {
			String memberNickname = (String)session.getAttribute("memberNickname");
			String replyWriter = reply.getReplyWriter();
			url = "/board/detail.kh?boardNo="+reply.getRefBoardNo();
			if(replyWriter != null && replyWriter.equals(memberNickname)) {
				int result = rService.deleteReply(reply);
				if(result > 0) {
					mv.setViewName("redirect:"+url);
				} else {
					mv.addObject("msg", "댓글 삭제가 완료되지 않았습니다.");
					mv.addObject("error", "댓글 삭제 실패");
					mv.addObject("url", url);
					mv.setViewName("common/serviceFailed.jsp");
				}
			}
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의 바랍니다.");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", url);
			mv.setViewName("common/serviceFailed");
		}
		return mv;
	}
	
	
	
	
	
	
	
	
}
