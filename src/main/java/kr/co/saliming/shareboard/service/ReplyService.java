package kr.co.saliming.shareboard.service;

import java.util.List;

import kr.co.saliming.shareboard.domain.Reply;

public interface ReplyService {

	/**
	 * 게시글 댓글 등록 Service
	 * @param reply
	 * @return
	 */
	int insertReply(Reply reply);

	/**
	 * 게시글 댓글 수정 Service
	 * @param reply
	 * @return
	 */
	int updateReply(Reply reply);


	/**
	 * 게시글 댓글 삭제 Service
	 * @param reply
	 * @return
	 */
	int deleteReply(Reply reply);

	/**
	 * 게시글 댓글 조회 Service
	 * @param boardNo
	 * @return
	 */
	List<Reply> selectReplyList(Integer boardNo);

}
