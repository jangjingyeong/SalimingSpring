package kr.co.saliming.shareboard.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.saliming.shareboard.domain.ShareBoard;
import kr.co.saliming.shareboard.store.ShareBoardStore;

@Repository
public class ShareBoardStoreLogic implements ShareBoardStore{

	@Override
	public int insertShareBoard(SqlSession session, ShareBoard shareBoard) {
		int result = session.insert("ShareBoardMapper.insertShareBoard", shareBoard);
		return result;
	}

}
