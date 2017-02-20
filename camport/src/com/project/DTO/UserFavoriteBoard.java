package com.project.DTO;

public class UserFavoriteBoard {	//즐겨찾기

	private String favoriteSeq;
	private String ReportBoardSeq;
	private String userId;
	
	public String getFavoriteSeq() {
		return favoriteSeq;
	}
	public void setFavoriteSeq(String favoriteSeq) {
		this.favoriteSeq = favoriteSeq;
	}
	public String getReportBoardSeq() {
		return ReportBoardSeq;
	}
	public void setReportBoardSeq(String reportBoardSeq) {
		ReportBoardSeq = reportBoardSeq;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
