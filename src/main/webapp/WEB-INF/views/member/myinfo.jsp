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
        <link rel="stylesheet" href="/resources/css/user-edit.css">
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
                            <th><a href="/member/mypage.do">마이페이지</a></th>
                        </tr>
                        <tr>
                            <td><a href="/member/myinfo.do?memberId=${memberId }">회원정보수정</a></td>
                        </tr>
                        <tr>
                            <td><a href="#">장바구니</a></td>
                        </tr>
                        <tr>
                            <td><a href="#">주문내역</a></td>
                        </tr>
                        <tr>
                            <td><a href="#">내 후기</a></td>
                        </tr>
                        <tr>
                            <td><a href="/member/saliming-mypage-mywrite.html">내가 쓴 글/댓글</a></td>
                        </tr>
                        <tr>
                            <td><a href="/member/saliming-mypage-scrap.html">스크랩</a></td>
                        </tr>
                        <tr>
                            <td><a href="#">내 문의</a></td>
                        </tr>
                    </table>
                </div>
                <section id="section">

                    <div id="edit-title">
                        <div id="sharetitle">회원정보수정</div>
                        <p id="pTag1"><span class="compulsory"> *</span> 필수입력사항</p>
                    </div>
                    <div id="user-edit">
                        <div id="personal">
                       		<form action="/member/update.do" method="post">
                       			<input type="hidden" name="id" value="${ member.memberId}">
	                            <div id="edit-id" class="edit">
	                                <span class="compulsory"> * </span><strong>아이디</strong><br>
	                                <p>${ member.memberId}</p> 
	                            </div>
	                            <div id="edit-pw" class="edit">
	                                <label for="pw"><span class="compulsory"> * </span><strong>비밀번호수정</strong><br>
	                                <input type="password" name="pw" id="pw" placeholder="영문, 숫자, 특수문자를 포함한 8~20자리"></label>
	                            </div>
	                            <div id="edit-pw1" class="edit">
	                                <label for="pw2"><span class="compulsory"> * </span><strong>비밀번호확인</strong><br>
	                                <input type="password" name="pw2" id="pw2" placeholder="영문, 숫자, 특수문자를 포함한 8~20자리"></label>
	                            </div>
	                            <div id="edit-name" class="edit">
	                                <span class="compulsory"> * </span><strong>이름</strong><br>
	                                <p>${ member.memberName}</p> 
	                            </div>
	                            <div id="edit-nickname" class="edit">
	                                <label for="nickname"><span class="compulsory"> * </span><strong>닉네임</strong><br>
	                                <p>${ member.memberNickname}</p> 
	                                <input type="text" name="nickname" id="nickname" placeholder="변경할 닉네임을 입력해주세요."></label>
	                            </div>
	                            <div id="edit-birth" class="edit"> 
	                                <span class="compulsory"> * </span><strong>생년월일</strong><br>
	                                <p>${ member.memberBirthday}</p> 
	                            </div>
	                            <div id="edit-tel" class="edit">
	                                <label for="tel"><span class="compulsory"> * </span><strong>연락처</strong><br>
	                                    <p>${ member.memberPhone}</p> 
	                                <input type="text" name="tel" id="tel" placeholder="'-'빼고 숫자만 입력해주세요."></label>
	                            </div>
	                            <div id="edit-email" class="edit">
	                                <label for="email"><strong>이메일</strong><br>
	                                    <p>${ member.memberEmail}</p> 
	                                <input type="text" name="email" id="mail" placeholder="이메일을 입력해주세요."></label>
	                            </div>
	                            <div id="edit-address">
	                                <p><strong>주소</strong></p>
	                                <p>${ member.memberAddress}</p> 
	                            <input type="text" name="postcode" id="postcode" placeholder="우편번호" class="post">
	                            <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" class="post"><br>
	                            <input type="text" name="address" id="address" placeholder="주소" class="addr"><br>
	                            <input type="text" name="detailAddress" id="detailAddress" placeholder="상세주소" class="addr"> 
	                            </div>
	                            <div id="edit-btns" class="edit">
	                                <button id="edit-btn">회원정보수정</button>
	                                <a href="javascript:void(0)" onclick="checkDelete();">회원탈퇴</a>
	                            </div>
                            </form>
                        </div>
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
        <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script>
			 function sample4_execDaumPostcode() {
			        new daum.Postcode({
			        	oncomplete : function(data) {
			        		document.querySelector("#postcode")
			        		.value = "(" + data.zonecode + ")";
			        		document.querySelector("#address")
			        		.value= data.roadAddress;
			        		document.querySelector("#detailAddress")
			        		.value= data.buildingName;
			        	}
			        }).open();
			 }
		
		// /member/delete.do?memberId=${sessionScope.memberId }
			function checkDelete() {
				const memberId = '${sessionScope.memberId}';
				if(confirm("탈퇴하시겠습니까?")){
					location.href = "/member/delete.do?memberId=" + memberId;
				}
			}
		</script>
	</body>
</html>