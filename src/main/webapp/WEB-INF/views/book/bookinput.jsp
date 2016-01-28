<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
   function fnsuccess(){
      var bookimg = document.getElementById("book_img").value;
      var bookisbn = document.getElementById("book_isbn").value;
      if(bookimg != null && bookimg != "" && bookisbn != null && bookisbn != ""){
         alert("책 추가에 성공하셨습니다.")
           document.bookinput.submit();
           
      }
      else if(bookisbn == null || bookisbn == ""){
         alert("ISBN을 입력하세요")
       
      }
      else if(bookimg == null || bookimg == ""){
        alert("이미지를 추가하세요")
        
      }
   }
</script>
</head>
<%@include file="/header.jsp"%>
<body>
<div class="orange_box" style="padding-top: 25px; padding-left: 50px;">
<form name="bookinput" action="bookinput" enctype="multipart/form-data" method="POST"><!--로그인 또한  자체 dto가 필요하다. action는 같은 이름으로 해도된다. 구별은 method방식(즉 보내는 방법으로 구별) -->
      <p align="center">               <!-- 또한 만약 같은 GET방식으로 보내야할 상황이면 param로 전달하는 방식으로 구분해서 전달받을수 있다.-->
         <label>
            도서명 : <br/>
            <input type="text" name="book_title" id="book_title" style="width: 300px; height: 30px"/>
         </label>
      </p>
      <p align="center">
         <label>
            출판사 : <br/>
            <input type="text" name="book_label" id="book_label" style="width: 300px; height: 30px"/>
         </label>
      </p>
      <p align="center">
         <label>
            저자 : <input type="text" name="book_author" id="book_author" style="width: 300px; height: 30px"/>
         </label>
      </p>
      <p align="center">
         <label>
            장르 :<br />
            <select name="book_genre" title="책장르" style="width: 300px; height: 30px">
<!--                   <option selected="selected"></option> -->
                  <option value="JAVA">JAVA</option>
                  <option value="DB" >DB</option>
                  <option value="JSP">JSP</option>
                  <option value="Spring">Spring</option>
                  <option value="Android">Android</option>      
            </select> 
         </label>
      </p>
      <p align="center">
         <label>
            ISBN : <input type="text" name="book_isbn" id="book_isbn" style="width: 300px; height: 30px"/>
         </label>
      </p>
      <p align="center">
         <label>
            파일 :<input type="file" name="upFile" id="book_img" style="width: 300px; height: 30px"/><br/><br/>
         </label>
      </p>
      <p align="center">
         <label>
            청구기호 :<input type="text" name="book_chunggu" id="book_chunggu" style="width: 300px; height: 30px"/><br/><br/>
         </label>
      </p>
      <p align="center">
         <label>
            소장위치 :<input type="text" name="book_loc" id="book_loc" style="width: 300px; height: 30px"/><br/><br/>
         </label>
      </p>
      <div align="center" >
      <input type="button" value="저장" onclick="fnsuccess()"/>
      <input type="reset" value="취소" />
      <input type="button" value="전체목록보기" onclick="location.href='success.book'">
      <input type="button" value="오늘추가목록보기" onclick="location.href='today.book'">
      </div>
   </form>
   </div>
</body>
</html>
<%@include file="/footer.jsp"%>
loc : bookinput.jsp 도서입력 페이지