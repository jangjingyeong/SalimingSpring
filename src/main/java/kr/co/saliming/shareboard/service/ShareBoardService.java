package kr.co.saliming.shareboard.service;

import kr.co.saliming.shareboard.domain.ShareBoard;

public interface ShareBoardService {

	/**
	 * 정보공유게시판 게시글 작성 Service
	 * @param shareBoard
	 * @return
	 */
	int insertShareBoard(ShareBoard shareBoard);

}
