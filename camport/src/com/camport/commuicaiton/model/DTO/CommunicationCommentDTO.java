package com.camport.commuicaiton.model.DTO;

public class CommunicationCommentDTO {

	private int commcommentSeq;
	private String commcommentContent;
	private String commcommentRegdate;
	private int commcommentThread;
	private int commcommentDepth;
	private int commBoardSeq;
	
	
	
	public int getCommcommentSeq() {
		return commcommentSeq;
	}
	public void setCommcommentSeq(int commcommentSeq) {
		this.commcommentSeq = commcommentSeq;
	}
	public String getCommcommentContent() {
		return commcommentContent;
	}
	public void setCommcommentContent(String commcommentContent) {
		this.commcommentContent = commcommentContent;
	}
	public String getCommcommentRegdate() {
		return commcommentRegdate;
	}
	public void setCommcommentRegdate(String commcommentRegdate) {
		this.commcommentRegdate = commcommentRegdate;
	}
	public int getCommcommentThread() {
		return commcommentThread;
	}
	public void setCommcommentThread(int commcommentThread) {
		this.commcommentThread = commcommentThread;
	}
	public int getCommcommentDepth() {
		return commcommentDepth;
	}
	public void setCommcommentDepth(int commcommentDepth) {
		this.commcommentDepth = commcommentDepth;
	}
	public int getCommBoardSeq() {
		return commBoardSeq;
	}
	public void setCommBoardSeq(int commBoardSeq) {
		this.commBoardSeq = commBoardSeq;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	private String userId;
	
	
	
	
}
