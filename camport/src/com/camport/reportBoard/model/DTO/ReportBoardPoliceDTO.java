package com.camport.reportBoard.model.DTO;

public class ReportBoardPoliceDTO {	//게시판 신고

	private int policeSeq;
	private String policeRegdate;
	private String policeContent;
	private String userId;
	private int reportBoardSeq;
	
	
	public int getPoliceSeq() {
		return policeSeq;
	}
	public void setPoliceSeq(int policeSeq) {
		this.policeSeq = policeSeq;
	}
	public String getPoliceRegdate() {
		return policeRegdate;
	}
	public void setPoliceRegdate(String policeRegdate) {
		this.policeRegdate = policeRegdate;
	}
	public String getPoliceContent() {
		return policeContent;
	}
	public void setPoliceContent(String policeContent) {
		this.policeContent = policeContent;
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
