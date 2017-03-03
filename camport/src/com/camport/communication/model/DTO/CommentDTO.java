package com.camport.communication.model.DTO;

public class CommentDTO {
	private String commentSeq;
	private String commentContent;
	private String commentRegdate;
	private String commentTherad;
	private String commentDepth;
	private String commentFileName;
	private String commentOrgFileName;
	private String commBoardSeq;
	private String userId;
	private String adminId;
	public String getCommentSeq() {
		return commentSeq;
	}
	public void setCommentSeq(String commentSeq) {
		this.commentSeq = commentSeq;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCommentRegdate() {
		return commentRegdate;
	}
	public void setCommentRegdate(String commentRegdate) {
		this.commentRegdate = commentRegdate;
	}
	public String getCommentTherad() {
		return commentTherad;
	}
	public void setCommentTherad(String commentTherad) {
		this.commentTherad = commentTherad;
	}
	public String getCommentDepth() {
		return commentDepth;
	}
	public void setCommentDepth(String commentDepth) {
		this.commentDepth = commentDepth;
	}
	public String getCommentFileName() {
		return commentFileName;
	}
	public void setCommentFileName(String commentFileName) {
		this.commentFileName = commentFileName;
	}
	public String getCommentOrgFileName() {
		return commentOrgFileName;
	}
	public void setCommentOrgFileName(String commentOrgFileName) {
		this.commentOrgFileName = commentOrgFileName;
	}
	public String getCommBoardSeq() {
		return commBoardSeq;
	}
	public void setCommBoardSeq(String commBoardSeq) {
		this.commBoardSeq = commBoardSeq;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

}
