package com.camport.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camport.admin.model.DAO.AdminDAO;
import com.camport.admin.model.DTO.AdminDTO;

public class EditOk extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String adminId=request.getParameter("id");
		String noticeBoardName=request.getParameter("subject");
		String noticeBoardContent=request.getParameter("content");
		int noticeBoardSeq=Integer.parseInt(request.getParameter("noticeBoardSeq"));
		
		AdminDTO dto = new AdminDTO();
		dto.setAdminId(adminId);
		dto.setNoticeBoardName(noticeBoardName);
		dto.setNoticeBoardContent(noticeBoardContent);
		dto.setNoticeBoardSeq(noticeBoardSeq);
		
		AdminDAO dao = new AdminDAO();
		
		int result = 0;
		if(dao.check(dto)){
			result=dao.edit(dto);			
		} else {
			result=2;
		}
		
		request.setAttribute("result", result);
		request.setAttribute("noticeBoardSeq",noticeBoardSeq);
		
		
		RequestDispatcher dispatcher
			= request.getRequestDispatcher("/adminNotice/editok.jsp");
		dispatcher.forward(request, response);		
				
		
		
	}
	
	
}
