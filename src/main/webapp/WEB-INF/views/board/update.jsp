<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div align="center">
<h2>자유게시판</h2>
<form:form method="POST" action="upload2.spring" enctype="multipart/form-data"><!-- enctype="multipart/form-data"란 데이터를 여러개로 나눠서 전송하겠다는 뜻(파일 업로드할때 필요하다 꼭) -->
	<input type="hidden" name="b_num" value="${dto['b_num'] }"/><!--업로드시 위에 업데이트할때 hidden으로 b_num값을 넘겨야하므로 -->																				<!-- multipart로 하면 req로 받아올수 없다. -->
															<!--업로드할때  hidden으로 b_num값을 넘겨서 dto값을 찾아서 다시 update.jsp로 올때 dto값을 유지해 있어야한다. 그래야 온전하게 업데이트가 가능하다.  -->
	<input type="file" name="files" style="margin-left:920px"/><br/><br/>
	<input type="submit" value="업로드"/>
</form:form>
<c:if test="${path!=null}">
	<h3>파일명 : ${name}</h2>
</c:if>



<form action="update.board" method="post">
	<input type="hidden" name="b_num" value="${dto['b_num'] }"/><!-- 이부분 sql에 비교에 기준인 b_seq를 히든으로 컨트롤에 넘겨줌 -->
	제목:<input type="text" name="b_title" value="${dto['b_title']}" style="width:500px;height:50px;"/><br/><br/>
	작성자:<input type="text" name="b_writer" value="${dto['b_writer']}" style="width:500px;height:50px;"/><br/><br/>
	내용:<textarea cols="50" name="b_content" style="width:500px;height:350px;">${dto['b_content']}</textarea><br/><br/>
	<input type="submit" value="저장"/>
	<input type="button" value="리스트 페이지로 이동"/>
</form>
</div>

<%@include file="/footer.jsp"%>
