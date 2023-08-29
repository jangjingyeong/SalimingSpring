package kr.co.saliming.shareboard.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.saliming.shareboard.domain.Reply;

public interface ReplyStore {

	/**
	 * 게시글 댓글 등록 Store
	 * @param sqlSession
	 * @param reply
	 * @return
	 */
	int insertReply(SqlSession sqlSession, Reply reply);

	/**
	 * 게시글 댓글 수정 Store
	 * @param sqlSession
	 * @param reply
	 * @return
	 */
	int updateReply(SqlSession sqlSession, Reply reply);

	/**
	 * 게시글 댓글 삭제 Store
	 * @param sqlSession
	 * @param reply
	 * @return
	 */
	int deleteReply(SqlSession sqlSession, Reply reply);

	/**
	 * 게시글 댓글 조회 Store
	 * @param sqlSession
	 * @param boardNo
	 * @return
	 */
	List<Reply> selectReplyList(SqlSession sqlSession, Integer boardNo);

}
