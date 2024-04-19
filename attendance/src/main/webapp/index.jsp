<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    HttpSession sess1 = request.getSession(true);
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
    <form action="./login" method="post">
    <div class="container">
        <h3 class="text-center mb-3">수강신청</h3>
        <ul class="tabs">
          <li class="tab-link current" data-tab="tab-1">학생</li>
          <li class="tab-link" data-tab="tab-2">교수</li>
        </ul>
      
        <div id="tab-1" class="tab-content current">
            <ul>
                <li><label class="col-1"></label>이름 <input type="text" name="name" id="name" class="rounded border border-3 col-6" ></li>
                <li><label class="col-1"></label>학번 <input type="number" name="student_id" id="student_id" class="rounded border border-3 col-6"></li>
                <li>비밀번호 <input type="password" id="password" name="password" id="password" class="rounded border border-3 col-6"></li>
              </ul>
              
        </div>
        
        <div id="tab-2" class="tab-content">
             <ul>
                <li><label class="col-1"></label>이름 <input type="text" name="tname" id="tname" class="rounded border border-3 col-6" ></li>
                <li>비밀번호 <input type="password" name="tpass" id="tpass" class="rounded border border-3 col-6"></li>
            </ul>
            
        </div> 
           
        <button type="submit" class="btn btn-primary sub">로그인</button> 
      </div>
      </form>
</body> 
</html>