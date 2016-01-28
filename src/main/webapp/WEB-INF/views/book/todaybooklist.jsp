<%@ page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<title>오늘 책 추가 리스트</title>
<script type="text/javascript">
function fnDelete(){
		location.href="delete.board?b_seq="+${dto["b_seq"]};
	}
</script>
</head>
<%@include file="/header.jsp"%>
<body>
<div class="orange_box" style="padding-left: 390px; padding-top: 20px; padding-bottom: 20px">
<table border="1">
<h2 style="padding-right: 50px;">오늘 추가 목록</h2>
	<tr>
		<td>순서</td><td>제목</td><td>출판사</td><td>저자</td>
	</tr>
	<c:forEach items="${list}" var="dto" varStatus="status">
	<tr><td>${status.count}</td>
		<td><a href="bookupdate?book_num=${dto.book_num}">${dto.book_title}</td>
		<td>${dto.book_label}</td>
		<td>${dto.book_author}</td>
		<td><input type="button" value="삭제" onclick="fnDelete()"/></td>
	</tr>
	</c:forEach>
</table>
</div>
</body>
</html>
<%@include file="/footer.jsp"%>
loc : todaybooklist.jsp