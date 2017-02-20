package com.project.DTO;

public class UserPurchase {		//구매내역

	private String purchaseSeq;
	private String purchaseDate;
	private String userId;
	private String ReportBoardSeq;
	
	public String getPurchaseSeq() {
		return purchaseSeq;
	}
	public void setPurchaseSeq(String purchaseSeq) {
		this.purchaseSeq = purchaseSeq;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getReportBoardSeq() {
		return ReportBoardSeq;
	}
	public void setReportBoardSeq(String reportBoardSeq) {
		ReportBoardSeq = reportBoardSeq;
	}
}
