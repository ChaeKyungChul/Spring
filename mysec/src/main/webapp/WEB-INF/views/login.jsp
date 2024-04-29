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
<h2>Login</h2>
    <c:if test="${param.error != null }">
        <div>
           <span class="text-danger">아이디, 또는 패스워드가 잘못됐습니다.</span>
        </div>  
    </c:if>
    <c:if test="${param.logout != null }">
        <div>
          <span class="text-success">로그아웃 되었습니다.</span>
        </div>
     </c:if>
    <form action="<c:url value='/login' />" method="post">
       <div>
          <label>아이디</label>
          <input type="text" name="userid" placeholder="userid" />
       </div>
       <div>
          <label>비밀번호</label>
          <input type="password" name="userpass" placeholder="userpass" />
       </div>
       <div>
          <button type="submit"> 로그인 </button>
       </div>
       <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }" />
    </form> 
</body>
</html>