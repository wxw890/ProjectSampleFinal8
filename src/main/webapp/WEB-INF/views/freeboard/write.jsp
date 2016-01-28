<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/header.jsp"%>
<div align="center">
<h2>공지사항</h2>
<form action="write.board1" method="post">
	제목:<input type="text" name="b_title" value="<공지> : " style="width:500px;height:50px;"/><br/><br/>
	내용:<textarea id="b_content" cols="50" name="b_content" style="width:500px;height:350px;"></textarea><br/><br/>
	<input type="submit" value="저장"/>
	<input type="button" value="리스트 페이지로 이동"/>
</form>
</div>
<%@include file="/footer.jsp"%>