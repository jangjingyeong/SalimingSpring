<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
                <div id="maincate">
                    <table id="category">
                        <tr>
                            <th><a href="/shareBoard/list.do">커뮤니티</a></th>
                        </tr>
                        <tr>
                            <td><a href="/shareBoard/list.do">정보공유게시판</a></td>
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
            			<c:if test="${memberId ne null }">
							<span class="writeArea">
								<form action="/shareboard/insert.do" method="get">
                           			<button class="writeBtn" onclick="">글쓰기</button> 
                            	</form>
                        	</span>
                        </c:if>
                        <span class="searchArea">
                        	<form action="/shareBoard/search.do" method="get">
								<select name="searchCondition">
									<option value="all" <c:if test="${paramMap.searchCondition == 'all' }">selected</c:if>>전체</option>
									<option value="title" <c:if test="${paramMap.searchCondition == 'title' }">selected</c:if>>제목</option>
									<option value="writer" <c:if test="${paramMap.searchCondition == 'writer' }">selected</c:if>>작성자</option>
									<option value="content" <c:if test="${paramMap.searchCondition == 'content' }">selected</c:if>>내용</option>
								</select>
                            <input class="searchInput" type="text" placeholder="검색어를 입력하세요." name="searchKeyword" value="${paramMap.searchKeyword }">
                            <input type="submit" value="검색">
                            </form>
                        </span>
                    </div>
            
                    <table class="boardtable">
                        <thead>
                            <tr>
                                <th>글번호</th>
                                <th style="width: 300px;">제목</th>
                                <th>작성자</th>
                                <th>작성일</th>
                                <th>첨부파일</th>
                                <th>조회수</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="shareBoard" items="${ sList }" varStatus="i">
	                            <tr>
	                                <td>${shareBoard.boardNo }</td>
	                                <td><a href="/shareBoard/detail.do?boardNo=${shareBoard.boardNo }">${shareBoard.boardTitle }</td>
	                                <td>${shareBoard.boardWriter }</td>
	                                <td><fmt:formatDate pattern="YYYY-MM-dd" value="${shareBoard.bCreateDate }"/></td>
	                                <td>
										<c:if test="${!empty shareBoard.boardFilename }">O</c:if>
										<c:if test="${empty shareBoard.boardFilename }">X</c:if>
									</td>
	                                <td><fmt:formatNumber pattern="##,###,###" value="${shareBoard.boardCount }"/></td>
	                            </tr>	
                           </c:forEach>
                        </tbody>
                    </table>
            		
                    <div class="page">
                    <c:if test="${pInfo.startNavi ne '1' }">
                    	<a href="/shareBoard/list.do?page=${pInfo.startNavi-1 }" class="first"><img class="arrowKey" src="/resources/img/왼쪽페이지.png">&nbsp;&nbsp;&nbsp;</a>
                    </c:if>
                    <c:forEach begin="${pInfo.startNavi }" end="${pInfo.endNavi }" var="p">
						<c:url var="pageUrl" value="/shareBoard/search.do">
							<c:param name="searchCondition" value="${paramMap.searchCondition }"></c:param>
								<c:param name="searchKeyword" value="${paramMap.searchKeyword }"></c:param>
							<c:param name="page" value="${p }"></c:param>
						</c:url>
						<a href="${pageUrl }">${p }</a>&nbsp;
					</c:forEach>
					<c:if test="${pInfo.endNavi ne pInfo.naviTotalCount }">
						<a href="/shareBoard/list.do?page=${pInfo.endNavi+1 }" class="last"><img class="arrowKey" src="/resources/img/오른쪽페이지.png"></a>
					</c:if>
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