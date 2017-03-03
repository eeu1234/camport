package com.camport.login.model.DTO;

public class LoginDTO {
	private String id;
	private String pw;
	
	//회원가입
	private String name;
	private String tel;
	
	//대학
	private String uniName;
	private String uniSeq;
	
	//단과
	private String colName;
	private String colSeq;

	//major
	private String majorName;
	private String majorSeq;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getUniName() {
		return uniName;
	}
	public void setUniName(String uniName) {
		this.uniName = uniName;
	}
	public String getUniSeq() {
		return uniSeq;
	}
	public void setUniSeq(String uniSeq) {
		this.uniSeq = uniSeq;
	}
	public String getColName() {
		return colName;
	}
	public void setColName(String colName) {
		this.colName = colName;
	}
	public String getColSeq() {
		return colSeq;
	}
	public void setColSeq(String colSeq) {
		this.colSeq = colSeq;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public String getMajorSeq() {
		return majorSeq;
	}
	public void setMajorSeq(String majorSeq) {
		this.majorSeq = majorSeq;
	}
	
	
	
	
}
