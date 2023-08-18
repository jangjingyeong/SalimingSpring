<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>살림ing</title>
        <link rel="stylesheet" href="/resources/css/join.css">
        <link rel="stylesheet" href="/resources/css/header&footer.css">
	</head>
	<body>
		<div id="container">
           	<jsp:include page="/WEB-INF/views/include/nav.jsp"></jsp:include>
            <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
            <main id="main">
                <div id="join-wrapper">
                    <div id="join-title">
                        <h2>회원가입</h2>
                        <p id="pTag1"><span class="compulsory"> *</span> 필수입력사항</p>
                    </div>
                    <form action="/member/register.do" method="post">
                    <div id="personal">
                        <div id="join-id" class="join">
                            <label for="id"><span class="compulsory"> * </span><strong>아이디</strong><br>
                            <input type="text" name="id" id="join_id" placeholder="영소문자, 숫자 5~12자리"></label>
                            <p>
                        </div>
                        <div id="join-pw" class="join">
                            <label for="pw"><span class="compulsory"> * </span><strong>비밀번호</strong><br>
                            <input type="password" name="pw" id="join_pw" placeholder="영문, 숫자, 특수문자를 포함한 8~20자리"></label>
                        </div>
                        <div id="join-pw2" class="join">
                            <label for="pw2"><span class="compulsory"> * </span><strong>비밀번호확인</strong><br>
                            <input type="password" name="pw2" id="join_pw2" placeholder="영문, 숫자, 특수문자를 포함한 8~20자리"></label>
                        </div>
                        <div id="join-name" class="join">
                            <label for="name"><span class="compulsory"> * </span><strong>이름</strong><br>
                            <input type="text" name="name" id="join_name" placeholder="실명을 입력해주세요."></label>
                        </div>
                        <div id="join-nickname" class="join">
                            <label for="nickname"><span class="compulsory"> * </span><strong>닉네임</strong><br>
                            <input type="text" name="nickname" id="join_nickname" placeholder="닉네임을 입력해주세요."></label>
                        </div>
                        <div id="join-birth" class="join">
                            <label for="birth"><span class="compulsory"> * </span><strong>생년월일</strong><br>
                            <input type="text" name="birth" id="join_birth" placeholder="YYYYMMDD"></label>
                        </div>
                        <div id="join-tel" class="join">
                            <label for="tel"><span class="compulsory"> * </span><strong>연락처</strong><br>
                            <input type="text" name="tel" id="join_tel" placeholder="'-'빼고 숫자만 입력해주세요."></label>
                        </div>
                        <div id="join-email" class="join">
                            <!-- <span> -->
                                <label for="email"><strong>이메일</strong><br>
                                <input type="text" name="email" id="join_email" placeholder="이메일을 입력해주세요."></label>
                        </div>
                        <div id="join-address">
                            <p><strong>주소</strong></p><br>
                            <input type="text" name="postcode" id="postcode" placeholder="우편번호" class="post">
                            <input type="button" onclick="sample4_execDaumPostcode();" value="우편번호 찾기" class="post"><br>
                            <input type="text" name="address" id="address" placeholder="주소" class="addr"><br>
                            <input type="text" name="detailAddress" id="detailAddress" placeholder="상세주소" class="addr"> 

                        </div>
                        
                        <div id="join-btns" class="join">
                            <button id="join-btn">회원가입</button>
                        </div>
                        </form>
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
		</script>
</html>