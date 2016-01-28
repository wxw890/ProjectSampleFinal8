<%@ page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/Nwagon.css" type="text/css">

<script src="js/Nwagon.js"></script>
<script type="text/javascript">
   //반납처리
   
   function returnbook(sal){
      var sal = sal;
      alert("연체료는 "+sal+"원입니다.")
      alert("반납처리한다.")
      
   }
   //연장처리
   function Extension(num,res,day){
      var res= res;
      var day= day;
   
   
      if(day == 0 && res == false){   
         location.href="extension.book?book_num="+num;
      }
      else if(day != 0 ){
         alert("연체로 인한 연장 불가")
      
      }
      else if(res == true){
         alert("예약으로 인한 연장불가")
      }
   }

   //예약 후 대여처리
   function resrental(num,status){
   
      var rental = document.getElementById("rental").value;
      var status = status
      if(rental <= 4 && status == 0){
         
         alert("대여처리한다.")
         location.href="resrental.book?book_num="+num;
      }
      else if(rental > 5){
         alert("대여가능 권수가 넘었습니다. 반납 후 빌려주시길 바랍니다.")
      }
      else if(status == 1){
         alert("대여상태이므로 빌릴 수 없습니다.")
      }
   }
</script>
</head>
<%@include file="/header.jsp"%>
<body>
<div class="orange_box" style="padding-top: 25px; padding-left: 250px; padding-bottom: 25px;">
<h3>대출 내역</h3>
<form action="return.book" method="get">
<table border="1" class="rental">
    
   <tr>
      <td>번호</td><td>등록번호</td><td>자료명</td><td>대출일</td>
      <td>반납예정일</td><td>연체일</td><td>연체료</td>
      <td>연장</td><td>반납</td>
   </tr>
   
   <c:forEach items="${list}" var="dto" varStatus="status">
   <tr>
      <td>${status.count }</td>
      <td>${dto.book_num}</td>
      <td>${dto.book_title}</td>
      <td>${dto.rental_date}</td>
      <td>${dto.renbtal_returndate}</td>
      <td>${dto.overdate }일</td>
      <td>${dto.return_sal }원</td>
      <input type="hidden" id="book_title" value="${dto.getBook_title()}">
      <input type="hidden" id="oversal" value="${dto.getReturn_sal()}">
      <input type="hidden" id="overdate" value="${dto.getOverdate()}">
      <input type="hidden" name="book_num" value="${dto.getBook_num()}">
      <input type="hidden" name="rental_num" value="${dto.getRental_num()}">
      <td><input type="button" value="연장" onclick="Extension(${dto.book_num},${dto.book_res },${dto.overdate })"></td>
      <td><input type="submit" value="반납" onclick="returnbook(${dto.return_sal})"></td>
   </tr>
   </c:forEach>
</table>
</form>

<br/><br/>
<h3>예약 내역</h3>
<form action="rescan.book" method="get">
<table border="1" class="rental">
    
   <tr>
      <td>번호</td><td>자료명</td><td>예약일</td>
      <td>예약만료일</td><td>대여</td><td>취소</td>
   </tr>
   
   <c:forEach items="${lists}" var="dto" varStatus="status">
   <tr>
      <td>${status.count }</td>
      <td>${dto.book_title}</td>
      <td>${dto.res_date}</td>
      <td>${dto.res_end}</td>
      <input type="hidden" name="book_num" value="${dto.getBook_num()}">
      <input type="hidden" name="res_num" value="${dto.getRes_num()}">
      <input type="hidden" id="book_title" value="${dto.getBook_title()}">
      
      <td><input type="button"  value="대여" onclick="resrental(${dto.book_num},${dto.book_status})"></td>
      <td><input type="submit"  value="취소" ></td>
   </tr>
   </c:forEach>
</table>

</form>
<input type="hidden" id="rental" value="${renlist}">


<br/><br/><br/>

<div id="Nwagon"></div>
<script>
   var options = {
      'dataset':{
         title: 'Web accessibility status',
         values:[${java},  ${db}, ${jsp}, ${spring}, ${android}],
         colorset: ['#2EB400', '#2BC8C9', "#666666", '#f09a93'],
         fields: ['JAVA', 'DB',  'JSP', 'Spring', 'Android'],
      },
      'donut_width' : 85,
      'core_circle_radius':0,
      'chartDiv': 'Nwagon',
      'chartType': 'pie',
      'chartSize': {width:700, height:400}
   };
   Nwagon.chart(options);
</script>
</div>
</body>
</html>
<%@include file="/footer.jsp"%>
loc : myrental.jsp