package com.project.freeBoard;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.project.DAO.FreeBoardDAO;
import com.project.DTO.FreeBoardDTO;

public class FreeBoardAddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request
											, HttpServletResponse response) 
														throws ServletException, IOException {
		
		//1. 데이터 받기(Request -> MultipartRequest 교체)
		//1.5 첨부파일 처리(첨부파일명 얻기 -> 2번의 insert 작업에 추가)
		//2. DB 작업 -> DAO 위임
		//3. JSP 호출하기 -> 완료 메시지
		
		//1.
		request.setCharacterEncoding("UTF-8");
		
		
		String path = request.getRealPath("/files");
		int size = 100 * 1024 * 1024;
		
		
		try {

			//request -> (역할을 대신) -> multi
			MultipartRequest multi = new MultipartRequest(
																request,
																path, 		//업로드  폴더
																size, 		//최대 크기
																"UTF-8", //인코딩
																new DefaultFileRenamePolicy()
																);
			
			String freeBoardName = multi.getParameter("freeBoardName");
			String freeBoardContent = multi.getParameter("freeBoardContent");
			String freeboardPw = multi.getParameter("freeboardPw");
			String userId = multi.getParameter("userId");
			//String freeBoardSeq = multi.getParameter("freeBoardSeq");
			/*String userip = request.getRemoteAddr()
										.toString().replace("0:0:0:0:0:0:0:1", "127.0.0.1");*/
			//첨부파일명 얻기
			System.out.println("비밀번호");
			System.out.println(multi.getParameter("freeboardPw"));
			System.out.println(multi.getParameter("freeBoardSeq")); /*d*/
			System.out.println( multi.getParameter("userId"));
			System.out.println(multi.getParameter("freeBoardName")); /*d*/
			System.out.println(multi.getParameter("freeBoardContent")); /*d*/
					
			// 확장자 가져오는.. java
			//fileName.substring(fileName.lastIndexOf(".")+1,fileName.length())
			//
			
			
			String reportBoardfileName = multi.getFilesystemName("attach");
			String reportBoardfileOrgname = multi.getOriginalFileName("attach");
			
			
			
			
			System.out.println("파일명?");
			System.out.println(multi.getFilesystemName("attach"));
			System.out.println(multi.getOriginalFileName("attach"));
			
			//새글 or 답변글
			/*
			String mode = multi.getParameter("mode");
			boolean isReply = (mode != null && mode.equals("reply")) ? true : false;
			*/
			//freeBoardSeq = (multi.getParameter("freeBoardSeq")); //부모글번호
			
			
			
			//2.
			FreeBoardDTO dto = new FreeBoardDTO();
			dto.setFreeBoardName(freeBoardName);
			dto.setFreeBoardContent(freeBoardContent);
			dto.setUserId(userId);
			dto.setFreeboardPw(freeboardPw);
			//dto.setFreeBoardSeq(Integer.parseInt(freeBoardSeq));
			
			dto.setReportBoardfileName(reportBoardfileName);
			dto.setReportBoardfileOrgname(reportBoardfileOrgname);
			
			System.out.println("seq");
			System.out.println( dto.getFreeBoardSeq()); 
			
			
			FreeBoardDAO dao = new FreeBoardDAO();
			/*
			//새글 or 답변글의 thread, depth 추가하기
			
			//현재 작성하려는 글의 thread, depth
			int thread = -1;
			int depth = -1;
			
			if (isReply) {
				//답변글
				//a. 현재 테이블에 존재하는 모든 thread값 중에서 답변글의 부모글 thread값보다 작고 이전 새글의 thread값보다 큰 모든 thread값들을 -1 업데이트
				
				//부모글의 thread? depth?
				FreeBoardDTO parent = dao.get(pseq);
				
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
			 */
			
			int result = dao.add(dto);
			
			//3.
			request.setAttribute("result", result);
			

		} catch (Exception e) {

			System.out.println(e.toString());
			request.setAttribute("result", 0);

		}
		
		
		RequestDispatcher dispatcher
			= request.getRequestDispatcher("/freeboard/freeboardaddok.jsp");
		dispatcher.forward(request, response);		
		
	}
	
}