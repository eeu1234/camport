package com.camport.communication.model.DTO;



//서블릿 <-> DAO
//DB에 상관없는 DTO         -> DTO
//DB의 데이터를 나르는 DTO -> VO(Value Object)
public class SearchDTO {

 private String column;
 private String word;
 private boolean isSearch;
 private String yn;
 private String commBoardSeq;
 
 
 public String getCommBoardSeq() {
	return commBoardSeq;
}
public void setCommBoardSeq(String commBoardSeq) {
	this.commBoardSeq = commBoardSeq;
}
public String getYn() {
	return yn;
}
public void setYn(String yn) {
	this.yn = yn;
}
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
