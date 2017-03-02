package com.camport.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camport.admin.model.DAO.AdminDAO;
import com.camport.admin.model.DTO.AdminDTO;

public class AddOk extends HttpServlet{


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	//1.
	request.setCharacterEncoding("UTF-8");
	
	String adminId = request.getParameter("admin");
	String noticeBoardName = request.getParameter("subject");
	String noticeBoardContent = request.getParameter("content");
	
	
	//2.
	AdminDTO dto = new AdminDTO();
	dto.setAdminId(adminId);
	dto.setNoticeBoardName(noticeBoardName);
	dto.setNoticeBoardContent(noticeBoardContent);
	
	AdminDAO dao = new AdminDAO();
	int result = dao.add(dto);
	
	
	//3.
	request.setAttribute("result", result);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/adminNotice/addok.jsp");
	dispatcher.forward(request, response);

		
			
			
	}
}
