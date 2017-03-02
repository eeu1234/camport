package com.project.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.ReportBoardDAO;
import com.project.DTO.ReportBoardDTO;

public class Edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request
											, HttpServletResponse response) 
														throws ServletException, IOException {
		
		//1. 데이터 받기(seq)
		//2. DB작업(select) -> DAO 위임
		//3. DTO 반환 -> JSP 건네주면서 호출하기
		
		//1. onclick="location.href='/JSPTest/board/edit.do?seq=11';
		String reportBoardSeq = request.getParameter("reportBoardSeq");
		
		//2.
		ReportBoardDAO dao = new ReportBoardDAO();
		
		ReportBoardDTO dto = dao.get(reportBoardSeq);
		
		//3.
		request.setAttribute("dto", dto);

		System.out.println("수정");
		RequestDispatcher dispatcher
			= request.getRequestDispatcher("/edit.jsp");
		dispatcher.forward(request, response);		
		
	}
	
}













