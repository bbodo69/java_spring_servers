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
<h1>count : ${count }</h1>
<h1>maxAge : ${maxAge }</h1>

<c:forEach var="user" varStatus="status" items="${userList }">  <!-- 지정해준 user 가 dto 자체가 됨. -->
	<h3>${status.count} : ${user.id } : ${user.pw } : ${user.age } : ${user.reg }</h3>
</c:forEach>

<h1> ${dto.id } : ${dto.pw } : ${dto.age } : ${dto.reg }</h1>

<h1> ${reg }</h1>


</body>
</html>