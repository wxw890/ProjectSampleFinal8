<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><!-- 업로드 form태그를 위해 빼먹지말자!!! -->
<%@include file="/header.jsp"%>
<div align="center">
<h2>자유게시판</h2>
<form:form method="POST" action="upload.spring" enctype="multipart/form-data"><!-- enctype="multipart/form-data"란 데이터를 여러개로 나눠서 전송하겠다는 뜻(파일 업로드할때 필요하다 꼭) -->
																					<!-- multipart로 하면 req로 받아올수 없다. -->
	
	<input type="file" name="files" style="margin-left:920px"/><br/><br/>
	<input type="submit" value="업로드"/>
</form:form>
<c:if test="${path!=null}">
	<h3>파일명 : ${name}</h2>
</c:if>



<form action="write.board" method="post" id="freeboardWrite">
	제목:<input type="text" name="b_title" style="width:500px;height:50px;"/><br/><br/>
	내용:<textarea cols="50" name="b_content" style="width:500px;height:350px;"></textarea>
	
	<input type="submit" value="저장"/>
	<input type="button" value="리스트 페이지로 이동"/>
</form>
</div>


<%@include file="/footer.jsp"%>