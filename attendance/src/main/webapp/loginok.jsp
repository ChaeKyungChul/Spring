<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    HttpSession sess = request.getSession(true);
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/script.js"></script>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%
String username = (String) sess.getAttribute("name");
%>
    <div class="container mt-3">
        <h3 class="text-center"><%=username %>님 환영합니다.</h3>
            <div class="box">
                <a href="classes.jsp">수강신청</a>
                <a href="list.jsp">시간표</a> 
                <a href="grade.jsp">학점관리</a> 
            </div>
    </div>
</body>
</html>