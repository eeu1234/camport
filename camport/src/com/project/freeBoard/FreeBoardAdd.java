package com.project.freeBoard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FreeBoardAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request
											, HttpServletResponse response) 
														throws ServletException, IOException {
		
		//나를 왜불렀는지??
		//1. 새글 쓰기
		//		- add.do
		//2. 답변글 쓰기
		//		- add.do?mode=reply&seq=71
		HttpSession  session = request.getSession();
		session.setAttribute("id", "leesu@gmail.com");
		//session.setAttribute("pw", "leesu");
		
		/*String mode = request.getParameter("mode");*/
		//String freeBoardSeq = request.getParameter("freeBoardSeq");
		//System.out.println("freeBoardSeq : " + freeBoardSeq);
		//request.setAttribute("freeBoardSeq", freeBoardSeq);

		//1. 업무 없음
		//2. JSP 호출하기
		
		/*request.setAttribute("mode", mode);*/
		//request.setAttribute("freeBoardSeq", freeBoardSeq);
		
	
		
		
		RequestDispatcher dispatcher
			= request.getRequestDispatcher("/freeboard/freeboardadd.jsp");
		dispatcher.forward(request, response);		
		
	}
	
}
