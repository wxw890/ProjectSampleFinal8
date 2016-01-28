<%@ page language="java" contentType="text/html; charset=utf-8"
   isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script>
   function fndelete(reservation_num){
      var answer = confirm(reservation_num+"예약을 정말로 삭제하시겠습니까?");
      if(answer == true){
         location.href = "reservation.delete?reservation_num="+reservation_num;
      }
      else{
         location.href = "reservation1.delete";
      }
   }
</script>
</head>
<%@include file="/header.jsp"%>   
<body>
<div class="orange_box">
<h1 align="center">${name}님의 현재 예약 상태</h1>

<table border="1" align="center">
<c:if test="${!list5.isEmpty()}"><!-- 리스트가 아무것도 없는 것이 아니라면 실행 -->
   
   <tr>
      <tr><td>번호</td><td>아이디</td><td>예약날짜</td>
      <td>예약시간</td><td>예약테이블</td>
   </tr>
   <c:forEach var="dto5" items="${list5}">
      <tr>
         <td>${dto5.reservation_num}</td>
         <td>${dto5.member_email}</td>
         <td>${dto5.reservation_date}</td>
         <td>${dto5.reservation_time }</td>
         <td>${dto5.table_num}</td>
         <td><input type="button" value="삭제" onclick="fndelete(${dto5.reservation_num})"/></td>
      </tr>
   </c:forEach>
</c:if>
</table>
</div>
<c:if test="${list5.isEmpty()}"><!-- 리스트가 아무것도 없으면 실행 -->

<h2 style="color: red;" align="center">현재 예약하신게 없습니다.</h1>
</c:if>

</body>
<%@include file="/footer.jsp"%>
</html>
loc : myreservation.jsp 사용자 예약확인 페이지