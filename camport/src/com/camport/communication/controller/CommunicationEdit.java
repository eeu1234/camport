package com.camport.communication.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camport.communication.model.DAO.CommunicationBoardDAO;
import com.camport.communication.model.DTO.CommunicationBoardDTO;

public class CommunicationEdit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.
		String seq = request.getParameter("seq");

		// 2.
		CommunicationBoardDAO dao = new CommunicationBoardDAO();
		
		// 수정메소드
		int result = dao.communicationEdit(seq);

		
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/communication/edit.jsp");
		dispatcher.forward(request, response);
	}
}
