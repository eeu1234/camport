package com.project.DTO;

public class ReportBoardFileDTO {
	
	private int reportBoardFileSeq;			//파일seq
	private String reportBoardFileName;		//파일이름
	private String reportBoardFileOrgname;	//진짜파일이름
	private String reportBoardFileSize;		//파일크기
	private String reportBoardFileType;		//파일 확장자
	private int reportBoardSeq;				//게시판seq
	private int freeBoardSeq;				//공지사항seq
	
	public int getReportBoardFileSeq() {
		return reportBoardFileSeq;
	}
	public void setReportBoardFileSeq(int reportBoardFileSeq) {
		this.reportBoardFileSeq = reportBoardFileSeq;
	}
	public String getReportBoardFileName() {
		return reportBoardFileName;
	}
	public void setReportBoardFileName(String reportBoardFileName) {
		this.reportBoardFileName = reportBoardFileName;
	}
	public String getReportBoardFileOrgname() {
		return reportBoardFileOrgname;
	}
	public void setReportBoardFileOrgname(String reportBoardFileOrgname) {
		this.reportBoardFileOrgname = reportBoardFileOrgname;
	}
	public String getReportBoardFileSize() {
		return reportBoardFileSize;
	}
	public void setReportBoardFileSize(String reportBoardFileSize) {
		this.reportBoardFileSize = reportBoardFileSize;
	}
	public String getReportBoardFileType() {
		return reportBoardFileType;
	}
	public void setReportBoardFileType(String reportBoardFileType) {
		this.reportBoardFileType = reportBoardFileType;
	}
	public int getReportBoardSeq() {
		return reportBoardSeq;
	}
	public void setReportBoardSeq(int reportBoardSeq) {
		this.reportBoardSeq = reportBoardSeq;
	}
	public int getFreeBoardSeq() {
		return freeBoardSeq;
	}
	public void setFreeBoardSeq(int freeBoardSeq) {
		this.freeBoardSeq = freeBoardSeq;
	}
	
	
	
}