<%@ page language="java" contentType="text/html; charset=utf-8"
   isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Forte | About</title>
<meta charset="utf-8">
<!-- <link rel="stylesheet" href="css/normalize.css"> -->
<!-- <link rel="stylesheet" href="css/foundation.min.css" type="text/css"> -->
<!-- <link rel="stylesheet" href="css/superfish.css"> -->
<!-- <link rel="stylesheet" href="css/style.css" type="text/css"> -->
<link
   href='http://fonts.googleapis.com/css?family=PT+Sans+Caption|Open+Sans'
   rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/import.css" />
<script src="js/vendor/custom.modernizr.js"></script>
<script>
Modernizr.load({
    // test if browser understands media queries
    test: Modernizr.mq('only all'),
    // if not load ie8-grid
    nope: 'css/ie8-grid-foundation-4.css'
});
</script>
<!--[if lt IE 9]>
<link rel="stylesheet" href="css/ie-fixes.css">
<![endif]-->

</head>
<body>
<div class="footer">
      <div class="row">
         <div class="large-12 twelve columns">
            <div class="row">
               <div class="large-4 four small-12 columns">
                  <div class="contact" style="margin-right: 30px;">
                     <h3>contacts us</h3>
                     <a href="http://www.jhta.co.kr/"><img src="images/HTA-2.png"
                        alt="">
                        <div class="contact-icons">
                           <ul>
                              <li class="phone1 mobile">TEL: 070-8240-3211</li>
                              <li class="email">kse@jhta.co.kr</li>
                              <li class="phone2">TEL: 000-0000-0000</li>
                              <li class="fax">FAX: 02-777-5407</li>
                           </ul>
                        </div>
                        <p>사업자등록번호 104-81-59383 통신판매업신고번호 중구 065325 중앙HTA㈜ 서울특별시 종로구
                           율곡로10길 105 디아망 401호(봉익동 10-1 디아망 401호)</p>
                  </div>
                  <!--           <div class="social-icons">  불필요 부분 삭제 -->
                  <!--             <ul> -->
                  <!--               <li><a href="#">t</a></li> -->
                  <!--               <li><a href="#">f</a></li> -->
                  <!--               <li><a href="#">y</a></li> -->
                  <!--               <li><a href="#">p</a></li> -->
                  <!--               <li><a href="#">d</a></li> -->
                  <!--             </ul> -->
                  <!--           </div> -->
               </div>
               <div class="large-4 four small-12 columns">
                  <div class="information">
                     <h3>information</h3>
                     <ul>
                        <li><a href="#" onclick="window.open('http://www.q-net.or.kr/' , 'sample' , 'width=700,height=600' , 'location=no' , 'toolbar=no' )"> <h3>자격의 모든것Q-Net</h3></a></li>
                        <li><a href="#">phasellus etres solris nobita cumque
                              minus</a></li>
                        <li><a href="#">lorem ipsum dolor sit esmut sint
                              officia</a></li>
                        <li><a href="#">phasellus etres solris nobita cumque
                              minus</a></li>
                        <li><a href="#">lorem ipsum dolor sit esmut sint
                              officia</a></li>
                        <li><a href="#">phasellus etres solris nobita cumque
                              minus</a></li>
                        <li><a href="#">lorem ipsum dolor sit esmut sint
                              officia</a></li>
                        <li><a href="#">phasellus etres solris nobita cumque
                              minus</a></li>
                        <li><a href="#">lorem ipsum dolor sit esmut sint
                              officia</a></li>
                     </ul>
                  </div>
               </div>
               <div class="large-4 four small-12 columns">
                  <div class="quick-contacts" style="margin-left: 30px">
                     <h3>quick contacts</h3>
                     <form action="#" method="post" class="quick-contact-form">
                        <table>
                           <tr>
                              <td><input type="text" name="name" placeholder="Name:"></td>
                           </tr>
                           <tr>
                              <td><input type="text" name="email" placeholder="Email:"></td>
                           </tr>
                           <tr>
                              <td><input type="text" name="subject"
                                 placeholder="Subject:"></td>
                           </tr>
                           <tr>
                              <td><textarea name="message" placeholder="Message:"></textarea></td>
                           </tr>
                           <tr>
                              <td style="text-align: right;"><input type="submit"
                                 name="submit" value="Submit"></td>
                           </tr>
                        </table>
                     </form>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <div class="theme-credits">
         <p>
            &copy; 2045 All rights reserved by <a href="#">Forte.</a> Design by:
            <a href="http://topwebsitetemplates.org">topwebsitetemplates.org</a>
         </p>
      </div>
   </div>
   <div id="recaptcha_container"></div>
   <script src="js/jquery.min.js"></script>
   <script src="js/superfish.js"></script>
   <script src="js/hoverIntent.js"></script>
   <script src="js/slider/jquery.flexslider.js"></script>
   <script src="js/slider/jquery.testimonialslider.js"></script>
   <script>
Modernizr.load({
    test: Modernizr.placeholder,
    nope: 'js/placeholder.min.js'
});
function goToNewPage() {
    if (document.getElementById('target').value) {
        window.location.href = document.getElementById('target').value;
    }
}
</script>
   <script>
$(document).ready(function () {
    $('ul.sf-menu').superfish({
        animation: {
            height: 'show'
        },
        delay: 400
    });
    $('.flexslider').flexslider({
        animation: "slide"
    });
    $('.testimonialslider').testimonialslider({
        animation: "fade",
        animationLoop: false,
        itemMargin: 50,
        itemMargin: 0,
        maxItems: 1,
        after: function (slider) {
            var currentSlide = parseInt(slider.currentSlide);
            var currentSlide = parseInt(slider.currentSlide);
            var currentSlideHeight = $('.testimonialslider ul.slides').find('li').eq(currentSlide).css('height');
            $('.testimonialslider ul.slides').animate({
                height: currentSlideHeight
            }, 100);
        }
    });
});
</script>

</body>
</html>

</body>
</html>