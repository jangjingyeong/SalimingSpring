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
                        <div id="sharetitle">공지사항 작성</div>
                    </div>
                	<form action="/notice/insert.do" method="post">
                    <div class="actionArea">
	                    <table class="boardtable">
                    		<tr>
                    			<td>
									<label><b>제목 : </b></label><input type="text" id="noticeSubject" name="noticeSubject">
                    			</td>
                    		</tr>
                    		<tr>
                    			<td>
			                        <label><b>내용 : </b></label><textarea rows="30" cols="40" id="noticeContent" name="noticeContent"></textarea>
                    			</td>
                    		</tr>
                    		<tr>
                    			<td>
			                        <label><b>첨부파일 : </b></label><input type="file" name="uploadFile">
                    			</td>
                    		</tr>
	                    </table>
                    </div>
	                <div id="buttons">
	                	<input type="submit" value="작성"  id="submitbutton">
						<input type="reset" value="초기화" id="resetbutton">
	                </div>
            		</form>
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