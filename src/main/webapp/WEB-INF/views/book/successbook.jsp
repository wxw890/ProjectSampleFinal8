<%@ page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<title>전체 책 리스트</title>
<script type="text/javascript">
	function Delete(num){
		alert("삭제합니다.")
		location.href="delete.book?book_num="+num;
		
	}
</script>

<!-- 체크박스 전체선택 function -->
      <script>
         var checkflag = "false";
         function check(field) {
            if (checkflag == "false") {
               for (i = 0; i < field.length; i++) {
                  field[i].checked = true;
               }
               checkflag = "true";
               return "전체 선택 해제";
            } else {
               for (i = 0; i < field.length; i++) {
                  field[i].checked = false;
               }
               checkflag = "false";
               return "전체 선택";
            }
         }
      </script>
<!-- 여기까징 -->

<style type="text/css">
.rental td{text-align: center}
</style>
</head>
<%@include file="/header.jsp"%>
<body>

<form name="form">
<div class="orange_box" style="padding-left: 280px; padding-top: 20px; padding-bottom: 20px">
<table border="1" class="rental">
	<tr>
		<td>선택</td><td>등록번호</td><td>제목</td><td>출판사</td><td>저자</td><td>ISBN</td><td>입고날짜</td>
	</tr>
	<c:forEach items="${list}" var="dto" varStatus="status">
	<tr>
		<td><input type="checkbox" name="multbook" value=${dto.book_num }/></td>
		<td>${dto.book_num}</td>
		<td><a href="bookupdate?book_num=${dto.book_num}">${dto.book_title}</td>
		<td>${dto.book_label}</td>
		<td>${dto.book_author}</td>
		<td>${dto.book_isbn}</td>
		<td>${dto.book_imdate}</td>
		<td><input type="button" value="삭제" onclick="Delete(${dto.book_num})"/></td>
	</tr>
	</c:forEach>
</table>
<br/><br/>
<input type="button" value="메인" onclick="location.href='main'"/>
<input type="button" value="도서추가" onclick="location.href='bookinput'"/>
</div>
</form>

</body>
</html>
<%@include file="/footer.jsp"%>
loc : successbook.jsp