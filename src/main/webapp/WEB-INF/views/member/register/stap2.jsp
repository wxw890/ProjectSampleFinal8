<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/header.jsp"%>

<script>
Modernizr.load({
    // test if browser understands media queries
    test: Modernizr.mq('only all'),
    // if not load ie8-grid
    nope: 'css/ie8-grid-foundation-4.css'
});
</script>
<script  type="text/javascript">

   var overlap_member_email = "<c:out value='${overlap_member_email}'/>";//c태그를 통해 EL값을 받아와 script에서 사용하는 방법, 중복되는 이메일
   var confim_member_email = "<c:out value='${confim_member_email}'/>";//사용가능한 이메일
   //alert("이메일 중복 확인값"+overlap_member_email.toString());
   //alert("이메일 확인값"+confim_member_email.toString());
   
   
   if(overlap_member_email !==""){//이메일 중복시
   alert(overlap_member_email+"는 이미 사용중입니다.");
   }
   if(confim_member_email !==""){//이메일 사용가능할시
   alert(confim_member_email+"는 사용가능합니다.");
   }
</script>
<script>
   function sendemail(){
      var member_email = document.getElementById("member_email").value;
      //alert("이메일은"+member_email);
      location.href = "stap2?member_email="+member_email;
   }
</script>


<!-- 이부분이 약관동의 부분 -->
 
   <div class="orange_box">
      
      
      
      <div align="center" style="margin-top: 50px; margin-bottom: 50px;">
      <h2>회원정보입력</h2>
      <form action="stap3" method="POST">
      <p>
         <label>메일<br/>
            <input type="text" name="member_email" id="member_email" value="${confim_member_email}" style="width: 300px; height: 30px">
         </label>
         <input type="button" value="중복확인" onclick="sendemail()" style="width: 300px; height: 30px"/>
      </p>
      <p>
         <label>이름<br/>
            <input type="text" name="member_name" id="member_name" style="width: 300px; height: 30px">
         </label>
      </p>
      <p>
         <label>주소<br/>
            <input type="text" name="member_address" id="member_address" style="width: 300px; height: 30px">
         </label>
      </p>
      <p>
         <label>핸드폰 번호<br/>
            <input type="text" name="member_phonenumber" id="member_phonenumber" style="width: 300px; height: 30px">
         </label>
      </p>
      <p>
         <label>비밀번호<br/>
            <input type="password" name="member_password" id="member_password" style="width: 300px; height: 30px">
         </label>
      </p>
      <p>
         <label>비밀번호 확인<br/>
            <input type="password" name="confirmpassword" id="confirmpassword" style="width: 300px; height: 30px">
         </label>
      </p>
      <input type="submit" value="가입 완료"/>
      
      </form>
      </div>
      
      
      
      
      
   </div>
   


<%@include file="/footer.jsp"%>