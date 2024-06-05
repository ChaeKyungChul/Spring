<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>my blog</title>
    <link rel="icon" type="image/x-icon" href="res/images/favicon.ico">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://fonts.googleapis.com/css2?family=Hahmlet:wght@100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/remixicon/4.2.0/remixicon.css" integrity="sha512-OQDNdI5rpnZ0BRhhJc+btbbtnxaj+LdQFeh0V9/igiEPDiWE2fG+ZsXl0JEH+bjXKPJ3zcXqNyP4/F/NegVdZg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="res/css/style.css" />
    
    <script src="res/js/jquery.min.js"></script>
    <script src="res/js/scripts.js"></script> 
    
</head>
<body>
    <header>
        <div class="logo">
            <a href="#"><img src="res/images/logo.png" alt="logo"></a>
        </div>
        <div class="post-card-img1">                                                                   
                          <img src="res/images/사진1.png" alt="사진" class="img-fluid">
                        </div>
        <div class="signin text-center">
        <sec:authorize access="!isAuthenticated()"> 
           <h3 class="mb-3">LOGIN</h3>          
           <!-- 로그인 -->
           <form name="form" action="${pageContext.request.contextPath }/" method="post">
              <div class="mb-3">
                 <input type="text" 
                        name="username" class="form-control" placeholder="username"/>
              </div>
              <div class="mb-3">
                <input type="password" 
                       name="password" class="form-control" placeholder="password"/>
             </div>
             <div class="mb-2 text-end">
                 <a href="#" class="find-id">아이디/패스워드 찾기</a>
             </div>
             <div class="d-grid">
                <button type="submit" class="btn btn-success">LOGIN</button>
             </div>
             <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
           </form>   
           <!-- /로그인 -->        
        </sec:authorize>
        
        <sec:authorize access="isAuthenticated()">    
           <!-- 로그아웃 -->
           환영합니다. <sec:authentication property="name" />님.
           
           <sec:authentication property="principal.authorities" var="roles" />
           <c:forEach var="role" items="${roles }">
              <c:if test="${role.authority eq 'ADMIN' }">
                 <p>관리자 모드</p>
              </c:if>
           </c:forEach>
         <!-- 
           <sec:authorize access="hasRole('ADMIN')">
              <p>넌 관리자 구먼</p>
           </sec:authorize>
           
           <sec:authorize access="hasRole('USER')">
              <p>넌 회원이 구먼</p>
           </sec:authorize>
         -->   
           
           <form action="${pageContext.request.contextPath }/logout" method="post">
              <button type="submit" class="btn btn-danger"> LOGOUT </button>
              <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
           </form>
           <!--  /로그아웃 -->
        </sec:authorize>
           
        </div>
        
        <div class="my-2 text-end">
        <sec:authorize access="!isAuthenticated()">    
            <a href="#" class="signup">회원가입</a>
        </sec:authorize>    
        </div> 
        <nav>
            <ul class="main-nav mt-5">
                <li><a href="about">about me</a></li>
                <li><a href="./">my gallery</a></li>
                  <li><a href="https://github.com/ChaeKyungChul?tab=repositories" target="_blank">my project</a></li>
                  <li><a href="youtube">youtube link</a></li>
                  <li><a href="contact">contact me</a></li>    
               </ul>
        </nav>
        <div class="social">
           <a href="#" class="instagram"><i class="ri-instagram-line"></i></a>
           <a href="https://www.youtube.com/channel/UCKx3HtwsELqy2wIwD2N5Xjg" class="youtube"><i class="ri-youtube-line"></i></a>
           <a href="https://www.facebook.com/profile.php?id=100004782243586" class="facebook"><i class="ri-facebook-circle-line"></i></a>
           <a href="https://open.kakao.com/o/sRcsXyvg" class="kakaotalk"><i class="ri-kakao-talk-line"></i></a>
        </div>
        <div class="copyright">
            Copyright &copy; wein's.
        </div>
    </header>
    <div class="wrapper">
