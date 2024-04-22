<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
 <%@ include file="include/header2.jsp" %>
 <div class="container-fluid mt-5 pt-4">
   <c:if test="${param.logout != null }">
   <h1 class="text-center">
      안녕히 가세요~~
   </h1>
   </c:if>
   <div class="col-4 m-auto">
   <form:form action="/mysecurity/logout" method="post">
      <h1>로그아웃 하시겠습니까?</h1>
      <input type="submit" class="btn btn-dark w-100" value="logout" />
   </form:form>
   </div>
 </div>
 <%@ include file="include/footer.jsp" %>