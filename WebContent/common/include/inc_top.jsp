<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*, java.net.*, java.text.*, java.io.*, org.slf4j.*,org.apache.ibatis.session.*"%>
<%@page import="org.apache.commons.lang3.*, org.apache.commons.lang3.math.*, org.apache.commons.lang3.time.*, org.json.simple.*"%>
<%@page import="com.eucom.util.*, com.eucom.dao.*"%>

<div class="jumbotron text-center" >
	<h1>Eulji</h1>
</div>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<!--  div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="../main.do" id="topText">HOME</a>
		</div -->
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
			    <li <%=topCode.equals("") ? "class='active'" : ""%> ><a class="navbar-brand" href="../main.do" id="topText">HOME</a></li>
				<li <%=topCode.equals("A") ? "class='active'" : ""%> ><a href="../complain.eu" id="topText">커뮤니티</a></li>
				<li <%=topCode.equals("B") ? "class='active'" : ""%>><a href="../notice.eu" id="topText">소식홍보</a></li>
				<li <%=topCode.equals("C") ? "class='active'" : ""%>><a href="#" id="topText">취업진로</a></li>
				<li <%=topCode.equals("D") ? "class='active'" : ""%>><a href="#" id="topText">강의정보</a></li>
				<li <%=topCode.equals("E") ? "class='active'" : ""%>><a href="#" id="topText">생활정보</a></li>
				<li <%=topCode.equals("M") ? "class='active'" : ""%>><a href="../user.eu" id="topText">&nbsp;&nbsp;&nbsp;&nbsp;관리&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
			</ul>
			<%if(SESS_USER_SEQ!=0 && !SESS_ID.equals("") ){ %>
			 <br>
			 <span class="topSpan"> 
			   <a id="topText2"><%=SESS_NAME %>(<%=SESS_ID %>)님이 접속중입니다.</a>&nbsp;&nbsp; 
		       <input type="button" value="로그아웃" onclick="javascript:logOut()" class="logOutBtn">
		     </span>
			<%} %>
		</div>
	</div>
</nav>