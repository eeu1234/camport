package com.camport.login.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




public class LogOut extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
		
		HttpSession session = request.getSession(); 
		session.removeAttribute("id");
		
		
		
		
				
				
				
		
		
		
		
		RequestDispatcher dispatcher
		= request.getRequestDispatcher("/adminNotice/list.jsp");
	dispatcher.forward(request, response);		
	
		
		
	}
	
	
}
