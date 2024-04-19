<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="include/header2.jsp" %>
 <div class="container-fluid mt-5 pt-5">
     <div class="row">
     <% for(int i = 1; i < 21; i++){ 
    	String img=""; 
        if(i < 10){
        	img = "00" + i +".jpg";
        }else{
            img = "0"+ i + ".jpg";	
        }
     %>
         <div class="col-3 mb-4">
            <img src="../res/images/<%=img %>" class="img-fluid img-thumbnail">
            <h4>갤러리 작품 <%=i %></h4>
            <p>모든 국민은 언론·출판의 자유와 집회·결사의 자유를 가진다. 
               선거에 관한 경비는 법률이 정하는 경우를 제외하고는 정당 또는 후보자에게 부담시킬 수 없다.
            </p>
         </div>
      <% } %>   
     </div>
 </div>
 <%@ include file="include/footer.jsp" %>