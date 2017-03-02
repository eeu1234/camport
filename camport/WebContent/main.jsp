<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page contentType="text/html;charset=EUC-KR"%> --%>

<%
    String checkName = "";
    String checkId = "";
    
    
    checkName = (String)session.getAttribute("s_Name");
    
    if(checkName == null)
    {
        response.sendRedirect("/login.jsp");
    }
    
    checkId = (String)session.getAttribute("s_Id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  	세션 인증 성공 <br><br>
    <%=checkName%>(<%=checkId%>)님 안녕!!<br>
    <a href="logout.jsp">로그아웃</a>
</body>
</html>