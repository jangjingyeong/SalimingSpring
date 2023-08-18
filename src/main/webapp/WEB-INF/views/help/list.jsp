<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>살림ing</title>
        <link rel="stylesheet" href="/resources/css/mypage.css">
        <link rel="stylesheet" href="/resources/css/community.css">
        <link rel="stylesheet" href="/resources/css/header&footer.css">
	</head>
	<body>
		<div id="container">
            <jsp:include page="/WEB-INF/views/include/nav.jsp"></jsp:include>
            <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
            <main id="main">
                <div id="main-left">
                    <table id="category">
                        <tr>
                            <th><a href="/notice/list.do">고객지원</a></th>
                        </tr>
                        <tr>
                            <td><a href="/notice/list.do">공지사항</a></td>
                        </tr>
                        <tr>
                            <td><a href="#">FAQ</a></td>
                        </tr>
                        <tr>
                            <td><a href="#">Q&A</a></td>
                        </tr>
                    </table>
                </div>
                <section id="section">

                    <div>
                        <div id="sharetitle">공지사항</div>
                    </div>
                    <div class="actionArea">
            			<c:if test="${memberId eq 'admin' }">
							<span class="writeArea">
								<form action="/notice/insert.do" method="get">
                           			<button class="writeBtn" onclick="">글쓰기</button> 
                            	</form>
                        	</span>
                        </c:if>
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
                                <th>작성일</th>
                                <th>조회수</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="notice" items="${requestScope.nList }">
	                            <tr>
	                                <td>${notice.noticeNo }</td>
	                                <td><a href="/notice/detail.do?noticeNo=${notice.noticeNo }">${notice.noticeSubject }</td>
	                                <td>${notice.noticeDate }</td>
	                                <td>${notice.viewCount }</td>
	                            </tr>
                           </c:forEach>
                        </tbody>
                    </table>
            
                    <div class="page">
                        ${pageNavi }
                    </div>
                </section>
            </main>
            <footer id="footer">
                <ul>
                    <li><a href="#">회사소개</a></li>
                    <li><a href="#">이용약관</a></li>
                    <li><a href="#">개인정보 처리방침</a></li>
                </ul>
            </footer>
        </div>
	</body>
</html>