<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/include/inc_common.jsp"%>

<%@ include file="/common/include/inc_header.jsp"%>

<script type="text/javascript">
	function regist(seq) {
		$("#seq").val(seq);
		$("#order").val("REGIST");
		$("#NoticeAddNews").attr("method", "post");
		//$("#frm").attr("target", "submit_iframe");
		$("#NoticeAddNews").attr("action", "../notice.no");

		$("#NoticeAddNews").submit();
	}
</script>

</head>
<body>
	<div class="container">

		<%@ include file="/common/include/inc_top.jsp"%>

		<div class="container-fluid text-center">
			<div class="row content">

				<%@ include file="/common/include/inc_left.jsp"%>
				
				<form name="NoticeAddNews" id="NoticeAddNews">
		 
				<input type="hidden" name="seq" id="seq" >
    	    	<input type="hidden" name="order" id="order" >
					<div class="col-sm-8 text-left">
						<h2>학교 뉴스</h2>
						<br>

						<table style="width: 75%;">
						<tr>
							<td>제목</td>
							<td><input type="text" name="news_title" id="news_title"
								size="70" " /></td>
							<tr>
							<td>내용</td>
							<td><textarea name="news_content" id="news_content"
									rows="20" style="width: 100%;"></textarea></td>
						</tr>
						<tr>
							<td align=center colspan=2><input type="button" value="등록"
								onclick="javascript:regist()" class="myButton"></td>
						</tr>
					</table>
					</div>
				</form>
				<%@ include file="/common/include/inc_right.jsp"%>
			</div>
			<%@ include file="/common/include/inc_footer.jsp"%>
		</div>
	</div>


				
		
</body>
</html>