<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Session Login</title>
</head>
<body>

 <%
  String id = session.getAttribute("identification").toString();
  String pw = session.getAttribute("password").toString();
 %>
 
 id : <%=id%><br>
 pw : <%=pw%><br>
 <a href="Login.jsp">log-in</a>

</body>
</html>