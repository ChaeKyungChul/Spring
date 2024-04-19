<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.*, 
                 attendance.dto.*,
                 dao.*,
                 java.sql.*" %>  
 
   <%
  
	   HttpSession sess = request.getSession(true);
	   DBConnect db = new DBConnect();
	   Connection conn = db.getConnection(); 
	   MemberDao dao = new MemberDao(conn); 
	   String code = "1";
	   ArrayList<DBto> list = dao.gradeDB(code);
	   DBto dto = new DBto();
	   
	   String name = null;
	   String subject = null;
	   Double score = null;
	   
	
	     name = dto.getName();
	     subject = dto.getSubject();
	     score = dto.getScore();
	
	     System.out.println(name+"|"+subject+"|"+score);
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
    <link rel="stylesheet" href="css/style2.css">
</head>
<body>
  
            <p class="text-right"><%=dto.getName() %>님<a href="#"> 로그아웃</a></p>

 
    <h1>학점 관리</h1>

    <!-- 학생 성적 입력 폼 -->
    <h2>학생 성적 입력</h2>
    <form id="gradeForm">
        <label for="studentName">학생 이름:</label>
        <input type="text" id="studentName" name="studentName"><br><br>

        <label for="subject">과목:</label>
        <select id="subject" name="subject">
            <option value="java">JAVA</option>
            <option value="mysql">MySQL</option>
            <option value="python">PyThon</option>
            <!-- 다른 과목 옵션들을 추가하세요 -->
        </select><br><br>

        <label for="score">점수:</label>
        <input type="text" id="score" name="score"><br><br>

        <input type="submit" value="저장">
    </form>
    

    <!-- 학생 성적 조회 테이블 -->
    <h2>학생 성적 조회</h2>
    <input type="text" id="searchInput" placeholder="학생 이름으로 검색">
    <button onclick="searchGrade()">검색</button><br><br>

    <table id="gradeTable">
        <tr>
            <th>학생 번호</th>
            <th>이름</th>
            <th>과목</th>
            <th>점수</th>
            <th>수정</th>
            <th>삭제</th> 
          
        </tr>
     
        <!--   /*for(int i=0; i<list.size(); i++){
       dto = list.get(i);   
       name = dto.getName();
	   }*/ -->
    
         <tr>
           <th><%=dto.getId() %> </th>
           <th><%=dto.getName() %> </th>
           <th><%=dto.getSubject() %>  </th>
           <th><%=dto.getScore() %> </th>
           <th> </th>
           <th> </th>
         </tr>   
         <tr>
           <th><%=dto.getId() %> </th>
           <th><%=dto.getName() %> </th>
           <th><%=dto.getSubject() %>  </th>
           <th><%=dto.getScore() %> </th>
           <th> </th>
           <th> </th>
         </tr>
       
       
      
      
        <!-- 여기에 성적 정보를 표시할 행들을 추가하세요 -->
    </table>

    <script>
        // 여기에 JavaScript 코드를 추가하세요
        function searchGrade() {
            // 검색 기능을 구현하는 JavaScript 함수
        }
    </script>
</body>
</html>