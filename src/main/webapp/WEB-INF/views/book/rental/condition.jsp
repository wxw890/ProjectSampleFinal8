<%@ page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<title>리스트</title>

<script>
   function fnNullChk(){
       var chk = document.getElementById("onevalue").value;
         
            
       if(chk == "" || chk == null){
          alert("1차 검색어를 입력하세요.")   
       }   
       else if(chk != "" || chk != null){
         document.bsearch.submit();
       }
   }
</script>


</head>
<%@include file="/header.jsp"%>
<body>

<!-- <form action="condition.book" method="post"> -->
<!--    <select name="item" title="검색항목"> -->
<!--       <option selected="selected">분류</option> -->
<!--       <option value="book_title">서명</option> -->
<!--       <option value="book_author" >저자</option> -->
<!--       <option value="book_label">출판사</option> -->
<!--       <option value="book_num">등록번호</option> -->
<!--       <option value="book_chunggu">청구기호</option> -->
<!--       <option value="book_isbn">ISBN</option> -->
<!--    </select> -->
<!--    <input type="text" name="value" id="value1" title="검색어입력" /> -->
<!--    <select name="op" title="검색옵션"> -->
<!--       <option></option> -->
<!--       <option value="AND">AND</option> -->
<!--       <option value="OR">OR</option> -->
<!--       <option value="NOT">NOT</option> -->
<!--    </select> -->
<!--    <br /> -->
<!--    <select name="seconditem" title="검색항목"> -->
<!--       <option selected="selected"></option> -->
<!--       <option value="book_title">서명</option> -->
<!--       <option value="book_author" >저자</option> -->
<!--       <option value="book_label">출판사</option> -->
<!--       <option value="book_num">등록번호</option> -->
<!--       <option value="book_chunggu">청구기호</option> -->
<!--       <option value="book_isbn">ISBN</option> -->
<!--    </select> -->
<!--    <input type="text" name="secondvalue" id="value1" title="검색어입력" /> -->
<!--    <select name="secondop" title="검색옵션"> -->
<!--       <option></option> -->
<!--       <option value="AND">AND</option> -->
<!--       <option value="OR">OR</option> -->
<!--       <option value="NOT">NOT</option> -->
<!--    </select> -->
<!--    <br/> -->
<!--    <select name="thirditem" title="검색항목"> -->
<!--       <option selected="selected"></option> -->
<!--       <option value="book_title">서명</option> -->
<!--       <option value="book_author" >저자</option> -->
<!--       <option value="book_label">출판사</option> -->
<!--       <option value="book_num">등록번호</option> -->
<!--       <option value="book_chunggu">청구기호</option> -->
<!--       <option value="book_isbn">ISBN</option> -->
<!--    </select> -->
<!--    <input type="text" name="thirdvalue" id="value1" title="검색어입력" /> -->
<!--    <br/> -->
<!--    <input type="submit" value="검색"/> -->
<!-- </form> -->

<div class="orange_box" style="background-color: white ; padding-top: 30px; padding-left: 120px;">
   <img src="images/booksearch.png" alt="도서검색 이미지" style="margin-left: 30px;"/>
<form  action="condition.book" method="post" name="bsearch" style="width:800px; height:200px; margin-top: 30px; margin-bottom: 30px; margin-left: 30px; margin-right: 30px;">
   <select name="item" title="검색항목" placeholder="분류" style="width:100px;height:30px;float:left;" >
   
      <option selected="selected"></option>
      <option value="book_title">서명</option>
      <option value="book_author" >저자</option>
      <option value="book_label">출판사</option>
      <option value="book_num">등록번호</option>
      <option value="book_chunggu">청구기호</option>
      <option value="book_isbn">ISBN</option>
   </select>
   <input type="text" name="value" id="onevalue"  title="검색어입력" placeholder="검색어를 입력하세요" style="width: 500px; height:30px; float:left;" />
   <select name="op" title="검색옵션" placeholder="옵션" style="width: 100px; height:30px; float:left; ">
      <option></option>
      <option value="AND">AND</option>
      <option value="OR">OR</option>
      <option value="NOT">NOT</option>
   </select>
   
   
   <br />
   
   
   <select name="seconditem" id="twoitem" title="검색항목" placeholder="분류" style="width:100px;height:30px;float:left; clear:left;" >
      <option selected="selected"></option>
   
      <option value="book_title">서명</option>
      <option value="book_author" >저자</option>
      <option value="book_label">출판사</option>
      <option value="book_num">등록번호</option>
      <option value="book_chunggu">청구기호</option>
      <option value="book_isbn">ISBN</option>
   </select>
   <input type="text" name="secondvalue" id="twovalue" title="검색어입력" placeholder="2차 검색어를 입력하세요" style="width: 500px; height:30px; float:left;"/>
   <select name="secondop" title="검색옵션" placeholder="옵션" style=" width: 100px; height:30px; float:left;">
      <option></option>
      
      <option value="AND">AND</option>
      <option value="OR">OR</option>
      <option value="NOT">NOT</option>
   </select>
   <br/>
   <select name="thirditem" title="검색항목" placeholder="분류" style="width:100px;height:30px; float:left; clear:left;">
      <option selected="selected"></option>
      <option value="book_title">서명</option>
      <option value="book_author" >저자</option>
      <option value="book_label">출판사</option>
      <option value="book_num">등록번호</option>
      <option value="book_chunggu">청구기호</option>
      <option value="book_isbn">ISBN</option>
   </select>
   <input type="text" name="thirdvalue" id="value3" title="검색어입력" placeholder="3차 검색어를 입력하세요" style="width: 500px; height:30px; float: left"/>
   <br/><br /><br /><br /><br /><br />
   <input type="button" value="검색" onclick="fnNullChk()" style="width:50px; height:30px;  float:left; clear: left;"/>
   
</form>
</div>

</body>
</html>
<%@include file="/footer.jsp"%>
loc : condition.jsp