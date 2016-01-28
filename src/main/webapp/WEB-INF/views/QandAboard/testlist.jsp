<%@page import="mybatis.BoardManager"%>
<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.List" %>
<%@page import="com.hta.QandAboard.repository.BoardDto" %>
<!DOCTYPE html>
<%! 
	public String getParam(HttpServletRequest req, String pName){
		if(req.getParameter(pName) != null){
			return req.getParameter(pName);
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
<%
List list = BoardManager.getList();
totalRecord = BoardManager.getList().size();//게시판 전체 글수
System.out.println("testlist전체글수"+totalRecord);
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
<html>
<link href="css/boardstyle.css" rel="stylesheet" type="text/css">
<script>
	function check(){
		if(document.search.keyWord.value == ""){
			alert("검색어를 입력하세요.");
			document.search.keyWord.focus();
			return;
		}
		document.search.submit();
	}
	
	function testlist(){
		document.list.action="list.jsp";
		document.list.submit();
	}
	
	function read(b_num){
		document.read.b_num.value = b_num;
		document.read.submit();
	}
</script>
<body>
<center><br>
<h2>JSP Board</h2>

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
			<c:set var="list1" value="${list}"/>
			<c:if test="${list1 == null || list.isEmpty()}">
				<div style="color:red">등록된 글이 없습니다.</div>
			</c:if>
			<c:if test="${list1 != null }">
				
			
		
		<%	
			
				for(int i=beginPerPage; i<beginPerPage+numPerPage; i++){
					if(i == totalRecord){
						break;
					}
					
					BoardDto dto = (BoardDto)list.get(i);
					
					System.out.print("돌아가니???!!"+i);
		%>
				
				
			<tr>
				<td><%=dto.getB_num()%></td>
				<td><a href="read.board?b_seq='<%=dto.getB_num()%>'"><%=dto.getB_title()%></a></td>
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
<!-- 페이지 출력 -->
<tr>
	<td align="left">Go to Page 
		<%if(nowBlock > 0){ %>
			<a href="list.board?nowBlock=<%=nowBlock-1%>&nowPage=<%=pagePerBlock*(nowBlock-1)%>">이전 <%=pagePerBlock %>개</a>&nbsp;&nbsp;&nbsp;
		<%} %>
		
		<%
			for(int i=0; i<pagePerBlock; i++){
				if((nowBlock * pagePerBlock) + i == totalPage){
					break;
				}
		%>
				<a href="list.board?nowPage=<%=(nowBlock * pagePerBlock)+i%>&nowBlock=<%=nowBlock%>"><%=(nowBlock * pagePerBlock) + i+1%></a>&nbsp;&nbsp;&nbsp;
		<%
			}
		%>
		&nbsp;&nbsp;&nbsp;
		<%if(totalBlock > nowBlock+1){ %>
			<a href="list.board?nowBlock=<%=nowBlock+1%>&nowPage=<%=pagePerBlock*(nowBlock+1)%>">다음<%=pagePerBlock %>개</a>
		<%} %>
	</td>
	<td align=right>
		<a href="write.board">[글쓰기]</a>
		<a href="javascript:list.board">[처음으로]</a>
	</td>
</tr>
</table>

</body>
</html>