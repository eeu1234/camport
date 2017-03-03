package com.camport.communication.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.camport.communication.model.DAO.CommentDAO;
import com.camport.communication.model.DTO.CommentDTO;

public class CommentAdd extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		//아이디,글 시퀀스, 코멘트 내용
		session.setAttribute("id", "admin");
		String commBoardSeq = request.getParameter("commBoardSeq");
		String commentContent = request.getParameter("commentContent");
		String userId = (String)session.getAttribute("id");
		String adminId =(String)session.getAttribute("id");
		
		
		
		CommentDTO dto = new CommentDTO();
		dto.setCommBoardSeq(commBoardSeq);
		dto.setCommentContent(commentContent);
		dto.setUserId(userId);
		dto.setAdminId(adminId);
		
	
		
		
		
		

		
		
		CommentDAO dao = new CommentDAO();
		int result = dao.commAdd(dto);
		
		//System.out.println("result" + result);

		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/communication/commAdd.jsp");
		dispatcher.forward(request, response);
		
	}

}
