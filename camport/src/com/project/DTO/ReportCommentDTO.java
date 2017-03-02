package com.project.DTO;

public class ReportCommentDTO {	//댓글

	private int reportCommentSeq;			//댓글번호
	private String reportCommentContent;	//내용
	private String reportCommentRegdate;	//등록일 날짜
	private int reportCommentThread;		//게시판 계층형
	private int reportCommentDepth;			//게시판 계층형
	private int reportBoardSeq;				//게시판 번호
	private String userId;					//유저 아이디
	private int ruleSeq;					//포인트 규정
	
	
	public int getReportCommentSeq() {
		return reportCommentSeq;
	}
	public void setReportCommentSeq(int reportCommentSeq) {
		this.reportCommentSeq = reportCommentSeq;
	}
	public String getReportCommentContent() {
		return reportCommentContent;
	}
	public void setReportCommentContent(String reportCommentContent) {
		this.reportCommentContent = reportCommentContent;
	}
	public String getReportCommentRegdate() {
		return reportCommentRegdate;
	}
	public void setReportCommentRegdate(String reportCommentRegdate) {
		this.reportCommentRegdate = reportCommentRegdate;
	}
	public int getReportCommentThread() {
		return reportCommentThread;
	}
	public void setReportCommentThread(int reportCommentThread) {
		this.reportCommentThread = reportCommentThread;
	}
	public int getReportCommentDepth() {
		return reportCommentDepth;
	}
	public void setReportCommentDepth(int reportCommentDepth) {
		this.reportCommentDepth = reportCommentDepth;
	}
	public int getReportBoardSeq() {
		return reportBoardSeq;
	}
	public void setReportBoardSeq(int reportBoardSeq) {
		this.reportBoardSeq = reportBoardSeq;
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

	
}
