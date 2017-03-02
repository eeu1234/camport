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
  String id_ = "hong@naver.com";
  String pw_ = "hong";
  
  String id = request.getParameter("id");
  String pw = request.getParameter("pw");
  
  if(id.equals(id_) && pw.equals(pw_))
  {
   session.setAttribute("identification", id_);
   session.setAttribute("password", pw_);
   response.sendRedirect("SessionLogin1.jsp");
   
   session.setMaxInactiveInterval(10);
  }
  else
  {
 %>
   <script>
    alert("fail");
    history.go(-1);
   </script>
 <%
   //response.sendRedirect("CookieLogin.jsp");
  }
  
  
 %> 

</body>
</html>