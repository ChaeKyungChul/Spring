<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
   <title>Home</title>
   <style>
		  .container {
			  width: 1000px;
			  margin: 0 auto;
			  padding: 50px;
			}
			
			
			h1 {
			  text-align: center;
			  margin-bottom: 30px;
			}
			
			
			table {
			  width: 100%;
			  border-collapse: collapse;
			  margin-top: 20px;
			}
			
			th, td {
			  padding: 12px 15px;
			  text-align: center;
			  border-bottom: 1px solid #ddd;
			}
			
			th {
			  background-color: #f5f5f5;
			  font-weight: bold;
			}
			
		
			a {
			  color: #4CAF50;
			  text-decoration: none;
			}
			
			a:hover {
			  color: #45a049;
			}
			
			
			.text-center {
			  text-align: center;
			}

   </style>
</head>
<body>
<div class="container">
<h1 class="text-center">
   블로그
</h1>
 <p><tr>
      <th>id : </th>
      <th>${dto.id }</th>
   </tr><p>

<P>  <a href="insert">새로운 글 등록</a> </P>
<table border="1">
    
   <tr>
      <th>제목</td>
      <th>${dto.title }</td>
   </tr>
   <tr>
      <th>내용</td>
      <th>${dto.content }</td>
   </tr>
   <tr>
      <th>날짜</td>
      <th>${dto. wdate }</th>
    
   </tr>
   

</table>
</div>
</body>
</html>
