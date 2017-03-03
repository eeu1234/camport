package com.camport.communication.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camport.communication.model.DAO.CommunicationBoardDAO;
import com.camport.communication.model.DTO.SearchDTO;

public class YnChange extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		// 1. 데이터 받기 (Request -> MultipartRequest 교체)
		// 1.5 첨부파일 처리(첨부파일명 얻기) -> 2번의 insert 작업에 추가

		// 2. DB 작업 -> DAO 위임
		// 3. JSP 호출하기 -> 완료 메시지

		// 1.encoding
		String commBoardSeq = request.getParameter("commBoardSeq");
		String yn = request.getParameter("yn");
	//	System.out.println(commBoardSeq);
	//	System.out.println(yn);
			
			// 2. DB 작업
			CommunicationBoardDAO dao = new CommunicationBoardDAO();
			int result = dao.ynChange(commBoardSeq, yn);
			
			
			request.setAttribute("result", result);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/communication/ynChange.jsp");
		dispatcher.forward(request, response);
	}
}
