package kr.co.saliming.member.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.saliming.member.domain.Member;
import kr.co.saliming.member.service.MemberService;
import kr.co.saliming.member.store.MemberStore;

@Service // 빈 등록 
public class MemberServiceImpl implements MemberService {

	@Autowired // 의존성 주입 
	private MemberStore mStore;
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public int insertMember(Member member) {
		int result = mStore.insertMember(sqlSession, member);
		return result;
	}

	@Override
	public int updateMember(Member member) {
		int result = mStore.updateMember(sqlSession, member);
		return result;
	}

	@Override
	public int deleteMember(String memberId) {
		int result = mStore.deleteMember(sqlSession, memberId);
		return result;
	}

	@Override
	public Member selectCheckLogin(Member member) {
		Member mOne = mStore.selectCheckLogin(sqlSession, member);
		return mOne;
	}

	@Override
	public Member selectOneById(String memberId) {
		Member member = mStore.selectOneById(sqlSession, memberId);
		return member;
	}
	
}
