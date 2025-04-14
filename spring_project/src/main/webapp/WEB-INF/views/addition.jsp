<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="emp7">
	<table border="1">
		<thead>
			<tr>
				<th>empno</th>
				<td><input type="text" name="empno" value="${select20.empno}"></td>
			</tr>
			<tr>
				<th>ename</th>
				<td><input type="text" name="ename" value="${select20.ename}"></td>
			</tr>
			<tr>
				<th>job</th>
				<td><input type="text" name="job" value="${select20.job}"></td>
			</tr>
			<tr>
				<th>mgr</th>
				<td><input type="text" name="mgr" value="${select20.mgr}"></td>
			</tr>
			<tr>
				<th>hiredate</th>
				<td><input type="date" name="hiredate" value="${select20.hiredate}"></td>
			</tr>
			<tr>
				<th>sal</th>
				<td><input type="text" name="sal" value="${select20.sal}"></td>
			</tr>
			<tr>
				<th>comm</th>
				<td><input type="text" name="comm" value="${select20.comm}"></td>
			</tr>
			<tr>
				<th>deptno</th>
				<td><input type="text" name="deptno" value="${select20.deptno}"></td>
			</tr>
		</thead>
	</table>
<input type="submit" value="추가">
</form>
</body>
</html>