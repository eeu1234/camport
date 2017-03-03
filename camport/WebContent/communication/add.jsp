<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />

<meta name="mobile-web-app-capable" content="yes">
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Pragma" content="no-cache" />

<%@include file="/inc/asset.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#tbl1 {
	width: 800px;
	margin: 30px auto;
}

#tbl1 th {
	width: 150px;
	text-align: center;
}

#tbl1 td {
	width: 650px;
}

#tbl1 #name, #tbl1 #tag, #tbl1 #pw {
	width: 150px;
}

#tbl1 #content {
	height: 200px;
}

#btnList {
	width: 800px;
	margin: 30px auto;
}
</style>

<script>
	$(document).ready(function() {

	});
</script>
</head>
<body>

	<div id="wrapper">
		<%@include file="/inc/top.jsp"%>
		<div id="middle">


			<form action="/camport/communication/addOk.do" method="POST" enctype="multipart/form-data">
				<h1 style="margin: 0 auto; text-align: center;">*모든 작성 글은 익명이
					보장 됩니다.</h1>
				<table id="tbl1" class="table table-striped">

					<tr>
						<th>제목</th>
						<td><input type="text" name="subject" id="subject"
							maxlength="30" required class="form-control"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="content" id="content" maxlength="5500"
								required class="form-control"></textarea></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td><input type="file" name="attach" id="attach"
							class="form-control"></td>
					</tr>

				</table>
				<div id="btnList">
					<input type="button" value="돌아가기" class="btn btn-default"
						onclick="history.back();"> <input type="submit"
						value="글쓰기" class="btn btn-primary">
				</div>
				<input type="hidden" name="mode" value="" /> 
				<input type="hidden" name="seq" value="" /> 
				<input type="hidden" name="userId"	value="${id}" />
			</form>


		</div>
	 <%@include file="/inc/Dark_footer.jsp" %>
	</div>
</body>
</html>