package kr.co.saliming.shareboard.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.saliming.shareboard.domain.PageInfo;
import kr.co.saliming.shareboard.domain.ShareBoard;
import kr.co.saliming.shareboard.service.ShareBoardService;
import kr.co.saliming.shareboard.store.ShareBoardStore;

@Service
public class ShareBoardServiceImpl implements ShareBoardService{

	@Autowired
	private SqlSession session;
	
	@Autowired
	private ShareBoardStore sbStore;
	
	@Override
	public int insertShareBoard(ShareBoard shareBoard) {
		int result = sbStore.insertShareBoard(session, shareBoard);
		return result;
	}

	@Override
	public int updateShareBoard(ShareBoard shareBoard) {
		int result = sbStore.updateShareBoard(session, shareBoard);
		return result;
	}

	@Override
	public int deleteShareBoard(int boardNo) {
		int result = sbStore.deleteShareBoard(session, boardNo);
		return result;
	}

	@Override
	public ShareBoard selectShareBoardByNo(int boardNo) {
		ShareBoard shareBoard = sbStore.selectShareBoardByNo(session, boardNo);
		return shareBoard;
	}

	@Override
	public int getListCount() {
		int result = sbStore.getListCount(session);
		return result;
	}

	@Override
	public List<ShareBoard> selectShareBoardList(PageInfo pInfo) {
		List<ShareBoard> sbList = sbStore.selectShareBoardList(session, pInfo);
		return sbList;
	}

	@Override
	public int getListCount(Map<String, String> paramMap) {
		int result = sbStore.getListCount(session, paramMap);
		return result;
	}

	@Override
	public List<ShareBoard> searchShareBoardByKeyword(PageInfo pInfo, Map<String, String> paramMap) {
		List<ShareBoard> searchList = sbStore.selectShareBoardByKeyword(session, pInfo, paramMap);
		return searchList;
	}

}
