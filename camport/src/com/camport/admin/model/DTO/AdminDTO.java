package com.camport.admin.model.DTO;

public class AdminDTO {

	
	private String adminId;
	private String adminPassword;
	
	private int noticeCommentSeq;
	private String noticeCommentContent;
	private String noticeCommentRegdate;
	private int noticeCommentThread;
	private int noticeCommentDepth;
	private String userId;
	private int noticeBoardSeq;
	
	
	private String noticeBoardName;
	private String noticeBoardContent;
	private String noticeBoardReadcount;
	private String noticeBoardView;	
	private String noticeBoardFileName;
	private String noticeBoardOrgFileName;
	private String noticeBoardRegdate;
	private int noticeBoardThread;
	private int noticeBoardDepth;
	
	//추가
	
	private String newimg;
	private String commentcount; 	//댓글수
	private String filename;		//첨부파일명
	private String orgfilename;		//첨부파일명(원본)
	
	

	
	
	public int getNoticeBoardThread() {
		return noticeBoardThread;
	}
	public void setNoticeBoardThread(int noticeBoardThread) {
		this.noticeBoardThread = noticeBoardThread;
	}
	public int getNoticeBoardDepth() {
		return noticeBoardDepth;
	}
	public void setNoticeBoardDepth(int noticeBoardDepth) {
		this.noticeBoardDepth = noticeBoardDepth;
	}
	
	public String getCommentcount() {
		return commentcount;
	}
	public void setCommentcount(String commentcount) {
		this.commentcount = commentcount;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getOrgfilename() {
		return orgfilename;
	}
	public void setOrgfilename(String orgfilename) {
		this.orgfilename = orgfilename;
	}

	
	

	
	public String getNewimg() {
		return newimg;
	}
	public void setNewimg(String newimg) {
		this.newimg = newimg;
	}
	public String getNoticeBoardRegdate() {
		return noticeBoardRegdate;
	}
	public void setNoticeBoardRegdate(String noticeBoardRegdate) {
		this.noticeBoardRegdate = noticeBoardRegdate;
	}
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
	public String getNoticeBoardName() {
		return noticeBoardName;
	}
	public void setNoticeBoardName(String noticeBoardName) {
		this.noticeBoardName = noticeBoardName;
	}
	public String getNoticeBoardContent() {
		return noticeBoardContent;
	}
	public void setNoticeBoardContent(String noticeBoardContent) {
		this.noticeBoardContent = noticeBoardContent;
	}
	public String getNoticeBoardReadcount() {
		return noticeBoardReadcount;
	}
	public void setNoticeBoardReadcount(String noticeBoardReadcount) {
		this.noticeBoardReadcount = noticeBoardReadcount;
	}
	public String getNoticeBoardView() {
		return noticeBoardView;
	}
	public void setNoticeBoardView(String noticeBoardView) {
		this.noticeBoardView = noticeBoardView;
	}
	public String getNoticeBoardFileName() {
		return noticeBoardFileName;
	}
	public void setNoticeBoardFileName(String noticeBoardFileName) {
		this.noticeBoardFileName = noticeBoardFileName;
	}
	public String getNoticeBoardOrgFileName() {
		return noticeBoardOrgFileName;
	}
	public void setNoticeBoardOrgFileName(String noticeBoardOrgFileName) {
		this.noticeBoardOrgFileName = noticeBoardOrgFileName;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getSubject() {
		// TODO Auto-generated method stub
		return null;
	}

}
