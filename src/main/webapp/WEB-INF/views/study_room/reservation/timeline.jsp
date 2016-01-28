<%@ page contentType="text/html; charset=utf-8"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>좌석 예약 시간 페이지</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script	src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js">
	<script src="http://code.jquery.com/jquery.js" >
</script>
<script src="js/bootstrap/js/bootstrap.min.js"></script>
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script type="text/javascript">
       function fnBack2(){
      var answer = confirm("날짜 선택으로 되돌아가시겠습니까?")
      if(answer) {
         alert("날짜 선택으로 되돌아갑니다.")
         history.back();
      }
      else{
         alert("예약을 진행합니다.");
      }
   }
</script>
  <script>
  $(function() {
   
    $( "#timeline" )
      .selectmenu()
      .selectmenu( "menuWidget" )
        .addClass( "overflow" );
  });
  </script>
  <style>
    fieldset {
      border: 0;
    }
    label {
      display: block;
      margin: 30px 0 0 0;
    }
    select {
      width: 200px;
    }
    .overflow {
      height: 200px;
    }
  </style>
</head>
<body>
 
<div class="timeline" align="center" ><img src="images/hta_res.jpg" alt="">
 
<form action="#" method="POST">
   <p>
   <fieldset>
    <label for="files"><h3>사용 시간 설정</h3></label>
    <select name="files" id="files">
      
      <optgroup label="AM" >
        <option value="08:00~10:00">08:00~10:00</option>
        <option value="10:00~12:00">10:00~12:00</option>
      </optgroup>
      
      <optgroup label="PM">
        <option value="12:00~14:00">12:00~14:00</option>
        <option value="14:00~16:00">14:00~16:00</option>
        <option value="16:00~18:00">16:00~18:00</option>
        <option value="18:00~20:00">18:00~20:00</option>
        <option value="20:00~22:00">20:00~22:00</option>
      </optgroup>
      <optgroup label="close"></optgroup>
    </select>
   </fieldset>
   </p>
 	<p>
		<button class="btn btn-danger" type="button" name="selectBack" value="cancle" onclick="fnBack2()">이전</button>
		<button class="btn btn-primary" type="submit" name="selectTime" value="next" >다음</button>
	</p>	
 </form>
 
</div>
 
 
</body>
</html>