package kr.co.saliming.shareboard.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.saliming.shareboard.domain.Reply;

public interface ReplyStore {

	int insertReply(SqlSession sqlSession, Reply reply);

	List<Reply> selectReplyList(SqlSession sqlSession, Integer boardNo);

}
