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
        <link rel="stylesheet" href="/resources/css/header&footer.css">
        <link rel="stylesheet" href="/resources/css/mypage.css">
        <link rel="stylesheet" href="/resources/css/community.css">
	</head>
	<body>
		<div id="container">
            <jsp:include page="/WEB-INF/views/include/nav.jsp"></jsp:include>
            <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
            <main id="main">
                <div id="main-left">
                    <table id="category">
                        <tr>
                            <th><a href="/notice/list.do"">고객지원</a></th>
                        </tr>
                        <tr>
                            <td><a href="/notice/list.do"">공지사항</a></td>
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
                        <div id="sharetitle">공지사항 수정</div>
                    </div>
                    <div>
                    	<form action="/notice/modify.do" method="post">
		                    <table class="boardtable">
		                    	<tr>
									<td>
										<input type="hidden" name="noticeNo" value="${requestScope.notice.noticeNo }">
										<label>글번호</label>
										<span>${requestScope.notice.noticeNo }</span>
									</td>
									<td>
										<label>작성일</label>
										<span>${requestScope.notice.noticeDate }</span>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<label><b>제목 : <input type="text" id="" name="noticeSubject" value="${notice.noticeSubject }"></b></label>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<label><b>내용 : <textarea rows="30" cols="40" id="" name="noticeContent">${notice.noticeContent }</textarea></b></label>
									</td>							
								</tr>
		                    </table>
		                    <input type="submit" value="수정하기">
							<input type="reset" value="초기화">
	                    </form>
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