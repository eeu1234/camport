<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Board</title>

<meta http-equiv="Cache-Control" content="no-cache"/> 
<meta http-equiv="Expires" content="0"/> 
<meta http-equiv="Pragma" content="no-cache"/>

<%@include file="/inc/asset.jsp" %>

<style>

#tbl1, #btnList { width: 1200px; margin: 30px auto; }
#tbl1 th, #tbl1 td { text-align: center; }

#tbl1 td:nth-child(2) { text-align: left; }
/* 번호 / 제목 / 회원ID(이메일) / 날짜 / 조회수 / 다운로드횟수 / 포인트 */
/* 50 	  500 		210 		150 	80 			110			100  */
#tbl1 th:nth-child(1) { width: 50px; }
#tbl1 th:nth-child(2) { width: 500px; }
#tbl1 th:nth-child(3) { width: 210px; }
#tbl1 th:nth-child(4) { width: 150px; }
#tbl1 th:nth-child(5) { width: 80px; }
#tbl1 th:nth-child(6) { width: 110px; }
#tbl1 th:nth-child(7) { width: 100px; }

/*
#middle #adgif{
	background-image: url("images/anigif4.gif");
	background-size: 1200px 389px;
	background-repeat: no-repeat;
	width:1200px;
	height:389px;
	border:1px solid red;
}
*/	

#middle #adgif{
	background-image: url("images/gom.png");
	background-size: 1000px 250px;
	background-repeat: no-repeat;
	width:1000px;
	height:160px;
	margin:0 auto;
}
.effect_ho:hover{
	background-color:yellow;
}
.effect_ho:hover td, .effect_ho:hover td a{
	color:red;
	font-weight:bold;
}
</style>
<script>
$(document).ready(function() {
	
});
</script>


</head>

<body>
	
	<!-- list.jsp -->
	<div id="wrapper">
		<%@include file="/inc/top.jsp" %>
		<div id="middle">
			<div class="alert alert-warning" role="alert" style="text-align:center;"><strong>게시판 목록</strong>에서는 글쓰기, 수정, 삭제, 상세정보를 할 수 있습니다.</div>
			<!-- <div id="adgif">광고 배너</div> -->
			<table id="tbl1" class="table table-striped">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>회원ID</th>
					<th>날짜</th>
					<th>포인트</th>
					<th>조회수</th>
					<th>다운로드</th>
				</tr>		
				
				<c:forEach items="${list}" var="dto">
				<tr class="effect_ho">
					<td>${dto.reportBoardSeq}</td>
					<%-- <td><a href="/camport/view.do?reportBoardSeq=${dto.seq}">${dto.subject}</a> ${dto.newimg}</td> --%>
					<td style="text-align:center;"><a href="/camport/view.do?reportBoardSeq=${dto.reportBoardSeq}">${dto.reportBoardName}</a></td>
					<%-- <td><a href="#">${dto.reportBoardName}</a></td> --%>
					<td>${dto.userId}</td>
					<td>${dto.reportBoardRegdate}</td>
					<td>${dto.reportBoardPoint}</td>
					<td>${dto.reportBoardReadcount}</td>
					<td>${dto.reportBoardDowncount}</td>

				</tr>
				</c:forEach>
			</table>
			<div id="pagebar" style="text-align:center;">
			${pagebar}
			</div>
			<div id="btnList">
				<input type="button" value="메인으로" class="btn btn-primary"
					onclick="location.href='/camport/camport.do';">
				<input type="button" value="글쓰기" class="btn btn-primary"
					onclick="location.href='/camport/add.do';">
			</div>			
		</div>
		<!-- <div style="margin-bottom:400px;"></div> -->
		<%@include file="/inc/Dark_footer.jsp" %>
	</div>

</body>
</html>



















