package com.camport.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camport.admin.model.DAO.AdminDAO;
import com.camport.admin.model.DTO.AdminDTO;

public class Edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int noticeBoardSeq =Integer.parseInt(request.getParameter("seq"));
		
		AdminDAO dao = new AdminDAO();
		
		AdminDTO dto = dao.get(noticeBoardSeq);
		
		request.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher
		=request.getRequestDispatcher("/adminNotice/edit.jsp");
	dispatcher.forward(request, response);
			
		
		
		
		
	}
	
}
