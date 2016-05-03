<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/include/inc_common.jsp"%>

<%
    ArrayList<HashMap<String,Object>> noticeList =  
      (ArrayList<HashMap<String,Object>>)request.getAttribute("noticelist");
%>

<%@ include file="/common/include/inc_header.jsp"%>

<script type="text/javascript">
	function detail(seq) {
		$("#seq").val(seq);
		$("#order").val("VIEW");

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

					<div class="col-sm-8 text-left">
						<h2>학교 뉴스</h2>
						<br>

						<table class="table table-bordered">
							<%
							    if (noticeList.size() == 0) {
							%>
							<tr>
								<td colspan="6">조회된 내용이 없습니다</td>
							</tr>
							<%
							    } else {

									String NEWS_SEQ = "";
									String NEWS_TITLE = "";
									String NEWS_CONTENT = "";

									for (int i = 0; i < noticeList.size(); i++) {

									    NEWS_SEQ = StringUtils.trimToEmpty(String
										    .valueOf(noticeList.get(i).get("NEWS_SEQ")));
									    NEWS_TITLE = StringUtils.trimToEmpty(String
										    .valueOf(noticeList.get(i).get("NEWS_TITLE")));
									    NEWS_CONTENT = StringUtils.trimToEmpty(String
										    .valueOf(noticeList.get(i).get("NEWS_CONTENT")));
							%>
							<tr>

								<td><a href="javascript:detail('<%=NEWS_SEQ%>')"><%=NEWS_SEQ%></a></td>
								<td><%=NEWS_TITLE%></td>
								<td><%=NEWS_CONTENT%></td>

							</tr>

							<%
							    }
							    }
							%>

						</table>
						<a href="../noticeSchoolNewsWrite.no" class="myButton">글쓰기</a>
					</div>
				</form>
				<%@ include file="/common/include/inc_right.jsp"%>
			</div>
			<%@ include file="/common/include/inc_footer.jsp"%>
		</div>
		</div>
</body>
</html>



