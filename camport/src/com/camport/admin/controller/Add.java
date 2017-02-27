package com.camport.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Add extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request
											, HttpServletResponse response) 
														throws ServletException, IOException {
		
		
		//나를 왜불렀는지??
		//1.새글 쓰기
		//	-add.do
		//2.답변글 쓰기
		//	-add.do?mode=reply&seq=71
		//String mode = request.getParameter("mode");
		//if (mode != null) {
		//int noticeBoardSeq = Integer.parseInt(request.getParameter("noticeBoardSeq"));//답변글의 부모글 번호
		
		//1. 업무 없음
		//2. JSP 호출하기
		
		//request.setAttribute("noticeBoardSeq", noticeBoardSeq);
		
		//}
		
		//request.setAttribute("mode", mode);
		
		RequestDispatcher dispatcher
			= request.getRequestDispatcher("/adminNotice/add.jsp");
		dispatcher.forward(request, response);		
		
	}
	
}

