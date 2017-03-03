<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FreeBoardview</title>

<meta http-equiv="Cache-Control" content="no-cache"/>   
<meta http-equiv="Expires" content="0"/>				
<meta http-equiv="Pragma" content="no-cache"/>

<%@include file="/inc/asset.jsp" %> 

<style>

#main {margin:0px auto; overflow: hidden; width:1000px;}
#rightcontent {float:left; width:115px; margin-right:50px;}
#main .centertbl, #tbl2, #addComment, #listComment {width:830px; float:right;}
#serchtbl{margin:0px auto;}
#btnList {float:right;}
#btnList input{ margin-left:3px; margin-bottom: 20px;}
#commentdate{font-size: 12px; float:right; }

#tbl1{
	width: 830px;
	padding:20px;
}


</style>
<script>

$(document).ready(function() {

	$("#tbl3 tr").on("mouseover", function() {
		$(this).children().last().children().last().show();
	});
	$("#tbl3 tr").on("mouseout", function() {
		$(this).children().last().children().last().hide();
	});


	$("#fileDown").click(function(){
        if(confirm("포인트가 차감 됩니다. 계속 하시겠습니까?"))
        {
        }
        else
        {
           event.preventDefault();
        }
     })

});


function delComment(freeCommentSeq, freeBoardSeq) {
	if (confirm("댓글을 삭제하겠습니까?")) {
		location.href = "/camport/freeboard/freeboardcommentdelok.do?freeCommentSeq=" + freeCommentSeq + "&freeBoardSeq=" + freeBoardSeq;
	}
}




</script>
</head>
<body>
	
	<div id="wrapper" >
		<%@include file="/inc/top.jsp" %>
		<div id="main">
			<div class="alert alert-warning" role="alert" style="text-align:center;">
				<strong style="color:blue; font-weight:bold; font-size:18px;">무료 서식의</strong> 상세정보 페이지입니다. <span style="font-weight:bold; color:red;">수정, 삭제, 댓글</span> 등을 이용하실 수 있습니다.
			</div>
			<div id="rightcontent" class="btn-group-vertical" role="group" aria-label="...">
				<div class="btn-group " role="group" > 
					<button type="button" class="btn btn-default active" >
					서식
					</button>
				</div>
				<div class="btn-group" role="group">
	   				<button type="button" class="btn btn-default" >
	   				워드프로세서</button>
	 				</div>
				<div class="btn-group" role="group">
	   				<button type="button" class="btn btn-default">파워포인트</button>
	 				</div>
				<div class="btn-group" role="group">
	   				<button type="button" class="btn btn-default">한컴오피스</button>
	 				</div>
				<div class="btn-group" role="group">
	   				<button type="button" class="btn btn-default">MS 엑셀</button>
	 				</div>
				<div class="btn-group" role="group">
				    <button type="button" class="btn btn-default">기타서식</button>
				</div>
			</div>
			<table id="tbl1" class="table table-striped">
				<tr>
					<th>작성자</th>
					<td>${dto.userId}</td>
					<th>등록일</th>
					<td>${dto.freeBoardRegdate}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="3">${dto.freeBoardName}</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td colspan="3"> 
						<a href="/camport/freeboard/freeboarddownload.do?reportBoardfileName=${dto.reportBoardfileName}&reportBoardfileOrgname=${dto.reportBoardfileOrgname}"
							 onclick="drcount()" id="fileDown">
						${dto.reportBoardfileOrgname} <span style="font-size:13px; font-weight:bold; color:red; "> 다운수[${dto.freeBoardDawncount}]</span></a> 
						
						<input type="hidden" name="reportBoardfileName" value="${dto.reportBoardfileName}">
						<input type="hidden" name="reportBoardfileOrgname" value="${dto.reportBoardfileOrgname}">
					</td>
				</tr>
				<tr>
					<th>조회수</th>
					<td colspan="3">${dto.freeBoardReadcnt}</td>
				</tr>
				<tr>
					<th>소개글</th>
					<td colspan="3">${dto.freeBoardContent}</td>
				</tr>
			</table>
			<div id="btnList">
				<input type="button" value="돌아가기" class="btn btn-default"
						onclick="location.href='/camport/freeboard/freeboardlist.do';"><input type="button" value="수정하기" class="btn btn-primary"
						onclick="location.href='/camport/freeboard/freeboardedit.do?freeBoardSeq=${dto.freeBoardSeq}';">
				<input type="button" value="삭제하기" class="btn btn-primary"
						onclick="location.href='/camport/freeboard/freeboarddel.do?freeBoardSeq=${dto.freeBoardSeq}';">
			</div><!-- btnList -->
			<div id="addComment">
				<form method="POST" action="/camport/freeboard/freeboardcommentok.do">
					<table id="tbl2" class="table table-striped">
						<tr>
							<td>
								${id}
							</td>
							<td  style="width: 580px;">
								<input type="text" name="freeCommentContent" id="content" required placeholder="댓글 내용" class="form-control">
							</td>
							<td>
							
							<input type="hidden" name="freeBoardSeq" value="${dto.freeBoardSeq}" />
								<input type="submit" value="댓글 쓰기" class="btn btn-info">
							</td>
						</tr>
					</table>
					<input type="hidden" name="userId" value="${id}"> 
				</form>
			</div><!-- addComment -->
			<div id="listComment" style="width:830px; margin:0px auto;">
				<table id="tbl3" class="table table-striped">
					<c:forEach items="${clist}" var="cdto">
					<tr> 
						<td>${cdto.userId}</td>
						<td  style="width: 830px; text-align:left; ">
							${cdto.freeCommentContent} <span id="commentdate" >(${cdto.freeCommentRegdate})</span>
						</td>
						<td>
							<input type="button" value=" x "
								class="btn btn-default btn-xs"
								style="float: right; display:none;" 
								 onclick="delComment(${cdto.freeCommentSeq}, ${dto.freeBoardSeq});"> 
						</td>
					</tr>
					</c:forEach>
				</table>
			</div><!-- listComment -->
		</div><!-- main   -->
		<%@include file="/inc/Dark_footer.jsp" %>
	</div><!-- wrapper -->
</body>
</html>