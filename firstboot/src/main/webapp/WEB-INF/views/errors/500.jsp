<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>서버 내부 오류</h1>
<!-- request.는 jsp도 쓸 수 있으니까. -->
<!-- jsp, exception내장객체 가지고있음, 예외정보가지고있음// 위에 isErrorPage="true" 설정되야 익셉션사용가능. -->
<%=exception%>

</body>
</html>
<!-- /WEB-INF/views/errors/400.jsp 
errors/400.jsp  여기서부터 view이름임. -->