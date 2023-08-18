package kr.co.saliming.member.domain;

import java.sql.Timestamp;

public class Member {
	private String memberId;
	private String memberPw;
	private String memberPw2;
	private String memberName;
	private String memberNickname;
	private String memberBirthday;
	private String memberPhone;
	private String memberEmail;
	private String memberAddress;
	private Timestamp memberDate;
	private Timestamp updateDate;
	private String memberYn;
	
	// 기본생성자
	public Member() {}

	// 가입용생성자
	public Member(String memberId, String memberPw, String memberPw2, String memberName, String memberNickname,
			String memberBirthday, String memberPhone, String memberEmail, String memberAddress) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberPw2 = memberPw2;
		this.memberName = memberName;
		this.memberNickname = memberNickname;
		this.memberBirthday = memberBirthday;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberAddress = memberAddress;
	}
	
	// 로그인용
	public Member(String memberId, String memberPw) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
	}
	
	// 수정용
	public Member(String memberId, String memberPw, String memberPw2, String memberNickname, String memberPhone,
			String memberEmail, String memberAddress) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberPw2 = memberPw2;
		this.memberNickname = memberNickname;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberAddress = memberAddress;
	}

	
	
	// getter, setter 
	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberPw2() {
		return memberPw2;
	}

	public void setMemberPw2(String memberPw2) {
		this.memberPw2 = memberPw2;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	public String getMemberBirthday() {
		return memberBirthday;
	}

	public void setMemberBirthday(String memberBirthday) {
		this.memberBirthday = memberBirthday;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public Timestamp getMemberDate() {
		return memberDate;
	}

	public void setMemberDate(Timestamp memberDate) {
		this.memberDate = memberDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getMemberYn() {
		return memberYn;
	}

	public void setMemberYn(String memberYn) {
		this.memberYn = memberYn;
	}

	@Override
	public String toString() {
		return "회원 [아이디=" + memberId + ", 비밀번호=" + memberPw + ", 비밀번호확인=" + memberPw2 + ", 이름="
				+ memberName + ", 닉네임=" + memberNickname + ", 생일=" + memberBirthday
				+ ", 전화번호=" + memberPhone + ", 이메일=" + memberEmail + ", 주소=" + memberAddress
				+ ", 가입일=" + memberDate + ", 수정일=" + updateDate + ", 회원여부=" + memberYn + "]";
	}

	
	
}

