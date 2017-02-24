package com.camport.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camport.admin.model.DAO.AdminDAO;
import com.camport.admin.model.DTO.AdminDTO;

public class DelOk extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pw = request.getParameter("pw");
		int noticeBoardSeq = Integer.parseInt(request.getParameter("noticeBoardSeq"));
		System.out.println(pw);
		System.out.println(noticeBoardSeq);
		AdminDTO dto = new AdminDTO();
		
		dto.setAdminPassword(pw);
		dto.setNoticeBoardSeq(noticeBoardSeq);
		
		
		AdminDAO dao = new AdminDAO();
		
		int result = 0;
		
		if(dao.check(dto)) {
			result = dao.del(dto);
		} else {
			result=2;
		}
		
		request.setAttribute("result", result);
		
		RequestDispatcher dispatcher
		= request.getRequestDispatcher("/adminNotice/delok.jsp");
		dispatcher.forward(request, response);	
	}
	
}
