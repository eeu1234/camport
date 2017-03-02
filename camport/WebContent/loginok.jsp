<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="Util.DBUtil" %>
<%
//1. 데이터 받기(email, pw)
//2. DB 작업(select)
//3. 결과 -> 인증O, 인증X
//4. 페이지 이동하기(시작 페이지)


//1. 데이터 물어오기
String userId = request.getParameter("user_Id");
String userPw = request.getParameter("user_Pw");

//2.
Connection conn = null;
PreparedStatement stat = null;
ResultSet rs = null;
boolean result = false;

try {
	
	conn = DBUtil.open();
	
	if (request.getParameter("admin") != null
			&& request.getParameter("admin").equals("1")) {
		stat = conn.prepareStatement(DBUtil.sql.get("adminlogin"));
	} else {
		stat = conn.prepareStatement(DBUtil.sql.get("login"));
	}
	
	stat.setString(1, userId);
	stat.setString(2, userPw);
	
	rs = stat.executeQuery();
	
	if (rs.next()) {
		
		result = true; //로그인 성공
		
		//인증 + 추가 개인 정보 데이터 가져오기
		session.setAttribute("user_Id", rs.getString("user_Id"));
		session.setAttribute("admin_Id", rs.getString("admin_Id"));
		session.setAttribute("admin_Password", rs.getString("admin_Password"));
		session.setAttribute("user_Pw", rs.getString("user_Pw"));
		session.setAttribute("user_Name", rs.getString("user_Name"));
		session.setAttribute("user_Tel", rs.getString("user_Tel"));
		session.setAttribute("user_Point", rs.getString("user_Point"));
		session.setAttribute("major_Seq", rs.getString("major_Seq"));
		
		if (request.getParameter("Admin") != null
				&& request.getParameter("Admin").equals("1")) {
			session.setAttribute("isAdmin", true); //등급		
		} else {
			session.setAttribute("gender", rs.getString("gender"));
			session.setAttribute("isAdmin", false); //등급		
		}
		
	} else {
		result = false;
	}
} catch (Exception e) {
	e.printStackTrace();
}
%>

<script>
	//Context Root
	//URL에 "/JSPTest" 표현은 서버의 WebContent 폴더를 뜻함
	<% if (result) { %>
		<% if ((boolean)session.getAttribute("isAdmin")) { %>
			location.href = "/camport/adminList.jsp";
		<% } else { %>
			location.href = "/camport";
		<% } %>
	<% } else { %>
		history.back();
	<% } %>
</script> --%>