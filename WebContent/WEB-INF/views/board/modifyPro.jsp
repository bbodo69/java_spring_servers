<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="style.css" rel="stylesheet" type="text/css">
</head>	
	<c:if test="${check == 1 }">
		<script>
			location.href="/web/board/list.dw";			
		</script>
	</c:if>
	<c:if test="${check != 1 }">
		<script>
			alert("비밀번호가 맞지 않습니다.다시 시도해주세요..");
			history.go(-1);
		</script>
	</c:if>
<body>
</body>
</html>