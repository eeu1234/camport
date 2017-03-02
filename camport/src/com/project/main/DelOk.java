package com.project.main;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.ReportBoardDAO;
import com.project.DTO.ReportBoardDTO;
import com.project.DTO.ReportBoardFileDTO;

public class DelOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request
											, HttpServletResponse response) 
														throws ServletException, IOException {
		
		//1. 데이터 받기
		//2. DB 작업 -> DAO 위임
		//3. JSP 호출하기 -> 완료 메시지
		
		//1.		
		String pw = request.getParameter("pw");
		String reportBoardSeq = request.getParameter("reportBoardSeq");
		
		
		
		//Integer reportBoardPoint = Integer.parseInt(request.getParameter("reportBoardPoint"));
		
		//2.
		ReportBoardDTO dto = new ReportBoardDTO();
		dto.setPw(pw);
		dto.setReportBoardSeq(Integer.parseInt(reportBoardSeq));
		
		ReportBoardDAO dao = new ReportBoardDAO();
		
		int result = 0;
		
		if (dao.check(dto)) {
			
			//게시물 삭제 전에 첨부파일명을 잠시 저장
			ReportBoardDTO temp = dao.get(reportBoardSeq);
			String filename = temp.getReportBoardFileName();
			/*
			
FILENAME VARCHAR2(200) NULL,            --첨부파일명(하드에 저장된 이름)
    ORGFILENAME VARCHAR2(200) NULL,          --원래파일명(사용자가 처음 올린 이름)
    THREAD NUMBER NOT NULL,                 --계층형
    THREAD NUMBER NOT NULL                   --계층형


			 
			*/
			//0 : 실패
			//1 : 성공
			result = dao.del(dto);
			
			if (result == 1) {
				//게시물 삭제를 성공하면 첨부파일 같이 삭제
				String path = request.getRealPath("/files");
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
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/delOk.jsp");
		dispatcher.forward(request, response);		
		
	}
	
}













