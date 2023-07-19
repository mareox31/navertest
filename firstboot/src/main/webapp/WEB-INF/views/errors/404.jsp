<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>요청 rul 매핑 컨트롤러 메소드가 없거나 뷰가 없습니다.</h1>
<!-- request.는 jsp도 쓸 수 있으니까. -->
<%=request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI) %>

</body>
</html>
<!-- /WEB-INF/views/errors/400.jsp 
errors/400.jsp  여기서부터 view이름임. -->