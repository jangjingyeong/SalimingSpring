package kr.co.saliming.notice.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.co.saliming.notice.domain.Notice;
import kr.co.saliming.notice.domain.PageInfo;

public interface NoticeStore {

	/**
	 * 공지사항 작성 Store
	 * @param session
	 * @param notice
	 * @return
	 */
	int insertNotice(SqlSession session, Notice notice);

	/**
	 * 공지사항 수정 Store
	 * @param session
	 * @param notice
	 * @return
	 */
	int updateNotice(SqlSession session, Notice notice);

	/**
	 * 공지사항 조회수 Store
	 * @param session
	 * @param noticeNo
	 * @return
	 */
	int updateViewCount(SqlSession session, int noticeNo);

	/**
	 * 공지사항 삭제 Store
	 * @param session
	 * @param noticeNo
	 * @return
	 */
	int deleteNotice(SqlSession session, int noticeNo);

	/**
	 * 공지사항 전체 리스트 조회 Store
	 * @param session
	 * @param pInfo
	 * @return
	 */
	List selectNoticesList(SqlSession session, PageInfo pInfo);

	/**
	 * 공지사항 전체 갯수 조회 Store
	 * @param session
	 * @return
	 */
	int getListCount(SqlSession session);

	/**
	 * 공지사항 상세 조회 Store
	 * @param session
	 * @param noticeNo
	 * @return
	 */
	Notice selectOneByNo(SqlSession session, int noticeNo);

	/**
	 * 공지사항 키워드로 검색 Store
	 * @param session
	 * @param pInfo
	 * @param paramMap
	 * @return
	 */
	List<Notice> searchNoticesByKeyword(SqlSession session, PageInfo pInfo, Map<String, String> paramMap);

	/**
	 * 공지사항 검색 갯수 조회 Store
	 * @param session
	 * @param paramMap
	 * @return
	 */
	int getListCount(SqlSession session, Map<String, String> paramMap);
	
	
	
}
