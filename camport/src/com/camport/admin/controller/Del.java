package com.camport.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Del extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int noticeBoardSeq =Integer.parseInt(request.getParameter("seq"));
		
		
		request.setAttribute("noticeBoardSeq",noticeBoardSeq);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/adminNotice/del.jsp");
		dispatcher.forward(request, response);
		
	}
	
}
