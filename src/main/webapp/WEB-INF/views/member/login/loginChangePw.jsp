<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false"%>

<%@include file="/header.jsp"%>

<h2>패스워드 변경하기</h2>
<form action="loginchange.member?command2=submit2" method="POST"><!--로그인 또한  자체 dto가 필요하다. action는 같은 이름으로 해도된다. 구별은 method방식(즉 보내는 방법으로 구별) -->
		<p>					<!-- 또한 만약 같은 GET방식으로 보내야할 상황이면 param로 전달하는 방식으로 구분해서 전달받을수 있다.-->
			<label>
				이메일 : <br/>
				${loginCommand.email}
			</label>
		</p>
		<p>
			<label>
				패스워드 : <br/>
				<input type="password" name="passwordcomf" id="passwordcomf" />
			</label>
		</p>
		<p>
			<label>
				새 패스워드 : <br/>
				<input type="password" name="newpassword" id="newpassword" />
			</label>
		</p>
		<p>
			<label>
				새 패스워드 확인 : <br/>
				<input type="password" name="newpasswordcomf" id="newpasswordcomf" />
			</label>
		</p>
		
		<input type="submit" value="변경하기"/>
	</form>
<%@include file="/footer.jsp"%>