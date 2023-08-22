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
                            <input type="text" name="id" id="join_id" placeholder="영소문자로 시작, 영소문자 + 숫자 5~12자리"  ></label>
                            <div class="check_font" id="check_id"></div>
                        </div>
                        <div id="join-pw" class="join">
                            <label for="pw"><span class="compulsory"> * </span><strong>비밀번호</strong><br>
                            <input type="password" name="pw" id="join_pw" placeholder="영문, 숫자, 특수문자를 포함한 8~20자리" ></label>
                            <div class="check_font" id="check_pw"></div>
                        </div>
                        <div id="join-pw2" class="join">
                            <label for="pw2"><span class="compulsory"> * </span><strong>비밀번호확인</strong><br>
                            <input type="password" name="pw2" id="join_pw2" placeholder="영문, 숫자, 특수문자를 포함한 8~20자리" ></label>
                            <div class="check_font" id="check_pw2"></div>
                        </div>
                        <div id="join-name" class="join">
                            <label for="name"><span class="compulsory"> * </span><strong>이름</strong><br>
                            <input type="text" name="name" id="join_name" placeholder="실명을 입력해주세요." ></label>
                            <div class="check_font" id="check_name"></div>
                        </div>
                        <div id="join-nickname" class="join">
                            <label for="nickname"><span class="compulsory"> * </span><strong>닉네임</strong><br>
                            <input type="text" name="nickname" id="join_nickname" placeholder="닉네임을 입력해주세요." ></label>
                            <div class="check_font" id="check_nickname"></div>
                        </div>
                        <div id="join-birth" class="join">
                            <label for="birth"><span class="compulsory"> * </span><strong>생년월일</strong><br>
                            <input type="text" name="birth" id="join_birth" placeholder="YYYYMMDD" ></label>
                            <div class="check_font" id="check_birth"></div>
                        </div>
                        <div id="join-tel" class="join">
                            <label for="tel"><span class="compulsory"> * </span><strong>연락처</strong><br>
                            <input type="text" name="tel" id="join_tel" placeholder="'-'빼고 숫자만 입력해주세요." ></label>
                            <div class="check_font" id="check_tel"></div>
                        </div>
                        <div id="join-email" class="join">
                            <!-- <span> -->
                                <label for="email"><strong>이메일</strong><br>
                                <input type="text" name="email" id="join_email" placeholder="이메일을 입력해주세요."></label>
                                <div class="check_font" id="check_email"></div>
                        </div>
                        <div id="join-address">
                            <p><strong>주소</strong></p><br>
                            <input type="text" name="postcode" id="postcode" placeholder="우편번호" class="post">
                            <input type="button" onclick="sample4_execDaumPostcode();" value="우편번호 찾기" class="post"><br>
                            <input type="text" name="address" id="address" placeholder="주소" class="addr"><br>
                            <input type="text" name="detailAddress" id="detailAddress" placeholder="상세주소" class="addr"> 

                        </div>
                        
                        <div id="join-btns" class="join">
                            <button type="submit" id="join-btn" onclick="return check();">회원가입</button>
<!-- 							<input type="submit" id="join-btn" value="회원가입"> -->
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
			 
			function check() {
				const cId = document.getElementById("check_id");
				const cPw = document.getElementById("check_pw");
				const cPw2 = document.getElementById("check_pw2");
				const cName = document.getElementById("check_name");
				const cNickName = document.getElementById("check_nickname");
				const cBirth = document.getElementById("check_birth");
				const cPhone = document.getElementById("check_tel");
				
				// 체크 내용 나올 필드
				const id = document.querySelector("#join_id");
				const pw = document.getElementById("join_pw");
				const pw2 = document.getElementById("join_pw2");
				const name = document.getElementById("join_name");
				const nickname = document.getElementById("join_nickname");
				const birth = document.getElementById("join_birth");
				const phone = document.getElementById("join_tel");
				
				//정규표현식 
				const idRegExp = /^[a-z][a-z0-9]{4,11}$/g;
				const pwRegExp =  /^(?=.*[a-zA-Z]{1,})(?=.*[!@#$%^*+=-]{1,})(?=.*[0-9]{1,}).{8,20}$/g;
				const nameRegExp = /^[가-힣]+$/g;
				const nicknameRegExp = ^[가-힣a-zA-Z0-9]*$
				const birthRegExp = /^[0-9]{8}$/g;	
				const emailRegExp = /^[a-zA-Z0-9]{4,12}@[a-z]+\.[a-z]{3}/g;
				const telRegExp = /^[0-9]{11}$/g;
				
				
				if(!idRegExp.test(id.value)) {
				 	cId.innerText = "아이디는 영어 소문자로 시작해야하고 영어, 숫자를 포함한 5~12자리여야 합니다.";
				 	id.focus();
		        	return false;
			    } 
				if(!pwRegExp.test(pw.value)) {
					cPw.innerText = "비밀번호는 영어, 숫자, 특수문자를 포함한 8~20자리여야 합니다.";
					pw.focus();
		        	return false;
				}
				if(pw.value != pw2.value) {
					cPw2.innerText = "비밀번호가 일치하지 않습니다.";
					pw2.focus();
		        	return false;
				}
				if(!nameRegExp.test(name.value)) {
					cName.innerText = "이름은 한글만 입력 가능합니다. 최소 한글자 이상 입력해주세요.";
					name.focus();
					return false;
				}
				if(!nicknameRegExp.test(nickname.value)) {
					cNickname.innerText = "닉네임은 비워둘 수 없습니다. 특수문자를 제외하고 최소 한글자 이상 입력해주세요.";
					nickname.focus();
					return false;
				}
				if(!birthRegExp.test(birth.value)) {
					cBirth.innerText = "생년월일은 8자리로 입력해주세요. 예시) 19981127";
					birth.focus();
					return false;
				}
				if(!telRegExp.test(phone.value)) {
					cPhone.innerText = "연락처는 -를 빼고 11자리로 입력해주세요. 예시) 01012345678";
					phone.focus();
					return false;
				}
			}

			 
		</script>
	</body>
</html>