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
body{
	/* background-image:url("/camport/images/flower1.jpg"); */
}
#tbl1,#btnList{width:870px; margin:30px auto;}
#tbl1 th,#tbl1 td{text-align:center;}
#tbl1 td:nth-child(2){text-align:left;}

#tbl1 th:nth-child(1){width:50px; }
#tbl1 th:nth-child(2){width:490px;}
#tbl1 th:nth-child(3){width:90px;}
#tbl1 th:nth-child(4){width:120px;}
#tbl1 th:nth-child(5){width:70px;}

#tbl2 { width: 500px; margin: 20px auto; }
#tbl2 td { padding: 0px 2px; }
#tbl2 td:nth-child(1) { width: 120px; }
#tbl2 td:nth-child(2) { width: 280px; }
#tbl2 td:nth-child(3) { width: 100px; }

#searchMsg {text-align:center;}

</style>
<script>

function movepage() {
	if (
				$("#pagenum").val() != null &&
				!isNaN($("#pagenum").val()) && 
				$("#pagenum").val() >=1 && 
				$("#pagenum").val() <= ${totalPage}
		) {
		location.href = "/camport/board/list.do?page=" + $("#pagenum").val();
	}
}

function movepage2() {
	location.href = "/camport/adminNotice/list.do?page=" + $(event.srcElement).val();
}


});
	
</script>
</head>
<body>

	<div id="main">
		<%@include file="/inc/top.jsp"%>
		<div id="middle">
		<c:if test="${sdto.search}">
		<div id="searchMsg">
			'<c:choose><c:when test="${sdto.column == 'noticeBoardName'}">제목</c:when><c:when test="${sdto.column == 'noticeBoardContent'}">내용</c:when></c:choose>'에서 '${sdto.word}'을 검색했습니다.
		</div>
		</c:if>
		
			<table id="tbl1" class="table table-striped">
				<tr>
					<th>번호</th>
					<th>제목</th>					
					<th>읽음</th>
					<th>날짜</th>
					<th>공개</th>
				</tr>
				<c:if test="${empty list || list.size() == 0}">
				<tr>
					<td colspan="5">게시물이 존재하지 않습니다.</td>
				</tr>				
				</c:if>
				<c:forEach items="${list}" var="dto">
					<tr>
						
						<td>${dto.noticeBoardSeq}</td>     
						<td>
							<%-- <c:if test="${noticeCommentDepth} >0">
								<img src="/camport/adminNotice/images/re.png"
									style="margin-left:${dto.noticeCommentDepth*20}px;">
							</c:if> --%>
						
						<a href="/camport/adminNotice/view.do?seq=${dto.noticeBoardSeq}">${dto.noticeBoardName}
							${dto.newimg}
						</a>
						
						
						</td>
						<%-- <td>${dto.noticeBoardName}</td> --%>
						<td>${dto.noticeBoardReadcount}</td>
						<td>${dto.noticeBoardRegdate}</td>
						
						<td><c:if test="${id == 'admin'}">
							<select name="column" id="column" class="form-control">
								
									<option value="y" <c:if test="${dto.noticeBoardView eq 'y'}">selected	</c:if>>y</option>
							
									<option value="n" <c:if test="${dto.noticeBoardView eq 'n'}">selected</c:if>>n</option>
							</select>
							</c:if>
							
							
							
						</td>
					</tr>
				</c:forEach>
			</table>
			
			<div id="pagebar" style="text-align: center;">

			
			${pagebar}
			
		</div>
			
			<div id="search">
				<form method="GET" action="/camport/adminNotice/list.do">
					<table id="tbl2">
						<tr>
							<td>
								<select name="column" id="column" class="form-control">
									<option value="noticeBoardName" <c:if test="${sdto.column == 'subject'}">selected</c:if>>제목</option>
									<option value="noticeBoardContent" <c:if test="${sdto.column == 'content'}">selected</c:if>>내용</option>
									
								</select>								
							</td>
							<td>
								<input type="text" name="word" id="word" class="form-control" required placeholder="검색어를 입력하세요." value="${sdto.word}">
							</td>
							<td>
								<input type="submit" value="검색하기" class="btn btn-warning">
							</td>
						</tr>
					</table>
				</form>
			
			
			</div><!--search -->
			
			
			
			<div id="btnList">
				<c:if test="${id == 'admin'}">
				<input type="button"value="글쓰기"class="btn btn-primary" onclick="location.href='/camport/adminNotice/add.do';">
				</c:if>
			</div>

		</div>
		<!--middle -->
		<%@include file="/inc/Dark_footer.jsp"%>
	</div>
	<!--main -->


</body>
</html>