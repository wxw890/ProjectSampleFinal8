<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@include file="/header.jsp"%>
<div align="center">
<form action="reply.board2" method="post">
	<input type="hidden" name="b_num" value="${dto['b_num']}"/>
	<h2>Q&A게시판</h2>
	제목:<input type="text" name="b_title" value="Re : " style="width:500px;height:50px;"/><br/><br/>
	작성자:<input type="text" name="b_writer" style="width:500px;height:50px;"/><br/><br/>
	내용:<input type="5" cols="50" name="b_content" style="width:500px;height:350px;"></textarea><br/><br/>
	<input type="submit" value="저장"/>
	<input type="button" value="리스트 페이지로 이동"/>
</form>
</div>
<%@include file="/footer.jsp"%>