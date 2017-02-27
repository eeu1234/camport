package com.camport.admin.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.camport.admin.model.DTO.AdminDTO;
import com.camport.admin.model.DTO.AdminSDTO;

import Util.DBUtil;

public class AdminDAO {
	
	//DB연결
	private static Connection conn=null;

	
	public AdminDAO() {
		conn=DBUtil.open();
	}
	
	
	
	//AddOk 서블릿이 글 좀 써달라고 DTO 건네면서 위임
//		public int add(AdminNoticeDTO dto){
	public int add(AdminDTO dto){	
			try {
				
				String sql="INSERT INTO ADMIN_NOTICE(NOTICE_BOARD_NAME,NOTICE_BOARD_CONTENT,NOTICE_BOARD_THREAD,NOTICE_BOARD_DEPTH,ADMIN_ID)VALUES(?,?,?,?,?)";
				
				PreparedStatement stat = conn.prepareStatement(sql);
				stat.setString(1, dto.getNoticeBoardName());
				stat.setString(2, dto.getNoticeBoardContent());
				stat.setString(3, "admin");
				
				
				return stat.executeUpdate();//글쓰기
			} catch (Exception e) {
				System.out.println("add: " + e.toString());
			}
			
			
			return 0;
			
		}

	public ArrayList<AdminDTO> list(AdminSDTO sdto) {
		
		try {
			
		    String where = "";
	         if (sdto.isSearch()) {
	            where = String.format("AND %s like '%%%s%%'", sdto.getColumn(), sdto.getWord());
	         }
			
	         String sql = "SELECT NOTICE_BOARD_SEQ,NOTICE_BOARD_NAME,NOTICE_BOARD_READCOUNT,NOTICE_BOARD_REGDATE,NOTICE_BOARD_VIEW FROM ADMIN_NOTICE WHERE NOTICE_BOARD_VIEW = 'y'"
	                 + where + "ORDER BY NOTICE_BOARD_SEQ DESC";
			
			
			
			
			
			
			
			PreparedStatement stat = conn.prepareStatement(sql);
			
			ResultSet rs = stat.executeQuery();
			
			
			ArrayList<AdminDTO> list = new ArrayList<AdminDTO>();
			
			while(rs.next()) {
				AdminDTO dto = new AdminDTO();
			
				dto.setNoticeBoardSeq((rs.getInt("NOTICE_BOARD_SEQ")));
				dto.setNoticeBoardName(rs.getString("NOTICE_BOARD_NAME"));				
				dto.setNoticeBoardReadcount(rs.getString("NOTICE_BOARD_READCOUNT"));
				dto.setNoticeBoardRegdate(rs.getString("NOTICE_BOARD_REGDATE"));
				dto.setNoticeBoardView(rs.getString("NOTICE_BOARD_VIEW"));
				
				list.add(dto);
			}
			return list;
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
		
		
		return null;
	}
	
	public AdminDTO get(int noticeBoardSeq) {
		
		
		try {
			
			String sql="SELECT * FROM ADMIN_NOTICE WHERE NOTICE_BOARD_SEQ =?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1,noticeBoardSeq);
			
			
			ResultSet rs = stat.executeQuery();
			
			if(rs.next()) {
				
				AdminDTO dto = new AdminDTO();
				dto.setNoticeBoardSeq(rs.getInt("NOTICE_BOARD_SEQ"));
				dto.setNoticeBoardName(rs.getString("NOTICE_BOARD_NAME"));
				dto.setNoticeBoardContent(rs.getString("NOTICE_BOARD_CONTENT"));
				dto.setNoticeBoardReadcount(rs.getString("NOTICE_BOARD_READCOUNT"));
				dto.setNoticeBoardView(rs.getString("NOTICE_BOARD_VIEW"));
				dto.setNoticeBoardRegdate(rs.getString("NOTICE_BOARD_REGDATE"));
				
				return dto;
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return null;
	}



	public void addReadCount(int noticeBoardSeq) {
		
		try {

			String sql = "UPDATE ADMIN_NOTICE SET NOTICE_BOARD_READCOUNT = NOTICE_BOARD_READCOUNT+1 WHERE NOTICE_BOARD_SEQ = ?";
			
			PreparedStatement stat = conn.prepareStatement(sql);
			
			stat.setInt(1,noticeBoardSeq);
			
			stat.executeUpdate();

		} catch (Exception e) {

			System.out.println(e.toString());

		}
		
	}
	
	//EditOk 서블릿이 수정할 모든 내용을 줄테니 수정
	public int edit(AdminDTO dto){
		
		try {
			
			String sql="UPDATE ADMIN_NOTICE SET NOTICE_BOARD_NAME = ?,NOTICE_BOARD_CONTENT= ? WHERE NOTICE_BOARD_SEQ=?";
			
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, dto.getNoticeBoardName());
			stat.setString(2, dto.getNoticeBoardContent());
			stat.setInt(3, dto.getNoticeBoardSeq());
			System.out.println( "번호" +dto.getNoticeBoardSeq());
			System.out.println( "제목" +dto.getNoticeBoardName());
			System.out.println( "내용" +dto.getNoticeBoardContent());
			return stat.executeUpdate();
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
		return 0;
		
		
	}


	//수정 확인
	public boolean check(AdminDTO dto) {
		
		
		try {
			
			String sql = "SELECT COUNT(*) AS CNT FROM ADMIN_NOTICE WHERE NOTICE_BOARD_SEQ=?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, dto.getNoticeBoardSeq());
			
			ResultSet rs = stat.executeQuery();
			
			if(rs.next()){
				if(rs.getInt("cnt") == 1){
				
					return true;
				}
			}
			
		} catch (Exception e) {
			
		}
		
		
		
		
		return false;
	}
	
	public int del(AdminDTO dto) {
		
		try {
			
			String sql = "DELETE FROM ADMIN_NOTICE WHERE NOTICE_BOARD_SEQ = ?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, dto.getNoticeBoardSeq());
			
			return stat.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return 0;
	}



	public int getTotal(AdminSDTO sdto) {
		
		
		try {
		
			
			String where = "";
			if (sdto.isSearch()) {
				where = String.format("WHERE %s LIKE '%%s%%'"
											,sdto.getColumn()
											,sdto.getWord());
			}
			String sql = "SELECT COUNT(*) AS CNT FROM ADMIN_NOTICE" + where;
			PreparedStatement stat = conn.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			if(rs.next()){
				return rs.getInt("cnt");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
		return 0;
	}






	public void updateThread(int noticeBoardThread, int prevThread) {
		
		try {

			String sql = String.format("UPDATE ADMIN_NOTICE SET NOTICE_BOARD_THREAD = NOTICE_BOARD_THREAD - 1 WHERE NOTICE_BOARD_THREAD > ? AND NOTICE_BOARD_THREAD < ?");
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, prevThread);
			stat.setInt(2, noticeBoardThread);
			stat.executeUpdate();

		} catch (Exception e) {

			System.out.println(e.toString());

		}
		
		
	}
	
	
	
	
	
	

	
}//AdminDAO
