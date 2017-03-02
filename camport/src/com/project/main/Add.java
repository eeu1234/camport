package com.project.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Add extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request
											, HttpServletResponse response) 
														throws ServletException, IOException {
		//로그인한 세션
		HttpSession session = request.getSession();
		session.setAttribute("id", "hong@naver.com");
		
		//1. New 글쓰기
		String mode = request.getParameter("mode");
		String seq = request.getParameter("seq");//답변글의 부모글 번호
		
		request.setAttribute("mode", mode);
		request.setAttribute("seq", seq);
		
		
		//2. JSP 호출하기
		RequestDispatcher dispatcher = request.getRequestDispatcher("/add.jsp");
		dispatcher.forward(request, response);		
		
	}
	
}













