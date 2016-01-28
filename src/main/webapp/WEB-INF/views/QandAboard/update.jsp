<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/header.jsp"%>
<div align="center">
<h2>Q&A게시판</h2>
<form action="update.board2" method="post">
	<input type="hidden" name="b_num" value="${dto['b_num'] }"/><!-- 이부분 sql에 비교에 기준인 b_seq를 히든으로 컨트롤에 넘겨줌 -->
	제목:<input type="text" name="b_title" value="${dto['b_title']}" style="width:500px;height:50px;"/><br/><br/>
	
	내용:<textarea cols="50" name="b_content" style="width:500px;height:350px;">${dto['b_content']}</textarea><br/><br/>
	<input type="submit" value="저장"/>
	<input type="button" value="리스트 페이지로 이동"/>
</form>
</div>
<%@include file="/footer.jsp"%>