<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>My Board</title>
  <link rel="stylesheet" href="res/css/style.css">
  <script src="res/jquery.min.js"></script>
  <script src="res/popper.min.js"></script>
  <script src="res/bootstrap.min.js"></script>
  <script src="res/script.js"></script>
</head>
<body>
   <div class="container">

    <!-- 헤더 -->
      <header>
         <a href="#" class="brand">MY BBS</a>
         <nav>
            <a href="#">회원보기</a>
            <a href="#">추천글</a>
            <a href="#">0000</a>
         </nav>
      </header>
      <!-- / 헤더 -->
      <div class="row">








        <!-- ASIDE -->
         <aside class="mt-3 p-4 bg-white">
            <form name="loginForm" class="loginform" id="loginform" method="post">
               <input type="text" class="form-control userid mb-4" id="userid"
                      placeholder="아이디" name="userid" />
               <input type="password" class="form-control userpass mb-3" id="userpass"
                      placeholder="비밀번호" name="userpass" />      
               <div class="text-right mb-3">
                 <label> 아이디 기억 <input type="checkbox" name="rid" value="rid" id="rid"></label>
               </div>         
               <button type="submit" class="btn btn-primary btn-block">로그인</button>                     
               <a href="join.html">회원가입</a>
            </form>    
         </aside>
         <!--/ ASIDE-->





         
         <section>
            <!-- listbox -->
            <div class="listbox">
                <h1 class="text-center mb-5">게시판</h1>
                <div class="d-flex justify-content-between py-4">
                    <div>
                        <a href="#" class="btn btn-primary">최신글순</a>
                        <a href="#" class="btn btn-primary">인기글순</a>
                    </div>
                    <div>
                        <a href="#" class="btn btn-primary">목록</a>
                        <a href="write.html" class="btn btn-primary">글쓰기</a>                      
                    </div>
                </div>
                <table class="table table-hover">
                    <colgroup>
                       <col width="8%">
                       <col>
                       <col width="15%">
                       <col width="10%">
                       <col width="15%">
                    </colgroup>
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>글쓴이</th>
                            <th>조회수</th>
                            <th>날짜</th>
                        </tr>
                    </thead>
                    <tbody>
                       <!-- loop --> 
                       <tr>
                           <td class="text-center">1</td>
                           <td><a href="contents.html">제목입니다. 이곳에 제목 제목입니다. 이곳에 제목
                            제목입니다. 이곳에 제목
                            제목입니다. 이곳에 제목
                            제목입니다. 이곳에 제목
                            제목입니다. 이곳에 제목 
                            제목입니다. 이곳에 제목
                            </a><span>(2)</span>
                               <i class="ri-file-image-fill"></i>
                               <i class="ri-file-hwp-fill"></i>
                               <i class="ri-file-music-fill"></i>
                            </td>
                            
                           <td class="text-center">홍길동</td>
                           <td class="text-center">12</td>
                           <td class="text-center">2024.02.26</td>
                       </tr>
                       <tr>
                        <td class="text-center">1</td>
                        <td><a href="#">제목입니다. 이곳에 제목</a></td>
                        <td class="text-center">홍길동</td>
                        <td class="text-center">12</td>
                        <td class="text-center">2024.02.26</td>
                       </tr>
                       <tr>
                        <td class="text-center">1</td>
                        <td><a href="#">제목입니다. 이곳에 제목</a></td>
                        <td class="text-center">홍길동</td>
                        <td class="text-center">12</td>
                        <td class="text-center">2024.02.26</td>
                       </tr>
                       <tr>
                        <td class="text-center">1</td>
                        <td><span class="re"></span><i class="ri-corner-down-right-line"></i><a href="#">제목입니다. 이곳에 제목</a></td>
                        <td class="text-center">홍길동</td>
                        <td class="text-center">12</td>
                        <td class="text-center">2024.02.26</td>
                       </tr>
                       <tr>
                        <td class="text-center">1</td>
                        <td><span class="re"></span><span class="re"></span><i class="ri-corner-down-right-line"></i><a href="#">제목입니다. 이곳에 제목</a></td>
                        <td class="text-center">홍길동</td>
                        <td class="text-center">12</td>
                        <td class="text-center">2024.02.26</td>
                       </tr>
                       <!-- /loop -->
                    </tbody>
                </table>
                <div class="d-flex justify-content-between py-4">
                    <div>
                        <a href="#" class="btn btn-primary">최신글순</a>
                        <a href="#" class="btn btn-primary">인기글순</a>
                    </div>
                    <ul class="paging">
                        <li>
                            <a href="#"><i class="ri-arrow-left-double-line"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="ri-arrow-left-s-line"></i></a>
                        </li>
                        <li><a href="#" class="active">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li>
                            <a href="#"><i class="ri-arrow-right-s-line"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="ri-arrow-right-double-line"></i></a>
                        </li>
                    </ul>
                    <div>
                        <a href="#" class="btn btn-primary">목록</a>
                        <a href="write.html" class="btn btn-primary">글쓰기</a>                      
                    </div>
               </div>
               <form name="searchform" id="searchform" class="searchform">
                   <div class="input-group my-3">
                        <div class="input-group-prepend">
                            <button type="button" 
                                    class="btn btn-outline-secondary dropdown-toggle" 
                                    data-toggle="dropdown"
                                    value="title">
                                제목검색
                              </button>
                              <div class="dropdown-menu">
                                <a class="dropdown-item" href="username">이름검색</a>
                                <a class="dropdown-item" href="title">제목검색</a>
                                <a class="dropdown-item" href="contents">내용검색</a>
                            </div>
                        </div>
                       <input type="search" class="form-control" placeholder="검색">
                       <div class="input-group-append">
                          <button class="btn btn-primary"><i class="ri-search-line"></i></button>
                       </div>
                   </div>
               </form>
            </div>
            <!-- /listbox-->
         </section>






      </div>
      <!-- 푸터 -->
   </div>
</body>
</html>>