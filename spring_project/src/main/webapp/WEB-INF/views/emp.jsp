<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹툰연습</title>
<style>
.pp {
	/* border: 1px solid red; */
	width: 100px;
	height: 100px;
}
</style>
</head>
<body>
	

	<form method="get" action="addition3">
		<input type="submit" value="등록하기">
	</form>
	
	<form method="get" action="emp9">
		<select name="type">
			<option value="ename" >ename</option>
			<option value="sal" >sal(이상)</option>		
			<option value="ej" >Ename + Job</option><!-- ename + job -->		
		</select>
		<input type="text" name="keyword"> 
		<input type="submit" value="검색하기"> 
	</form>


	 <form method="get" action="emp5">
	<input type="submit" value="선택된 것만 조회"> 
	<input type="submit" value="테이블 총개수" name="count"> 
	<table border="1">
		<thead>
			<tr>
				<th>No.</th>
				<th>checkbox</th>
				<th>empno</th>
				<th>ename</th>
				<th>job</th>
				<th>mgr</th>
				<th>hiredate</th>
				<th>sal</th>
				<th>comm</th>
				<th>deptno</th>
			</tr>
		</thead>
		<tbody></tbody>
		<c:forEach var="dto" items="${list}" varStatus="loop">
			<tr>
				<td>${loop.count}</td>
				<td><input type="checkbox" name="empnos" value="${dto.empno}"></td>
				<td>${dto.empno}</td>
				<!-- 클릭으로 empno의 줄에 내가emp99.jsp에 적었던거
				가져오기위한 것 <a href="emp99?empno=${dto.empno}">-->
				<td><a href="emp99?empno=${dto.empno}">${dto.ename}</a></td>
				<td>${dto.job}</td>
				<td>${dto.mgr}</td>
				<td>${dto.hiredate}</td>
				<td>${dto.sal}</td>
				<td>${dto.comm}</td>
				<td>${dto.deptno}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</form> 

<div>
	<a href="emp5?page=1">1</a>
	<a href="emp5?page=2"><strong>2</strong></a>
	<a href="emp5?page=3">3</a>
</div>



<script>
fatch('joinEmp',{
	method: 'POST',
	headers: {
		'Content-Type' : 'application/json'
	},
	body : JSON.stringify( param )
	}).then(function(resp){
		return resp.json()
	}).then((data)=>{
		console.log(data)
	}).catch((err)=>{
		console.error('ERROR joinEmp fetch', err)
	})
	
	let a = 10
	setTimeout( function(){
		a = 20
	},  1000)
	console.log(a) //10
	// 20이 출력되게 하려면?
		
	// Promise는 resolve() 또는 reject()가 실행될때 까지 기다려준다		
	let p = new Promise( function(resolve, reject) {
		setTimeout( function(){
			if(a == 10){
				a = 20
				resolve(a)
			}else{
			resolve('ERRRRR')
			}
		},  1000)
	})
	p.then( function(data){
		console.log(data)
	})p.catch(function(data){
		console.log(data))	
})

asyns function async_await(){
	await new Promise( function(resolve, reject){
	setTimeout( function(){
		if(a == 10){
			a = 20
			resolve(a)
		}else{
			reject('ERRRRR')
		}		
	}, 2000)
})
	// 위에꺼 끝날때 까지 기다렸다가
	// 이거 실행함
	console.log(1)
}	
</script>

</body>
</html>