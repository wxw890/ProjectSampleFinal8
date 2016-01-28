<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"
	type="text/javascript"></script>

<script>
	// html 이 다 로딩된 후 실행
	$(document).ready(function() {
		// 체크박스들이 변경됬을때
		$(":checkbox").change(function() {
			var cnt = $("#person").val();
			// 셀렉트박스의 값과 체크박스중 체크된 갯수가 같을때, 다른 체크박스들을 disable 처리
			if (":checkbox:checked") {
				$(":checkbox").attr("disabled", "disabled");
			}
			// 체크된 갯수가 다르면 활성화 시킴
			else {
				$(":checkbox").removeAttr("disabled");
			}
		});
		// 셀렉트박스에서 다른 인원수를 선택하면 초기화 시킴
		$("#person").change(function() {
			$(":checkbox").removeAttr("checked");
			$(":checkbox").removeAttr("disabled");
		});
	});
	function fnCancel() {
		$(":checkbox").removeAttr("checked");
		$(":checkbox").removeAttr("disabled");
	}
</script>
</head>
<body>

		<form action="" method="POST" >
<!-- 	<table name="table_num"> -->
		<div class="tableBox" >
							<div class="box">
								<strong>1번 테이블</strong>
								<div class="info">좌석수 : 6인석</div>
								<div class="marking">예약상태 : 예약중이라면 빨간색으로 예약중이라고 표시</div><br />
								<input type="radio" name="table_num" value="1" />
							</div>
											<div class="box">
								<strong>2번 테이블</strong>
								<div class="info">좌석수 : 6인석</div>
								<div class="marking">예약상태 : 예약중이아니라면 초록색으로 예약가능 표시</div><br />
								<input type="radio" name="table_num" value="2" />
							</div>
							<div class="box">
								<strong>3번 테이블</strong>
								<div class="info">좌석수 : 6인석</div>
								<div class="marking">예약상태 : 예약중이아니라면 초록색으로 예약가능 표시</div><br />
								<input type="radio" name="table_num" value="3" />
							</div>
							<div class="box">
								<strong>4번 테이블</strong>
								<div class="info">좌석수 : 6인석</div>
								<div class="marking">예약상태 : 예약중이아니라면 초록색으로 예약가능 표시</div><br />
								<input type="radio" name="table_num" value="4" />
							</div>
							<div class="box">
								<strong>5번 테이블</strong>
								<div class="info">좌석수 : 8인석</div>
								<div class="marking">예약상태 : 예약중이아니라면 초록색으로 예약가능 표시</div><br />
								<input type="radio" name="table_num" value="5" />
							</div>
							<div class="box">
								<strong>6번 테이블</strong>
								<div class="info">좌석수 : 8인석</div>
								<div class="marking">예약상태 : 예약중이아니라면 초록색으로 예약가능 표시</div><br />
								<input type="radio" name="table_num" value="6" />
							</div>
							<div class="box">
								<strong>7번 테이블</strong>
								<div class="info">좌석수 : 8인석</div>
								<div class="marking">예약상태 : 예약중이아니라면 초록색으로 예약가능 표시</div><br />
								<input type=radio name="table_num" value="7" />
							</div>
							<div class="box">
								<strong>8번 테이블</strong>
								<div class="info">좌석수 : 8인석</div>
								<div class="marking">예약상태 : 예약중이아니라면 초록색으로 예약가능 표시</div><br />
								<input type="radio" name="table_num" value="8" />
							</div>
							<div class="box">
								<strong>9번 테이블</strong>
								<div class="info">좌석수 : 4인석</div>
								<div class="marking">예약상태 : 예약중이아니라면 초록색으로 예약가능 표시</div><br />
								<input type="radio" name="table_num" value="9" />
							</div>
							<div class="box">
								<strong>10번 테이블</strong>
								<div class="info">좌석수 : 4인석</div>
								<div class="marking">예약상태 : 예약중이아니라면 초록색으로 예약가능 표시</div><br />
								<input type="radio" name="table_num" value="10" />
							</div>
							<div class="box">
								<strong>11번 테이블</strong>
								<div class="info">좌석수 : 4인석</div>
								<div class="marking">예약상태 : 예약중이아니라면 초록색으로 예약가능 표시</div><br />
								<input type="radio" name="table_num" value="11" />
							</div>
							<div class="box">
								<strong>12번 테이블</strong>
								<div class="info">좌석수 : 4인석</div>
								<div class="marking">예약상태 : 예약중이아니라면 초록색으로 예약가능 표시</div><br />
								<input type="radio" name="table_num" value="12" />
							</div>

							<div class="button" align="center">
								<button class="btn btn-primary" type="button" name="selectChange"
									value="테이블 선택 변경" onclick="fnCancel()">테이블 선택 변경</button>
							</div>


						</div>

		</form>
<!-- 	</table> -->
	
	<br />
	<div class="button" align="center" >
	<button class="btn btn-primary" type="button" name="selectChange"
		value="테이블 선택 변경" onclick="fnCancel()">테이블 선택 변경</button>
	</div>
</body>
</html>



<!-- 		<tr> -->
<!-- 			<div style="background-color: black;"> -->
<!-- 				<td><label>1번 테이블<input type="checkbox" /></label></td> -->
<!-- 			</div> -->
<!-- 			<td><label>2번 테이블<input type="checkbox" /></label></td> -->
<!-- 			<td><label>3번 테이블<input type="checkbox" /></label></td> -->
<!-- 			<td><label>4번 테이블<input type="checkbox" /></label></td> -->
<!-- 			<td><label>5번 테이블<input type="checkbox" /></label></td> -->
<!-- 			<td><label>6번 테이블<input type="checkbox" /></label></td> -->
<!-- 			<td><label>7번 테이블<input type="checkbox" /></label></td> -->
<!-- 			<td><label>8번 테이블<input type="checkbox" /></label></td> -->
<!-- 		</tr> -->