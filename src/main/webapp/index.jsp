<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="/WEB-INF/views/include/head.jsp"></jsp:include>
	</head>
	<body>
		<div id="container">
            <jsp:include page="/WEB-INF/views/include/nav.jsp"></jsp:include>
            <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
            <main id="main">
                <div id="main-layer1"><img src="/resources/img/배너사진.png" height="450px" alt=""></div>
                <div id="main-layer2"><h3> <img src="/resources/img/인기글.png" height="25px" alt="">  이번주 인기글</h3></div>
                <div id="main-layer3">
                    <div id="main3-1">
                        <div id="main-3-1-img">
                            <img src="/resources/img/화장실청소.jpg" height="200px" alt=""></div>
                        <div id="main-3-1-txt" class="in-main-layer3"> 
                            <p>
                                <b>화장실 청소법</b>
                            </p> 
                            <p>화장실 청소에 관련된 내용</p>
                        </div>
                    </div>
                    <div id="main3-2" >
                        <div id="main-3-2-img">
                        <img src="/resources/img/서랍장.jpg" height="200px" alt=""></div>
                        <div id="main-3-2-txt" class="in-main-layer3"> 
                        <p>
                            <b>깔끔한 수납템 추천</b>
                        </p> 
                        <p>수납 아이템 추천</p></div>
                    </div>
                    <div id="main3-3" >
                        <div id="main-3-3-img">
                            <img src="/resources/img/분리수거.jpg" height="200px" alt=""></div>
                        <div id="main-3-3-txt" class="in-main-layer3"> 
                            <p>
                                <b>분리수거 방법</b>
                            </p> 
                            <p>편하게 분리수거 하는 법</p>
                        </div>
                    </div>
                    <div id="main3-4" >
                        <div id="main-3-4-img">
                            <img src="/resources/img/스팸계란볶음밥.jpg" height="200px" alt=""></div>
                        <div id="main-3-4-txt"class="in-main-layer3"> 
                            <p>
                                <b>간단 레시피</b>
                            </p> 
                            <p>스팸계란볶음밥 레시피</p>
                        </div>
                    </div>
                </div>
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