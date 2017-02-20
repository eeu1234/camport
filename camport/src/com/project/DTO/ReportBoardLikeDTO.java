package com.project.DTO;

public class ReportBoardLikeDTO { //좋아요

	private String likeSeq;
	private String userId;
	private String reportBoardSeq;
	
	public String getLikeSeq() {
		return likeSeq;
	}
	public void setLikeSeq(String likeSeq) {
		this.likeSeq = likeSeq;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getReportBoardSeq() {
		return reportBoardSeq;
	}
	public void setReportBoardSeq(String reportBoardSeq) {
		this.reportBoardSeq = reportBoardSeq;
	}
	
	
}
