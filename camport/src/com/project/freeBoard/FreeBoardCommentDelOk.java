package com.project.freeBoard;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.FreeBoardDAO;

public class FreeBoardCommentDelOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request
											, HttpServletResponse response) 
														throws ServletException, IOException {
		
		//1. 데이터 받기
		//2. DB 작업(delete) -> DAO 위임
		//3. 결과 -> JSP 호출하기
		
		//1.
		String freeCommentSeq = request.getParameter("freeCommentSeq");							//댓글 번호
		String freeBoardSeq = request.getParameter("freeBoardSeq");	//부모글번호
		
		//2.
		FreeBoardDAO dao = new FreeBoardDAO();
				
		int result = dao.delComment(freeCommentSeq, freeBoardSeq);
		
		//3.
		request.setAttribute("result", result);
		request.setAttribute("freeBoardSeq", freeBoardSeq);
		
		
		RequestDispatcher dispatcher
			= request.getRequestDispatcher("/freeboard/freeboardcommentdelok.jsp");
		dispatcher.forward(request, response);		
		
	}
	
}
