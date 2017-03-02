
package com.camport.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.camport.login.model.DAO.LoginDAO;
import com.camport.login.model.DTO.LoginDTO;

public class LoginOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.
		request.setCharacterEncoding("UTF-8");
			
		String id = request.getParameter("iid");
		String pw = request.getParameter("ppw");
		
		
		//2.
		LoginDTO dto = new LoginDTO();
		dto.setId(id);
		dto.setPw(pw);
		
		LoginDAO dao = new LoginDAO();
		int result = dao.login(dto);
		
		if(result == 1){
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
		}
		
		
		
	
		request.setAttribute("result", result);
				
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login/loginok.jsp");
		dispatcher.forward(request, response);

	}

}
