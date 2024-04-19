<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    HttpSession sess = request.getSession(true);
    
    String username = (String)sess.getAttribute("name");
    String j001 = request.getParameter("j001");
    String m001 = request.getParameter("m001");
    String p001 = request.getParameter("p001");
    String mode = request.getParameter("mode");
    
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
    <link rel="stylesheet" href="css/classes.css">
</head>
<body>
    <form action="classesok.jsp">
        <div class="container">
            <h3 class="text-center classbutton">수강신청</h3>
            <p class="text-right"><%=username %>님<a href="#"> 로그아웃</a></p>
            <ul class="tabs">
              <li class="tab-link current" data-tab="tab-1">수강신청</li>
              <li><a href="list.html"></a>시간표</li>
            </ul>
          
            <div id="tab-1" class="tab-content current">
                <table class="table">
                    <col width="8%">
                    <col width="20%">
                    <col width="10%">
                    <col width="8%">
                    <col width="20%">
                    <col width="8%">
                    <col width="15%">
                    <thead class="text-center">
                        <tr>
                            <th>번호</th>
                            <th>신청</th>
                            <th>과목명</th>
                            <th>학점</th>
                            <th>강의시간</th>
                            <th>요일</th>
                            <th>과목코드</th>
                            <th>여석</th>
                        </tr>
                    </thead>
                    <tbody  class="text-center">
                        <tr>
                            <td>1</td>
                            <td>
                               <button type="submit" class="bt btn btn-primary" value="<%=j001 %>" id="<%=j001 %>">신청</button> 
                            </td>
                            <td>JAVA</td>
                            <td>3</td>
                            <td>9:00-12:00</td>
                            <td>월 수</td>
                            <td>J001</td>
                            <td>30</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>
                               <button type="submit" class="bt btn btn-primary" value="<%=m001 %>" id="<%=m001 %>">신청</button>
                             </td>
                            <td>MYSQL</td>
                            <td>3</td>
                            <td>13:00-15:00</td>
                            <td>화 목</td>
                            <td>M001</td>
                            <td>30</td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>
                               <button type="submit" class="bt btn btn-primary" value="<%=p001 %>" id="<%=p001 %>">신청</button>
                            </td>
                            <td>PYTHON</td>
                            <td>3</td>
                            <td>16:00-18:00</td>
                            <td>금</td>
                            <td>P001</td>
                            <td>30</td>
                        </tr>
                    </tbody>
                </table>
            </div>
          </div>
          <input type="hidden" name="mode" value="<%=mode %>"/>
          </form>
          
</body>
</html>