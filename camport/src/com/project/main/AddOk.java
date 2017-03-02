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
import com.project.DTO.ReportBoardFileDTO;


public class AddOk extends HttpServlet{

	protected void doPost(HttpServletRequest request
											, HttpServletResponse response) 
															throws ServletException, IOException {

		//1. 데이터 받기(Request -> MultipartRequest 교체)
		//2. DB 작업 -> DAO 위임
		//3. JSP 호출하기 -> 완료 메시지	
	
		//①
		request.setCharacterEncoding("UTF-8");
	
		String path = request.getRealPath("/files");
		int size = 50 * 1024 * 1024;
	
		try {

			//request -> (역할을 대신) -> multi
			MultipartRequest multi = new MultipartRequest(
																request,
																path, 		//업로드  폴더
																size, 		//최대 크기
																"UTF-8", 	//인코딩
																new DefaultFileRenamePolicy()
																);
			
			System.out.println("1");
			String tmpReportBoardSeq = multi.getParameter("reportBoardSeq");
			System.out.println("2");
			//System.out.println(multi.getParameter("reportBoardSeq"));
			String reportBoardName = multi.getParameter("reportBoardName");
			String reportBoardContent = multi.getParameter("reportBoardContent");
			String reportBoardSummary = multi.getParameter("reportBoardSummary");
			//Integer reportBoardPoint = Integer.parseInt(request.getParameter("reportBoardPoint"));
			String tmpReportBoardPoint = multi.getParameter("reportBoardPoint");
			//Integer collageSeq = Integer.parseInt(multi.getParameter("collageSeq"));
			//Integer ruleSeq = Integer.parseInt(multi.getParameter("ruleSeq"));
			
			String tmpCollageSeq = multi.getParameter("collageSeq");
			String tmpRuleSeq = multi.getParameter("ruleSeq");
			String tmpReportBoardFileSeq = multi.getParameter("reportBoardFileSeq");
			String userId = multi.getParameter("userId");
			String pw = multi.getParameter("pw");
	
			String reportBoardFileName = multi.getFilesystemName("attach");
			String reportBoardFileOrgname = multi.getOriginalFileName("attach"); 
			//Integer reportBoardFileSeq = Integer.parseInt(multi.getParameter("reportBoardFileSeq"));
			
			int reportBoardSeq = 0;
			int reportBoardPoint = 0;
			int collageSeq = 0;
			int ruleSeq = 0;
			int reportBoardFileSeq = 0;
			try {
			
				reportBoardSeq = Integer.parseInt(tmpReportBoardSeq);
				reportBoardPoint = Integer.parseInt(tmpReportBoardPoint);
				collageSeq = Integer.parseInt(tmpCollageSeq);
				ruleSeq = Integer.parseInt(tmpRuleSeq);
				reportBoardFileSeq = Integer.parseInt(tmpReportBoardFileSeq);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			/*ReportBoardFileSeq
			ReportBoardFileSeq/ReportBoardFileName/ReportBoardFileOrgname/ReportBoardSeq 
			*/
			
			//System.out.println(multi.getFilesystemName("attach"));
			//System.out.println(multi.getOriginalFileName("attach"));
			//System.out.println(multi.getParameter("reportBoardFileSeq"));
			//System.out.println(multi.getParameter("reportBoardSeq"));
			
			//Integer reportBoardFileSeq = Integer.parseInt(multi.getParameter("reportBoardFileSeq"));
			//Integer reportBoardSeq = Integer.parseInt(multi.getParameter("reportBoardSeq"));
			 
			//새글 or 답변글
			//String mode = multi.getParameter("mode");
			//boolean isReply = (mode != null && mode.equals("reply")) ? true : false;
			//String pseq = multi.getParameter("seq"); //부모글번호
			
			
			
			//2	DB작업	
			ReportBoardDTO dto = new ReportBoardDTO();
			ReportBoardFileDTO fdto = new ReportBoardFileDTO();	//ReportBoardDAO에서의 add부분
			
			dto.setReportBoardName(reportBoardName);
			dto.setReportBoardContent(reportBoardContent);
			dto.setReportBoardSummary(reportBoardSummary);
			dto.setReportBoardSeq(reportBoardSeq);
			dto.setReportBoardPoint(reportBoardPoint);
			dto.setUserId(userId);
			dto.setRuleSeq(ruleSeq);
			dto.setPw(pw);
			dto.setCollageSeq(collageSeq);
			
			fdto.setReportBoardFileSeq(reportBoardFileSeq);
			fdto.setReportBoardFileOrgname(reportBoardFileOrgname);
			//dto.setReportBoardFileOrgname(reportBoardFileOrgname);
			//fdto.setReportBoardFileSeq(reportBoardFileSeq);
			//fdto.setReportBoardSeq(reportBoardSeq);
	

		
			ReportBoardDAO dao = new ReportBoardDAO();
				
			//새글 or 답변글의 thread, depth 추가하기			
			//현재 작성하려는 글의 thread, depth

			
			System.out.println(fdto.getReportBoardFileName());
			System.out.println(fdto.getReportBoardFileOrgname());
			int result = dao.add(dto, fdto);	//fdto 추가
			
			//3.
			request.setAttribute("result", result);
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
			request.setAttribute("result", 0);
		}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/addok.jsp");
			dispatcher.forward(request, response);		
		
	}
}
