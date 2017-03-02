package com.project.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Del extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request
											, HttpServletResponse response) 
														throws ServletException, IOException {
		
		//1. 데이터 받기
		//2. DB X
		//3. JSP 호출하기
		
		//1.
		String reportBoardSeq = request.getParameter("reportBoardSeq");
		
		
		//3.
		request.setAttribute("reportBoardSeq", reportBoardSeq);
		
		RequestDispatcher dispatcher
			= request.getRequestDispatcher("/del.jsp");
		dispatcher.forward(request, response);		
		
	}
	
}













