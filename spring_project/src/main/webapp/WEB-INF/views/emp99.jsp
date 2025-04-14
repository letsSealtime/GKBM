<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<thead>
			<tr>
				<th>empno</th>
				<td>${select10.empno}</td>
			</tr>
			<tr>
				<th>ename</th>
				<td>${select10.ename}</td>
			</tr>
			<tr>
				<th>job</th>
				<td>${select10.job}</td>
			</tr>
			<tr>
				<th>mgr</th>
				<td>${select10.mgr}</td>
			</tr>
		</thead>
	</table>
	
<a href="emp00?empno=${select10.empno}"><button type="button">수정</button></a>
<a href="emp8?empno=${select10.empno}"><button type="button">삭제</button></a>
	
</body>
</html>