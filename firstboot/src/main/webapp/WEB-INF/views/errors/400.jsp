<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>요청 파라미터를 확인하세요</h1>
<!-- request.는 jsp도 쓸 수 있으니까. -->
<%=request.getAttribute(RequestDispatcher.FORWARD_QUERY_STRING) %>

</body>
</html>
<!-- /WEB-INF/views/errors/400.jsp 
errors/400.jsp  여기서부터 view이름임. -->