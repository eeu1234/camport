package com.project.main;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.DAO.ReportBoardDAO;
import com.project.DTO.ReportBoardDTO;
import com.project.DTO.SearchDTO;

public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getRealPath("/files");
		// System.out.println(path);

		// 페이징 -> 게시판의 꽃
		int nowpage = 0; // 현재 페이지 번호
		int totalCount = 0; // 총 게시물 수
		int pageSize = 7; // 한페이지에 보여줄 게시물 수
		int totalPage = 0; // 총 몇페이지
		int start = 0, end = 0; // RNUM 조건에 사용될 범위 지정값

		int n = 0, loop = 0; // 페이지바에 사용
		int blockSize = 10;

		// list.do -> list.do?page=1
		// list.do?page=5
		String page = request.getParameter("page");

		if (page == null) {
			nowpage = 1; // 그냥 들어오면 무조건 첫페이지를 보여주자
		} else {
			nowpage = Integer.parseInt(page);
		}

		// nowpage -> start, end 범위 계산
		// 1page -> 1 ~ 10
		// 2page -> 11 ~ 20
		// ..
		// 9page -> 91 ~ 100
		start = ((nowpage - 1) * pageSize) + 1;
		end = start + pageSize - 1;

		// 선택?
		// 1. 나를 그냥 불렀는지?
		// - http://localhost:8090/JSPTest/board/list.do
		// 2. 검색하라고 불렀는지?
		// - http://localhost:8090/JSPTest/board/list.do?column=subject&word=테스트

		// list.do
		// list.do?column=&word=

		String column = request.getParameter("column");
		String word = request.getParameter("word");
		
		boolean isSearch = false;
		if ((column != null && word != null) && (column != "" && word != "")) {
			isSearch = true;
		}

		// 1. DB 작업(select) -> DAO 위임
		// 2. 반환된 목록을 JSP 에게 건네주면서 호출하기
		ReportBoardDAO dao = new ReportBoardDAO();

		SearchDTO sdto = new SearchDTO();
		sdto.setColumn(column);
		sdto.setWord(word);
		sdto.setSearch(isSearch);

		// 페이징 때문에 추가
		sdto.setStart(start);
		sdto.setEnd(end);

		totalCount = dao.getTotal(sdto);
		totalPage = (int) Math.ceil((double) totalCount / pageSize);

		ArrayList<ReportBoardDTO> list = dao.list(sdto);

		// 1.5데이터 조작
		for (ReportBoardDTO dto : list) {

			
			 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 
			 try { 
				 Date regdate = format.parse(dto.getReportBoardRegdate());
				 long regdateTick = regdate.getTime();//글쓴 시각의 tick
			 
				 long span = System.currentTimeMillis() - regdateTick;
			

				 // 1시간 이내
				 if ((span / 1000 / 60) < 60) {
					//최신글 표시 - 이미지
					dto.setNewimg("<img src='/camport/images/new.jpg'>");
				 } else {
					 //기존 글...
				 }

			 } catch (ParseException e) {
				 e.printStackTrace();
			 }

			 //날짜 자르기
			 dto.setReportBoardRegdate(dto.getReportBoardRegdate().substring(0,10));

			//이름 + 제목은 태그 사용 불가능
			dto.setUserId(dto.getUserId().replace("<", "&lt;").replace(">", "&gt;"));
			dto.setReportBoardName(dto.getReportBoardName().replace("<", "&lt;").replace(">", "&gt;"));
			 
			 //게시판 제목 자르기
			 String reportBoardName = dto.getReportBoardName();	//게시판 제목
			 if(reportBoardName.length() > 30) {
				 reportBoardName = reportBoardName.substring(0, 30) + "..";
			 }
			  
			dto.setReportBoardName(reportBoardName);

			//검색 중이면 검색어를 부각시키기
			//	- 게시판 테스트중입니다.
			//  - 게시판 <span style='color:red;'>테스트</span>중입니다.
			
			if (isSearch && column.equals("reportBoardName")){
				reportBoardName = dto.getReportBoardName().replace(word,String.format("<span style='color:blue; background-color:yellow;'>%s</span>",word));
			
				dto.setReportBoardName(reportBoardName);
				
				}//if
			}//for

			// 조회수 증가 방지 티켓
			// 서블릿에서 세션 객체 얻는 방법
			HttpSession session = request.getSession();
			session.setAttribute("reportBoardReadcount", "n");

			// 페이지바 만들기
			String pagebar = "";

			loop = 1; // 페이지 번호를 만드는 루프 담당
			n = ((nowpage - 1) / blockSize) * blockSize + 1; // 페이지 번호 역할(시작 번호)

			pagebar += "<nav><ul class='pagination'>";

			if (n == 1) {
				pagebar += String.format("<li class='disabled'><a href='#' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
			} else {
				pagebar += String.format("<li><a href='/camport/list.do?page=%d' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>",
						n - 1);
			}

			while (!(loop > blockSize || n > totalPage)) {
				
				//현재 보고 있는 페이지?
				if (n == nowpage) {
					pagebar += String.format("<li class='active'><a href='#'>%d</a></li>", n, n);
				} else {
					pagebar += String.format("<li><a href='/camport/list.do?page=%d'>%d</a></li>", n, n);
				}
				
				n++;
				loop++;
				
			}//페이지 번호 while

			
			if (n > totalPage) {
				pagebar += String.format("<li class='disabled'><a href='#' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
			} else {
				pagebar += String.format("<li><a href='/camport/list.do?page=%d' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>", n);
			}

			pagebar += "</ul></nav>";

			// 2.
			request.setAttribute("list", list);
			request.setAttribute("sdto", sdto);
			request.setAttribute("totalCount", totalCount);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("nowpage", nowpage);
			request.setAttribute("pagebar", pagebar);

		//}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
		dispatcher.forward(request, response);

	}
}
