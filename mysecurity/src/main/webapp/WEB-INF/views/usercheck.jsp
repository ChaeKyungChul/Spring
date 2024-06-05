<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>중복체크</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="res/js/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $('.thisclose').click(function(){
                window.close();
            });
        });
    </script>
</head>
<body>
    <div class="checkbox m-5 p-5 border">
        <form name="checkform" action="check" id="checkform" method="post">
            <div class="form-group">
                <label for="usearch">검색어</label>
                <input type="text" name="usearch" class="form-control" id="usearch" value="${param.usearch }"/>
            </div>
            <input type="hidden" name="check" id="check" value="${param.check }">
            <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
            <div class="mt-3 text-center">
                <button type="button" class="thisclose btn btn-danger me-2">닫기</button>
                <button type="submit" class="btn btn-primary ms-2">중복확인</button> 
            </div>
        </form>
    </div>
</body>
</html>