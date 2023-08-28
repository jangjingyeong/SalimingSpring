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
                        <div id="sharetitle">공지사항 수정</div>
                    </div>
                    <div>
                    	<form action="/shareBoard/modify.do" method="post" enctype="multipart/form-data">
                    		<input type="hidden" name="boardFilename" value="${shareBoard.boardFilename }">
							<input type="hidden" name="boardFileRename" value="${shareBoard.boardFileRename }">
							<input type="hidden" name="boardFilepath" value="${shareBoard.boardFilepath }">
							<input type="hidden" name="boardFilelength" value="${shareBoard.boardFilelength }">
		                    <table class="boardtable">
		                    	<tr>
									<td>
										<input type="hidden" name="boardNo" value="${requestScope.shareBoard.boardNo }">
										<label>글번호</label>
										<span>${requestScope.shareBoard.boardNo }</span>
									</td>
									<td>
										<label>작성일</label>
										<span>${requestScope.shareBoard.bCreateDate }</span>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<label><b>제목 : <input type="text" id="" name="boardTitle" value="${shareBoard.boardTitle }"></b></label>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<label><b>내용 : <textarea rows="30" cols="40" id="" name="boardContent">${shareBoard.boardContent }</textarea></b></label>
									</td>							
								</tr>
								<tr>
                    			<td>
			                        <label><b>첨부파일 : </b></label><input type="file" name="uploadFile" >
                    			</td>
                    			<td>
                    				<a href="../resources/sbuploadFiles/${shareBoard.boardFileRename }" download>${shareBoard.boardFilename }</a>
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