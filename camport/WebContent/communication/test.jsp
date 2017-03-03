<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.1.0.min.js"></script>
<script>
	$(function() {
		$("#call")
				.click(
						function() {
							var str = $(this).parents('form:first').serialize();
							alert(str);

							$
									.ajax({
										type : "POST",
										url : "/camport/communication/commList.do",
										contentType : "application/x-www-form-urlencoded; charset=utf-8",
										data : str,
										datatype : "json",
										success : function(data) {
											//alert(data.result);
											
											console.log(data["num"]);

											
										},
										error : function(e) {
											alert("에러발생");
										}
									});
						});
	});
</script>
</head>
<body>
	<form id="form1">
		<input type="text" name="val" value="ajax 테스트" id="val"></input> <input
			type="text" name="num" value="12345" id="num"></input> <input
			type="button" value="호출" id="call"></input>
	</form>
	<div id='wrap'></div>
</body>
</html>
