package kr.co.saliming.shareboard.store.logic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.saliming.shareboard.domain.PageInfo;
import kr.co.saliming.shareboard.domain.ShareBoard;
import kr.co.saliming.shareboard.store.ShareBoardStore;

@Repository
public class ShareBoardStoreLogic implements ShareBoardStore{

	@Override
	public int insertShareBoard(SqlSession session, ShareBoard shareBoard) {
		int result = session.insert("ShareBoardMapper.insertShareBoard", shareBoard);
		return result;
	}

	@Override
	public int updateShareBoard(SqlSession session, ShareBoard shareBoard) {
		int result = session.update("ShareBoardMapper.updateShareBoard", shareBoard);
		return result;
	}

	@Override
	public int deleteShareBoard(SqlSession session, int boardNo) {
		int result = session.delete("ShareBoardMapper.deleteShareBoard", boardNo);
		return result;
	}

	@Override
	public ShareBoard selectShareBoardByNo(SqlSession session, int boardNo) {
		ShareBoard shareBoard = session.selectOne("ShareBoardMapper.selectShareBoardByNo", boardNo);
		return shareBoard;
	}

	@Override
	public int getListCount(SqlSession session) {
		int result = session.selectOne("ShareBoardMapper.getTotalCount");
		return result;
	}

	@Override
	public List<ShareBoard> selectShareBoardList(SqlSession session, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage()-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<ShareBoard> sbList = session.selectList("ShareBoardMapper.selectShareBoardList", null, rowBounds);
		return sbList;
	}

	@Override
	public int getListCount(SqlSession session, Map<String, String> paramMap) {
		int result = session.selectOne("ShareBoardMapper.selectListByKeywordCount", paramMap); 
		return result;
	}

	@Override
	public List<ShareBoard> selectShareBoardByKeyword(SqlSession session, PageInfo pInfo, Map<String, String> paramMap) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage()-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<ShareBoard> searchList = session.selectList("ShareBoardMapper.selectShareBoardByKeyword", paramMap, rowBounds);
		return searchList;
	}
	
	

}
