<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Login</title>
</head>
<body>

 <form action="SessionLogin.jsp">
  <table>
   <tr>
    <td>id</td>
    <td>
     <input type="text" name="id" value="<%=session.getAttribute("identification")%>">
    </td>
   </tr>
   <tr>
    <td>pw</td>
    <td>
     <input type="text" name="pw" value="<%=session.getAttribute("password")%>">
    </td>
   </tr>   
   <tr>
    <td><input type="submit" value="Send"></td>
   </tr>
  </table>
 </form>
 
</body>
</html>

