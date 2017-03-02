<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

//관리자로 인증받았는지 검사?
if (session.getAttribute("seq") == null 
			|| (boolean)session.getAttribute("isAdmin") == false) {
	out.println("<script>location.href='/camport';</script>");
	out.close();
}

%>














