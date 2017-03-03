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

<style>
body {
	background-color: #E9EBEE;
}

#middle {
	position: relative;
	margin: 0 auto;
}

#search {
	padding-bottom: 20px;
	border-bottom: 2px solid #444;
}

#searchMsg {
	text-align: center;
}

#tbl1 {
	width: 600px;
	margin: 30px auto;
}

.spaceTd {
	width: 50px;
}

.tdSeq {
	width: 80px;
	color: #3B5998;
	font-weight: bold;
	border-left: 2px solid #DDDDDD;
	background-color: #337AB7;
	color: white;
	padding-top: 10px;
}

.tdSubject {
	text-align: center;
	width: 440px;
	background-color: #337AB7;
	vertical-align: middle !important;
	padding: 0;
	font-weight: bold;
	font-size: 1.5em;
	color: white;
	padding: 0;
	margin: 0;
}

.tdDelBtn {
	width: 80px;
	text-align: right;
	border-right: 2px solid #DDDDDD;
	background-color: #337AB7;
	color: white;
	padding: 0;
}

.tdCnt {
	font-size: 0.6em;
	border-left: 2px solid #DDDDDD;
	border-bottom: 0px solid white;
	background-color: white;
}

.tdDate {
	font-size: 0.6em;
	text-align: right;
	border-right: 2px solid #DDDDDD;
	border-bottom: 0px solid white;
	background-color: white;
}

.tdContent {
	width: 800px;
	height: 200px;
	background-color: white;
	text-align: left;
	border-left: 2px solid #DDDDDD;
	border-right: 2px solid #DDDDDD;
}
/* 글쓰기 검색폼 */
#tbl2 {
	width: 600px;
	margin: 0 auto;
	max-width: 100%;
}

#tbl2 td {
	padding: 0px 2px;
}

#tbl2 td:nth-child(1) {
	width: 5%;
	text-align: left;
}

#tbl2 td:nth-child(2) {
	text-align: -webkit-right;
}

#tbl2 td:nth-child(3) {
	width: 7%;
	text-align: right;
}
</style>
<script>
$(document).ready(function() {






	
	<c:if test="${id == 'admin'}">
	/* 관리자 페이지  y,n 글 보이기/숨기기 변경*/
	 $(".ynBox").change(function(){
		 
		 //console.log($(this).val());
		 //console.log($("#yn").val($(this).val()));
		 $("#yn").val($(this).val())
		 $(this).parents('form:first').submit();

	}) 
	</c:if>

	 $(document).ready(function(){
		  //폼아이디가 my 의 submit 이벤트 받음
		  $('#my').submit(function(event){
		   var url = '/camport/communication/commentList.do';  //서블릿 위치
		   $('#wrap').load(url,$(this).serialize());   //jquery의 serialize 함수 이용하여 폼데이터들을 직렬화로 전송시키고 응답 받음
		   
		   event.preventDefault();  //기본 폼의 submit이 발생되지 않게 막기
		  });
		 });

	   
});


	//왼쪽 페이징 버튼
	function movepage() {
	   if (
	            $("#pagenum").val() != null &&
	            !isNaN($("#pagenum").val()) && 
	            $("#pagenum").val() >=1 && 
	            $("#pagenum").val() <= ${totalPage}
	      ) {
	      location.href = "/camport/communication/list.do?page=" + $("#pagenum").val();
	   }
	}

	//오른쪽 페이징 버튼
	function movepage2() {
	   location.href = "/camport/communication/list.do?page=" + $(event.srcElement).val();
	}
	



	
		/*aJax 댓글 보기*/
		function ajaxCommList(event){
			
				 //var str = $(event).parents('form:first').serialize();

				
				 
				var str = $(event).parent().serialize();
				$(event).hide();				  
				// alert(str); 

				$.ajax({
							type : "POST",
							url : "/camport/communication/commList.do",
							contentType : "application/x-www-form-urlencoded; charset=utf-8",
							data : str,
							datatype : "json",
							success : function(data) {
								if(data.length !=0){
								$.each( data, function( intValue, currentElement ) {
									var valueId = "";
									var valueDate = "";
									var valueContent = "";
									var adminId = "";
	                                $.each(currentElement, function( key, value ) {
	                                   // console.log(key);
	                                     //console.log(value);
	                                     if(key == "commentContent"){
		                                  valueContent=value;
		                                  }
	                                     else if(key == "userId"){


		                                     
	                                    	 console.log(value);
		                                     if(typeof value != undefined && value != null ){
	                                    	 	valueId=value;
				                                 }else{
		                                    	 valueId="";
				                                     }




		                                     }else if(key == "adminId"){
	                                    	 adminId=value;
			                                 }
	                                     else if(key == "commentRegdate"){
		                                  valueDate=value;
		                                 }

	                      
	                                });
	                              	$(event).parent().parent().parent().after( 
                                	"<tr><td   style='padding-left:20px;border-left:1px solid silver;font-weight:bold;    padding-bottom: 5px;'>"+valueId+adminId+"<br></td><td colspan='2' style='text-align:right;border-right:1px solid silver;'>"+valueDate+"<br></td></tr><tr><td colspan='3' style='padding-left:20px;border-bottom:1px solid white;border-left:1px solid silver;border-right:1px solid silver;'>"+valueContent+"</td></tr>" );
                                	//"<tr><td colspan='3'  style='padding-left:20px;border-left: 2px solid #DDDDDD;border-right: 2px solid #DDDDDD;'>"+valueId+adminId+valueDate+"</span><br>"+valueContent+"</td></tr>" );
	                        });
							
							
								}else{
									$(event).parent().parent().parent().after( 
                                	"<tr><td colspan='3'  style='padding-left:20px;border-left: 2px solid #DDDDDD;border-right: 2px solid #DDDDDD;'>댓글이 없습니다.</td></tr>" );
	                        }
							},
							error : function(e) {
								//alert("에러발생");
							}
						});
		}
</script>


</head>

<body>

	<!-- list.jsp -->
	<div id="main">
		<%@include file="/inc/top.jsp"%>
		<div id="middle">
			<c:if test="${sdto.search}">
				<div id="searchMsg">'에서 '${sdto.word}'을 검색했습니다.</div>
			</c:if>

			<div id="search">
				<!-- 자기 자신을 호출 -->
				<form method="GET" action="/camport/communication/list.do">
					<table id="tbl2">
						<tr>
							<td><input type="button" value="글쓰기" class="btn btn-primary"
								onclick="location.href='/camport/communication/add.do';">
							</td>
							<td><input type="text" name="word" id="word"
								style="width: 80%;" class="form-control" required
								placeholder="검색어를 입력하세요." value="${sdto.word}"></td>
							<td><input type="submit" value="검색하기"
								class="btn btn-warning"></td>
						</tr>
					</table>
				</form>
			</div>

			<table id="tbl1" class="">

				<c:if test="${empty list || list.size() == 0}">
					<tr>
						<td colspan="2">게시물이 존재하지 않습니다.</td>
					</tr>
				</c:if>




				<c:forEach items="${list}" var="dto">
					<tr>
						<td class="tdSeq">#${dto.commBoardSeq}<br> <span
							style="font-size: 0.4em;">${dto.commRegdate}</span></td>
						<td class="tdSubject">${dto.commName}</td>
						<td class="tdDelBtn"><c:if test="${id == 'admin'}">
								<a href="/camport/communication/edit.do?seq=${dto.commBoardSeq}"><input
									type="button" value="Blind" class="btn btn-danger" /></a>
							</c:if></td>
					</tr>

					<c:if test="${!empty dto.commFileName}">
						<tr>
							<td colspan="3" style="width:100%;height:50%;position: relative;text-align: center;"><img
								src="http://localhost:8090/camport/download.do?fileName=${dto.commFileName}&orgFileName=${dto.commOrgFileName}"
								style="width: 50%; height: 25%; margin:15px 15px;" /></td>
						</tr>
					</c:if>
					<tr>

						<td colspan="3" class="tdContent">${dto.commContent}</td>
					</tr>


					<c:if test="${id == 'admin'}">
						<tr>
							<td colspan="2"
								style="background-color: white; border-left: 2px solid #DDDDDD;">
								작성자 : ${dto.userId}</td>
							<td
								style="background-color: white; border-right: 2px solid #DDDDDD;">
								<form method="POST" action="/camport/communication/ynChange.do"
									id="frm">
									<input type="hidden" name="commBoardSeq"
										value="${dto.commBoardSeq}"> <input type="hidden"
										value="0" name="yn" id="yn"> <select class="ynBox"
										onchange="" style="float: right;">
										<option value='y'
											<c:if test="${dto.commView eq 'y'}">selected</c:if>>Y</option>
										<option value='n'
											<c:if test="${dto.commView eq 'n'}">selected</c:if>>N</option>
									</select>
								</form>

							</td>
						</tr>
					</c:if>
					<tr>
						<td colspan="3"
							style="background-color: #eee; border-left: 2px solid #DDDDDD; border-right: 2px solid #DDDDDD;">
							<form>
								<input type="hidden" name="commBoardSeq"
									value="${dto.commBoardSeq}" /> <input type="button"
									onclick="ajaxCommList(this)" value="댓글 보기">
							</form>
						</td>
					</tr>
					<tr>

						<td colspan="3"
							style="background-color: #eee; border-left: 2px solid #DDDDDD; border-right: 2px solid #DDDDDD;">

							<form method="POST" action="/camport/communication/commAdd.do">

								<input type="hidden" name="commBoardSeq"
									value="${dto.commBoardSeq}" class="form-control" /> <input
									type="text" required="required"
									style="width: 80%; display: inline-block; float: left;"
									name="commentContent" class="form-control" /> <input
									type="submit" value="GO" style="float: right; width: 20%;"
									class="btn btn-warning">
							</form>
						</td>

						<!-- style="float: right;" onclick="ajaxCommAdd(this);"> -->
					</tr>
					<tr>
						<td colspan="3" class="spaceTd"></td>
					</tr>
				</c:forEach>
			</table>

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

				<%-- <input type="range" class="form-control" style="width: 800px;margin:0px auto;" list="steplist" min="1" max="${totalPage}" value="${nowpage}" onchange="movepage2();">
         <datalist id="steplist">
            <c:forEach var="i" begin="1" end="${totalPage}">
             <option>${i}</option>
             </c:forEach>
         </datalist> --%>

				${pagebar}

			</div>



		</div>
	<%@include file="/inc/Dark_footer.jsp" %>
	</div>

</body>
</html>

















