package com.project.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.project.DAO.ReportBoardDAO;
import com.project.DTO.ReportBoardDTO;
import com.project.DTO.ReportCommentDTO;

import sun.print.PrinterJobWrapper;

public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request
											, HttpServletResponse response) 
														throws ServletException, IOException {
		
		
		
		
		//1. view.do?reportBoardSeq=5 데이터 받기
		String reportBoardSeq = request.getParameter("reportBoardSeq");
		String column = request.getParameter("column");
		String word = request.getParameter("word");

		boolean isSearch = false;
		if ((column != null && word != null) &&
				(column != "" && word != "")) {
			isSearch = true;
		}       
		
		//2.
		ReportBoardDAO dao = new ReportBoardDAO();
						
		//2.3 조회수 증가하기(성공)
		HttpSession session = request.getSession();
		
		if(session.getAttribute("reportBoardReadcount") != null
					&& session.getAttribute("reportBoardReadcount").equals("n")) {
			dao.addReportBoardReadcount(reportBoardSeq);
			session.setAttribute("reportBoardReadcount", "y");
		}//if

		
		ReportBoardDTO dto = dao.get(reportBoardSeq); //글 1개 반환
		
		//2.4 존재않는 게시물에 접근하는 경우 예외 처리
		if (dto == null) {
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('게시물이 이미 삭제되었거나 존재하지 않습니다.');location.href='/camport/list.do';</script>");
			out.close();
			return;
		}

		
		
		//reportBoardContent = content
		String reportBoardContent = dto.getReportBoardContent();
		
		//삭제가능 66~
		//<script> 사용 불가능
		reportBoardContent = dto.getReportBoardContent()
							.replace("<script", "&lt;script")
							.replace("</script>", "&lt;/script&gt;");
		dto.setReportBoardContent(reportBoardContent);
		
		//이름 + 제목은 태그 사용 불가능
		dto.setUserId(dto.getUserId().replace("<", "&lt;").replace(">", "&gt;"));
		dto.setReportBoardName(dto.getReportBoardName().replace("<", "&lt;").replace(">", "&gt;"));
		
		//날짜 자르기
		dto.setReportBoardRegdate(dto.getReportBoardRegdate().substring(0,10));

		
		//글내용 엔터값 처리
		reportBoardContent = dto.getReportBoardContent().replace("\r\n", "<br>");
		dto.setReportBoardContent(reportBoardContent);
		
		//검색중이면서 내용일 경우.. 검색어 부각시키기
		if (isSearch && column.equals("reportBoardContent")) {
			reportBoardContent = dto.getReportBoardContent()
				.replace(word, String.format("<span style='color:blue; background-color:yellow;'>%s</span>", word));
			
			dto.setReportBoardContent(reportBoardContent);
		}//if
		//~88
		
		
		
		
		//첨부파일이 이미지면 본문에 보여주기
		if (dto.getReportBoardFileName() != null && !dto.getReportBoardFileName().equals("")) {
			
			//cat01.png, cat01.Png, cat01.PNG
			String filename = dto.getReportBoardFileName().toLowerCase();
			
			if (filename.endsWith(".png")
					|| filename.endsWith(".jpg")
					|| filename.endsWith(".jpeg")
					|| filename.endsWith(".gif")) {
				
				reportBoardContent = String.format("<div style='padding:20px 0px;'><img src='/camport/files/%s' id='attachimg'></div>", dto.getReportBoardFileName()) + dto.getReportBoardContent();
				
				dto.setReportBoardContent(reportBoardContent);
				
			}
				
			
		}
		
		//2.7 댓글 목록 가져오기
		ArrayList<ReportCommentDTO> clist = dao.listComment(reportBoardSeq);
				
		
		
		//3.
		request.setAttribute("dto", dto);		//부모글 보기	
		request.setAttribute("clist", clist);	//부모글에 딸린 댓글 목록 보기
		request.setAttribute("column", column);
		request.setAttribute("word", word);
		
		RequestDispatcher dispatcher
			= request.getRequestDispatcher("/view.jsp");
		dispatcher.forward(request, response);		
		
	}
	
}













