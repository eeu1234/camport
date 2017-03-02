package com.camport.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.camport.admin.model.DAO.AdminDAO;
import com.camport.admin.model.DTO.AdminDTO;

public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.
		int noticeBoardSeq =Integer.parseInt(request.getParameter("seq"));
		String column = request.getParameter("column");
		String word = request.getParameter("word");
		
		boolean isSearch = false;
		if ((column != null && word != null) &&
					(column != "" && word != "")) {
			isSearch = true;
		}
		
		//2.
		AdminDAO dao = new AdminDAO();
		
		//2.3 조회수 증가하기
		HttpSession session = request.getSession();
		
		if(session.getAttribute("noticeBoardReadcount") != null
					&& session.getAttribute("noticeBoardReadcount").equals("n")) {
			dao.addReadCount(noticeBoardSeq);
			
			session.setAttribute("noticeBoardReadcount", "y");
		}
		
		AdminDTO dto = dao.get(noticeBoardSeq);
		//3.
		request.setAttribute("dto", dto);

		
		RequestDispatcher dispatcher
			=request.getRequestDispatcher("/adminNotice/view.jsp");
		dispatcher.forward(request, response);
				
		
		
		
	}
	
}
