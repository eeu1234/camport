package com.project.freeBoard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FreeBoardDel extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request
											, HttpServletResponse response) 
														throws ServletException, IOException {
		
		//1. 데이터 받기
		//2. DB X
		//3. JSP 호출하기
		
		//1.
		String freeBoardSeq = request.getParameter("freeBoardSeq");
		
		
		//3.
		request.setAttribute("freeBoardSeq", freeBoardSeq);
		
		RequestDispatcher dispatcher
			= request.getRequestDispatcher("/freeboard/freeboarddel.jsp");
		dispatcher.forward(request, response);		
		
	}
	
}
