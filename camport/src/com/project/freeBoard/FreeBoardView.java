package com.project.freeBoard;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.DAO.FreeBoardDAO;
import com.project.DTO.FreeBoardCommentDTO;
import com.project.DTO.FreeBoardDTO;

public class FreeBoardView extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession  session = request.getSession();
		session.setAttribute("id", "leesu@gmail.com");
		
		
		////1. view.do?seq=5 데이터 받기
		String freeBoardSeq =request.getParameter("freeBoardSeq");
		String word = request.getParameter("word");
		System.out.println("gk");
		System.out.println(freeBoardSeq);
		
		boolean isSearch = false;
		if ((word != null) &&
				(word != "")) {
			isSearch = true;
		}
	
		////2. DB 작업(select) -> DAO 위임
		FreeBoardDAO dao =new FreeBoardDAO();
		
		
		//2.3 조회수 증가하기
		 session = request.getSession();
		
		if(session.getAttribute("freeBoardReadcnt") != null
					&& session.getAttribute("freeBoardReadcnt").equals("n")) {
			dao.addReadCount(freeBoardSeq);
			session.setAttribute("freeBoardReadcnt", "y");
		}
		
		FreeBoardDTO dto = dao.get(freeBoardSeq); //글 1개 반환
		
		
		//2.4 존재않는 게시물에 접근하는 경우 예외 처리
		if (dto == null) {
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('게시물이 이미 삭제되었거나 존재하지 않습니다.');location.href='/JSPTest/board/list.do';</script>");
			out.close();
			return;
		}
		
		
		
		//2.5 데이터 조작
		
		
		
		//태그 미적용 처리 -> 글내용의 태그를 무효화 처리
		// <> -> &lt;&gt;
		String freeBoardContent = dto.getFreeBoardContent();
		
		//글내용 엔터값 처리
		freeBoardContent = dto.getFreeBoardContent().replace("\r\n", "<br>");
		dto.setFreeBoardContent(freeBoardContent);
		
		
		//검색중이면서 내용일 경우.. 검색어 부각시키기
		if (isSearch) {
			freeBoardContent = dto.getFreeBoardContent()
				.replace(word, String.format("<span style='color:red;background-color:yellow;'>%s</span>", word));
			
			dto.setFreeBoardContent(freeBoardContent);
		}
		
		/*
		//첨부파일이 이미지면 본문에 보여주기
		if (dto.getFilename() != null && !dto.getFilename().equals("")) {
			
			//cat01.png, cat01.Png, cat01.PNG
			String filename = dto.getFilename().toLowerCase();
			
			if (filename.endsWith(".png")
					|| filename.endsWith(".jpg")
					|| filename.endsWith(".jpeg")
					|| filename.endsWith(".gif")) {
				
				content = String.format("<div style='padding:20px 0px;'><img src='/JSPTest/board/files/%s' id='attachimg'></div>", dto.getFilename()) + dto.getContent();
				
				dto.setContent(content);
				
			}
				
			
		}
		
		*/
		
		
		//2.7 댓글 목록 가져오기
		ArrayList<FreeBoardCommentDTO> clist = dao.listComment(freeBoardSeq);
		System.out.println("댓글목록가져오기");
	
		//3
		request.setAttribute("dto", dto);
		request.setAttribute("clist", clist);
		request.setAttribute("word", word);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/freeboard/freeboardview.jsp");
		dispatcher.forward(request, response);
		
	}
}
