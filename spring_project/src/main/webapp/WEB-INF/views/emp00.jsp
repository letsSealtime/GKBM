<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="emp6">
	<table border="1">
		<thead>
			<tr>
				<th>empno</th>
				<td id="empno">${select10.empno}</td>
			</tr>
			<tr>
				<th>ename</th>
				<td><input type="text" name="ename" value="${select10.ename}"></td>
			</tr>
			<tr>
				<th>job</th>
				<td><input type="text" name="job" value="${select10.job}"></td>
			</tr>
			<tr>
				<th>mgr</th>
				<td><input type="text" name="mgr" value="${select10.mgr}"></td>
			</tr>
		</thead>
	</table>
<input type="hidden" name="empno" value="${select10.empno}">
<input type="submit" value="수정하기1"> 
</form>	
	
</body>
</html>