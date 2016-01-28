<%@ page language="java" contentType="text/html; charset=utf-8"
   isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>


<%@include file="/header.jsp"%>
<script>
   function fnSearch(){
      var day = document.getElementById("day").value;
         if(day !== ""){
            location.href = "reservation.search?date="+day;
         }
         else if(day === ""){
            alert("날짜를 지정해주세요!");
            location.href ="reservation.study";
         }
      
   }
</script>
<script>
   function fndelete(reservation_num){
      var answer = confirm(reservation_num+"예약을 정말로 삭제하시겠습니까?");
      if(answer == true){
         location.href = "reservation.delete?reservation_num="+reservation_num;
      }
      else{
         location.href = "reservation.search";
      }
   }
</script>
<script>
   function fnreservation(member_email){ //스터디 예약 로그인 안했을때 처리부분, step1Error.jsp 부분에는 추가 안해도 될것같다.. 이유는 로그인을 해야하만 step1Error.jsp부분을 갈수
                                  //있게 때문이다. 하지만 여기서는 혹시모를 상황을 위해서 추가하겠다.
      var day1 = document.getElementById("day").value;
      //var submit1 = document.getElementById("selectDay");
      //alert("날짜는"+day);
      //location.href="reservation1.study";
      if(member_email !== ""){
         alert("로그인을 하세요!!")
         //location.href="reservation3.study" //이부분에서는 form태그 안에서 버튼이 submit 타입이라서 location.href는 GET방식이라 아마 GET방식으로 가다가 POST방식 또한 같이가서 에러가 발생하는 것 같다.
         window.history.back(0);//버튼이 submit인 POST방식에서는 window.history.back()을 해야 되돌갈수 있는 듯하다....
         
      }
      else{
         if(day1 === ""){
            alert("날짜를 입력하세요");
            window.history.back(0);
         }
      }
      
      
   }
</script>
   
   
<script>
   
   var NullValueError = ${NullValueError=='NullValue'}
   if(NullValueError == "NullValue"){
   alert("날짜좀 입력해주세요!");
   }
</script>   
<!-- step1Error부분 function들 -->
<!-- 날짜를 잘못 선택했다고 알려주는 알림창 띄어줌 -->
<script type="text/javascript">
   (function (year, month, day) { //step1Error.jsp 페이지를 시작할때 바로 띄어주는(무조건 먼저!!) javascript 언어 부분
      alert("선택하신 날짜 "+year + "년 "+ month + "월 " + day + "일은 현재 예약되었거나 이미 지난 날짜 입니다. 다시 확인해주세요!");
   })('${list.get(0)}', '${list.get(1)}', '${list.get(2)}');
</script>


   <c:set var="map" value="<%=new java.util.HashMap()%>" />
   
   <!-- 위쪽은 header.css 대신 사용하는 부분. 탬플릿에서 가져왔다. -->
   <c:set var="email" value="${email}"/>
   
   <div class="container" align="center" id="resview"
      style="margin-top: 50px">
      <img src="images/hta_res.jpg" alt="" />
      <!-- 
      <h1>${map.year}</h1><h1>${map.get["month"]}</h1><h1>${map.get['day']}</h1>
      <c:forEach var="map" items="${map}" varStatus="current">
         <tr>
         <td>${map.value}</td>
         <td>${map.month}</td>
         <td>${map.day}</td>
         </tr>
      </c:forEach> -->
      <tr>
      <td>가져온 날짜들 ${list.get(0)}, ${list.get(1)}, ${list.get(2)}</td>
   
      </tr>
      

      
      <form action="reservation2.study" method="post">
         <input type="hidden" name="member_email" />
         <!-- 사용자 계정 정보 전달을 위해 히든값으로 이메일(계정)전달 -->
   

         <p class="calendarP">
            <label><h3>예약하실 날짜를 선택해 주세요</h3></label> 
            <input type="date"   name="reservation_date" id="day" class="calendar" style="width: 300px; margin-left: 790px;"/>
               
         </p>
            <hr />
         <p>
         <fieldset style="width: 300px; margin-right: 23px;">
            <label for="files"><h3>사용 시간 설정</h3></label> <select
               name="reservation_time" id="files">
               <optgroup label="morning">
                  <option value="08:00~10:00">08:00~10:00</option>
                  <option value="10:00~12:00">10:00~12:00</option>
               </optgroup>
               <optgroup label="afternoon">
                  <option value="12:00~14:00">12:00~14:00</option>
                  <option value="14:00~16:00">14:00~16:00</option>
                  <option value="16:00~18:00">16:00~18:00</option>
                  <option value="18:00~20:00">18:00~20:00</option>
                  <option value="20:00~22:00">20:00~22:00</option>
               </optgroup>
               <optgroup label="deadline"></optgroup>
            </select>
         </fieldset>
         </p>

         <div class="tableBox" style="width: 705px;">
            <div class="box" onmouseover='this.style.backgroundColor="#FF5E00"'  onMouseOut='this.style.backgroundColor="#FFFFFF"'>
               <strong>0번 테이블</strong>
               <div class="info" >좌석수 : 6인석</div>
<!--                <div class="marking">예약상태 : 예약중이라면 빨간색으로 예약중이라고 표시</div> -->
               <br /> <input type="radio" name="table_num" value="0" />
            </div>
            <div class="box" onmouseover='this.style.backgroundColor="#FF5E00"'  onMouseOut='this.style.backgroundColor="#FFFFFF"'>
               <strong>1번 테이블</strong>
               <div class="info">좌석수 : 6인석</div>
<!--                <div class="marking">예약상태 : 예약중이라면 빨간색으로 예약중이라고 표시</div> -->
               <br /> <input type="radio" name="table_num" value="1" />
            </div>
            <div class="box" onmouseover='this.style.backgroundColor="#FF5E00"'  onMouseOut='this.style.backgroundColor="#FFFFFF"'>
               <strong>2번 테이블</strong>
               <div class="info">좌석수 : 6인석</div>
<!--                <div class="marking">예약상태 : 예약중이라면 빨간색으로 예약중이라고 표시</div> -->
               <br /> <input type="radio" name="table_num" value="2" />
            </div>
            <div class="box" onmouseover='this.style.backgroundColor="#FF5E00"'  onMouseOut='this.style.backgroundColor="#FFFFFF"'>
               <strong>3번 테이블</strong>
               <div class="info">좌석수 : 6인석</div>
<!--                <div class="marking">예약상태 : 예약중이라면 빨간색으로 예약중이라고 표시</div> -->
               <br /> <input type="radio" name="table_num" value="3" />
            </div>
            <div class="box" onmouseover='this.style.backgroundColor="#FF5E00"'  onMouseOut='this.style.backgroundColor="#FFFFFF"'>
               <strong>4번 테이블</strong>
               <div class="info">좌석수 : 6인석</div>
<!--                <div class="marking">예약상태 : 예약중이라면 빨간색으로 예약중이라고 표시</div> -->
               <br /> <input type="radio" name="table_num" value="4" />
            </div>
            <div class="box" onmouseover='this.style.backgroundColor="#FF5E00"'  onMouseOut='this.style.backgroundColor="#FFFFFF"'>
               <strong>5번 테이블</strong>
               <div class="info">좌석수 : 8인석</div>
<!--                <div class="marking">예약상태 : 예약중이라면 빨간색으로 예약중이라고 표시</div> -->
               <br /> <input type="radio" name="table_num" value="5" />
            </div>
            <div class="box" onmouseover='this.style.backgroundColor="#FF5E00"'  onMouseOut='this.style.backgroundColor="#FFFFFF"'>
               <strong>6번 테이블</strong>
               <div class="info">좌석수 : 8인석</div>
<!--                <div class="marking">예약상태 : 예약중이라면 빨간색으로 예약중이라고 표시</div> -->
               <br /> <input type="radio" name="table_num" value="6" />
            </div>
            <div class="box" onmouseover='this.style.backgroundColor="#FF5E00"'  onMouseOut='this.style.backgroundColor="#FFFFFF"'>
               <strong>7번 테이블</strong>
               <div class="info">좌석수 : 8인석</div>
<!--                <div class="marking">예약상태 : 예약중이라면 빨간색으로 예약중이라고 표시</div> -->
               <br /> <input type="radio" name="table_num" value="7" />
            </div>
            <div class="box" onmouseover='this.style.backgroundColor="#FF5E00"'  onMouseOut='this.style.backgroundColor="#FFFFFF"'>
               <strong>8번 테이블</strong>
               <div class="info">좌석수 : 8인석</div>
<!--                <div class="marking">예약상태 : 예약중이라면 빨간색으로 예약중이라고 표시</div> -->
               <br /> <input type="radio" name="table_num" value="8" />
            </div>
            <div class="box" onmouseover='this.style.backgroundColor="#FF5E00"'  onMouseOut='this.style.backgroundColor="#FFFFFF"'>
               <strong>9번 테이블</strong>
               <div class="info">좌석수 : 4인석</div>
<!--                <div class="marking">예약상태 : 예약중이라면 빨간색으로 예약중이라고 표시</div> -->
               <br /> <input type="radio" name="table_num" value="9" />
            </div>
            <div class="box" onmouseover='this.style.backgroundColor="#FF5E00"'  onMouseOut='this.style.backgroundColor="#FFFFFF"'>
               <strong>10번 테이블</strong>
               <div class="info">좌석수 : 4인석</div>
<!--                <div class="marking">예약상태 : 예약중이라면 빨간색으로 예약중이라고 표시</div> -->
               <br /> <input type="radio" name="table_num" value="10" />
            </div>
            <div class="box" onmouseover='this.style.backgroundColor="#FF5E00"'  onMouseOut='this.style.backgroundColor="#FFFFFF"'>
               <strong>11번 테이블</strong>
               <div class="info">좌석수 : 4인석</div>
<!--                <div class="marking">예약상태 : 예약중이라면 빨간색으로 예약중이라고 표시</div> -->
               <br /> <input type="radio" name="table_num" value="11" />
            </div>
            <div class="box" onmouseover='this.style.backgroundColor="#FF5E00"'  onMouseOut='this.style.backgroundColor="#FFFFFF"'>
               <strong>12번 테이블</strong>
               <div class="info">좌석수 : 4인석</div>
<!--                <div class="marking">예약상태 : 예약중이라면 빨간색으로 예약중이라고 표시</div> -->
               <br /> <input type="radio" name="table_num" value="12" />
            </div>
         </div>
         
         
         
<!-- 현재 예약 테이블 -->
<c:if test="${list5 == null}">
   <h1>조회된 예약이 없습니다.</h1>
</c:if>               
<c:if test="${list5 != null}">         
<table border="1">
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
</table>
</c:if>      







         <div style="margin-top: 475px">
         <button class="btn btn-danger" type="button" name="selectSearch"
               value="cancle" onclick="fnSearch()">예약조회</button>
            <button class="btn btn-primary" type="submit" name="selectDay"
               value="next">예약하기</button>

         </div>
      </form>
   </div>


   <!-- 아래쪽은 footer.css 대신 사용하는 부분. 탬플릿에서 가져왔다. -->
<%@include file="/footer.jsp"%>
loc : step1Error.jsp