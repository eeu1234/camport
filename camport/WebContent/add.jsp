<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>

<meta http-equiv="Cache-Control" content="no-cache"/> 
<meta http-equiv="Expires" content="0"/> 
<meta http-equiv="Pragma" content="no-cache"/>

<%@include file="/inc/asset.jsp" %>

<style>
	
#tbl1 { width: 1000px; margin: 30px auto; }

#tbl1 th { width: 150px; text-align: center; }
#tbl1 td { width: 650px; }
#tbl1 #name, #tbl1 #tag, #tbl1 #pw { width: 150px; }
#tbl1 #content { height: 200px; }
#btnList { width: 800px; margin: 30px auto; }
	
</style>
<script>
$(document).ready(function() {
	dummy();
});

function dummy() {
	
	$("#subject").val("베타 테스트 입니다.");
	$("#content").val("베타 테스트 입니다.");
	$("#summary").val("베타 테스트 입니다.");
	$("#point").val("50");
	$("#pw").val("1234");
	$("#collage").val("1");
} 
//$("#email").val("hong@naver.com");
</script>
</head>
<body>

	<!-- add.jsp -->
	<div id="wrapper">
		<%@include file="/inc/top.jsp" %>
		<div id="middle">
			<div class="alert alert-info" role="alert" style="text-align:center;"><strong>글쓰기</strong> 작성하는 페이지입니다.</div>
			<form method="POST" action="/camport/addok.do" enctype="multipart/form-data"><!-- enctype="multipart/form-data" -->
				<table id="tbl1" class="table table-striped">
				<!--<tr>
						<th>이메일</th>
						<td><input type="email" name="email" id="email" class="form-control"></td>
					</tr> -->
					<tr>
						<th>제목</th>
						<td><input type="text" name=reportBoardName id="subject" required class="form-control" placeholder="제목 입력하시오"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="reportBoardContent" id="content" required class="form-control" placeholder="내용 입력하시오"></textarea></td>
					</tr>
					<tr>
						<th>소개글</th>
						<td><textarea name="reportBoardSummary" id="summary" required class="form-control" placeholder="소개글을 입력하시오"></textarea></td>
					</tr>
					<tr>
						<th>포인트</th>
						<td><input type="number" name="reportBoardPoint" id="point" class="form-control" placeholder="10 ~ 1000포인트"></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td><input type="file" name="attach" id="attach" class="form-control" value="${reportBoardFileName}"></td>
					</tr>
					<tr>
						<th>암호</th>
						<td><input type="password" name="pw" id="pw" required class="form-control"></td>
					</tr>
					<tr>
						<th>단과대학 번호</th>
						<td><input type="number" name="collageSeq" id="collage" class="form-control" ></td>
					</tr>
				</table>
				<div id="btnList">
					<input type="button" value="돌아가기" class="btn btn-default"
							onclick="history.back();">
					<input type="submit" value="작성하기" class="btn btn-primary">
					<input type="button" value="메인으로" class="btn btn-primary"
							onclick="location.href='/camport/camport.do';">
				</div>
				<input type="hidden" name="mode" value="" />
				<input type="hidden" name="seq" value="" />
				<input type="hidden" name="userId" value="${id}" />
				<input type="hidden" name="ruleSeq" value="1" />
			</form>
		</div>
		<%@include file="/inc/Dark_footer.jsp" %>
	</div>

</body>
</html>



















