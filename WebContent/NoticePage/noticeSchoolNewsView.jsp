<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/include/inc_common.jsp"%>

<%
    HashMap<String,Object> newsMap =  (HashMap<String,Object>)request.getAttribute("newsMap");
%>

<%@ include file="/common/include/inc_header.jsp"%>

<script type="text/javascript">
	function goModify(seq) {
		$("#seq").val(seq);
		$("#order").val("MODIFY");

		$("#frm").attr("method", "post");
		//$("#frm").attr("target", "submit_iframe");
		$("#frm").attr("action", "../notice.no");

		$("#frm").submit();
	}
</script>
</head>
<body>
	<div class="container">

		<%@ include file="/common/include/inc_top.jsp"%>

		<div class="container-fluid text-center">
			<div class="row content">

				<%@ include file="/common/include/inc_left.jsp"%>

				<form name="frm" id="frm">
					<input type="hidden" name="seq" id="seq"> <input
						type="hidden" name="order" id="order">

					<div class="col-md-9 cont">
						<h2>회원 내용</h2>
						<br>

						<table class="table table-bordered">
							<tr>
								<th>제목</th>
								<td><%=newsMap.get("NEWS_TITLE")%></td>
							</tr>

							<tr>
								<th>내용</th>
								<td><%=newsMap.get("NEWS_CONTENT")%></td>
							</tr>

						</table>


						<input type="button" value="수정" class="myButton"
							onclick="javascript:goModify('<%=newsMap.get("NEWS_SEQ")%>')">
						<input type="button" value="목록" class="myButton"
							onclick="location.href='../noticeSchoolNewsList.no';">

					</div>
				</form>
			</div>
			<%@ include file="/common/include/inc_right.jsp"%>
		</div>
		<%@ include file="/common/include/inc_footer.jsp"%>
	</div>

</body>
</html>
