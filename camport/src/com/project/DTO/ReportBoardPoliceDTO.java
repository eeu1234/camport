package com.project.DTO;

public class ReportBoardPoliceDTO {	//게시판 신고

	private String policeSeq;
	private String userId;
	private String reportBoardSeq;
	
	public String getPoliceSeq() {
		return policeSeq;
	}
	public void setPoliceSeq(String policeSeq) {
		this.policeSeq = policeSeq;
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
