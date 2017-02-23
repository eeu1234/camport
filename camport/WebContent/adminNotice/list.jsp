<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Pragma" content="no-cache" />

<%@include file="/inc/asset.jsp"%>

<style>

#tbl1,#btnList{width:900px; margin:40px auto;}
#tbl1 th,#tbl1 td{text-align:center;}
#tbl1 td:nth-child(2){text-align:left;}

#tbl1 th:nth-child(1){width:50px; margin-top:10px;}
#tbl1 th:nth-child(2){width:400px;}
#tbl1 th:nth-child(3){width:120px;}
#tbl1 th:nth-child(4){width:50px;}

</style>
<script>
	
</script>
</head>
<body>

	<div id="main">
		<%@include file="/inc/top.jsp"%>
		<div id="middle">
			<table id="tbl1" class="table table-striped">
				<tr>
					<th>번호</th>
					<th>제목</th>					
					<th>읽음</th>
					<th>공개</th>
				</tr>
				<c:forEach items="${list}" var="dto">
					<tr>
						<%-- <td>${dto.seq}</td> --%>
						<td>${dto.noticeBoardSeq}</td>     
						<td><a href="/camport/adminNotice/view.do?seq=${dto.noticeBoardSeq}">${dto.noticeBoardName}</a></td>								
						<td>${dto.noticeBoardReadcount}</td>
						<td>
							<select name="column" id="column" class="form-control">
								
									<option value="y" <c:if test="${dto.noticeBoardView eq 'y'}">selected	</c:if>>y</option>
							
									<option value="n" <c:if test="${dto.noticeBoardView eq 'n'}">selected</c:if>>n</option>
							</select>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div id="btnList">
				<input type="button"value="글쓰기">
			</div>

		</div>
		<!--middle -->
		<%@include file="/inc/bottom.jsp"%>
	</div>
	<!--main -->


</body>
</html>