package kr.co.saliming.shareboard.domain;

import java.sql.Timestamp;

public class Reply {
	private int replyNo;
	private int refBoardNo;
	private String replyContent;
	private String replyWriter;
	private Timestamp rCreateDate;
	private Timestamp rUpdateDate;
	private char updateYn;
	private char rStatus;
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	public int getRefBoardNo() {
		return refBoardNo;
	}
	public void setRefBoardNo(int refBoardNo) {
		this.refBoardNo = refBoardNo;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyWriter() {
		return replyWriter;
	}
	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}
	public Timestamp getrCreateDate() {
		return rCreateDate;
	}
	public void setrCreateDate(Timestamp rCreateDate) {
		this.rCreateDate = rCreateDate;
	}
	public Timestamp getrUpdateDate() {
		return rUpdateDate;
	}
	public void setrUpdateDate(Timestamp rUpdateDate) {
		this.rUpdateDate = rUpdateDate;
	}
	public char getUpdateYn() {
		return updateYn;
	}
	public void setUpdateYn(char updateYn) {
		this.updateYn = updateYn;
	}
	public char getrStatus() {
		return rStatus;
	}
	public void setrStatus(char rStatus) {
		this.rStatus = rStatus;
	}
	@Override
	public String toString() {
		return "댓글 [댓글번호=" + replyNo + ", 글번호=" + refBoardNo + ", 댓글내용=" + replyContent
				+ ", 댓글작성자=" + replyWriter + ", 댓글작성일=" + rCreateDate + ", 댓글수정일=" + rUpdateDate
				+ ", 수정여부=" + updateYn + ", 사용여부=" + rStatus + "]";
	}
	
	
	
	
	
}
