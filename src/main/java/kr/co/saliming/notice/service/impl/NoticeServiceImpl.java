package kr.co.saliming.notice.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.saliming.notice.domain.Notice;
import kr.co.saliming.notice.domain.PageInfo;
import kr.co.saliming.notice.service.NoticeService;
import kr.co.saliming.notice.store.NoticeStore;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private SqlSession session;
	
	@Autowired
	private NoticeStore nStore;
	
	@Override
	public int insertNotice(Notice notice) {
		int result = nStore.insertNotice(session, notice);
		return result;
	}

	@Override
	public int updateNotice(Notice notice) {
		int result = nStore.updateNotice(session, notice);
		return result;
	}

	@Override
	public int updateViewCount(int noticeNo) {
		int result = nStore.updateViewCount(session, noticeNo);
		return result;
	}

	@Override
	public int deleteNotice(int noticeNo) {
		int result = nStore.deleteNotice(session, noticeNo);
		return result;
	}

	@Override
	public List<Notice> selectNoticesList(PageInfo pInfo) {
		List nList = nStore.selectNoticesList(session, pInfo);
		return nList;
	}

	@Override
	public int getListCount() {
		int result = nStore.getListCount(session);
		return result;
	}

	@Override
	public Notice selectNoticeByNo(int noticeNo) {
		Notice notice = nStore.selectOneByNo(session, noticeNo);
		return notice;
	}

	@Override
	public List<Notice> searchNoticesByKeyword(PageInfo pInfo, Map<String, String> paramMap) {
		List<Notice> searchList = nStore.searchNoticesByKeyword(session, pInfo, paramMap);
		return searchList;
	}

	@Override
	public int getListCount(Map<String, String> paramMap) {
		int result = nStore.getListCount(session, paramMap);
		return result;
	}

}
