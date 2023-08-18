package kr.co.saliming.notice.store;

import org.apache.ibatis.session.SqlSession;

import kr.co.saliming.notice.domain.Notice;

public interface NoticeStore {

	int insertNotice(SqlSession session, Notice notice);
	
	
	
}
