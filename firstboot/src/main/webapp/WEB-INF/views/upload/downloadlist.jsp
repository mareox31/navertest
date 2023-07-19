<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 컬렉션, jstl써. -->
 <!-- 안의 내용 a태그로 보여줄것. 클릭하면 a태그링크걸린데로이동. -->

<h1>다운로드 목록을 보여드립니다.</h1>
<c:forEach items="${filearray }" var="filename">
<h3><a href="filedownloadresult?filename=${filename }">${filename } </a> 다운로드</h3> 
<!-- 선택파일이름넘겨주고다운로드할수있도록.//다운받게끔 구현, 다운로드컨트롤러 -->
</c:forEach>

<!-- a태그 get방식만가능.  -->

</body>
</html>