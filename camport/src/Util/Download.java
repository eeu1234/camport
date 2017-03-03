package Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//사용자가 첨부파일의 다운로드를 누르면 호출되는 서블릿
// ->그래서 doGet()을 구현한다.
// ->해당 게시물의 첨부파일을 읽어서 사용자에게 돌려주는 역할
// ->브라우저가 해석을 할 수 없도록 고쳐서 돌려준다.
// ->이 서블릿이 돌려주는 데이터는 첨부 파일이다.즉,JSP는 없다.
public class Download extends HttpServlet {
   
   @Override
   protected void doGet(HttpServletRequest request
                  , HttpServletResponse response) 
                           throws ServletException, IOException {
      String fileName = request.getParameter("fileName");
      String orgFileName = request.getParameter("orgFileName");

      String savePath = "D:\\images";
      ServletContext context = getServletContext();
      //System.out.println(context);
      String sDownloadPath = "D:\\images";
     // System.out.println(sDownloadPath);
      String sFilePath = sDownloadPath + "/" + fileName;
      //System.out.println(sFilePath);
      byte b[] = new byte[4096];
      FileInputStream in = new FileInputStream(sFilePath);
      String sMimeType = getServletContext().getMimeType(sFilePath);
      //System.out.println("sMimeType>>>" + sMimeType);

      if (sMimeType == null)
         sMimeType = "image";//images/jpg

      response.setContentType(sMimeType);
      String agent = request.getHeader("User-Agent");
      boolean ieBrowser = (agent.indexOf("MSIE") > -1) || (agent.indexOf("Trident") > -1);

      
      //파일명 처리
      if (ieBrowser) {
         orgFileName = URLEncoder.encode(orgFileName, "UTF-8").replaceAll("/+", "%20");
      } else {
    	  orgFileName = new String(orgFileName.getBytes("UTF-8"), "iso-8859-1");
      }

      response.setHeader("Content-Disposition", "attachment; filename= " + orgFileName);

      //파일명처리 끝
      
      ServletOutputStream out2 = response.getOutputStream();
      int numRead;

      while ((numRead = in.read(b, 0, b.length)) != -1) {
         out2.write(b, 0, numRead);
      }
      out2.flush();
      out2.close();
      in.close();
      
   }
   
}