<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="include/header.jsp" %>   
 

<div class="main mt-5">
    <div class="row d-flex justify-content-center">
        <h2 class="text-center mb-4">LOGIN</h2>
        <div class="col-md-8 mt-5">
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
            
            <div class="card px-5 py-5" id="form1">
                <form:form class="form-data" action="member/gallery" method="post">
                    <div class="forms-inputs mb-4"> <span>username</span> 
                        <input type="text" name="username" class="form-control">
                    </div>
                    <div class="forms-inputs mb-4"> <span>Password</span> 
                        <input type="password" name="password" class="form-control">
                    </div>
                    <div class="mb-3"> 
                        <input type="submit" class="btn btn-dark w-100" value="Login"> 
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
 <%@ include file="include/footer.jsp" %>  