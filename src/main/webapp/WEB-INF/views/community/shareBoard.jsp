<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <jsp:include page="/WEB-INF/views/include/head.jsp"></jsp:include>
        <link rel="stylesheet" href="/resources/css/community.css">
    </head>
    <body>
        <div id="container">
            <jsp:include page="/WEB-INF/views/include/nav.jsp"></jsp:include>
            <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
            <main id="main">
                <div id="maincate">
                    <table id="category">
                        <tr>
                            <th><a href="/community/shareList.do">커뮤니티</a></th>
                        </tr>
                        <tr>
                            <td><a href="/community/shareList.do">정보공유게시판</a></td>
                        </tr>
                        <tr>
                            <td><a href="#">자유게시판</a></td>
                        </tr>
                        
                    </table>    
                </div>
                <section id="section">

                    <div>
                        <div id="sharetitle">정보공유게시판</div>
                    </div>
            
                    <div class="actionArea">
                        <span class="writeArea">
                            <button class="writeBtn" onclick="">글쓰기</button>
                        </span>
                        <span class="searchArea">
                            <input class="searchInput" type="text" placeholder="검색">
                            <a class="searchIconATag" href="#"><img class="searchIcon" src="/resources/img/검색.png""></a>
                        </span>
                    </div>
            
                    <table class="boardtable">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th style="width: 300px;">제목</th>
                                <th>작성자</th>
                                <th>작성일</th>
                                <th>조회수</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>글1</td>
                                <td>작성자</td>
                                <td>2023-05-31</td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>글2</td>
                                <td>작성자</td>
                                <td>2023-05-31</td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>글3</td>
                                <td>작성자</td>
                                <td>2023-05-31</td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td>4</td>
                                <td>글4</td>
                                <td>작성자</td>
                                <td>2023-05-31</td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td>5</td>
                                <td>글5</td>
                                <td>작성자</td>
                                <td>2023-05-31</td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td>6</td>
                                <td>글6</td>
                                <td>작성자</td>
                                <td>2023-05-31</td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td>7</td>
                                <td>글7</td>
                                <td>작성자</td>
                                <td>2023-05-31</td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td>8</td>
                                <td>글8</td>
                                <td>작성자</td>
                                <td>2023-05-31</td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td>9</td>
                                <td>글9</td>
                                <td>작성자</td>
                                <td>2023-05-31</td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td>10</td>
                                <td>글10</td>
                                <td>작성자</td>
                                <td>2023-05-31</td>
                                <td>0</td>
                            </tr>
                        </tbody>
                    </table>
            
                    <div class="page">
                        <ul class="pagination">
                            <li><a href="#" class="first"><img class="arrowKey" src="/resources/img/왼쪽페이지.png"></a></li>
                            <li><a href="#" class="num">1</a></li>
                            <li><a href="#" class="num">2</a></li>
                            <li><a href="#" class="num">3</a></li>
                            <li><a href="#" class="num">4</a></li>
                            <li><a href="#" class="num">5</a></li>
                            <li><a href="#" class="last"><img class="arrowKey" src="/resources/img/오른쪽페이지.png"></a></li>
                        </ul>
                    </div>
                </section>
            </main>
            <footer id="footer">
                <ul>
                    <li><a href="#">회사소개</a></li>
                    <li><a href="#">이용약관</a></li>
                    <li><a href="#">개인정보 처리방침</a></li>
                    <!-- <li><a href="#">맞다</a></li> -->
                </ul>
            </footer>
        </div>
    </body>
</html>