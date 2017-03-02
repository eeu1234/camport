package com.project.freeBoard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.DAO.FreeBoardDAO;
import com.project.DTO.FreeBoardDTO;

public class FreeBoardEdit extends HttpServlet {
	

	@Override
	protected void doGet(HttpServletRequest request
											, HttpServletResponse response) 
														throws ServletException, IOException {
		
		//1. 데이터 받기(seq)
		//2. DB작업(select) -> DAO 위임
		//3. DTO 반환 -> JSP 건네주면서 호출하기
		
		//1. onclick="location.href='/JSPTest/board/edit.do?seq=11';
		HttpSession  session = request.getSession();
		session.setAttribute("id", "leesu@gmail.com");
		//session.setAttribute("pw", "leesu");
		
		
		
		String freeBoardSeq = request.getParameter("freeBoardSeq");
		System.out.println("her");
		System.out.println("freeBoardSeq:"+request.getParameter("freeBoardSeq"));
		
		//2.
		FreeBoardDAO dao = new FreeBoardDAO();
		
		FreeBoardDTO dto = dao.get(freeBoardSeq);
		
		//3.
		request.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher
			= request.getRequestDispatcher("/freeboard/freeboardedit.jsp");
		dispatcher.forward(request, response);		
		
	}
	
}













