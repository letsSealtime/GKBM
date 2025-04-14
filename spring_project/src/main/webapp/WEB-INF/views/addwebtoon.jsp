<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="addwebtoon.do">
이미지 : <input type="text" name="image"><br>
제목 : <input type="text" name="title"><br>  
작가 : <input type="text" name="author"><br> 
내용 : <input type="text" name="detail"><br> 

<input type="submit" value="확인">
<input type="reset" value="취소"><!-- 타입에 reset이것은 form요소 초기화해준다-->
</form>


</body>
</html>