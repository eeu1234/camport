package com.project.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.DAO.ReportBoardDAO;

public class DelCommentOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request
											, HttpServletResponse response) 
														throws ServletException, IOException {
		//로그인한 세션
		HttpSession session = request.getSession();
		session.setAttribute("id", "hong@naver.com");
		
		
		//1. 데이터 받기
		//2. DB 작업(delete) -> DAO 위임
		//3. 결과 -> JSP 호출하기
		
		//1.
		String reportCommentSeq = request.getParameter("reportCommentSeq");		//댓글 번호
		String reportBoardSeq = request.getParameter("reportBoardSeq");			//부모글번호
		
		//2.
		ReportBoardDAO dao = new ReportBoardDAO();
				
		int result = dao.delComment(reportCommentSeq, reportBoardSeq);
		
		//3.
		request.setAttribute("result", result);
		request.setAttribute("reportBoardSeq", reportBoardSeq);
		
		
		RequestDispatcher dispatcher
			= request.getRequestDispatcher("/delCommentOk.jsp");
		dispatcher.forward(request, response);		
		
	}
	
}













