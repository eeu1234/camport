package com.project.DTO;

public class BoardPointHistory {	//글 포인트 내역

	private String writePointSeq;
	private String reportBoardSeq;
	private String userId;

	public String getWritePointSeq() {
		return writePointSeq;
	}
	public void setWritePointSeq(String writePointSeq) {
		this.writePointSeq = writePointSeq;
	}
	public String getReportBoardSeq() {
		return reportBoardSeq;
	}
	public void setReportBoardSeq(String reportBoardSeq) {
		this.reportBoardSeq = reportBoardSeq;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
