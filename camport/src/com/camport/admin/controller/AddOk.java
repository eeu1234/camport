package com.camport.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camport.admin.model.DAO.AdminDAO;
import com.camport.admin.model.DTO.AdminDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 데이터 받기(Request -> MultipartRequest 교체)
		// 1.5 첨부파일 처리(첨부파일명 얻기 -> 2번의 insert 작업에 추가)
		// 2. DB 작업 -> DAO 위임
		// 3. JSP 호출하기 -> 완료 메시지

		// 1.
		request.setCharacterEncoding("UTF-8");

		String path = request.getRealPath("/files");
		int size = 100 * 1024 * 1024;

		try {

			// request -> (역할을 대신) -> multi
			MultipartRequest multi = new MultipartRequest(request, 
																path, // 업로드
																										
																size, // 최대 크기
														    	"UTF-8", // 인코딩
														    	new DefaultFileRenamePolicy());

		
			String noticeBoardName = multi.getParameter("noticeBoardName");
			
			String noticeBoardContent = multi.getParameter("noticeBoardContent");
		
			
			
			// 새글 or 답변글
			//String mode = multi.getParameter("mode");
			//boolean isReply = (mode != null && mode.equals("reply")) ? true : false;
			//int noticeBoardSeq = Integer.parseInt(multi.getParameter("noticeBoardSeq")); // 부모글번호

			
			
			// 2.
			AdminDTO dto = new AdminDTO();
			
			dto.setNoticeBoardName(noticeBoardName);
			dto.setNoticeBoardContent(noticeBoardContent);

			AdminDAO dao = new AdminDAO();

			// 새글 or 답변글의 thread, depth 추가하기

			// 현재 작성하려는 글의 thread, depth
			int thread = -1;
			int depth = -1;

			/*if (isReply) {
				// 답변글
				// a.현재 테이블에 존재하는 모든 thread값 중에서 답변글의 부모글 thread값보다 작고 이전 새글의
				// thread값보다 큰 모든 thread값들을 -1 업데이트

				// 부모글의 thread ?
				AdminDTO parent = dao.get(noticeBoardSeq);

				// 이전 새글의 thread?
				int prevThread = (int) Math.floor((parent.getNoticeBoardThread() - 1) / 1000) * 1000;

				// thread-1 업데이트
				dao.updateThread(parent.getNoticeBoardThread(), prevThread);

				// b.현재 작성중인 답변글의 thread값은 부모글의 thread-1을 사용한다.
				thread = parent.getNoticeBoardThread() - 1;

				// c.현재 작성중인 답변글의 depth값은 부모글의 depth+1을 사용한다.
				depth = parent.getNoticeBoardDepth() + 1;

			} else {*/
				// 새글
				// a. 현재 테이블에 존재하는 모든 thread값 중에서 가장 큰값을 찾아서 + 1000 한 값을 새글의
				// thread값으로 사용한다.(첫글에 한해서는 0 + 1000 을 첫글의 thread로 사용)
				

				// b. depth는 무조건 0을 사용한다.
				depth = 0;
			//}

			dto.setNoticeBoardThread(thread);
			dto.setNoticeBoardDepth(depth);

			int result = dao.add(dto);
			System.out.println(result);

			// 3.
			request.setAttribute("result", result);

		} catch (Exception e) {

			System.out.println("add : " + e.toString());
			request.setAttribute("result", 0);

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/adminNotice/addok.jsp");
		dispatcher.forward(request, response);

	}

}
