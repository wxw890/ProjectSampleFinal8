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




   <div class="orange_box" style="padding-left: 325px; padding-top: 10px">
      <!-- 이부분이 축하 메세지 부분 -->
   <h2>${dto.member_name}<strong>님</strong>회원가입을 축하합니다.</h2>
   <!--<p><a href="/chap02/index.jsp">메인 페이지로 이동</a></p> -->
   <p><a href="index.jsp">메인 페이지로 이동</a></p> 

      
      
   </div>
   
  

<%@include file="/footer.jsp"%>