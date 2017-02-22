package com.camport.DTO;

public class ReportCommentDTO {	//댓글
	
	private int reportCommentSeq;
	private String reportCommentContent;
	private String reportCommentRegdate;
	private int reportCommentThread;
	private int reportCommentDepth;
	private int reportBoardSeq;
	private String userId;
	private int ruleSeq;
	
	
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
