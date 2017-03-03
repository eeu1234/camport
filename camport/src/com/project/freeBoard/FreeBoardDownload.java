package com.project.freeBoard;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.collections.SynchronizedStack;

import com.project.DAO.FreeBoardDAO;


//사용자가 첨부파일의 다운로드를 누르면 호출되는 서블릿
//		-> 그래서 doGet()을 구현한다.
//		-> 해당 게시물의 첨부파일을 읽어서 사용자에게 돌려주는 역할
//		-> 브라우저가 해석을 할 수 없도록 고쳐서 돌려준다.
//		-> 이 서블릿이 돌려주는 데이터는 첨부 파일이다. 즉, JSP는 없다.
public class FreeBoardDownload extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request
										, HttpServletResponse response) 
													throws ServletException, IOException {
		
		////2.3 조회수 증가하기
		
		String reportBoardfileName = request.getParameter("reportBoardfileName");
		String reportBoardfileOrgname = request.getParameter("reportBoardfileOrgname");
		
		
		String savePath = "D:\\images";

		/*String savePath = "freeboard/files";*/
		File f = new File(savePath);
		if(!f.isDirectory()){ //저장경로 폴더가 없을경우 
			f.mkdirs();			// 폴더 생성 
		}
		ServletContext context = getServletContext();
		//String sDownloadPath = context.getRealPath(savePath);
		
		
		System.out.println("savePath : " + savePath);
		System.out.println("fileName : " + reportBoardfileName);
		//System.out.println("sDownloadPath : " + sDownloadPath);
		
		String sFilePath = savePath + "/" + reportBoardfileName;
		
		System.out.println("sFilePath : " + sFilePath);
		//byte b[] = new byte[4096];
		FileInputStream in = new FileInputStream(sFilePath);
		String sMimeType = getServletContext().getMimeType(sFilePath);
		System.out.println("sMimeType>>>" + sMimeType);

		if (sMimeType == null)
			sMimeType = "application/octet-stream";

		response.setContentType(sMimeType);
		String agent = request.getHeader("User-Agent");
		boolean ieBrowser = (agent.indexOf("MSIE") > -1) || (agent.indexOf("Trident") > -1);

		
		//파일명 처리
		if (ieBrowser) {
			reportBoardfileOrgname = URLEncoder.encode(reportBoardfileOrgname, "UTF-8").replaceAll("/+", "%20");
		} else {
			reportBoardfileOrgname = new String(reportBoardfileOrgname.getBytes("UTF-8"), "iso-8859-1");
		}

		response.setHeader("Content-Disposition", "attachment; filename= " + reportBoardfileOrgname);
		//파일명처리

		ServletOutputStream out2 = response.getOutputStream();
		//int numRead;

		/*while ((numRead = in.read(b, 0, b.length)) != -1) {
			out2.write(b, 0, numRead);
		}*/
		out2.flush();
		out2.close();
		in.close();
		
		
		
		
	}
	
}
