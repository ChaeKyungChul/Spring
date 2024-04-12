<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
   <title>Home</title>
   <style>
     .container{
        width:1000px;
        margin:auto;
        padding:50px;
     }
     th,td,.text-center{
     text-align:center; 
     }

   </style>
</head>
<body>
<div class="container">
<h1 class="text-center">
   Hello Student!  
</h1>
<p>${msg }</p>
<p>The time on the server is ${serverTime}.</p>
<P>  <a href="insert">새로운 학생 등록</a> </P>
<table border="1">
   <tr>
      <th>번호</th>
      <th>${dto.stu_id }</th>
   </tr>
   
   <tr>
      <th>이름</td>
      <th>${dto.stu_name }</td>
   </tr>
   <tr>
      <th>이메일</td>
      <th>${dto.stu_email }</td>
   </tr>
   <tr>
      <th>이름</td>
      <th>${dto.stu_course }</td>
   </tr>
   

</table>
</div>
</body>
</html>
