<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button type="button" id="btn">진동</button>
	<div id='view'></div>

	<style>
#popup {
	border: 1px solid red;
	width: 300px;
	height: 500px;
	
	position: absolute;
	top: 50px;
	left: 550px;
}

#popup .title {
	background: blue;
	color: white
}
#popup .title:hover{
	/* cursor: all-scroll; */
	cursor: grab;
}
#popup .title:active{
	/* cursor: all-scroll; */
	cursor: grabbing;
}

#popup .content {
	background: white;
}
#idm{
	position: absolute;
	top: 0;
	left: 0;
	
	width: 100vw;
	height: 100vh;
	background: rgba(172,172,172,1)
}
</style>
	<div id='dim'>
		<div id='popup'>
			<div class='title'>
				<div>제목</div>
			</div>
			<div class='content'>
				<div>
					내용<br> 내용
				</div>
			</div>
		</div>
	</div>
	<script>
	document.querySelector('#btn').addEventListener('click', ()=>{
		/* navigator.vibrate(500) */ //ms
		if(navigator.vibrate){}
		navigator.vibrate([300,100,500,100,300]) //ms, 진동, 쉬기, 진동...
		}else{
			alert('navigator.vibrate 없음')
		}
	})
	
	if(screen.orientation){
        screen.orientation.addEventListener('change',()=>{
            document.querySelector('#view').innerHTML = 
            type: \${screen.orientation.type}<br>
            angle:\${screen.orientation.angle}
            orientation: \${window.orientation}
        
    })
		}else{
    	alert('방향 지원 안함')
	}
	
	
	/* 
		타이틀에서 왼쪽 버튼을 누르면
		- 왼쪽 버튼이 눌렸 다는걸 저장
		타이틀에서 왼쪽 버튼을 떼면
		- 왼쪽 버튼이 떨어졌 다는걸 저장
		
		마우스 최초 눌렀을 때
		- 그때 마우스 위치값 저장
	
	*/
	
	let istDragable = false;
	let offsetX = 0;
	let offsetY = 0;
	
	document.querySelector('.title').addEventListener('mousedown', (event)=>{
		istDragable = true;
		
		document.querySelector('#view').innerHTML = `
			x: \${event.clientX}<br>
			y: \${event.clientY}<br>
		`
		
		offsetX = event.clientX
		offsetY = event.clientY
	})
	document.querySelector('.title').addEventListener('mouseup', ()=>{
		istDragable = false;
	})
	document.querySelector('.title').addEventListener('mousemove', ()=>{
		if(istDragable){
			let diff_X = event.clientX - offsetX
			let diff_Y = event.clientY - offsetY
			
			let popup = document.querySelector('#popup')
			
/* 			console.log(popup.style.top) */
			console.log(popup.offsetTop)
			
			popup.style.top = (popup.offsetTop + diff_Y)+'px'
			popup.style.left = (popup.offsetLeft + diff_X)+'px'
			
			
			offsetX = event.clientX
			offsetX = event.clientX
		}
	})
</script>
</body>
</html>