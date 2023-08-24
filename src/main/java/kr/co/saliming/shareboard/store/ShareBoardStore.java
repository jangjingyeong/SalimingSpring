package kr.co.saliming.shareboard.store;

import org.apache.ibatis.session.SqlSession;

import kr.co.saliming.shareboard.domain.ShareBoard;

public interface ShareBoardStore {

	/**
	 * 정보공유게시판 게시글 작성 Store
	 * @param session
	 * @param shareBoard
	 * @return
	 */
	int insertShareBoard(SqlSession session, ShareBoard shareBoard);

}
