<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.text-danger{
    color:red;
 }
.text-success{
   color:green;
} 
</style>
</head>
<body>
<h2>LogOut</h2>
  
    <form action="<c:url value='/logout' />" method="post">
       <div>
          <button type="submit"> 로그아웃 </button>
       </div>
       <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }" />
    </form> 
</body>
</html>