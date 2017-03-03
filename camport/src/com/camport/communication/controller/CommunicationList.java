package com.camport.communication.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.camport.communication.model.DAO.CommentDAO;
import com.camport.communication.model.DAO.CommunicationBoardDAO;
import com.camport.communication.model.DTO.CommentDTO;
import com.camport.communication.model.DTO.CommunicationBoardDTO;
import com.camport.communication.model.DTO.SearchDTO;

public class CommunicationList extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

      HttpSession session = request.getSession();
      //session.setAttribute("id", "admin");
      String userID = (String) session.getAttribute("id");
      System.out.println(userID);
      // 페이징 -> 게시판의 꽃
      int nowpage = 0; // 현재 페이지 번호
      int totalCount = 0; // 총 게시물 수
      int pageSize = 10; // 한페이지에 보여줄 게시물 수
      int totalPage = 0; // 총 몇페이지
      int start = 0, end = 0; // RNUM 조건에 사용될 범위 지정값

      int n = 0, loop = 0; // 페이지바에 사용
      int blockSize = 10;

      String page = request.getParameter("page");
      String word = request.getParameter("word");
      String seq = request.getParameter("seq");

      boolean isSearch = false;
      if ((word != null) && (word != "")) {
         isSearch = true;
      }

      CommunicationBoardDAO dao = new CommunicationBoardDAO();
      SearchDTO sdto = new SearchDTO();
      sdto.setWord(word);
      sdto.setSearch(isSearch);
      /* 페이지바 만들기 */
      String pagebar = "";
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

      // 페이징 때문에 추가
      sdto.setStart(start);
      sdto.setEnd(end);

      ArrayList<CommunicationBoardDTO> list;
      System.out.println();
      // 관리자용 list
      if (userID.equals("admin")) {
         list = dao.communicationAdminList(sdto);
      } else {
         // 사용자용 list
         list = dao.communicationList(sdto);
      }

      totalCount = dao.getTotal(sdto);

      // 검색을 위한 리페이징
      if (isSearch) {
         totalCount = list.size();
      }

      totalPage = (int) Math.ceil((double) totalCount / pageSize);

      loop = 1; // 페이지 번호를 만드는 루프 담당
      n = ((nowpage - 1) / blockSize) * blockSize + 1; // 페이지 번호 역할(시작 번호)
      pagebar += "<nav><ul class='pagination'>";

      // 페이지 10개 이상 일 때
      if (n == 1) {
         pagebar += String.format(
               "<li class='disabled'><a href='#' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
      } else {
         pagebar += String.format(
               "<li><a href='/camport/communication/list.do?page=%d' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>",
               n - 1);
      }

      /*
       * while (!(loop > blockSize || n > totalPage)) {
       * 
       * //현재 보고 있는 페이지? if (n == nowpage) { pagebar +=
       * String.format(" <a style='font-weight:bold;color:blue;'>%d</a> ", n,
       * n); } else { pagebar +=
       * String.format(" <a href='/JSPTest/board/list.do?page=%d'>%d</a> ", n,
       * n); }
       * 
       * n++; loop++;
       * 
       * }//페이지 번호 while
       */

      while (!(loop > blockSize || n > totalPage)) {

         // 현재 보고 있는 페이지?
         if (n == nowpage) {
            pagebar += String.format("<li class='active'><a href='#'>%d</a></li>", n, n);
         } else {
            pagebar += String.format("<li><a href='/camport/communication/list.do?page=%d'>%d</a></li>", n, n);
         }

         n++;
         loop++;

      } // 페이지 번호 while

      // 다음 10페이지
      /*
       * if (n > totalPage) { pagebar += String.format(" [다음%d페이지]",
       * blockSize); } else { pagebar += String.
       * format(" <a href='/JSPTest/board/list.do?page=%d'>[다음%d페이지]</a>", n,
       * blockSize); }
       */

      if (n > totalPage) {
         pagebar += String.format(
               "<li class='disabled'><a href='#' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
      } else {
         pagebar += String.format(
               "<li><a href='/camport/communication/list.do?page=%d' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>",
               n);
      }

      pagebar += "</ul></nav>";

      
      

      request.setAttribute("list", list);
      request.setAttribute("totalCount", totalCount);
      request.setAttribute("totalPage", totalPage);
      request.setAttribute("nowpage", nowpage);
      request.setAttribute("pagebar", pagebar);

      RequestDispatcher dispatcher = request.getRequestDispatcher("/communication/list.jsp");
      dispatcher.forward(request, response);

   }

}