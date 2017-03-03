<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>

<meta http-equiv="Cache-Control" content="no-cache"/> 
<meta http-equiv="Expires" content="0"/> 
<meta http-equiv="Pragma" content="no-cache"/>

<%@include file="/inc/asset.jsp" %>

<style>
	
#tbl1 { width: 800px; margin: 30px auto; }

#tbl1 th { width: 150px; text-align: center; }
#tbl1 td { width: 650px; }
#tbl1 #name, #tbl1 #tag, #tbl1 #pw { width: 150px; }
#tbl1 #content { height: 200px; }
#btnList { width: 800px; margin: 30px auto; }

#tbl2{
	width: 800px; margin: 30px auto;
}	
#tbl2 td:nth-child(1){
	width: 150px;
}	
#tbl2 td:nth-child(2){
	width: 500px;
}	
#tbl2 td:nth-child(3){
	width: 150px;
}	

#tbl3{
	width: 800px; margin: 30px auto;
}
#tbl3 td:nth-child(1){
	width: 170px;
}	
#tbl3 td:nth-child(2){
	width: 630px;
}	

</style> 
<script>


$(document).ready(function() {
	$("#tbl3 tr").on("mouseover",function(){
		$(this).children().last().children().last().show();
	});
	$("#tbl3 tr").on("mouseout",function(){
		$(this).children().last().children().last().hide();
	});

	////첨부 이미지 너무 크면 resize 
	//alert($("#attachimg").width);
	//alert($("#attachimg").css("width"));
	if($("#attachimg").width() > 600){
		$("#attachimg").width(600);
		}
});

function delComment(seq,board_seq){
	if(confirm("댓글을 삭제하시겠습니까?")){
		location.href = "/JSPTest/board/delcommentok.do?seq=" + seq + "&board_seq=" + board_seq;
	}
}

</script>


</head>

<body>

	<!-- add.jsp -->
	<div id="main">
		<%@include file="/inc/top.jsp" %>
		<div id="middle">
		
		
		<table id="tbl1" class="table table-striped">
			<tr>
				<th>글 번호</th>
				<td>${dto.commBoardSeq}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${dto.commName}</td>
			</tr>
			
			<tr style="height:300px;">
				<th style ="vertical-align:middle;">내용</th>
				<td  style ="vertical-align:middle;">${dto.commContent}</td>
			</tr>
			<tr>
				<th>날짜</th>
				<td>${dto.commRegdate}	</td>
			</tr>
			<tr>
				<th>읽음</th>
				<td>${dto.commReadcnt}</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
				<c:if test = "${empty dto.commFileName}">
				파일이 없습니다.
				</c:if>
				<c:if test = "${!empty dto.commOrgFileName}">
				<a href="/JSPTest/board/download.do?filename=${dto.commFileName}&orgfilename=${dto.commOrgFileName}">${dto.commOrgFileName}</a>
				</c:if>
				
				</td>
			</tr>
		</table>
		<div id="btnList">
			<input type="button" value="돌아가기" class="btn btn-default"
					onclick="location.href='/camport/communication/list.do';">
			<input type="button" value="수정하기" class="btn btn-primary" onclick="location.href='/JSPTest/board/edit.do?seq=${dto.commBoardSeq}'">
			<input type="button" value="삭제하기" class="btn btn-primary" onclick="location.href='/JSPTest/board/del.do?seq=${dto.commBoardSeq}'">
		</div>
		
		<div id = "addComment">
			<form method="POST" action="/JSPTest/board/commentok.do">
				<table id="tbl2" class="table table-striped">
					<tr>
						<td><input type="text" name="name" id="name" required="required" placeholder="이름" class="form-control"/></td>
						<td>	<input type="text" name="content" id="content" required="required" placeholder="댓글 내용" class="form-control"/></td>
						<td>
							<input type="submit" value="댓글 쓰기" class="btn btn-info"/>
						</td>
					</tr>
				</table>
				<input type="hidden" name="board_seq" value="${dto.commBoardSeq}"/>
			</form>
		</div>
		<div id="listComment">
			<table id="tbl3" class="table table-striped">
			
		<%-- 	<c:forEach items="${clist}" var="cdto">
				<tr>
					<td>${cdto.name}<br>${cdto.regdate}</td>
					<td>${cdto.content}
					<input type="button" value="x" class="btn btn-default btn-xs" style="float:right;display: none;" onclick="delComment(${cdto.seq},${dto.seq})"/>
					</td>
				</tr>
				
			</c:forEach>	 --%>
				
			</table>
		</div>
		
		</div>
	<%@include file="/inc/Dark_footer.jsp" %>
	</div>

</body>
</html>



















