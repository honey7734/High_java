<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax를 이용한 json데이터 처리하기</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function() {
	// 문자열 처리
	$('#strBtn').on('click', function() {
		$.ajax({
			url : "<%=request.getContextPath()%>/jsonController.do",
			type : "post",
			data : {"choice" : "string"},
			success : function(data) {	// 응답데이터 처리함수
				var str = "문자열 데이터<hr>";
				str += data;
				$('#result').html(str);
			},
			error : function() {	// 에러 처리함수
				alert("오류");
			},
			dataType: "json"	// 응답으로 오는 데이터 종류 설정
		})
	})
	// -----------------------------------------------------
	
	// 배열 처리
	$('#arrayBtn').on("click", function() {
		$.ajax({
			url : "<%=request.getContextPath()%>/jsonController.do",
			type : "post",
			data : {"choice" : "array"},
			success : function(data) {	
				let str = "배열 데이터<hr>";
				$.each(data, function (i,v) {
					str += i +"번째 데이터 : " + v + "<br>";
				})
				
				$('#result').html(str);
			},
			error : function() {	
				alert("오류");
			},
			dataType: "json"
		})
	})
	// -----------------------------------------------------
	
	// 객체 처리
	$('#objBtn').on("click", function() {
		$.ajax({
			url : "<%=request.getContextPath()%>/jsonController.do",
			type : "post",
			data : {"choice" : "object"},
			success : function(data) {	
				//{ "num" : 100, "name" : "홍길동", "tel" : "010-1234-5678" }
				let str = "객체 데이터<hr>";
				str += "번호 : " + data.num + "<br>"				
				str += "이름 : " + data.name + "<br>"				
				str += "전화 : " + data.tel + "<br>"				
				$('#result').html(str);
			},
			error : function() {	
				alert("오류");
			},
			dataType: "json"
		})
	})
	// -----------------------------------------------------

	// 리스트 처리 (자바에 List는 JSON에서는 배열로 변환된다.)
	$('#listBtn').on("click", function() {
		$.ajax({
			url : "<%=request.getContextPath()%>/jsonController.do",
			type : "post",
			data : {"choice" : "list"},
			success : function(data) {	
				/*
				[ {"num" : 100, "name" : "홍길동", "tel" : "010-1234-5677"}, 
				  {"num" : 200, "name" : "홍길서", "tel" : "010-1234-5678"}, 
				  {"num" : 300, "name" : "홍길남", "tel" : "010-1234-5679"} ]
				*/
				
				let str = "리스트 데이터<hr>";
				
				$.each(data, function(i,v) {
					str += i + "번째 자료<br>";
					str += "번호 : " + v.num  + "<br>"				
					str += "이름 : " + v.name + "<br>"				
					str += "전화 : " + v.tel  + "<hr>"	
				})
				$('#result').html(str);
			},
			error : function() {	
				alert("오류");
			},
			dataType: "json"
		})
	})
	// -----------------------------------------------------
	
	// Map 처리(자바의 Map은 JSON에서는 객체형으로 변환된다.)
	$('#mapBtn').on("click", function() {
		$.ajax({
			url : "<%=request.getContextPath()%>/jsonController.do",
			type : "post",
			data : {"choice" : "map"},
			success : function(data) {	
				// { 키값1:value값1, 키값2:value값2, ... }
				let str = "Map 데이터<hr>";
				str += "name : " + data.name + "<br>";
				str += "tel  : " + data.tel  + "<br>";
				str += "addr : " + data.addr + "<hr>";
				
				$.each(data, function(i,v) {
					// data가 객체형이면 i에는 변수명, v에는 데이터 값이 저장된다.
					str += i + " ==> " + v + "<br>";
				})
				
				$('#result').html(str);
			},
			error : function() {	
				alert("오류");
			},
			dataType: "json"
		})
	})
	
})
</script>
</head>
<body>
<form>
  <input type="button" id="strBtn" value="문자열">
  <input type="button" id="arrayBtn" value="배 열">
  <input type="button" id="objBtn" value="객 체">
  <input type="button" id="listBtn" value="리스트">
  <input type="button" id="mapBtn" value="Map객체">
</form>
<hr>
<h3>응답 결과 출력</h3>
<div id="result"></div>
</body>
</html>