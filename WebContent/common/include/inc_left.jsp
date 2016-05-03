<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="java.util.*, java.net.*, java.text.*, java.io.*, org.slf4j.*,org.apache.ibatis.session.*"%>
<%@page
	import="org.apache.commons.lang3.*, org.apache.commons.lang3.math.*, org.apache.commons.lang3.time.*, org.json.simple.*"%>
<%@page import="com.eucom.util.*, com.eucom.dao.*"%>

<div class="col-sm-2 sidenav">
	<section class="login_wrap">
		<div class="login">
			<form name="logForm" id="logForm">
				<%if (SESS_USER_SEQ == 0 || SESS_ID.equals("")) {%>
				<div class="1_login_form">
					<input type="text" name="id" id="id" placeholder="아이디"> <input
						type="password" name="pw" id="pw" placeholder="비밀번호">
				</div>
				<div>
					<button type="button" class="bt_1_login"
						onclick="javascript:login()">로그인</button>
				</div>
				<div class="logText2">
					<a href="../join.do">회원가입</a>
				</div>
				<br>
				<br>
				<%
				    }
				%>
			</form>
		</div>

		<%if (topCode.equals("A") || topCode == null) { %>
		<div class="leftMenu"><a href="#">자유게시판</a></div>			
		<div class="logText2"><a href="../complain.eu">신문고</a></div>
		<div class="logText2"><a href="#">연애상담</a></div>
		<div class="logText2"><a href="#">제휴정보</a></div>
		</div>
		<% } else if (topCode.equals("B")) { %>
			
			 <div class="list-group">
			<a class="list-group-title">
			<h4>소식홍보</h4>
			<p>about eulji	</p>
			</a>
           	<div class="notice_a"><a href="../noticeSchoolNewsList.no" class="list-group-item active">학교뉴스</a></div>
			<div class="notice_b"><a href="../noticeSchoolTime.no" class="list-group-item">학사일정</a></div>
			<div class="notice_c"><a href="../noticeParty.no" class="list-group-item">동아리소개</a></div>
			<div class="notice_d"><a href="../noticeSchoolFood.no" class="list-group-item">학식정보</a></div>
          </div>
          
		
			<%
			    } else if (topCode.equals("C")) {
			%>
			<div class="leftMenu">
				<div class="logText2">
					<a href="#">-</a>
				</div>
			</div>
			<%
			    } else if (topCode.equals("D")) {
			%>
			<div class="leftMenu">
				<div class="logText2">
					<a href="#">-</a>
				</div>
			</div>
			<%
			    } else if (topCode.equals("E")) {
			%>
			<div class="leftMenu">
				<div class="logText2">
					<a href="#">-</a>
				</div>
			</div>
			<%
			    } else if (topCode.equals("M")) {
			%>
			<div class="leftMenu">
				<div class="logText2"><a href="../user.eu">계정관리</a></div>
			</div>
			<%
			    }
			%>
		
	</section>

</div>


