/*
package com.project.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.project.DAO.ReportBoardDAO;
import com.project.DTO.ReportBoardDTO;

public class LoginOk extends HttpServlet {
	protected void doPost(HttpServletRequest request
			, HttpServletResponse response) 
					throws ServletException, IOException {

		//1. 데이터 받기(Request -> MultipartRequest 교체)
		//2. DB 작업 -> DAO 위임
		//3. JSP 호출하기 -> 완료 메시지	
	
		//①
		request.setCharacterEncoding("UTF-8");
	
	
		String id = request.getParameter("email");
		String pw = request.getParameter("password");
		
		//if(id && pw 가 있다면){
		//	HttpSession session = request.getSession();
		//	session.setAttribute("id", id);
			
		//}
		
	         
		
		
		try {

			
			 
			//2	DB작업	
			ReportBoardDTO dto = new ReportBoardDTO();
			dto.setReportBoardName(reportBoardName);
			dto.setReportBoardContent(reportBoardContent);
			dto.setReportBoardSummary(reportBoardSummary);
			dto.setReportBoardPoint(reportBoardPoint);
			dto.setUserId(userId);
			dto.setRuleSeq(ruleSeq);
			dto.setPw(pw);
			
			dto.setReportBoardFileName(reportBoardFileName);
			dto.setReportBoardFileOrgname(reportBoardFileOrgname);
			
			ReportBoardDAO dao = new ReportBoardDAO();
	
			//새글 or 답변글의 thread, depth 추가하기
			
			//현재 작성하려는 글의 thread, depth
			/*
			int thread = -1;
			int depth = -1;
			
			if (isReply) {
				//답변글
				//a. 현재 테이블에 존재하는 모든 thread값 중에서 답변글의 부모글 thread값보다 작고 이전 새글의 thread값보다 큰 모든 thread값들을 -1 업데이트
				
				//부모글의 thread? depth?
				ReportBoardDTO parent = dao.get(pseq);
				
				//이전 새글의 thread?
				int prevThread = (int)Math.floor((parent.getThread() - 1) / 1000) * 1000;
				
				//thread - 1 업데이트
				dao.updateThread(parent.getThread(), prevThread);
				
				//b. 현재 작성중인 답변글의 thread값은 부모글의 thread - 1 을 사용한다.
				thread = parent.getThread() - 1;
				
				//c. 현재 작성중인 답변글의 depth값은 부모글의 depth + 1 을 사용한다.
				depth = parent.getDepth() + 1;
				
			} else {
				//새글
				//a. 현재 테이블에 존재하는 모든 thread값 중에서 가장 큰값을 찾아서 + 1000 한 값을 새글의 thread값으로 사용한다.(첫글에 한해서는 0 + 1000 을 첫글의 thread로 사용)
				thread = dao.getMaxThread() + 1000;
				
				//b. depth는 무조건 0을 사용한다. 
				depth = 0;				
			}
			
			dto.setThread(thread);
			dto.setDepth(depth);
			
			
			int result = dao.add(dto);
			//3. 완료후 JSP 파일 호출 넘어가기
			request.setAttribute("result", result);
				
			System.out.println("데이터 통과");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/addok.jsp");
			dispatcher.forward(request, response);		
	
		
	}
}
	*/