package com.project.DTO;

public class FreeBoardDTO {

	private int freeBoardSeq;
	private String freeBoardName;
	private String freeBoardContent;
	private int freeBoardReadcnt;
	private int freeBoardDawncount;
	private String freeBoardRegdate;
	private String userId;
	private String freeboardPw;
	
	//ReportBoardFile 에서  DTO
	private String reportBoardFileType;
	private int reportBoardfileSeq;
	private String reportBoardfileName;
	private String reportBoardfileOrgname;
	private String reportBoardfileSize;
	
	
	//추가?
	private String newimg; 					//최신글 아이콘
	private String commentcount;		//댓글수

	
	
	
	
	
	public String getNewimg() {
		return newimg;
	}
	public void setNewimg(String newimg) {
		this.newimg = newimg;
	}
	public String getCommentcount() {
		return commentcount;
	}
	public void setCommentcount(String commentcount) {
		this.commentcount = commentcount;
	}
	public int getReportBoardfileSeq() {
		return reportBoardfileSeq;
	}
	public void setReportBoardfileSeq(int reportBoardfileSeq) {
		this.reportBoardfileSeq = reportBoardfileSeq;
	}
	public String getReportBoardfileName() {
		return reportBoardfileName;
	}
	public void setReportBoardfileName(String reportBoardfileName) {
		this.reportBoardfileName = reportBoardfileName;
	}
	public String getReportBoardfileOrgname() {
		return reportBoardfileOrgname;
	}
	public void setReportBoardfileOrgname(String reportBoardfileOrgname) {
		this.reportBoardfileOrgname = reportBoardfileOrgname;
	}
	public String getReportBoardfileSize() {
		return reportBoardfileSize;
	}
	public void setReportBoardfileSize(String reportBoardfileSize) {
		this.reportBoardfileSize = reportBoardfileSize;
	}
	public int getFreeBoardSeq() {
		return freeBoardSeq;
	}
	public void setFreeBoardSeq(int freeBoardSeq) {
		this.freeBoardSeq = freeBoardSeq;
	}
	public String getFreeBoardName() {
		return freeBoardName;
	}
	public void setFreeBoardName(String freeBoardName) {
		this.freeBoardName = freeBoardName;
	}
	public String getFreeBoardContent() {
		return freeBoardContent;
	}
	public void setFreeBoardContent(String freeBoardContent) {
		this.freeBoardContent = freeBoardContent;
	}
	public int getFreeBoardReadcnt() {
		return freeBoardReadcnt;
	}
	public void setFreeBoardReadcnt(int freeBoardReadcnt) {
		this.freeBoardReadcnt = freeBoardReadcnt;
	}
	public int getFreeBoardDawncount() {
		return freeBoardDawncount;
	}
	public void setFreeBoardDawncount(int freeBoardDawncount) {
		this.freeBoardDawncount = freeBoardDawncount;
	}
	public String getFreeBoardRegdate() {
		return freeBoardRegdate;
	}
	public void setFreeBoardRegdate(String freeBoardRegdate) {
		this.freeBoardRegdate = freeBoardRegdate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getReportBoardFileType() {
		return reportBoardFileType;
	}
	public void setReportBoardFileType(String reportBoardFileType) {
		this.reportBoardFileType = reportBoardFileType;
	}
	public String getFreeboardPw() {
		return freeboardPw;
	}
	public void setFreeboardPw(String freeboardPw) {
		this.freeboardPw = freeboardPw;
	}
	
	
	
	
	
	
	
}
