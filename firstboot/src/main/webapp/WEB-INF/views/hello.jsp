<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-3.6.4.min.js"></script>
<!-- html은 / 포트번호까지생략됨 /js/jquery-3.6.4.min.js쓰면됨. -->
<!-- 포트번호 바꿔가면서 테스트하니까 /부터쓰면 알아서 가져옴. 
절대경로 : http://localhost:8063/js/jquery-3.6.4.min.js -->
<script>
$(document).ready(function(){
	$("#ajaxbtn").on('click', function(){
		
		$.ajax({ //전송데이터 객체로묶음.  data : 이건지금없음. //제이슨 sts4서 따로 라이브러리안해줘도 자동내장.
			url : "helloajax", 
			type : "get", 
			dataType: "JSON",
			success : function(server){ //서버가주는결과 그대로출력
				$("#result").html(server.model); //ajax 헬로컨트롤러서 넘겨준 모델=>result영역에출력.
			},
			error : function(error){
				alert(error);
				
			}
			
		});
	});
});



</script>


</head>
<body>

<h1>hello.jsp 파일입니다.</h1>
<h1>${model }</h1>

<!-- 정적 파일경로. 리소시즈 스테틱-->
<img src="/images/html5.jpg"> <!-- http://localhost:8063 -->
<!-- 외부경로 업로드맵핑 -->
<img src="/upload/drinks.jpg">

<input type=button value="ajax요청버튼" id="ajaxbtn">
ajax결과 출력 <h1 id="result"></h1>

</body>
</html>