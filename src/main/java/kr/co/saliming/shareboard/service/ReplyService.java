package kr.co.saliming.shareboard.service;

import java.util.List;

import kr.co.saliming.shareboard.domain.Reply;

public interface ReplyService {

	int insertReply(Reply reply);

	List<Reply> selectReplyList(Integer boardNo);

}
