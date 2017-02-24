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
		
		//2.
		AdminDAO dao = new AdminDAO();
		
		//2.3 조회수 증가하기
		HttpSession session = request.getSession();
		
		if(session.getAttribute("NOTICE_BOARD_READCOUNT") != null
					&& session.getAttribute("NOTICE_BOARD_READCOUNT").equals("n")) {
			dao.addReadCount(noticeBoardSeq);
			session.setAttribute("NOTICE_BOARD_READCOUNT", "y");
		}
		
		AdminDTO dto = dao.get(noticeBoardSeq);
		//3.
		request.setAttribute("dto", dto);

		
		RequestDispatcher dispatcher
			=request.getRequestDispatcher("/adminNotice/view.jsp");
		dispatcher.forward(request, response);
				
		
		
		
	}
	
}
