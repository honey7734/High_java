<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function() {
	$('#lprodBtn').on('click', function() {
		$.ajax({
			url : '<%=request.getContextPath() %>/lprodController.do',
			type : 'post',
			success : function(data) {
				var str = "";
				
				$.each(data, function(i,v) {
					str += i +"번째 자료<br>"
					str += "id : " + v.lprod_id + "<br>"
					str += "gu : " + v.lprod_gu + "<br>"
					str += "nm : " + v.lprod_nm + "<hr>"
				})
				
				$("#result").html(str);
			},
			error : function() {
				alert('오류');
			},
			dataType : 'json'
		})
	})
})
</script>
</head>
<body>
<!-- 
	DB의 LPROD테이블의 전체 데이터를 가져와 화면에 출력하시오
-->
<form>
	<input type="button" id="lprodBtn" value="Lprod자료 가져오기">
</form>
<h3>Lprod 자료 목록</h3>
<div id="result"></div>
</body>
</html>