package com.project.freeBoard;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.FreeBoardDAO;
import com.project.DTO.FreeBoardDTO;

public class FreeBoardDelOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request
											, HttpServletResponse response) 
														throws ServletException, IOException {
		
		//1. 데이터 받기
		//2. DB 작업 -> DAO 위임
		//3. JSP 호출하기 -> 완료 메시지
		
		//1.		
		String freeboardPw = request.getParameter("freeboardPw");
		String freeBoardSeq = request.getParameter("freeBoardSeq");
		
		//2.
		FreeBoardDTO dto = new FreeBoardDTO();
		dto.setFreeboardPw(freeboardPw);
		dto.setFreeBoardSeq(Integer.parseInt(freeBoardSeq));
		
		FreeBoardDAO dao = new FreeBoardDAO();
		
		int result = 0;
		
		if (dao.check(dto)) {
			
			//게시물 삭제 전에 첨부파일명을 잠시 저장
			FreeBoardDTO temp = dao.get(freeBoardSeq);
			String filename = temp.getReportBoardfileName();
			System.out.println("freebaorddelok.java 시퀀스:"+freeBoardSeq);
			//0 : 실패
			//1 : 성공
			result = dao.del(dto);
			System.out.println("result: "+result);
			
			if (result == 1) {
				//게시물 삭제를 성공하면 첨부파일 같이 삭제
				String path = request.getRealPath("/freeboard/files");
				File file = new File(path + "/"+ filename);//첨부 파일 참조 객체
				if (file.exists()) {
					file.delete();//파일 삭제
				}
			}
			
		} else {
			//2 : 암호 틀림
			result  = 2;
		}
		
		
		//3.
		request.setAttribute("result", result);
		
		
		RequestDispatcher dispatcher
			= request.getRequestDispatcher("/freeboard/freeboarddelok.jsp");
		dispatcher.forward(request, response);		
		
	}
	
}

