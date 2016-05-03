<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, java.net.*, java.text.*, java.io.*, org.slf4j.*,org.apache.ibatis.session.*"%>
<%@page import="org.apache.commons.lang3.*, org.apache.commons.lang3.math.*, org.apache.commons.lang3.time.*, org.json.simple.*"%>
<%@page import="com.eucom.util.*, com.eucom.dao.*"%>
<%
	
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragma","no-cache");
	response.setDateHeader("Expires",0);
	
	request.setCharacterEncoding("UTF-8"); 
		
  	Logger logger = LoggerFactory.getLogger(getClass());

  	
	/////////////////////////////////////////////////////////////////////////////
	// 세션 검사
	/////////////////////////////////////////////////////////////////////////////  
	int SESS_USER_SEQ 		= NumberUtils.toInt(String.valueOf(WebUtils.getSessionAttribute(request, "USER_SEQ"))) ;
	int SESS_STUDENT_NUM 	= NumberUtils.toInt(String.valueOf(WebUtils.getSessionAttribute(request, "STUDENT_NUM"))) ;
	String SESS_ID 			= StringUtils.trimToEmpty((String)WebUtils.getSessionAttribute(request, "ID")) ;
	String SESS_NAME 		= StringUtils.trimToEmpty((String)WebUtils.getSessionAttribute(request, "NAME")) ;
	String SESS_KIND 		= StringUtils.trimToEmpty((String)WebUtils.getSessionAttribute(request, "KIND")) ; 
	String SESS_MAJOR	= StringUtils.trimToEmpty((String)WebUtils.getSessionAttribute(request, "MAJOR")) ;	
	
	
	 
	System.out.println("SESS_USER_SEQ ------------>"+ SESS_USER_SEQ);
	System.out.println("SESS_USER_SEQ ------------>"+ SESS_NAME  );
	
	String topCode = (String)request.getAttribute("topCode");
	String subCode = (String)request.getAttribute("subCode");
 
	System.out.println("topCode ------------>"+ topCode  );
	System.out.println("subCode ------------>"+ subCode  );
	
	 String FileUploadPath = PropertiesUtil.getProperites("FileUploadPath");
	
	System.out.println("FileUploadPath ------------>"+ FileUploadPath  );
	
%>