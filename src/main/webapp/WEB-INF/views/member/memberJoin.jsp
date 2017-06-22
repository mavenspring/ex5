<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btn").click(function() {
			var path="";
			$(".g").each(function() {
				if($(this).prop("checked")){
					path=$(this).val()+"Join";
				}
			});
			
			$("#frm").attr("action",path);
			$("#frm").submit();
			
		})
	})
</script>
</head>
<body>
	
	<form action="" id="frm" method="post" enctype="multipart/form-data">
	<div id="join_check">
		Student<input type="radio" class="g" checked="checked" name="grade" value="student">
		Teacher<input type="radio" class="g" name="grade" value="teacher">
	</div>
	<div>
		<!-- 공통 입력 -->
		<p>ID :&nbsp;<input type="text" name="id"></p>
		<p>PW :&nbsp;<input type="password" name="pw"></p>
		<p>Name :&nbsp;<input type="text" name="name"></p>
		<p>AGE :&nbsp;<input type="text" name="age"></p>
		<p>file :&nbsp;<input type="file" name="f1"></p>
	
		
	</div>
	<div id="stduent">
		<!-- Student -->
		<p>PONE : <input type="text" name="phone"></p>
		<p>TID : <input type="text" name="tid"></p>
		
	</div>
	<div id="teacher">
		<!-- Teacher -->
		<p>SUBJECT : <input type="text" name="subject"></p>
		<p>HIREDATE : <input type="date" name="hireDate"></p>
		
	</div>
		<input type="button" value="JOIN" id ="btn"> 
	</form>
	
	
</body>

</html>