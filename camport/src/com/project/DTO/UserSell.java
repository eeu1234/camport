package com.project.DTO;

public class UserSell {	//판매내역

	private String sellSeq;
	private String sellDate;
	private String userId;
	private String reportBoardSeq;
	
	public String getSellSeq() {
		return sellSeq;
	}
	public void setSellSeq(String sellSeq) {
		this.sellSeq = sellSeq;
	}
	public String getSellDate() {
		return sellDate;
	}
	public void setSellDate(String sellDate) {
		this.sellDate = sellDate;
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
