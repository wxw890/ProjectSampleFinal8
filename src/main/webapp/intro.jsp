<%@ page language="java" contentType="text/html; charset=utf-8"
   isELIgnored="false"%>
<!doctype html>
<html>
<head>
<%@include file="/header.jsp"%>

   <meta charset="UTF-8">
   <title>중앙HTA 라이브러리 소개</title>
<style>
.css3-tab {
  list-style: none;
  margin: 0 auto 40px;
  padding: 38px 0 0 0;
  position: relative;
  width: 90%;
}
.css3-tab input[type='radio'] {
  display: none;
}
.css3-tab .css3-tab-nav {
  display: table;
  table-layout: fixed;
  width: 100%;
}
.css3-tab .css3-tab-nav label {
  display: table-cell;
  background-color: #666666;
  color: #FFFFFF;
  padding: 15px;
  text-align: center;
  transition: all .3s ease 0s;
}
.css3-tab .css3-tab-nav label:hover {
  cursor: pointer;
  background: white;
  color: #666666;
  transition: all .3s ease 0s;
}
@media (max-width: 692px) {
  .css3-tab .css3-tab-nav {
    display: block;
    margin: 0 0 20px;
  }
  .css3-tab .css3-tab-nav label {
    display: block;
    box-sizing: border-box;
    width: 100%;
    padding: 20px;
  }
}
.css3-tab .css3-tab-content {
  overflow: hidden;
  padding: 25px;
  display: none;
  background: #FFF;
  clear: left;
  box-sizing: border-box;
}
.css3-tab input[id='tabOne']:checked ~ .css3-tab-nav label[for='tabOne'] {
  background: #FF5E00;
  color: white;
  cursor: default;
}
.css3-tab input[id='tabOne']:checked ~ div.tab-one {
  display: block;
  border-top: solid 5px #353535;
}
.css3-tab input[id='tabTwo']:checked ~ .css3-tab-nav label[for='tabTwo'] {
  background: #FF5E00;
  color: white;
  cursor: default;
}
.css3-tab input[id='tabTwo']:checked ~ div.tab-two {
  display: block;
  border-top: solid 5px #353535;
}
.css3-tab input[id='addNew']:checked ~ .css3-tab-nav label[for='addNew'] {
  background: #FF5E00;
  color: white;
  cursor: default;
}
.css3-tab input[id='addNew']:checked ~ div.add-new {
  display: block;
  border-top: solid 5px #353535;
}
body {
  background: #e4e4e4;
}

</style>
</head>
<body>

<!-- Pure CSS Menu -->
<div class='css3-tab'>
      <input type='radio' name='a' id='tabOne' tabindex="1">
      <input type='radio' name='a' id='tabTwo' tabindex="2" checked>
      <input type='radio' name='a' id='addNew' tabindex="3">

      <div class="css3-tab-nav">
            <label for='tabOne'>교육 환경</label>
            <label for='tabTwo'>라이브러리 소개</label>
            <label for='addNew'>오시는 길</label>
      </div>

      <div class='css3-tab-content tab-one'>
            <!-- start slipsum code -->
            <div align="center">
            <h1>교육 도서 비치</h1> 
            <img alt="소개 이미지" src="images/book1.png"><br />
            스터디룸에 교육용 도서 비치<br />
            
            
            <h2>프로젝트 참고 자료</h2> 
            <img alt="소개 이미지" src="images/book2.png"><br />
            인포데스크에 원생 프로젝트 자료 비치
            
            <h2>스터디 테이블</h2> 
            <img alt="소개 이미지" src="images/room.jpg"><br />
            학습용 스터디 룸 시설 완비
            </div>
            
      </div>

      <div class='css3-tab-content tab-two'>
            <!-- start slipsum code -->
            <h1 align="center">Library Introduce</h1> 
            <p align="center">
            이 페이지는 중앙HTA Library를 주제로 삼은 프로젝트 사이트입니다.
            </p>
            
            <div align="center" style="margin-top: 30px">
            <h2>
            
            <img alt="소개 이미지" src="images/intro_img.png">
            
            <h2>
            <span style="font: bold;">원내 도서 이용과 스터디룸 이용에 대한 사이트로 제작했습니다.</span>
            </div>
      </div>

      <div class='css3-tab-content add-new'>
            <!-- start slipsum code -->
            <div align="center">
            <img src="images/map.png" alt="오시는 길 네이버 지도">
            </div>
            <h2 align="center">교통편 소개</h2>
            <div align="center">
               <span align="center">주 소 : 서울특별시 종로구 율곡로10길 105 디아망 401호(봉익동 10-1 디아망 401호)</span><br /> 
               <span align="center">전화번호 : 070-8240-3211 </span><br />
               <span align="center">팩스번호 : 02-777-5407 </span><br />
               <span align="center">교통편 : 지하철 1,3,5호선 8번출구로 나오셔서 좌측 건너편</span><br />
               <span align="center">공영주차장 정산소에서 좌측골목 진입(도보 1분) 교육센터 주차는 불가하오며 필요시 공영주차장 이용(10분당 1,000원)</span><br />
            </div>
      </div>
</div>
  
</body>
<%@include file="/footer.jsp"%>
</html>