package com.camport.login.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.camport.login.model.DTO.LoginDTO;

import Util.DBUtil;

public class LoginDAO {

	// DB연결
	private static Connection conn = null;

	public LoginDAO() {
		conn = DBUtil.open();
	}

	public int login(LoginDTO dto) {

		try {

			String sql = "SELECT USER_ID FROM USER WHERE USER_ID = ? AND USER_PW = ?";
			
			
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, dto.getId());
			stat.setString(2, dto.getPw());

			ResultSet rs = stat.executeQuery();
			
			int i=0; 			
			while(rs.next()){
				
				i++;
				
			}

			
			if(i !=1){
				i=0;
				String sql2 = "SELECT ADMIN_ID FROM ADMIN WHERE ADMIN_ID = ? AND ADMIN_PASSWORD = ?";
									
				PreparedStatement stat2 = conn.prepareStatement(sql2);
				stat2.setString(1, dto.getId());
				stat2.setString(2, dto.getPw());
				ResultSet rs2 = stat2.executeQuery();
					
				while(rs2.next()){
					i++;
				}				
			}			
			return i;
			
			} catch (Exception e) {
			System.out.println("hh" + e.toString());
		}

		return 0;
		
	}

	public int join(LoginDTO dto) {
		
		try {

			String sql = "INSERT INTO USER(USER_ID,USER_PW,USER_NAME,USER_TEL,USER_POINT,MAJOR_SEQ) VALUES(?,?,?,?,DEFAULT,?)";

			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, dto.getId());
			stat.setString(2, dto.getPw());
			stat.setString(3, dto.getName());
			stat.setString(4, dto.getTel());
			stat.setString(5, dto.getMajorname());


			return stat.executeUpdate();
		} catch (Exception e) {
			System.out.println("add: " + e.toString());
		}
		
		
		
		return 0;
	}

	public ArrayList<LoginDTO> list() {
		
		try {
			
			String sql = "SELECT UNIVERSITY_NAME FROM UNIVERSITY";
			PreparedStatement stat = conn.prepareStatement(sql);
			
			ResultSet rs = stat.executeQuery();
			
			ArrayList<LoginDTO> list = new ArrayList<LoginDTO>();
			while(rs.next()) {
				LoginDTO udto = new LoginDTO();
				//udto.setUniname(rs.getString("uniname"));//시퀀스
				udto.setUniname(rs.getString("UNIVERSITY_NAME"));
				list.add(udto);
			}
			return list;
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		
		return null;
	}

	public ArrayList<LoginDTO> clist() {
		
		
		try {
			
			String sql = "SELECT COLLAGE_NAME FROM COLLAGE";
			PreparedStatement stat = conn.prepareStatement(sql);
			
			ResultSet rs = stat.executeQuery();
			
			ArrayList<LoginDTO> list = new ArrayList<LoginDTO>();
			while(rs.next()) {
				LoginDTO cdto = new LoginDTO();
				
				cdto.setColname(rs.getString("COLLAGE_NAME"));
				list.add(cdto);
			}
			return list;
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		
		return null;
	}

	public ArrayList<LoginDTO> mlist() {
			
		
		try {
			
			String sql = "SELECT MAJOR_NAME FROM MAJOR";
			PreparedStatement stat = conn.prepareStatement(sql);
			
			ResultSet rs = stat.executeQuery();
			
			ArrayList<LoginDTO> list = new ArrayList<LoginDTO>();
			while(rs.next()) {
				LoginDTO mdto = new LoginDTO();
				
				mdto.setMajorname(rs.getString("MAJOR_NAME"));
				list.add(mdto);
			}
			return list;
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		
		return null;
	}
	
	

}// LoginDAO
