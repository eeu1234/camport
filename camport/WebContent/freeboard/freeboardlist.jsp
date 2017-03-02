<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FreeBoardList_무료서식게사판리스트</title>

<meta http-equiv="Cache-Control" content="no-cache"/>   
<meta http-equiv="Expires" content="0"/>				
<meta http-equiv="Pragma" content="no-cache"/>

<%@include file="/inc/asset.jsp" %> 

<style>

#main {margin:0px auto; overflow: hidden; width:980px;}
#rightcontent {float:left; width:115px}
#main .centertbl{width:830px; float:right;}
#serchtbl{margin:10px auto; }
#wirtebtn {float:right; margin:5px 0px;}

</style>
<script>

</script>
</head>
<body>
	
	<div id="wrapper" >
		<%@include file="/inc/top.jsp" %>
		<div id="main">
			<div class="panel panel-default">
			 <div class="panel-body">
			   무료서식 게시판
			  </div>
			</div>
			
				<div id="rightcontent" class="btn-group-vertical" role="group" aria-label="...">
					<div class="btn-group " role="group" > 
						<button type="button" class="btn btn-default " >
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
				<table id="centertoptbl" class="table table-hover centertbl" >
					<tr>
						<th colspan="4">
							<div class="panel-body">
					    BEST 3
					  </div>
						</th>
					</tr>
					<tr class="active">
						<th>분류</th>
						<th>제목</th>
						<th>다운로드횟수</th>
						<th>날짜</th>
					</tr>
					
					<c:forEach items="${listb}" var="dtob">
					<tr>
						<td>${dtob.reportBoardFileType}</td>
						<td>${dtob.freeBoardName}</td>
						<td>${dtob.freeBoardDawncount}</td>
						<td>${dtob.freeBoardRegdate}</td>
					</tr>
					</c:forEach>
				</table>
			<div style="clear:both;"></div>
			<div id="centetcontent">
				<div id="search">
				
					<form method="GET" action="/camport/freeboard/freeboardlist.do">
					<table id="serchtbl">
							<tr>
								<td>
									<select name="column" id="column" class="form-control">
										<option value="FREE_BOARD_NAME" <c:if test="${sdto.column == 'FREE_BOARD_NAME' }">selected</c:if>>
										제목</option>
										<option value="FREE_BOARD_CONTENT" <c:if test="${sdto.column == 'FREE_BOARD_CONTENT' }">selected</c:if>>
										내용</option>
										<option value="USER_ID" <c:if test="${sdto.column == 'USER_ID' }">selected</c:if>>
										글쓴이</option>
			
									</select>
								</td> 
								<td>
									<input type="text" name="word" id="content" class="form-control"
									placeholder="글제목검색" value="${sdto.word}">
								</td>
								<td><input type="submit"  value="검색하기"  class="btn btn-warning" ></td>
							</tr>
						</table>
					</form>
				</div><!--serch  -->
				
				<table id="centertbl" class="table table-hover centertbl">
					<tr>
						<th>분류</th>
						<th>제목</th>
						<th>날짜</th>
						<th>조회수</th>
						<th>다운로드</th>
					</tr>
					
					<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.reportBoardFileType}
							<input type="hidden" name="freeBoardSeq" value="${dto.freeBoardSeq }">
							
						</td>
						<td>
							<a href="/camport/freeboard/freeboardview.do?freeBoardSeq=${dto.freeBoardSeq}">
							${dto.freeBoardName}</a>
						</td>
						<td>${dto.freeBoardRegdate}</td>
						<td>${dto.freeBoardReadcnt}</td>
						<td>${dto.freeBoardDawncount}</td>
					</tr>
					</c:forEach>
				</table>
				<div style="clear:both;"></div>
				<input type="button" value="글쓰기"  class="btn btn-primary" id="wirtebtn" 
					onclick="location.href='/camport/freeboard/freeboardadd.do';">
				<div id="pagebar" style="text-align: center;">
			<%--
			페이지 번호 : <input type="number" name="pagenum" id="pagenum" required min="1" max="${totalPage}"> <input type="button" value="페이지 이동" onclick="movepage();">
			--%>
			
			<%--
			<select onchange="movepage2();">
				<c:forEach var="i" begin="1" end="${totalPage}">
				<option 
					value="${i}"
					<c:if test="${i == nowpage}">selected</c:if> 
					>${i} 페이지</option>
				</c:forEach>
			</select>
			--%>
			
			<%--
			<input type="range" class="form-control" style="width: 800px;margin:0px auto;" list="steplist" min="1" max="${totalPage}" value="${nowpage}" onchange="movepage2();">
			<datalist id="steplist">
				<c:forEach var="i" begin="1" end="${totalPage}">
			    <option>${i}</option>
			    </c:forEach>
			</datalist>
			--%>
			
			<!-- 
			<a href="list.do?page=1">1</a>
			<a href="list.do?page=2">2</a>
			<a href="list.do?page=3">3</a>
			<a href="list.do?page=4">4</a> 
			-->
			
			${pagebar}
			
		</div>
				
			</div>
		</div><!-- main   -->
		<%@include file="/inc/Dark_footer.jsp" %>
	</div>


</body>
</html>