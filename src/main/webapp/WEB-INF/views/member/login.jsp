<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>살림ing</title>
        <link rel="stylesheet" href="/resources/css/login.css">
        <link rel="stylesheet" href="/resources/css/header&footer.css">
	</head>
	<body>
		<div id="container">
            <jsp:include page="/WEB-INF/views/include/nav.jsp"></jsp:include>
            <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
            <main id="main">
                <form id="login-page" action="/member/login.do" method="post">
                    <div id="login-title"><h2>로그인</h2></div>
                    <div id="id" class="idpw"><input type="text" name="id" placeholder="아이디를 입력하세요."></div>
                    <div id="pw" class="idpw"><input type="password" name="pw" placeholder="비밀번호를 입력하세요."></div>
                    <div id="save_find">
                        <label for="idsave">
                        <input type="checkbox" name="idsave" id="idsave"> 
                        아이디저장</label>
                        <a href="#">아이디/비밀번호 찾기</a>
                    </div>
                    <button id="login">로그인</button>
                </form>
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