package com.camport.admin.model.DTO;

public class AdminNoticeCommentDTO {

	private int noticeCommentSeq;
	private String noticeCommentContent;
	private String noticeCommentRegdate;
	private int noticeCommentThread;
	private int noticeCommentDepth;
	private String userId;
	private int noticeBoardSeq;
	
	
	
	public int getNoticeCommentSeq() {
		return noticeCommentSeq;
	}
	public void setNoticeCommentSeq(int noticeCommentSeq) {
		this.noticeCommentSeq = noticeCommentSeq;
	}
	public String getNoticeCommentContent() {
		return noticeCommentContent;
	}
	public void setNoticeCommentContent(String noticeCommentContent) {
		this.noticeCommentContent = noticeCommentContent;
	}
	public String getNoticeCommentRegdate() {
		return noticeCommentRegdate;
	}
	public void setNoticeCommentRegdate(String noticeCommentRegdate) {
		this.noticeCommentRegdate = noticeCommentRegdate;
	}
	public int getNoticeCommentThread() {
		return noticeCommentThread;
	}
	public void setNoticeCommentThread(int noticeCommentThread) {
		this.noticeCommentThread = noticeCommentThread;
	}
	public int getNoticeCommentDepth() {
		return noticeCommentDepth;
	}
	public void setNoticeCommentDepth(int noticeCommentDepth) {
		this.noticeCommentDepth = noticeCommentDepth;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getNoticeBoardSeq() {
		return noticeBoardSeq;
	}
	public void setNoticeBoardSeq(int noticeBoardSeq) {
		this.noticeBoardSeq = noticeBoardSeq;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	private String adminId;
	
	
	
	
}
