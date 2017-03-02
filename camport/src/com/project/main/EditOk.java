package com.project.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.ReportBoardDAO;
import com.project.DTO.ReportBoardDTO;

public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request
											, HttpServletResponse response) 
														throws ServletException, IOException {
		
		//1. 데이터 받기
		//2. DB 작업 -> DAO 위임
		//3. JSP 호출하기 -> 완료 메시지
		
		//1.
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String reportBoardSummary = request.getParameter("reportBoardSummary");
		String reportBoardName = request.getParameter("reportBoardName");
		String reportBoardContent = request.getParameter("reportBoardContent");
		Integer reportBoardSeq = Integer.parseInt(request.getParameter("reportBoardSeq"));
		String pw = request.getParameter("pw");
		//Integer reportBoardPoint = Integer.parseInt(request.getParameter("reportBoardPoint"));
		Integer collageSeq = Integer.parseInt(request.getParameter("collageSeq"));
		//2.
		ReportBoardDTO dto = new ReportBoardDTO();
		
		dto.setUserId(userId);
		dto.setReportBoardSummary(reportBoardSummary);
		dto.setReportBoardName(reportBoardName);
		dto.setReportBoardContent(reportBoardContent);
		
		dto.setReportBoardSeq(reportBoardSeq);
		dto.setPw(pw);
		//dto.setReportBoardPoint(reportBoardPoint);
		dto.setCollageSeq(collageSeq);
		
		ReportBoardDAO dao = new ReportBoardDAO();
		
		int result = 0;
		
		if (dao.check(dto)) {
			//0 : 실패
			//1 : 성공
			result = dao.edit(dto);
		} else {
			//2 : 암호 틀림
			result  = 2;
		}
		
		//System.out.println("result"+result);
		//3.
		request.setAttribute("result", result);
		request.setAttribute("reportBoardSeq", reportBoardSeq);
		
		RequestDispatcher dispatcher
			= request.getRequestDispatcher("/editok.jsp");
		dispatcher.forward(request, response);		
		
	}
	
}













