package com.project.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPage extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request
											, HttpServletResponse response) 
														throws ServletException, IOException {
		
		//header 메인 로그인폼 호출 JSP
		RequestDispatcher dispatcher
			= request.getRequestDispatcher("/loginPage.jsp");
		dispatcher.forward(request, response);		
		
	}
	
}













