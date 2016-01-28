<!DOCTYPE html>
<!--[if lt IE 7]><html class="lt-ie9 lt-ie8 lt-ie7"><![endif]-->
<!--[if IE 7]><html class="lt-ie9 lt-ie8"><![endif]-->
<!--[if IE 8]><html class="lt-ie9"><![endif]-->
<!--[if gt IE 8]><!--><html><!--<![endif]-->
<head>
<title>Forte | Blog</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/foundation.min.css" type="text/css">
<link rel="stylesheet" href="css/superfish.css">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link href='http://fonts.googleapis.com/css?family=PT+Sans+Caption|Open+Sans' rel='stylesheet' type='text/css'>
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
<div class="call top-call-to-action">
  <div class="row">
    <div class="large-12 columns">
      <div class="social-icons">
        <ul>
          <li><a href="#">t</a></li>
          <li><a href="#">f</a></li>
          <li><a href="#">y</a></li>
          <li><a href="#">p</a></li>
          <li><a href="#">d</a></li>
        </ul>
      </div>
      <span>1800809000</span> </div>
  </div>
</div>
<div class="header">
  <div class="row">
    <div class="large-12 twelve columns">
      <div class="logo"><a href="index.jsp"> <img src="images/logo.png" alt=""></a> </div>
    </div>
  </div>
</div>
<div class="topmenu">
  <div class="row">
    <div class="large-12 twelve columns hide-for-small">
      <ul class="sf-menu">
        <li><a href="index.jsp">Home</a></li>
        <li><a href="about.jsp">About Us</a></li>
        <li><a href="gallery.jsp">Gallery</a></li>
        <li><a href="contact.jsp">Contact Us</a>
          <ul class="dropdown">
            <li><a href="#">Dropdown Level 1a</a>
              <ul>
                <li><a href="#">Dropdown Level 2a</a></li>
                <li><a href="#">Dropdown Level 2b</a></li>
              </ul>
            </li>
            <li><a href="#">Dropdown Level 1b</a></li>
            <li><a href="#">Dropdown Level 1c</a></li>
            <li><a href="#">Dropdown Level 1d</a></li>
            <li><a href="#">See all &rarr;</a></li>
          </ul>
        </li>
        <li><a href="blog.jsp">Blog</a></li>
      </ul>
    </div>
    <div class="large-12 twelve columns show-for-small">
      <form name="dropdown" action="#">
        <select name="selected" id="target" accesskey="E" onChange="goToNewPage(document.dropdown.selected)">
          <option value="index.jsp">Home</option>
          <option value="about.jsp">About Us</option>
          <option value="gallery.jsp">Gallery</option>
          <option value="contact.jsp">Contact Us</option>
          <option value="blog.jsp">Blog</option>
        </select>
      </form>
    </div>
  </div>
</div>
<div class="content-sub-page">
  <div class="row">
    <div class="large-12 twelve columns">
      <div class="blog-container">
        <div class="row">
          <div class="large-7 eight columns">
            <h1 class="page-title">Blog Posts</h1>
            <p>Egestas aliquam vel ultrices integer, ut sit pellentesque, et montes, turpis phasellus mauris porta parturient platea pulvinar risus, lectus? Pid! Elementum sociis nunc sit! Dolor in eu ut placerat pellentesque, platea est risus etiam, dolor! Nec, penatibus odio scelerisque elementum pulvinar urna, dis nec vel nunc ut mid! In eros magna vel urna a platea proin, in tortor ultricies, et egestas amet, pellentesque ac, sit est ac integer ut cum porttitor penatibus, sed purus odio! Mauris nec? Quis, facilisis, tempor magna in vel lacus, cras risus, vel montes penatibus ultrices, aenean penatibus, nec lectus lacus penatibus? Egestas duis. Diam phasellus, integer in etiam sociis porta turpis proin in? Ridiculus! Turpis mauris placerat. Tincidunt in scelerisque diam mus egestas? Augue mauris. Augue etiam. Porta? Cum sed platea, nunc elit ultricies phasellus auctor augue aliquam tempor. Amet velit, adipiscing sed ac dictumst penatibus aliquam, parturient, purus. Enim nec augue mauris elementum cras.</p>
            <p>Dolor amet amet lectus phasellus, dolor aliquam. Nascetur arcu urna placerat, mid, elit adipiscing parturient nec ac dolor amet. Velit? Augue enim nisi phasellus velit, sit nunc elit natoque lacus, mus et ac vut mattis? Eu pulvinar pulvinar et, in habitasse, lundium, ridiculus? Arcu, ultrices, amet augue, ac pulvinar urna cum, turpis pid, eu. Ac porttitor, ut aliquam in? Ridiculus ac. Urna augue pid tortor porttitor vut, amet, enim ut turpis, sociis dignissim, augue sit porta scelerisque, in lectus aliquam vut habitasse ac? Rhoncus, placerat! Eros nec tincidunt ultrices scelerisque lorem. Sed diam mauris diam egestas? Amet in, mauris, nunc sociis scelerisque, sed eu, et mus, pulvinar, velit et facilisis lacus a aliquam non ut, sit porta? Diam ultricies? Placerat ut auctor urna adipiscing sit, quis rhoncus pulvinar integer sed proin? Porta penatibus magna, elementum, lorem nisi, elit adipiscing, mauris, porta egestas pid, vut sed arcu tristique, rhoncus sit.</p>
          </div>
          <div class="large-4 four columns sidebar">
            <h1 class="page-title services">Our Services</h1>
            <ul>
              <li class="bullet"><a href="#">Purus magnis augue adipiscing mid magna</a></li>
              <li class="bullet"><a href="#">Amet dignissim natoque, dignissim lacus</a></li>
              <li class="bullet"><a href="#">Purus magnis augue adipiscing mid magna</a></li>
              <li class="bullet"><a href="#">Amet dignissim natoque, dignissim lacus</a></li>
              <li class="bullet"><a href="#">Purus magnis augue adipiscing mid magna</a></li>
              <li class="bullet"><a href="#">Amet dignissim natoque, dignissim lacus</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<div class="footer">
  <div class="row">
    <div class="large-12 twelve columns">
      <div class="row">
        <div class="large-4 four small-12 columns">
          <div class="contact">
            <h3>contacts us</h3>
            <img src="images/contact-us.png" alt="">
            <div class="contact-icons">
              <ul>
                <li class="phone1 mobile">(342)908898</li>
                <li class="email">email@domain.com</li>
                <li class="phone2">1800809000</li>
                <li class="fax">(132)1239040</li>
              </ul>
            </div>
            <p>15 Willson Street Oakliegh, 2211, Melbourne,Victoria, Australia</p>
          </div>
          <div class="social-icons">
            <ul>
              <li><a href="#">t</a></li>
              <li><a href="#">f</a></li>
              <li><a href="#">y</a></li>
              <li><a href="#">p</a></li>
              <li><a href="#">d</a></li>
            </ul>
          </div>
        </div>
        <div class="large-4 four small-12 columns">
          <div class="information">
            <h3>information</h3>
            <ul>
              <li><a href="#">lorem ipsum dolor sit esmut sint officia</a></li>
              <li><a href="#">phasellus etres solris nobita cumque minus</a></li>
              <li><a href="#">lorem ipsum dolor sit esmut sint officia</a></li>
              <li><a href="#">phasellus etres solris nobita cumque minus</a></li>
              <li><a href="#">lorem ipsum dolor sit esmut sint officia</a></li>
              <li><a href="#">phasellus etres solris nobita cumque minus</a></li>
              <li><a href="#">lorem ipsum dolor sit esmut sint officia</a></li>
              <li><a href="#">phasellus etres solris nobita cumque minus</a></li>
              <li><a href="#">lorem ipsum dolor sit esmut sint officia</a></li>
            </ul>
          </div>
        </div>
        <div class="large-4 four small-12 columns">
          <div class="quick-contacts">
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
                  <td><input type="text" name="subject" placeholder="Subject:"></td>
                </tr>
                <tr>
                  <td><textarea  name="message" placeholder="Message:"></textarea></td>
                </tr>
                <tr>
                  <td style="text-align:right;"><input type="submit" name="submit" value="Submit"></td>
                </tr>
              </table>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="theme-credits">
    <p>&copy; 2045 All rights reserved by <a href="#">Forte.</a> Design by: <a href="http://topwebsitetemplates.org">topwebsitetemplates.org</a></p>
  </div>
</div>
<div id="recaptcha_container"></div>
<script src="js/jquery.min.js"></script>
<script src="js/superfish.js"></script>
<script src="js/hoverIntent.js"></script>
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
});
</script>
</body>
</html>