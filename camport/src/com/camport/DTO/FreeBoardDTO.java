package com.camport.DTO;

public class FreeBoardDTO {

	private int freeBoardSeq;
	private String freeBoardName;
	private String freeBoardContent;
	private int freeBoardReadCnt;
	private int freeBoardDownCnt;
	private String freeBoardRegdate;
	private String userId;
	
	
	public int getFreeBoardSeq() {
		return freeBoardSeq;
	}
	public void setFreeBoardSeq(int freeBoardSeq) {
		this.freeBoardSeq = freeBoardSeq;
	}
	public String getFreeBoardName() {
		return freeBoardName;
	}
	public void setFreeBoardName(String freeBoardName) {
		this.freeBoardName = freeBoardName;
	}
	public String getFreeBoardContent() {
		return freeBoardContent;
	}
	public void setFreeBoardContent(String freeBoardContent) {
		this.freeBoardContent = freeBoardContent;
	}
	public int getFreeBoardReadCnt() {
		return freeBoardReadCnt;
	}
	public void setFreeBoardReadCnt(int freeBoardReadCnt) {
		this.freeBoardReadCnt = freeBoardReadCnt;
	}
	public int getFreeBoardDownCnt() {
		return freeBoardDownCnt;
	}
	public void setFreeBoardDownCnt(int freeBoardDownCnt) {
		this.freeBoardDownCnt = freeBoardDownCnt;
	}
	public String getFreeBoardRegdate() {
		return freeBoardRegdate;
	}
	public void setFreeBoardRegdate(String freeBoardRegdate) {
		this.freeBoardRegdate = freeBoardRegdate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	
	
}
