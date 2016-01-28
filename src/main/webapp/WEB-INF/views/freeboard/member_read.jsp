<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/header.jsp"%>

<script>
	function fnUpdate(){
		location.href="update.board1?b_seq="+${dto["b_num"]};//스크립트를 통해 번호 넘겨주기
	}
	function fnDelete(){
		location.href="delete.board1?b_seq="+${dto["b_num"]};
	}
	function fnReply(){
		location.href="reply.board1?b_seq="+${dto["b_num"]};
	}
</script>

<div align="center">
	<h2>공지사항</h2>
	<table border="1">
		<tr>
			<td>글번호</td><td style="width:500px;height:50px;">${dto["b_num"] }</td><!-- 변수명에 _나 특수 문자가 들어있으면 dto.b_seq로 사용할수 없음, 그래서 배열형태로 가져올수밖에 없음-->
		</tr>
		<tr>
			<td>제목</td><td style="width:500px;height:50px;">${dto["b_title"]}</td>
		</tr>
		<tr>
			<td>내용</td><td style="width:500px;height:350px;">${dto["b_content"]}</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="수정하기" onclick="fnUpdate()">
				<input type="button" value="삭제하기" onclick="fnDelete()">
				<input type="button" value="목록보기" onclick="location.href='list.board1?bool=false'"> <!-- onclick에서 스크립트 언어 location.href통해 이동할수있음 -->
				<input type="button" value="댓글달기" onclick="fnReply()">
			</td>
		</tr>
	</table>
	</div>

<%@include file="/footer.jsp"%>
