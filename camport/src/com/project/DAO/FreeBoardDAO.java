package com.project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.project.DTO.FreeBoardCommentDTO;
import com.project.DTO.FreeBoardDTO;
import com.project.DTO.FreeBoardSearchDTO;
import com.project.DTO.ReportBoardFileDTO;

import Util.DBUtil;

public class FreeBoardDAO {
	
	private Connection conn = null;
	
	public FreeBoardDAO() {
		conn = DBUtil.open();
	}
	
	//freeboardlist
	public ArrayList<FreeBoardDTO> list(FreeBoardSearchDTO sdto) {
		
		try{
			
			//검색하기 위해
			String where="";
			System.out.println(sdto.isSearch());
			if(sdto.isSearch()){
				where=String.format("WHERE F.%s  LIKE '%%%s%%' ", 
													sdto.getColumn(),
													sdto.getWord());
				
			}
			System.out.println("colum : " + sdto.getColumn() );
			
			String sql = String.format("SELECT F.FREE_BOARD_SEQ, R.REPORTBOARDFILE_TYPE , F.FREE_BOARD_NAME , F.FREE_BOARD_DOWNCOUNT , F.FREE_BOARD_REGDATE, F.FREE_BOARD_READCNT      FROM FREE_BOARD F JOIN REPORTBOARD_FILE R ON F.FREE_BOARD_SEQ = R.FREE_BOARD_SEQ    %s    ORDER BY F.FREE_BOARD_REGDATE DESC LIMIT ?,10"
											, where);
			
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, sdto.getStart()-1);
			ResultSet rs = stat.executeQuery();
			System.out.println(sql);
			
			ArrayList<FreeBoardDTO> list = new ArrayList<FreeBoardDTO>();
			
			while (rs.next()){
				FreeBoardDTO dto = new FreeBoardDTO();
				String type = rs.getString("R.REPORTBOARDFILE_TYPE"); 
				
				//System.out.println(type);
				if(type.contains("xl")){  //xl포함된 확장자 찾음
					type="MS 엑셀";
				}else if(type.contains("hw")){
					type="한컴오피스";
				}else if(type.contains("do")){
					type="워드프로세서";
				}else if(type.contains("pp")){
					type="파워포인트";
				}else{
					type="기타서식";
				}
				
				dto.setReportBoardFileType(type);
				dto.setFreeBoardName(rs.getString("F.FREE_BOARD_NAME"));
				dto.setFreeBoardDawncount(rs.getInt("F.FREE_BOARD_DOWNCOUNT"));
				dto.setFreeBoardRegdate(rs.getString("F.FREE_BOARD_REGDATE"));
				dto.setFreeBoardSeq(rs.getInt("F.FREE_BOARD_SEQ"));
				dto.setFreeBoardReadcnt(rs.getInt("F.FREE_BOARD_READCNT"));
				
				list.add(dto);
				
				
			}
			
			return list;
			
		}catch (Exception e){
			System.out.println(e.toString());
		}
		
		
		return null;
	}	
	//freeboardview 
	public FreeBoardDTO get(String freeBoardSeq) {
		
		try {
			
			String sql="SELECT * FROM FREE_BOARD WHERE FREE_BOARD_SEQ = ?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1,freeBoardSeq);
			
			ResultSet rs = stat.executeQuery();
			
			if(rs.next()){
				FreeBoardDTO dto = new FreeBoardDTO();
				dto.setUserId(rs.getString("USER_ID"));
				dto.setFreeBoardContent(rs.getString("FREE_BOARD_CONTENT"));
				dto.setFreeBoardDawncount(rs.getInt("FREE_BOARD_DOWNCOUNT"));
				dto.setFreeBoardName(rs.getString("FREE_BOARD_NAME"));
				dto.setFreeBoardReadcnt(rs.getInt("FREE_BOARD_READCNT"));
				dto.setFreeBoardRegdate(rs.getString("FREE_BOARD_REGDATE"));
				dto.setFreeBoardSeq(rs.getInt("FREE_BOARD_SEQ"));
							
				return dto;
			}
			
			
		} catch (Exception e) {
			System.out.println("get : " + e.toString());
		}
		
		return null;
	}
	
	//freeboardeditok
	public int edit(FreeBoardDTO dto) {
	
	try {
		
		String sql = "UPDATE FREE_BOARD SET FREE_BOARD_CONTENT = ?, FREE_BOARD_NAME = ? WHERE FREE_BOARD_SEQ=?";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, dto.getFreeBoardContent());
		stat.setString(2, dto.getFreeBoardName());
		//stat.setString(3, dto.getFreeboardPw());
		stat.setInt(3, dto.getFreeBoardSeq());
		
		return stat.executeUpdate();
		
	} catch (Exception e) {
		
		System.out.println("edit"+e.toString());
		
	}
	
	return 0;
	}

	//freeboardeditok 암호확인
	public boolean check(FreeBoardDTO dto) {
		try {

			//아래의 쿼리에서 최대값이 1이 나오는 이유가 뭔가요?
			//		-> 한마디 -> SEQ + ? -> PK
			String sql = "SELECT COUNT(*) AS CNT FROM FREE_BOARD WHERE FREE_BOARD_SEQ = ? AND FREE_BOARD_PW =?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, dto.getFreeBoardSeq());
			stat.setString(2, dto.getFreeboardPw());
			System.out.println("암호");
			System.out.println(dto.getFreeBoardSeq());
			System.out.println(dto.getFreeboardPw());
			
			ResultSet rs = stat.executeQuery();
			//System.out.println(rs.getInt("cnt"));
			if (rs.next()) {
				System.out.println(rs.getInt("cnt"));
				if (rs.getInt("cnt") == 1) {
					return true;
				}
			}
			

		} catch (Exception e) {

			System.out.println("check"+e.toString());

		}
		
		return false;
	}
	
	//freeboardaddok
	public int add(FreeBoardDTO dto) {
		try {

			int result = 0;
			
			String sql = "INSERT INTO FREE_BOARD ( FREE_BOARD_NAME, FREE_BOARD_CONTENT, FREE_BOARD_READCNT, FREE_BOARD_DOWNCOUNT, FREE_BOARD_REGDATE, USER_ID, FREE_BOARD_PW) "
					+ "VALUES (?,?,DEFAULT,DEFAULT,DEFAULT,?,?)";
			PreparedStatement stat = conn.prepareStatement(sql);
			//stat.setInt(1, dto.getFreeBoardSeq());
			stat.setString(1, dto.getFreeBoardName());
			stat.setString(2, dto.getFreeBoardContent());
			stat.setString(3, dto.getUserId());
			stat.setString(4, dto.getFreeboardPw());
			
			System.out.println("FREE_BOARD");
			
			result = stat.executeUpdate();

			sql ="SELECT FREE_BOARD_SEQ,FREE_BOARD_NAME, FREE_BOARD_CONTENT,FREE_BOARD_READCNT,FREE_BOARD_DOWNCOUNT,FREE_BOARD_REGDATE,USER_ID,FREE_BOARD_PW FROM FREE_BOARD";
			stat = conn.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			rs =stat.executeQuery();
			/*
			while(rs.next()){
				dto.setFreeBoardSeq(rs.getInt("FREE_BOARD_SEQ"));
				dto.setFreeBoardName(rs.getString("FREE_BOARD_NAME"));
				dto.setFreeBoardContent(rs.getString("FREE_BOARD_CONTENT"));
				dto.setFreeBoardReadcnt(rs.getInt("FREE_BOARD_READCNT"));
				dto.setFreeBoardDawncount(rs.getInt("FREE_BOARD_DOWNCOUNT"));
				dto.setFreeBoardRegdate(rs.getString("FREE_BOARD_REGDATE"));
				dto.setUserId(rs.getString("USER_ID"));
				dto.setFreeboardPw(rs.getString("FREE_BOARD_PW"));
				
			}
			*/
			System.out.println("SELECT");
			
			
			
			sql = "INSERT INTO REPORTBOARD_FILE ( FREE_BOARD_SEQ,REPORTBOARDFILE_SEQ,REPORTBOARDFILE_NAME, REPORTBOARDFILE_ORGNAME, REPORTBOARDFILE_SIZE, REPORTBOARDFILE_TYPE) "
					+ "VALUES (?,?,?,?,'10','jjj')" ;
			stat = conn.prepareStatement(sql);
			stat.setInt(1, dto.getFreeBoardSeq());
			stat.setInt(2, dto.getReportBoardfileSeq());
			stat.setString(3, dto.getReportBoardfileName());
			stat.setString(4, dto.getReportBoardfileOrgname());
			
			//stat.setString(3, dto.getReportBoardfileSize());
			//stat.setString(4, dto.getReportBoardFileType());
			
			System.out.println("seq");
			System.out.println( dto.getFreeBoardSeq()); /*0*/
			
			result = stat.executeUpdate();
			
			System.out.println("INSERT");
			
			return result;//글쓰기

		} catch (Exception e) {

			System.out.println("add : " + e.toString());

		}
		
		return 0;
	}
	
	//freeboarddelok
	public int del(FreeBoardDTO dto) {
		try {
			
			//지금 삭제하려는 부모글에 딸린 자식글 삭제
			String sql = "DELETE FROM FREE_BOARD_COMMENT WHERE FREE_BOARD_COMMENT_SEQ = ?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, dto.getFreeBoardSeq());
			stat.executeUpdate();
			
			//부모글 삭제
			
			System.out.println("del DAO");
			
			//자식테이블
			sql="DELETE FROM REPORTBOARD_FILE WHERE FREE_BOARD_SEQ = ?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, dto.getFreeBoardSeq());
			
			stat.executeUpdate();
			
			System.out.println("REPORTBOARD_FILE sql 실행");
			
			//부모테이블
			 sql = "DELETE FROM FREE_BOARD WHERE FREE_BOARD_SEQ = ?";
			 stat = conn.prepareStatement(sql);
			stat.setInt(1, dto.getFreeBoardSeq());
			
			System.out.println(sql);
			System.out.println(dto.getFreeBoardSeq());
			
			return stat.executeUpdate();
			
			
		} catch (Exception e) {

			System.out.println(e.toString());

		}
		
		return 0;
		
	}
	
	
	//FreeBoardList 게시판 글의 총 개수 알기
	public int getTotal(FreeBoardSearchDTO sdto) {
		
		try {

			String where = "";
			if (sdto.isSearch()) {
				where=String.format("WHERE %s LIKE '%%%s%%' ", 
						sdto.getColumn(),
						sdto.getWord());
			}
			
			String sql = "SELECT COUNT(*) AS CNT FROM FREE_BOARD" + where;
			PreparedStatement stat = conn.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}

		} catch (Exception e) {

			System.out.println(e.toString());

		}
		
		return 0;
	}
	
	//freebaordcommnetok.java
	public int addComment(FreeBoardCommentDTO cdto) {
		try {

			//댓글 추가
			String sql = "INSERT INTO FREE_BOARD_COMMENT (FREE_BOARD_COMMENT_CONTENT,FREE_BOARD_COMMENT_REGDATE, FREE_BOARD_SEQ, USER_ID) VALUES (?,DEFAULT,?,?);";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, cdto.getFreeCommentContent());
			stat.setInt(2, cdto.getFreeBoardSeq());
			stat.setString(3, cdto.getUserId());
			
			int result = stat.executeUpdate();
			/*
			if (result > 0) {
				//댓글수 증가
				sql = "UPDATE TBLBOARD SET COMMENTCOUNT = COMMENTCOUNT + 1 WHERE SEQ = ?";
				stat = conn.prepareStatement(sql);
				stat.setString(1, cdto.getBoardseq());
				stat.executeUpdate();
			}
			*/
			return result;			

		} catch (Exception e) {

			System.out.println(e.toString());

		}
		
		return 0;
	}

	
	//freeboardcommnetdelok.java
	public int delComment(String freeCommentSeq, String freeBoardSeq) {
		
		try {

			String sql = "DELETE FROM FREE_BOARD_COMMENT WHERE FREE_BOARD_COMMENT_SEQ = ?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, freeCommentSeq);
			
			int result = stat.executeUpdate();
			/*
			sql = "UPDATE TBLBOARD SET COMMENTCOUNT = COMMENTCOUNT - 1 WHERE SEQ = ?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, freeBoardSeq);
			stat.executeUpdate();
			*/
			return result;

		} catch (Exception e) {

			System.out.println(e.toString());

		}
		
		return 0;
	}
	
	//freebaordview 
	public void addReadCount(String freeBoardSeq) {
		
		try {

			String sql = "UPDATE FREE_BOARD SET FREE_BOARD_READCNT = FREE_BOARD_READCNT + 1 WHERE FREE_BOARD_SEQ = ?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, freeBoardSeq);
			System.out.println("freeBoardSeq"+freeBoardSeq);
			
			stat.executeUpdate();

		} catch (Exception e) {

			System.out.println(e.toString());

		}
		
	}
	
	
	//freeboardview 댓글 리스트불러오기
	public ArrayList<FreeBoardCommentDTO> listComment(String freeBoardSeq) {
		
		try {

			String sql = "SELECT * FROM FREE_BOARD_COMMENT WHERE FREE_BOARD_SEQ = ?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, freeBoardSeq);
			
			ResultSet rs = stat.executeQuery();
			ArrayList<FreeBoardCommentDTO> clist = new ArrayList<FreeBoardCommentDTO>();
			
			while (rs.next()) {
				//레코드 1개 -> DTO 1개
				FreeBoardCommentDTO dto = new FreeBoardCommentDTO();
					
				dto.setFreeCommentSeq(rs.getInt("FREE_BOARD_COMMENT_SEQ"));
				dto.setFreeCommentContent(rs.getString("FREE_BOARD_COMMENT_CONTENT"));
				//dto.setFreeCommentThread(rs.getInt("FREE_BOARD_COMMENT_THREAD"));
				//dto.setFreeCommentDepth(rs.getInt("FREE_BOARD_COMMENT_DEPTH"));
				dto.setFreeCommentRegdate(rs.getString("FREE_BOARD_COMMENT_REGDATE"));
				dto.setFreeBoardSeq(rs.getInt("FREE_BOARD_SEQ"));
				dto.setUserId(rs.getString("USER_ID"));

				clist.add(dto);				
			}
			
			return clist;
			
		} catch (Exception e) {

			System.out.println("listComment: "+e.toString());

		}
		
		return null;
	}
	
	
	//FreeBoardListBest list
	public ArrayList<FreeBoardDTO> listb(FreeBoardSearchDTO sdto) {
		try{
			
			String sql = "SELECT R.REPORTBOARDFILE_TYPE,F.FREE_BOARD_NAME,F.FREE_BOARD_READCNT,F.FREE_BOARD_DOWNCOUNT, F.FREE_BOARD_REGDATE, F.FREE_BOARD_SEQ FROM FREE_BOARD F JOIN REPORTBOARD_FILE R ON F.FREE_BOARD_SEQ = R.FREE_BOARD_SEQ ORDER BY F.FREE_BOARD_DOWNCOUNT DESC LIMIT 3";
		
			PreparedStatement stat = conn.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			
			ArrayList<FreeBoardDTO> listb = new ArrayList<FreeBoardDTO>();
			
			while (rs.next()){
				FreeBoardDTO dtob = new FreeBoardDTO();
				String type = rs.getString("R.REPORTBOARDFILE_TYPE"); 
				
				//System.out.println(type);
				if(type.contains("xl")){  //xl포함된 확장자 찾음
					type="MS 엑셀";
				}else if(type.contains("hw")){
					type="한컴오피스";
				}else if(type.contains("do")){
					type="워드프로세서";
				}else if(type.contains("pp")){
					type="파워포인트";
				}else{
					type="기타서식";
				}
				
				dtob.setReportBoardFileType(type);
				dtob.setFreeBoardName(rs.getString("F.FREE_BOARD_NAME"));
				dtob.setFreeBoardDawncount(rs.getInt("F.FREE_BOARD_DOWNCOUNT"));
				dtob.setFreeBoardRegdate(rs.getString("F.FREE_BOARD_REGDATE"));
				dtob.setFreeBoardSeq(rs.getInt("F.FREE_BOARD_SEQ"));
				dtob.setFreeBoardReadcnt(rs.getInt("F.FREE_BOARD_READCNT"));
				
				listb.add(dtob);
				
				
			}
			
			return listb;
			
		}catch (Exception e){
			System.out.println(e.toString());
		}
		
		
		return null;
	}
	
	
	
	
	

}
