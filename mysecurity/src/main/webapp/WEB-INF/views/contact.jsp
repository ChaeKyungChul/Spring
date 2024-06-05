<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="include/header.jsp" %>
        <div class="main mt-5 mb-5">
            <div class="container-fluid">
            <div class="row">
                <h1 class="mb-5">Contact</h1>
                <div class="col-md-6">
                    <h3 class="mb-4 me-5 fw-bold">궁금한 것이 있으시면 언제든 연락주세요.</h3>
                    <address>
                       <ul class="address me-5">
                          <li class="py-2 border-bottom"><label>Name :</label> 채경철 </li>
                          <li class="py-2 border-bottom"><label>Address :</label> 김포시 통진읍 조강로 36번길39</li>
                          <li class="py-2 border-bottom"><label>Number :</label> 010 - 5736 - 2464</li>
                          <li class="py-2 border-bottom"><label>Email :</label> corudwls33@naver.com</li>
                          <li class="py-2 border-bottom"><label>My Github :</label> <a href="https://github.com/ChaeKyungChul">https://github.com/ChaeKyungChul</a></li>
                       </ul>                        
                    </address>
                </div>
                <div class="col-md-6">
                   <form>
                     <div class="mb-3 me-4">
                        <label for="name" class="form-label">Your name</label>
                        <input type="text" class="form-control" id="name" placeholder="이름">
                     </div>
                     
                     <div class="mb-3 me-4">
                        <label for="email" class="form-label">Email Address</label>
                        <input type="email" class="form-control" id="email" placeholder="email">
                     </div>
                     <div class="mb-3 me-4">
                        <label for="tel" class="form-label">Phone Number</label>
                        <input type="tel" class="form-control" id="tel" placeholder="전화번호">
                     </div>
                     <div class="mb-3 me-4">
                        <label class="form-label">Content</label>
                        <textarea class="form-control" rows="4" placeholder="보내실 말씀"></textarea>
                     </div>
                     <div class="mb-3 me-4">
                        <button type="submit" class="btn btn-success">Submit</button>
                     </div>
                   </form>
                </div>
            </div>
            </div>
        </div>
        
           <%@ include file="include/footer.jsp" %>