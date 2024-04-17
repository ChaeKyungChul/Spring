<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
   <title>My Blog</title>
   <style>
       body{
    	    padding: auto;
   	     	margin: auto; 	
   	     	       
      }
      
		link { color: #0000EE; }
	    visited { color: #551A8B; }

       h1{
       
		    text-align: center;
		    width: 100%;
		    border:solid black;
		    border-radius: 10px;
		    background-color: rgb(201, 238, 238);
		   
       }
		     .text1{
		    text-align: center;
		    width: 120px;
		    height: auto;
		    border:solid black;
		    border-radius: 10px;
		    background-color: rgb(201, 238, 238);
		    font-size: 20px;
		    font-weight: bold;
		    padding: auto;
   	     	margin: auto;
   	     
		}
		  .del1{
		  background-color: rgb(201, 238, 238);
		  color: white;
		  width: 50px;
		  padding: 10px 20px;
		  border: none;
		  border-radius: 3px;
		  cursor: pointer;
		  font-size: 16px;
		  margin-right: 10px;   
		  font-weight: bold;
		  visited color: black; 
		  }
		  
		  .del2{
	      background-color: #4CAF50;
		  color: white;
		  padding: 10px 20px;
		  border: none;
		  border-radius: 3px;
		  cursor: pointer;
		  font-size: 16px;
		  margin-right: 10px;   
		   background-color: #f44336;
		   font-weight: bold;
		
		  }
		  
		  .del1:hover, .del2:hover {
		  opacity: 0.8;
		} 
		 
		  
       
       
        table {
          width: 100%;
          border-collapse: collapse;
          font-family: Arial, sans-serif;
         
        }
    
        th, td {
          padding: 10px;
          text-align: left;
          border-bottom: 1px solid #ddd;
           text-align: center;
         visited color: black; 
        }
    
        th {
          background-color: #f2f2f2;
          font-weight: bold;
           text-align: center;
         
        }
       
    
        h2 {
          font-size: 24px;
          margin-bottom: 20px;
      
        }
    
    
        body {
          font-size: 16px;
          line-height: 1.5;
          color: #333;
          margin: 0;
          padding: 20px;
         
        }
        .title1{
         font-weight: bold;
       
        }
        
       
         td >a
         ,td>.title1>a
         ,td>.del1>a
         ,td>.del2>a{
        text-decoration-line: none;
        visited color: black; 
        
        }
  
         


   </style>
</head>
<body>
<div class="container">
<h1 class="text-center">
   My Blog
</h1>



<table border="1">
   <tr>
      <th>id</th>
      <th>제목</th>
      <th>내용</th>
      <th>포스팅날짜</th>
      <th>조회수</th>
   </tr>
   <c:forEach var="st" items="${listboard }">
      <tr>
         <td>${st.id }</td>
         <td><a href="content?id=${st.id}">${st.title }</td>
         <td>
          <div class=title1> <p>제목 :<a href="content?id=${st.id}"> ${st.title }</p></div>
         ${st.content }</td>
         <td>${st.wdate }</td>      
         <td>${st.hit } </td>
         
        <td>  <div class=del1><a href="update?id=${st.id}">글수정</a> </div>  
       <div class=del2>  <a href="delete?id=${st.id}" class="del">글삭제</a></div>   </td>    
      </tr>
       
   </c:forEach>
</table>
<div class=text1>
<P>  <a href="insert">글등록</a> </P></div>
</div>
 <p>${msg } </p>
 
<script>

  const deltarget = document.querySelectorAll(".del");
  deltarget.forEach((target, index) => {
	  target.addEventListener("click", (e)=>{
		  e.preventDefault();
		  const hrefVal = target.getAttribute("href");
		  if(confirm("정말로 삭제하시겠습니가?")){
		 document.location.href=hrefVal;
		  }	  	  
	  });
  });
  
</script>
</body>
</html>
