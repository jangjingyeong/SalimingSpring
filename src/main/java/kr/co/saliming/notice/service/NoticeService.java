package kr.co.saliming.notice.service;

import java.util.List;
import java.util.Map;

import kr.co.saliming.notice.domain.Notice;
import kr.co.saliming.notice.domain.PageInfo;

public interface NoticeService {

	int insertNotice(Notice notice);

	int updateNotice(Notice notice);

	int deleteNotice(int noticeNo);

	List<Notice> selectNoticesList(PageInfo pInfo);

	int getListCount();

	Notice selectNoticeByNo(int noticeNo);

	int getListCount(Map<String, String> paramMap);

	List<Notice> searchNoticesByKeyword(PageInfo pInfo, Map<String, String> paramMap);

}
