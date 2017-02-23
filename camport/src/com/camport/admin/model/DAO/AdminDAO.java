package com.camport.admin.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.camport.admin.model.DTO.AdminDTO;
import com.camport.admin.model.DTO.AdminNoticeDTO;

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
				
				String sql="INSERT INTO ADMIN_NOTICE(NOTICE_BOARD_SEQ,NOTICE_BOARD_NAME,NOTICE_BOARD_CONTENT,NOTICE_BOARD_REGDATE,NOTICE_BOARD_READCOUNT)   VALUES(?,?,?,DEFAULT,DEFAULT)";
				
				PreparedStatement stat = conn.prepareStatement(sql);
				stat.setInt(1,dto.getNoticeBoardSeq());
				stat.setString(2, dto.getNoticeBoardName());
				stat.setString(3, dto.getNoticeBoardContent());
				stat.setString(4, dto.getNoticeBoardRegdate());
				stat.setString(5, dto.getNoticeBoardReadcount());
				
				
			} catch (Exception e) {
				System.out.println("add: " + e.toString());
			}
			
			
			return 0;
			
		}

	public ArrayList<AdminDTO> list() {
		
		try {
			
			String sql = "SELECT NOTICE_BOARD_SEQ,NOTICE_BOARD_NAME,NOTICE_BOARD_READCOUNT,NOTICE_BOARD_VIEW FROM ADMIN_NOTICE";
			
			PreparedStatement stat = conn.prepareStatement(sql);
			
			ResultSet rs = stat.executeQuery();
			
			
			ArrayList<AdminDTO> list = new ArrayList<AdminDTO>();
			
			while(rs.next()) {
				AdminDTO dto = new AdminDTO();
			
				dto.setNoticeBoardSeq((rs.getInt("NOTICE_BOARD_SEQ")));
				dto.setNoticeBoardName(rs.getString("NOTICE_BOARD_NAME"));				
				dto.setNoticeBoardReadcount(rs.getString("NOTICE_BOARD_READCOUNT"));
				dto.setNoticeBoardView(rs.getString("NOTICE_BOARD_VIEW"));
				
				list.add(dto);
			}
			return list;
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
		
		
		return null;
	}
	
	

	
}//AdminDAO
