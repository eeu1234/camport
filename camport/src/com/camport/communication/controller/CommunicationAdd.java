package com.camport.communication.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


	public class CommunicationAdd extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//나를 왜불렀는지??
			//1. 새글
			// - add.do
			//2. 답변글 쓰기
			// - add.do?mode=reply&seq=71
			//String mode = request.getParameter("mode");
			//String seq = request.getParameter("seq");//답변글의 부모글 번호
			
			
			//1.업무
			//2. JSP 호출하기
			//request.setAttribute("mode", mode);
			//request.setAttribute("seq", seq);

			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/communication/add.jsp");
			dispatcher.forward(request, response);
		}

}
