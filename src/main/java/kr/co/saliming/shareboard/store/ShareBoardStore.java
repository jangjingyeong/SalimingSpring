package kr.co.saliming.shareboard.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.co.saliming.shareboard.domain.PageInfo;
import kr.co.saliming.shareboard.domain.ShareBoard;

public interface ShareBoardStore {

	/**
	 * 정보공유게시판 게시글 작성 Store
	 * @param session
	 * @param shareBoard
	 * @return
	 */
	int insertShareBoard(SqlSession session, ShareBoard shareBoard);

	/**
	 * 정보공유게시판 게시글 수정 Store
	 * @param session
	 * @param shareBoard
	 * @return
	 */
	int updateShareBoard(SqlSession session, ShareBoard shareBoard);

	/**
	 * 정보공유게시판 게시글 조회수 Store
	 * @param session
	 * @param boardNo
	 * @return
	 */
	int updateBoardCount(SqlSession session, Integer boardNo);

	/**
	 * 정보공유게시판 게시글 삭제 Store
	 * @param session
	 * @param boardNo
	 * @return
	 */
	int deleteShareBoard(SqlSession session, int boardNo);

	/**
	 * 정보공유게시판 게시글 번호로 조회 Store
	 * @param session
	 * @param boardNo
	 * @return
	 */
	ShareBoard selectShareBoardByNo(SqlSession session, int boardNo);

	/**
	 * 정보공유게시판 게시글 총 갯수 조회 Store
	 * @param session
	 * @return
	 */
	int getListCount(SqlSession session);

	/**
	 * 정보공유게시판 게시글 리스트 조회 Store
	 * @param session
	 * @param pInfo
	 * @return
	 */
	List<ShareBoard> selectShareBoardList(SqlSession session, PageInfo pInfo);

	/**
	 * 정보공유게시판 검색 게시글 총 갯수 조회 Store
	 * @param session
	 * @param paramMap
	 * @return
	 */
	int getListCount(SqlSession session, Map<String, String> paramMap);

	/**
	 * 정보공유게시판 검색 게시글 리스트 조회 Store
	 * @param session
	 * @param pInfo
	 * @param paramMap
	 * @return
	 */
	List<ShareBoard> selectShareBoardByKeyword(SqlSession session, PageInfo pInfo, Map<String, String> paramMap);
}
