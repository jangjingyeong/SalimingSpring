package kr.co.saliming.shareboard.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.saliming.shareboard.domain.ShareBoard;
import kr.co.saliming.shareboard.service.ShareBoardService;
import kr.co.saliming.shareboard.store.ShareBoardStore;

@Service
public class ShareBoardServiceImpl implements ShareBoardService{

	@Autowired
	private SqlSession session;
	
	@Autowired
	private ShareBoardStore sbStore;
	
	@Override
	public int insertShareBoard(ShareBoard shareBoard) {
		int result = sbStore.insertShareBoard(session, shareBoard);
		return result;
	}

}
