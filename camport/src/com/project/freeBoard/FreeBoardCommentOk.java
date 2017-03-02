package com.project.freeBoard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.FreeBoardDAO;
import com.project.DTO.FreeBoardCommentDTO;

public class FreeBoardCommentOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 데이터 받기
		//2. DB 작업(insert) -> DAO 위임
		//3. 결과 처리 -> JSP 호출하기
		
		//1.
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String freeCommentContent = request.getParameter("freeCommentContent");
		String freeBoardSeq = request.getParameter("freeBoardSeq");
		System.out.println(freeBoardSeq);
		
		//2.
		FreeBoardDAO dao = new FreeBoardDAO();
		FreeBoardCommentDTO cdto = new FreeBoardCommentDTO();
		cdto.setUserId(userId);
		cdto.setFreeCommentContent(freeCommentContent);
		cdto.setFreeBoardSeq(Integer.parseInt(freeBoardSeq));
		
		System.out.println("commnetok.freeBoardSeq :" +freeBoardSeq);
		
		int result = dao.addComment(cdto);
		
		//3.
		request.setAttribute("result", result);
		request.setAttribute("freeBoardSeq", freeBoardSeq);
		
		RequestDispatcher dispatcher
			= request.getRequestDispatcher("/freeboard/freeboardcommentok.jsp");
		dispatcher.forward(request, response);		
		
	}
	
}