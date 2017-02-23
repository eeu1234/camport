package com.camport.admin.controller;

import java.io.IOException;


import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camport.admin.model.DAO.AdminDAO;
import com.camport.admin.model.DTO.AdminDTO;


public class List extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//1.
		AdminDAO dao = new AdminDAO();
		ArrayList<AdminDTO> list = dao.list();
		
		
		try {
			//1.5 일부 데이터 조작
			for(AdminDTO dto : list) {
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		request.setAttribute("list", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/adminNotice/list.jsp");
		dispatcher.forward(request, response);
		
		
		
	}
	
		
		
	}
	
	

