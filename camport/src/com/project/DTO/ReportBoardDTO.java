package com.project.DTO;

public class ReportBoardDTO {
	
	private int reportBoardSeq;
	private String reportBoardName;
	private String reportBoardContent;
	private String reportBoardSummary;
	private String reportBoardRegdate;
	private int reportBoardReadcount;
	private int reportBoardDowncount;
	private int reportBoardPoint;
	private int collageSeq;
	private String userId;
	private int ruleSeq;
	
	//게시판 비밀번호 지정
	private String pw;
	private int commentcount; //댓글수
	private String newimg;	  //새로운 글 이미지
	private String reportBoardFileName;		//파일이름	
	private String reportBoardFileOrgname;	//파일이름
	private int thread;			 //계층형
	private int depth;			//계층형
	
	public int getReportBoardSeq() {
		return reportBoardSeq;
	}
	public void setReportBoardSeq(int reportBoardSeq) {
		this.reportBoardSeq = reportBoardSeq;
	}
	public String getReportBoardName() {
		return reportBoardName;
	}
	public void setReportBoardName(String reportBoardName) {
		this.reportBoardName = reportBoardName;
	}
	public String getReportBoardContent() {
		return reportBoardContent;
	}
	public void setReportBoardContent(String reportBoardContent) {
		this.reportBoardContent = reportBoardContent;
	}
	public String getReportBoardSummary() {
		return reportBoardSummary;
	}
	public void setReportBoardSummary(String reportBoardSummary) {
		this.reportBoardSummary = reportBoardSummary;
	}
	public String getReportBoardRegdate() {
		return reportBoardRegdate;
	}
	public void setReportBoardRegdate(String reportBoardRegdate) {
		this.reportBoardRegdate = reportBoardRegdate;
	}
	public int getReportBoardReadcount() {
		return reportBoardReadcount;
	}
	public void setReportBoardReadcount(int reportBoardReadcount) {
		this.reportBoardReadcount = reportBoardReadcount;
	}
	public int getReportBoardDowncount() {
		return reportBoardDowncount;
	}
	public void setReportBoardDowncount(int reportBoardDowncount) {
		this.reportBoardDowncount = reportBoardDowncount;
	}
	public int getReportBoardPoint() {
		return reportBoardPoint;
	}
	public void setReportBoardPoint(int reportBoardPoint) {
		this.reportBoardPoint = reportBoardPoint;
	}
	public int getCollageSeq() {
		return collageSeq;
	}
	public void setCollageSeq(int collageSeq) {
		this.collageSeq = collageSeq;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getRuleSeq() {
		return ruleSeq;
	}
	public void setRuleSeq(int ruleSeq) {
		this.ruleSeq = ruleSeq;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getCommentcount() {
		return commentcount;
	}
	public void setCommentcount(int commentcount) {
		this.commentcount = commentcount;
	}
	public String getNewimg() {
		return newimg;
	}
	public void setNewimg(String newimg) {
		this.newimg = newimg;
	}
	public String getReportBoardFileName() {
		return reportBoardFileName;
	}
	public void setReportBoardFileName(String reportBoardFileName) {
		this.reportBoardFileName = reportBoardFileName;
	}
	public String getReportBoardFileOrgname() {
		return reportBoardFileOrgname;
	}
	public void setReportBoardFileOrgname(String reportBoardFileOrgname) {
		this.reportBoardFileOrgname = reportBoardFileOrgname;
	}
	public int getThread() {
		return thread;
	}
	public void setThread(int thread) {
		this.thread = thread;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}			 //계층형
}	
	