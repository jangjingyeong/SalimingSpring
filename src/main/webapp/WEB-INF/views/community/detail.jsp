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
                <div id="maincate">
                    <table id="category">
                        <tr>
                            <th><a href="/community/shareList.do">커뮤니티</a></th>
                        </tr>
                        <tr>
                            <td><a href="/community/shareList.do">정보공유게시판</a></td>
                        </tr>
                        <tr>
                            <td><a href="#">자유게시판</a></td>
                        </tr>
                        
                    </table>    
                </div>
                <section id="section">

                    <div>
                        <div id="sharetitle">정보공유게시판 상세</div>
                    </div>
               		<div id="a-tag">
	                    <c:if test="${sessionScope.memberNickname eq shareBoard.boardWriter }">
		                    <a href="/shareBoard/modify.do?boardNo=${shareBoard.boardNo }">수정하기</a>
	    	                <a href="javascript:void(0)" onclick="checkDelete();">삭제하기</a>
	                    </c:if>
                    <button type="button" class="delbtn" onclick="showBoardList();">목록으로</button>
	                </div>
<!-- 					<button type="button" onclick="javascripy:history.go(-1);">뒤로가기</button> -->
                    <div>
	                    <table class="boardtable">
	                    	<tr>
								<td>
									<label>글번호</label>
									<span>${requestScope.shareBoard.boardNo }</span>
								</td>
								<td>
									<label>작성일</label>
									<span>${requestScope.shareBoard.bCreateDate }</span>
								</td>
								<td>
									<label>수정일</label>
									<span>${requestScope.shareBoard.bUpdateDate }</span>
								</td>
							</tr>
							<tr>
								<td colspan="3">
									<label><b>제목 : ${shareBoard.boardTitle }</b></label>
								</td>
							</tr>
							<tr>
								<td colspan="3">
									<label><b>내용 : </b></label>
									<p>${shareBoard.boardContent }</p>
								</td>							
							</tr>
							<tr>
								<td colspan="3">
									<label><b>첨부파일 : </b></label>
									<p><a href="../resources/sbuploadFiles/${shareBoard.boardFileRename }" download>${shareBoard.boardFilename }</a></p>
								</td>							
							</tr>
	                    </table>
	                </div>
	                <br>
	                <!-- 댓글 등록 -->
					<form action="/reply/add.do" method="post">
						<input type="hidden" name="refBoardNo" value="${shareBoard.boardNo}">
						<table width="500" border="1">
							<tr>
								<td>
									<textarea rows="3" cols="55" name="replyContent"></textarea>
								</td>
								<td>
									<input type="submit" value="완료">
								</td>
							</tr>
						</table>
					</form>
					<!-- 댓글 목록 -->
					<table width="600" border="1">
						<c:forEach var="reply" items="${replyList }">
						<!-- forEach에서 var는 List에 있는 것들을 꺼내쓸 변수명 items는 값을 꺼낼 List -->
						<tr>
							<td>${reply.replyWriter }</td>
							<td>${reply.replyContent }</td>
							<td>${reply.rCreateDate }</td>
							<td>
		<%-- 						<a href="javascript:void(0)" onclick="showModifyForm(this, '${reply.replyContent }');">수정하기</a> / <a href="javascript:void(0)" onclick="deleteReply();" >삭제하기</a> --%>
								<c:if test="${ reply.replyWriter eq memberNickname}">
										<c:url var="delReplyUrl" value="/reply/delete.do">
											<c:param name="replyNo" value="${reply.replyNo }"></c:param>
											<c:param name="replyWriter" value="${reply.replyWriter }"></c:param>
											<c:param name="refBoardNo" value="${reply.refBoardNo }"></c:param>
										</c:url>
									<a href="javascript:void(0)" onclick="showReplyModifyForm(this);">수정하기</a> / <a href="javascript:void(0)" onclick="deleteReply('${delReplyUrl}');" >삭제하기</a>
								</c:if>
							</td>
						</tr>
						<tr id="replyModifyForm" style="display:none;">
		<!-- 					<form action="/reply/update.kh" method="post"> -->
		<%-- 						<input type="hidden" name="replyNo" value="${reply.replyNo }" > --%>
		<%-- 						<input type="hidden" name="refBoardNo" value="${reply.refBoardNo }" > --%>
		<%-- 						<td colspan="3"><input type="text" size="20" name="replyContent" value="${reply.replyContent }"></td> --%>
		<!-- 						<td><input type="submit" value="완료"></td> -->
		<!-- 					</form> -->
								<td colspan="3"><input type="text" id="replyContent" size="20" name="replyContent" value="${reply.replyContent }"></td>
								<td><input type="button" onclick="replyModifyReply(this, '${reply.replyNo}','${reply.refBoardNo }');" value="완료"></td>
						</tr>
						</c:forEach>
					</table>
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
        <script>
        	function replyModifyReply(obj, replyNo, refBoardNo) {
        		const form = document.createElement("form");
        		form.action="/reply/update.do";
        		form.method="post";
        		
        		const input1 = document.createElement("input");
        		input1.type="hidden";
        		input1.value=replyNo;
        		input1.name="replyNo";
        		
        		const input2 = document.createElement("input");
        		input2.type="hidden";
        		input2.value=refBoardNo;
        		input2.name="refBoardNo";
        		
        		const input3 = document.createElement("input");
        		input3.type="text";
        		input3.value=obj.parentElement.previousElementSibling.children[0].value;
        		input3.name="replyContent";
        		
        		form.appendChild(input1);
        		form.appendChild(input2);
        		form.appendChild(input3);
        		
        		document.body.appendChild(form);
        		form.submit();
        		
        		
        	}
        
        	function showReplyModifyForm(obj) {
        		obj.parentElement.parentElement.nextElementSibling.style.display="";
        	}
        	function deleteReply(url) {
        		location.href = url; 
        	}
        
	        function showBoardList() {
				location.href="/shareBoard/list.do";
			}
		// /member/delete.do?memberId=${sessionScope.memberId }
			function checkDelete() {
				const boardNo = '${requestScope.shareBoard.boardNo}';
				if(confirm("삭제하시겠습니까?")){
					location.href = "/shareBoard/delete.do?boardNo=" + boardNo;
				}
			}
		</script>
	</body>
</html>