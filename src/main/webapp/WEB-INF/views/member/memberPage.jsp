<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<p><img alt="" src="../resources/upload/${member.fileName }"></p>
		<p>Name :&nbsp;<input type="text" name="name" value="${member.name }"></p>
		<p>AGE :&nbsp;<input type="text" name="age" value="${member.age }"></p>
		
		<p>GRADE :&nbsp;<input type="text" name="grade" value="${member.grade }"></p>
		
		<div id="stduent">
		<!-- Student -->
		<p>PONE : <input type="text" name="phone" value="${student.phone }"></p>
		<p>TID : <input type="text" name="tid" value="${student.tid }"></p>
		</div> 
		
		<!-- <div id="teacher">
		Teacher
		<p>TID : <input type="text" name="tid"></p>
		<p>SUBJECT : <input type="text" name="subject"></p>
		<p>HIREDATE : <input type="date" name="hireDate"></p>
		</div> -->
</body>
</html>