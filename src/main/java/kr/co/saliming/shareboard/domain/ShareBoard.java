package kr.co.saliming.shareboard.domain;

import java.sql.Timestamp;

public class ShareBoard {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private String boardFilename;
	private String boardFileRename;
	private String boardFilepath;
	private long boardFilelength;
	private int boardCount;
	private Timestamp bCreateDate;
	private Timestamp bUpdateDate;
	private char bStatus;
	
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardFilename() {
		return boardFilename;
	}
	public void setBoardFilename(String boardFilename) {
		this.boardFilename = boardFilename;
	}
	public String getBoardFileRename() {
		return boardFileRename;
	}
	public void setBoardFileRename(String boardFileRename) {
		this.boardFileRename = boardFileRename;
	}
	public String getBoardFilepath() {
		return boardFilepath;
	}
	public void setBoardFilepath(String boardFilepath) {
		this.boardFilepath = boardFilepath;
	}
	public long getBoardFilelength() {
		return boardFilelength;
	}
	public void setBoardFilelength(long boardFilelength) {
		this.boardFilelength = boardFilelength;
	}
	public int getBoardCount() {
		return boardCount;
	}
	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}
	public Timestamp getbCreateDate() {
		return bCreateDate;
	}
	public void setbCreateDate(Timestamp bCreateDate) {
		this.bCreateDate = bCreateDate;
	}
	public Timestamp getbUpdateDate() {
		return bUpdateDate;
	}
	public void setbUpdateDate(Timestamp bUpdateDate) {
		this.bUpdateDate = bUpdateDate;
	}
	public char getbStatus() {
		return bStatus;
	}
	public void setbStatus(char bStatus) {
		this.bStatus = bStatus;
	}
	@Override
	public String toString() {
		return "정보공유게시판 [글번호=" + boardNo + ", 제목=" + boardTitle + ", 내용=" + boardContent
				+ ", 작성자=" + boardWriter + ", 파일이름=" + boardFilename + ", 파일새이름="
				+ boardFileRename + ", 파일경로=" + boardFilepath + ", 파일크기=" + boardFilelength
				+ ", 조회수=" + boardCount + ", 작성일=" + bCreateDate + ", 수정일=" + bUpdateDate
				+ ", 사용여부=" + bStatus + "]";
	}
	
	
	
	
	
	
	
	
}
