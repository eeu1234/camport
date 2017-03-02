package com.project.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.DAO.ReportBoardDAO;
import com.project.DTO.ReportCommentDTO;

public class ReportCommentOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request
											, HttpServletResponse response) 
														throws ServletException, IOException {
		
		
		//로그인한 세션
		HttpSession session = request.getSession();
		session.setAttribute("id", "hong@naver.com");
		
		
		//1. 데이터 받기
		//2. DB 작업(insert) -> DAO 위임
		//3. 결과 처리 -> JSP 호출하기
		
		//1.
		request.setCharacterEncoding("UTF-8");
		/*
				
		REPORTCOMMENT_SEQ			int
		REPORTCOMMENT_CONTENT		varchar
		REPORTCOMMENT_REGDATE		varchar
		REPORT_COMMENT_THREAD		int	
		REPORT_COMMENT_DEPTH		int
		REPORTBOARD_SEQ				int
		USER_ID						varchar
		RULE_SEQ					int 
		 
		*/
		//String userId = request.getParameter("userId");
		 
		String userId = (String)session.getAttribute("id");
		
		
		String reportCommentContent = request.getParameter("reportCommentContent");
		String reportBoardSeq =  request.getParameter("reportBoardSeq");
		String reportCommentRegdate = request.getParameter("reportCommentRegdate");
		
		
		//2.
		ReportBoardDAO dao = new ReportBoardDAO();
		ReportCommentDTO cdto = new ReportCommentDTO();
		cdto.setUserId(userId);
		cdto.setReportCommentContent(reportCommentContent);
		cdto.setReportBoardSeq(Integer.parseInt(reportBoardSeq));
		cdto.setReportCommentRegdate(reportCommentRegdate);
		
		int result = dao.addComment(cdto);
		
		//3.
		request.setAttribute("result", result);
		request.setAttribute("reportBoardSeq", reportBoardSeq);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/reportCommentOk.jsp");
		dispatcher.forward(request, response);		
		
	}
	
}




















