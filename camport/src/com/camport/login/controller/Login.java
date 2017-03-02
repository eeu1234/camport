package com.camport.login.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.camport.login.model.DAO.LoginDAO;
import com.camport.login.model.DTO.LoginDTO;



public class Login extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		LoginDAO udao = new LoginDAO();
		ArrayList<LoginDTO> list = udao.list();
		
		LoginDAO cdao = new LoginDAO();
		ArrayList<LoginDTO> clist = cdao.clist();
		
		LoginDAO mdao = new LoginDAO();
		ArrayList<LoginDTO> mlist = mdao.mlist();
		
		 
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("id") != null) {
			
			session.removeAttribute("id");
		}
		
		
				
				
				
		
		
		
		request.setAttribute("list", list);
		request.setAttribute("clist", clist);
		request.setAttribute("mlist", mlist);
		
		
		RequestDispatcher dispatcher
		= request.getRequestDispatcher("/login.jsp");
	dispatcher.forward(request, response);		
	
		
		
	}
	
	
}
