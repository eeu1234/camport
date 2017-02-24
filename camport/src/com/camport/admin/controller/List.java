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
import com.camport.admin.model.DTO.AdminSDTO;


public class List extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		//검색
		String column = request.getParameter("column");
		String word = request.getParameter("word");
		
		boolean isSearch = false;
		if((column != null && word != null) &&
				(column != "" && word != "")) {
			isSearch = true;
		}
		
		
		
		
		
		
		
		//1.
		AdminDAO dao = new AdminDAO();
		
		AdminSDTO sdto = new AdminSDTO();
		sdto.setColumn(column);
		sdto.setWord(word);
		sdto.setSearch(isSearch);
		
		ArrayList<AdminDTO> list = dao.list();
		
		
		try {
			//1.5 일부 데이터 조작
			for(AdminDTO dto : list) {
				
			
				
				
				
			}//for
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		request.setAttribute("list", list);
		request.setAttribute("sdto", sdto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/adminNotice/list.jsp");
		dispatcher.forward(request, response);
		
		
		
	}
	
		
		
	}
	
	

