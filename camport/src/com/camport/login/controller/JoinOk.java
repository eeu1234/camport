
package com.camport.login.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.camport.admin.model.DTO.AdminDTO;
import com.camport.login.model.DAO.LoginDAO;
import com.camport.login.model.DTO.LoginDTO;

public class JoinOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//파라메터 받아서
		// insert 정보 
		
		
		// 1.
		request.setCharacterEncoding("UTF-8");
			
		String id = request.getParameter("userId");
		String pw = request.getParameter("userPw");
		String name = request.getParameter("userName");
		String tel = request.getParameter("userTel");
		String uniSeq = request.getParameter("universe");
		String colSeq = request.getParameter("collage");
		String majorSeq = request.getParameter("major");
		
		
		
		
		//2.
		LoginDTO dto = new LoginDTO();
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		dto.setTel(tel);
		dto.setUniName(uniSeq);
		dto.setColName(colSeq);
		dto.setMajorName(majorSeq);
		
		LoginDAO dao = new LoginDAO();
		int result = dao.join(dto);
			
		
		
		if(result == 1){
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
		}
		
		 
		
				
				
	
		request.setAttribute("result", result);
	
				
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login/loginok.jsp");
		dispatcher.forward(request, response);

	}

}
