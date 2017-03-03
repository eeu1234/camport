package com.camport.communication.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camport.communication.model.DAO.CommunicationBoardDAO;
import com.camport.communication.model.DTO.CommunicationBoardDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CommunicationAddOk extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		//1. 데이터 받기             (Request -> MultipartRequest 교체)
		//1.5 첨부파일 처리(첨부파일명 얻기) -> 2번의 insert 작업에 추가
		
		//2. DB 작업 -> DAO 위임
		//3. JSP 호출하기 -> 완료 메시지
		
		//1.encoding
		//String path = request.getRealPath("D:\\images");
		String path = "D:\\images";
		int size = 100 * 1024 * 1024; //100MB|
		
		
		try {
			//request -> (역할을 대신) ->multi 
			MultipartRequest multi = new  MultipartRequest(request, path,size,"UTF-8",new DefaultFileRenamePolicy() );
			String subject = multi.getParameter("subject");
			String content = multi.getParameter("content");
			String attach = multi.getParameter("attach");
			String userId = multi.getParameter("userId");
			//multi로 안바꾸는 이유 - > getParameter 가아니라서 request가 여전히 한다.
			//String userip = request.getRemoteAddr().toString().replace("0:0:0:0:0:0:0:1","127.0.0.1");
			
			
			//첨부파일명 얻기
			String filename= multi.getFilesystemName("attach");
			String orgfilename =  multi.getOriginalFileName("attach");
			
		
					
					
			//2. DB 작업
			CommunicationBoardDTO dto = new CommunicationBoardDTO();
			dto.setCommName(subject);
			dto.setCommContent(content);
			dto.setCommFileName(filename);
			dto.setCommOrgFileName(orgfilename);
			dto.setUserId(userId);
			CommunicationBoardDAO dao = new CommunicationBoardDAO();

		
			
			
			int result = dao.communicationAdd(dto);
			
			
			//3. JSP 호출
			request.setAttribute("result", result);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			//3. JSP 호출
			request.setAttribute("result", 0);
		}
		
		
		
		

		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/communication/addOk.jsp");
		dispatcher.forward(request, response);
	}
}
