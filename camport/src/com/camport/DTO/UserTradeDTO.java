package com.camport.DTO;

public class UserTradeDTO {

	private int tradeSeq;
	private String tradeDate;
	private int reportBoardSeq;
	private String sellUserId;
	private String purcaheUserId;
	
	
	public int getTradeSeq() {
		return tradeSeq;
	}
	public void setTradeSeq(int tradeSeq) {
		this.tradeSeq = tradeSeq;
	}
	public String getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}
	public int getReportBoardSeq() {
		return reportBoardSeq;
	}
	public void setReportBoardSeq(int reportBoardSeq) {
		this.reportBoardSeq = reportBoardSeq;
	}
	public String getSellUserId() {
		return sellUserId;
	}
	public void setSellUserId(String sellUserId) {
		this.sellUserId = sellUserId;
	}
	public String getPurcaheUserId() {
		return purcaheUserId;
	}
	public void setPurcaheUserId(String purcaheUserId) {
		this.purcaheUserId = purcaheUserId;
	}
	
	
	
}
