<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page contentType="text/html;charset=EUC-KR"%> --%>
	
<%
    // 로그인 정보 설정
    String userID="id";
    String userPWD="pwd";
    String userName="이름";
    
    // login.jsp로부터 form data를 받는다
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");
    
    // id, pwd가 맞을 경우 실행
    if(userID.equals(id) && userPWD.equals(pwd)) 
    {
        session.setAttribute("s_Name",userName);
        session.setAttribute("s_Id", userID);
        response.sendRedirect("main.jsp"); // main.jsp 에 session 정보를 보낸다
        
    }
    else
    {
        response.sendRedirect("main.jsp");
    }
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
</body>
</html>