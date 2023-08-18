<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav id="nav1">
    <div id="nav1-1"></div>
    <div id="nav1-2">
        <ul id="nav1ul">
        <c:if test="${sessionScope.memberId !=null }">
        	<li><a href="/member/mypage.do">마이페이지</a></li>
            <li><a href="/member/logout.do">로그아웃</a></li>
        </c:if>
        
        <c:if test="${memberId eq null }">
            <li><a href="/member/login.do">로그인</a></li>
            <li><a href="/member/register.do">회원가입</a></li>
        </c:if>
        </ul>
    </div>
</nav>