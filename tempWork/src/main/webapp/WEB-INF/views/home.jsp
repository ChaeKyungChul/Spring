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
      <th>이름</th>
      <th>이메일</th>
      <th>수강과목</th>
   </tr>
   <c:forEach var="st" items="${listStudent }">
      <tr>
         <td>${st.stu_id }</td>
         <td>${st.stu_name }</td>
         <td>${st.stu_email }</td>
         <td>${st.stu_course }</td>
      </tr>
   </c:forEach>
</table>
</div>
</body>
</html>
