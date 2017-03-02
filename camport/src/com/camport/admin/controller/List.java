package com.camport.admin.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.camport.admin.model.DAO.AdminDAO;
import com.camport.admin.model.DTO.AdminDTO;
import com.camport.admin.model.DTO.AdminSDTO;


public class List extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int nowpage = 0;			//현재 페이지 번호
		int totalCount = 0;			//총 게시물 수
		int pageSize = 10;			//한페이지에 보여줄 게시물 수
		int totalPage = 0;			//총 몇페이지
		int start = 0, end = 0;		//RNUM 조건에 사용될 범위 지정값
		
		int n = 0, loop = 0;			//페이지바에 사용
		int blockSize = 10;
		
		String page = request.getParameter("page");
		
		if(page == null) {
			nowpage = 1;
		} else {
			nowpage = Integer.parseInt(page);
		}
		start = ((nowpage -1) * pageSize) + 1;
		end = start + pageSize - 1;
				
		
		
		//검색
		String column = request.getParameter("column");
		String word = request.getParameter("word");
		
		boolean isSearch = false;
		if((column != null && word != null) &&
				(column != "" && word != "")) {
			isSearch = true;
		}
		
		
		
		
		
		
		
		//1.
		AdminDAO dao = new AdminDAO();
		
		AdminSDTO sdto = new AdminSDTO();
		sdto.setColumn(column);
		sdto.setWord(word);
		sdto.setSearch(isSearch);
		
		//페이징추가
		sdto.setStart(start);
		sdto.setEnd(end);
		
		totalCount = dao.getTotal(sdto);
		totalPage =(int)Math.ceil((double)totalCount / pageSize);
		
		ArrayList<AdminDTO> list = dao.list(sdto);
		
		//1.5데이터 조작
		for (AdminDTO dto :list) {
			
			SimpleDateFormat format
			= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			try {
				Date regdate = format.parse(dto.getNoticeBoardRegdate());
				long regdateTick = regdate.getTime();
				
				long span = System.currentTimeMillis() - regdateTick;
				
				//1시간 이내
				if ((span / 1000 / 60) < 60) {
					//System.out.println("최신글");
					dto.setNewimg("<img src='/camport/images/new.png'>");
				} else {
				
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//날짜 자르기
			dto.setNoticeBoardRegdate(dto.getNoticeBoardRegdate().substring(0,10));
			
			//제목 자르기
			String noticeBoardName = dto.getNoticeBoardName();
			/*if(noticeBoardName.length() > 30) {
				noticeBoardName = noticeBoardName.substring(0, 30) + "..";
				
			}*/
			/*dto.setNoticeBoardName(noticeBoardName);*/
			
			
			//검색어 부각
			if (isSearch && column.equals("noticeBoardName")){
				noticeBoardName = dto.getNoticeBoardName()
						.replace(word,String.format("<span style='color:red;background-color:yellow;'>%s</span>",word));
				dto.setNoticeBoardName(noticeBoardName);
			}
		}//for
		
		
		HttpSession session = request.getSession();
		session.setAttribute("noticeBoardReadcount", "n");
		
		
		
		
		
		//페이지바 만들기
		String pagebar = "";
		
		loop=1;//페이지번호
		n = ((nowpage - 1) / blockSize) * blockSize + 1;
		
		
		pagebar += "<nav><ul class='pagination'>";
		
		
		if(n == 1) {
			pagebar += String.format("<li class='disabled'><a href='#' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
		}else{
			pagebar += String.format("<li><a href='/camport/adminNotice/list.do?page=%d' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>", n - 1);
		}
		
		while (!(loop > blockSize || n > totalPage)) {
			
			//현재 보고 있는 페이지?
			if (n == nowpage) {
				pagebar += String.format("<li class='active'><a href='#'>%d</a></li>", n, n);
			} else {
				pagebar += String.format("<li><a href='/camport/adminNotice/list.do?page=%d'>%d</a></li>", n, n);
			}
			
			n++;
			loop++;
			
		}//페이지 번호 while
		
		if (n > totalPage) {
			pagebar += String.format("<li class='disabled'><a href='#' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		} else {
			pagebar += String.format("<li><a href='/camport/adminNotice/list.do?page=%d' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>", n);
		}
		
		
		pagebar += "</ul></nav>";
		
		request.setAttribute("list", list);
		request.setAttribute("sdto", sdto);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("nowpage", nowpage);
		request.setAttribute("pagebar", pagebar);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/adminNotice/list.jsp");
		dispatcher.forward(request, response);
		
		
		
	}
	
		
		
	}
	
	

