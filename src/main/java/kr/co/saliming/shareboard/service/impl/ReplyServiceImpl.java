package kr.co.saliming.shareboard.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.saliming.shareboard.domain.Reply;
import kr.co.saliming.shareboard.service.ReplyService;
import kr.co.saliming.shareboard.store.ReplyStore;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private ReplyStore rStore;
	
	@Override
	public int insertReply(Reply reply) {
		int result = rStore.insertReply(sqlSession, reply);
		return result;
	}

	@Override
	public List<Reply> selectReplyList(Integer boardNo) {
		List<Reply> rList = rStore.selectReplyList(sqlSession, boardNo);
		return rList;
	}

}
