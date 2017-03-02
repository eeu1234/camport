package com.project.DTO;

public class FreeBoardSearchDTO {
	private boolean isSearch;
	private String word;
	private String column;
	
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
	public boolean isSearch() {
		return isSearch;
	}
	public void setSearch(boolean isSearch) {
		this.isSearch = isSearch;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	
}
