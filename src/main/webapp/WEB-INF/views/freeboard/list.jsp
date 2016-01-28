<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="mybatis.freeBoardManager"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.List" %>
<%@page import="com.hta.freeboard.repository.BoardDto" %>
<%@include file="/header.jsp"%>
<!-- 정의부분, freeboard는 공지사항이다.!!!!!!!!!!!!!!!!!!! -->

<%! 
	public String getParam(HttpServletRequest req, String pName){
		if(req.getParameter(pName) != null){
			return req.getParameter(pName); //pName은 요청된 keyWord이다. 
		}
		else{
			return "";
		}
	}
int totalRecord = 0;//게시판 전체글수
int numPerPage = 5;//한페이지에 보일 게시글수
int totalPage = 0;//최대페이지
int nowPage = 0;//현재 페이지
int beginPerPage = 0;//시작페이지
int pagePerBlock = 3;//블록 당 페이지
int totalBlock = 0;//전체 블록
int nowBlock = 0;//현재 블록
%>

<!-- 소스부분 -->

<%
request.setCharacterEncoding("utf-8");
BoardDto dto1 = (BoardDto)request.getAttribute("dto");// 컨트롤에 집어넣은 dto를 불러온다. jsp에...
System.out.println("세션 저장되었나욤"+dto1.getKeyWord());
String keyField = request.getParameter("keyField");//jsp에 입력된 keyField와 keyWord를 가져온다.
String keyWord = request.getParameter("keyWord");
System.out.println("나오라"+ keyField);
System.out.println("나오라"+ keyWord);
if(keyField == null){
	keyField = "b_writer";
}
System.out.println("keyField는 무엇일까요??"+ keyField);
String reload = request.getParameter("reload");
if(reload != null){
	if(reload.equals("true")){
		keyWord = "";
	}
}
System.out.println("1여기까지가 끝이가보오... ");
List list=null;//우선 리스트 생성
//System.out.println("freeBoardManager.getList()의 값은>?"+freeBoardManager.getList());
System.out.println("2여기까지가 끝이가보오... ");
%>
	<c:if test="${list != null}"><!-- list가 null이 아닐때 밑에 부분 소스가 실행되게 한다. 이유는 freeBoardManager.getList() jasperException 예외에러가 나기때문이다. -->
<%
	if(keyWord==null){ //keyWord를 입력하지 않았을때, 즉, 처음이거나 입력하지 않을때 null일면 
		list = freeBoardManager.getList();//list에 DB에 저장된 리스트들을 넣는다.
		System.out.println("3여기까지가 끝이가보오... ");
	}
	else{//keyWord가 입력되었다는 뜻
		list = freeBoardManager.findKeyword(dto1);//그땐 list에 덮어씨운다. 찾는 DB(findKeyword())를 통해 찾은 list를 덮어씨운다.
	}
%>
	</c:if>
<% 
	if(list != null){
		totalRecord = list.size();//게시판 전체 글수
	}
	else{
		totalRecord = 0;
	}
System.out.println("list전체글수");
totalPage = (int)Math.ceil(((double)totalRecord/numPerPage));//전체페이지=게시판전체글수 / 한페이지에 보일 게시글수(5)
if(request.getParameter("nowPage") != null){//현재 페이지
	nowPage = Integer.parseInt(request.getParameter("nowPage"));
}
if(request.getParameter("nowBlock") != null){//현재 블록
	nowBlock = Integer.parseInt(request.getParameter("nowBlock"));
}
beginPerPage = nowPage * numPerPage;//시작페이지=현재 페이지 * 한페이지에 보일 게시글수(5)
totalBlock = (int)Math.ceil(((double)totalPage/pagePerBlock));//전체블록=전체페이지 / 블록당페이지
%>
<script>
Modernizr.load({
    // test if browser understands media queries
    test: Modernizr.mq('only all'),
    // if not load ie8-grid
    nope: 'css/ie8-grid-foundation-4.css'
});
function check(){
	if(document.search.keyWord.value == ""){
		alert("검색어를 입력하세요.");
		document.search.keyWord.focus();
		return;
	}
	document.search.submit();
}
</script>
<!--[if lt IE 9]>
<link rel="stylesheet" href="css/ie-fixes.css">
<![endif]-->
</head>
<body>

<div class="content-sub-page">
  <div class="row">
    <div class="large-12 twelve columns">
      <div class="blog-container">
        <div class="row">
          <center><br>
			<h2>공지사항</h2>
			
			<table align=center border=0 width=80%>
			<tr>
				<td align=left>Total :  <%=totalRecord%> Articles(
					<font color=red>  <%=nowPage+1%> / <%=totalPage%> Pages </font>)
				</td>
			</tr>
			</table>
			
			<table align=center width=80% border=0 cellspacing=0 cellpadding=3>
			<tr>
				<td align=center colspan=2>
					<table border=0 width=100% cellpadding=2 cellspacing=0>
						<tr align=center bgcolor=#D0D0D0 height=120%>
							<td> 번호 </td>
							<td> 제목 </td>
							<td> 이름 </td>
							<td> 날짜 </td>
							<td> 조회수 </td>
						</tr>
						<c:set var="list1" value="${list}"/><!-- jstl로 list1이라는 변수를 만들어서 전체 리스트를 자진 list를 집어넣는다.(기존 소스에서 변환시킴) -->
						<c:if test="${list1 == null || list.isEmpty()}"><!-- list1이 null이거나 isEmpty 즉, 비어있으면 등록된 글이 없습니다.로 출력 -->
							<div style="color:red">등록된 글이 없습니다.</div>
						</c:if>
						<c:if test="${list1 != null }"><!-- list1이 null이 아니라면!! 밑에 리스트 출력소스 실행 -->
					
					<%	
						
							for(int i=beginPerPage; i<beginPerPage+numPerPage; i++){
								if(i == totalRecord){
									break;
								}
								
								BoardDto dto = (BoardDto)list.get(i);//이쪽도 기존소스와 다른부분이다. 
								//여기서 dto는 임시 저장하는 역할이며 i는 선택된 리스트인것 같다. 그래서 페이지를 선택할때 알고리즘에 따라 출력할 리스트 수에 따라 list에 있는 리스트들을 가져온다. 그후 dto에 임시 저장한다.
								//그리고 밑에 dto에 저장되있는 출력할 리스트들을 출력한다. 
								System.out.println("돌아가니???!!"+i);
					%>
							
						<!-- 실제 출력하는 부분 -->	
						<tr>
							<td><%=dto.getB_num()%></td>
							<td><a href="read.board1?b_seq=<%=dto.getB_num()%>"><%=dto.getB_title()%></a></td>
							<td><%=dto.getB_writer()%></td>
							<td><%=dto.getB_date() %></td>
							<td><%=dto.getB_count() %></td>
						</tr>
					<%
						
							}
						
					%>
					</c:if>
					</table>
				</td>
			</tr>
			<tr>
				<td><BR><BR></td>
			</tr>
			<!-- 페이지 출력 : 여기서 기존 리스트 페이지와 다르게 list.board1을 get방식으로 갈때 bool=false값을 줘야한다. -->
			<tr>
				<td align="left">Go to Page 
					<%if(nowBlock > 0){ %>
						<a href="list.board1?nowBlock=<%=nowBlock-1%>&nowPage=<%=pagePerBlock*(nowBlock-1)%>&bool=false">이전 <%=pagePerBlock %>개</a>&nbsp;&nbsp;&nbsp;
					<%} %>
					
					<%
						for(int i=0; i<pagePerBlock; i++){
							if((nowBlock * pagePerBlock) + i == totalPage){
								break;
							}
					%>
							<a href="list.board1?nowPage=<%=(nowBlock * pagePerBlock)+i%>&nowBlock=<%=nowBlock%>&bool=false"><%=(nowBlock * pagePerBlock) + i+1%></a>&nbsp;&nbsp;&nbsp;
					<%
						}
					%>
					&nbsp;&nbsp;&nbsp;
					<%if(totalBlock > nowBlock+1){ %>
						<a href="list.board1?nowBlock=<%=nowBlock+1%>&nowPage=<%=pagePerBlock*(nowBlock+1)%>&bool=false">다음<%=pagePerBlock %>개</a>
					<%} %>
				</td>
				<td align=right>
					<c:if test="${email=='admin@hta.co.kr'}">
					<a href="write.board1">[글쓰기]</a>
					</c:if>
					<a href="javascript:history.back()">[처음으로]</a>
				</td>
			</tr>
			</table>
		<!-- 찾기 기능 -->	
			<BR>
<form action="list.board11?page=0&bool=false" name="search" method="GET">
	<table border=0 width=527 align=center cellpadding=4 cellspacing=0>
	<tr>
		<td align=center valign=bottom>
			<select name="keyField" size="1">
				<option value="b_writer" <%if(keyField.equals("b_writer")){%> selected="selected" <%}%>> 이름
				<option value="b_title" <%if(keyField.equals("b_title")){%> selected="selected" <%}%>> 제목
				<option value="b_content" <%if(keyField.equals("b_content")){%> selected="selected" <%}%>> 내용
			</select>

			<input type="text" size="16" name="keyWord" value="<%=getParam(request, "keyWord")%>" />
			<input type="button" value="찾기" onClick="check()">
			
		</td>
	</tr>
	</table>
</form>

<form name="list" method="post">
	<input type="hidden" name="reload" value="true" />
</form>

</center>	
</div>
</div>
</div>
</div>
</div>
</body>

<%@include file="/footer.jsp"%>        