<%@ page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<head>
<title>Insert title here</title>
</head>
<%@include file="/header.jsp"%>
<body>
<div class="orange_box" style="padding-left: 365px; padding-top: 20px; padding-bottom: 20px">
<form action="bookupdate" enctype="multipart/form-data" method="POST"><!--로그인 또한  자체 dto가 필요하다. action는 같은 이름으로 해도된다. 구별은 method방식(즉 보내는 방법으로 구별) -->
     
     <h2 style="margin-left: 50px">도서 정보 수정</h2>
     
      <p>               <!-- 또한 만약 같은 GET방식으로 보내야할 상황이면 param로 전달하는 방식으로 구분해서 전달받을수 있다.-->
         <label>
            도서명 : <br/>
            <input type="text" name="book_title" style="width: 300px; height: 30px" id="book_title" value="${dto.getBook_title()}"/>
         </label>
      </p>
      <p>
         <label>
            출판사 : <br/>
            <input type="text" name="book_label" style="width: 300px; height: 30px" id="book_label" value="${dto.getBook_label()}"/>
         </label>
      </p>
      <p>
         <label>
            저자 : <input type="text" name="book_author" style="width: 300px; height: 30px" id="book_author" value="${dto.getBook_author()}"/>
         </label>
      </p>
      <p>
         <label>
            장르 :<select name="book_genre" title="책장르" style="width: 300px; height: 30px">
                  <option value="JAVA">JAVA</option>
                  <option value="DB" >DB</option>
                  <option value="JSP">JSP</option>
                  <option value="Spring">Spring</option>
                  <option value="Android">Android</option>      
               </select> 
         </label>
      </p>
      <p>
         <label>
            ISBN : <input type="text" style="width: 300px; height: 30px" name="book_isbn" id="book_isbn" value="${dto.getBook_isbn()}"/>
         </label>
      </p>
      <p>
         <label>
            파일 :<input type="file" style="width: 300px; height: 30px" name="upFile" id="book_img"/><br/><br/>
         </label>
      </p>
      <p>
         <label>
            청구기호 :<input type="text" name="book_chunggu" style="width: 300px; height: 30px" id="book_chunggu" value="${dto.getBook_chunggu()}"/><br/><br/>
         </label>
      </p>
      <p>
         <label>
            소장위치 :<input type="text" name="book_loc"  style="width: 300px; height: 30px" id="book_loc" value="${dto.getBook_loc()}"/><br/><br/>
         </label>
      </p>
      <input type="hidden" name="book_num" value="${dto.getBook_num()}"/>
      
      <input type="submit" value="수정" />
      <input type="reset" value="전부지우기"/>
      <input type="button" value="목록보기" onclick="location.href='success.book'"/>
   </form>
   </div>
</body>
</html>
<%@include file="/footer.jsp"%>

loc : bookupdate.jsp 