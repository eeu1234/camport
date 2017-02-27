package com.camport.admin.model.DTO;

public class AdminSDTO {

	
	private String column;
	private String word;
	private boolean isSearch;
	
	private int start;
	private int end;
	
	
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public boolean isSearch() {
		return isSearch;
	}
	public void setSearch(boolean isSearch) {
		this.isSearch = isSearch;
	}
	
}
