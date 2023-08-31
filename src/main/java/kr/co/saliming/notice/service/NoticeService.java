package kr.co.saliming.notice.service;

import java.util.List;
import java.util.Map;

import kr.co.saliming.notice.domain.Notice;
import kr.co.saliming.notice.domain.PageInfo;

public interface NoticeService {

	/**
	 * 공지사항 작성 Service
	 * @param notice
	 * @return
	 */
	int insertNotice(Notice notice);

	/**
	 * 공지사항 수정 Service
	 * @param notice
	 * @return
	 */
	int updateNotice(Notice notice);

	/**
	 * 공지사항 조회수 Service
	 * @param noticeNo
	 * @return
	 */
	int updateViewCount(int noticeNo);

	/**
	 * 공지사항 삭제 Service
	 * @param noticeNo
	 * @return
	 */
	int deleteNotice(int noticeNo);

	/**
	 * 공지사항 전체 리스트 조회 Service
	 * @param pInfo
	 * @return
	 */
	List<Notice> selectNoticesList(PageInfo pInfo);

	/**
	 * 공지사항 전체 갯수 조회 Service
	 * @return
	 */
	int getListCount();

	/**
	 * 공지사항 상세 조회 Service
	 * @param noticeNo
	 * @return
	 */
	Notice selectNoticeByNo(int noticeNo);

	/**
	 * 공지사항 키워드로 검색 Service
	 * @param pInfo
	 * @param paramMap
	 * @return
	 */
	List<Notice> searchNoticesByKeyword(PageInfo pInfo, Map<String, String> paramMap);

	/**
	 * 공지사항 검색 갯수 조회 Service
	 * @param paramMap
	 * @return
	 */
	int getListCount(Map<String, String> paramMap);

}
