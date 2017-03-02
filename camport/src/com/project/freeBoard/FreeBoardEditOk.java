package com.project.freeBoard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.collections.SynchronizedStack;

import com.project.DAO.FreeBoardDAO;
import com.project.DTO.FreeBoardDTO;

public class FreeBoardEditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request
											, HttpServletResponse response) 
														throws ServletException, IOException {
		
		//1. 데이터 받기
		//2. DB 작업 -> DAO 위임
		//3. JSP 호출하기 -> 완료 메시지
		
		//1.
		request.setCharacterEncoding("UTF-8");
		
		String freeBoardContent = request.getParameter("freeBoardContent");
		String freeBoardName = request.getParameter("freeBoardName");
		String freeBoardSeq = request.getParameter("freeBoardSeq");
		String userId = request.getParameter("userId");
		String freeboardPw = request.getParameter("freeboardPw");
		
		System.out.println("수정ok.java");
		System.out.println("비번"+freeboardPw);
		
		//2.
		FreeBoardDTO dto = new FreeBoardDTO();
		dto.setFreeBoardContent(freeBoardContent);
		dto.setFreeBoardName(freeBoardName);
		dto.setFreeBoardSeq(Integer.parseInt(freeBoardSeq));
		dto.setUserId(userId);
		dto.setFreeboardPw(freeboardPw);
		
		System.out.println("수정후 시퀀스:"+freeBoardSeq);
		
		FreeBoardDAO dao = new FreeBoardDAO();
		
		int result = 0;
		
		if (dao.check(dto)) {
			//0 : 실패
			//1 : 성공
			result = dao.edit(dto);
		} else {
			//2 : 암호 틀림
			result  = 2;
		}
		
		
		//3.
		request.setAttribute("result", result);
		request.setAttribute("freeBoardSeq", freeBoardSeq);
		
		RequestDispatcher dispatcher
			= request.getRequestDispatcher("/freeboard/freeboardeditok.jsp");
		dispatcher.forward(request, response);		
		
	}
	
}

