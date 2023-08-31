package kr.co.saliming.shareboard.service;

import java.util.List;
import java.util.Map;

import kr.co.saliming.notice.domain.Notice;
import kr.co.saliming.shareboard.domain.PageInfo;
import kr.co.saliming.shareboard.domain.ShareBoard;

public interface ShareBoardService {

	/**
	 * 정보공유게시판 게시글 작성 Service
	 * @param shareBoard
	 * @return
	 */
	int insertShareBoard(ShareBoard shareBoard);

	/**
	 * 정보공유게시판 게시글 수정 Service
	 * @param shareBoard
	 * @return
	 */
	int updateShareBoard(ShareBoard shareBoard);

	/**
	 * 정보공유게시판 게시글 조회수 Service
	 * @param boardNo
	 * @return
	 */
	int updateBoardCount(Integer boardNo);

	/**
	 * 정보공유게시판 게시글 삭제 Service
	 * @param boardNo
	 * @return
	 */
	int deleteShareBoard(int boardNo);

	/**
	 * 정보공유게시판 게시글 번호로 조회 Service
	 * @param boardNo
	 * @return
	 */
	ShareBoard selectShareBoardByNo(int boardNo);

	/**
	 * 정보공유게시판 게시글 총 갯수 조회 Service
	 * @return
	 */
	int getListCount();

	/**
	 * 정보공유게시판 게시글 리스트 조회 Service 
	 * @param pInfo
	 * @return
	 */
	List<ShareBoard> selectShareBoardList(PageInfo pInfo);

	/**
	 * 정보공유게시판 검색 게시글 총 갯수 조회 Service
	 * @param paramMap
	 * @return
	 */
	int getListCount(Map<String, String> paramMap);

	/**
	 * 정보공유게시판 검색 게시글 리스트 조회 Service
	 * @param pInfo
	 * @param paramMap
	 * @return
	 */
	List<ShareBoard> searchShareBoardByKeyword(PageInfo pInfo, Map<String, String> paramMap);
}
