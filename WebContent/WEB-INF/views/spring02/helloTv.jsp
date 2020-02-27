<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--Bean클래스(HelloBean2)에서 view로 전달되는 커맨드객체 (Model 계층에 삽입된즌 객체)를 출력
		@ModelAttribute 어노테이션에 별칭을 지정하지 않으면,
		전달하는 객체의 클래스 타입의 앞글자를 소문자로 바꿔서 속성명으로 전달되므로
		TvDTO => tvDTO 라는 이름으로 객체에 접근 가능함.
		
		@ModelAttribute  어노테이션이 붙은 메서드는 해당 ㅋ르래스의 하위  requestMapping 어노테이션이 붙은
		다른 메서드보다 선행되어 실행된다.
		따라서 requestMapping 으로 호출된 메서드는 @ModelAttribute 메서드를 반드시 선행 실행한다.
		==> 이미 리턴되는 객체가 (Tv)가 Model 속성으로 저장되어 있어서 페이지 실행시 꺼내 쓸수 있다.
	-->

	<h1>Tv</h1>
	${tvDTO.power } <br />
	${tvDTO.ch } <br />
	${tvDTO.col } <br />

	<!--
		
		별칭붙여준 걸로 출력됨  	
	<h1>Tv info</h1>
	${tvInfo.power } <br />
	${tvInfo.ch } <br />
	${tvInfo.col } <br />
	-->
	
</body>
</html>
