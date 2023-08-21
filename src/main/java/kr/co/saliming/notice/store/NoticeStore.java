package kr.co.saliming.notice.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.co.saliming.notice.domain.Notice;
import kr.co.saliming.notice.domain.PageInfo;

public interface NoticeStore {

	int insertNotice(SqlSession session, Notice notice);

	List selectNoticesList(SqlSession session, PageInfo pInfo);

	int getListCount(SqlSession session);

	Notice selectOneByNo(SqlSession session, int noticeNo);

	int updateNotice(SqlSession session, Notice notice);

	int deleteNotice(SqlSession session, int noticeNo);

	List<Notice> searchNoticesByKeyword(SqlSession session, PageInfo pInfo, Map<String, String> paramMap);

	int getListCount(SqlSession session, Map<String, String> paramMap);
	
	
	
}
