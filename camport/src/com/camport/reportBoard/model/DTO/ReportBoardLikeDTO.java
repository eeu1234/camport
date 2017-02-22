package com.camport.reportBoard.model.DTO;

public class ReportBoardLikeDTO { //좋아요

	private int likeSeq;
	private String userId;
	private int reportBoardSeq;
	
	
	public int getLikeSeq() {
		return likeSeq;
	}
	public void setLikeSeq(int likeSeq) {
		this.likeSeq = likeSeq;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getReportBoardSeq() {
		return reportBoardSeq;
	}
	public void setReportBoardSeq(int reportBoardSeq) {
		this.reportBoardSeq = reportBoardSeq;
	}
	
	
	
}
