package kr.co.saliming.member.service;

import kr.co.saliming.member.domain.Member;

public interface MemberService {
	
	public int insertMember(Member member);
	
	public int updateMember(Member member);
	
	public int deleteMember(String memberId);
	
	public Member selectCheckLogin(Member member);

	public Member selectOneById(String memberId);

	
}
