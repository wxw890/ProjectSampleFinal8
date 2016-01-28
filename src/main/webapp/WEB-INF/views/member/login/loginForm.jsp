<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/header.jsp"%>



      <div align="center" style="margin-top: 50px; margin-bottom: 50px;">
      <form action="login.member?command=submit" method="POST" ><!--로그인 또한  자체 dto가 필요하다. action는 같은 이름으로 해도된다. 구별은 method방식(즉 보내는 방법으로 구별) -->
      <p>               <!-- 또한 만약 같은 GET방식으로 보내야할 상황이면 param로 전달하는 방식으로 구분해서 전달받을수 있다.-->
         <label>
            이메일 : <br/>
            <input type="text" name="email" value="${loginCommand.email}" style="width: 300px; height: 30px" />
         </label>
      </p>
      <p>
         <label>
            패스워드 : <br/>
            <input type="password" name="password" value="${loginCommand.password}" style="width: 300px; height: 30px"/>
         </label>
      </p>
      <p>
         <label>
            이메일 기억하기 : <input type="checkbox" name="rememberEmail"/>
         </label>
      </p>
      <input type="submit" value="로그인 하기"/>
      </form>
      </div>



      </div>
    
   
   




<%@include file="/footer.jsp"%>