package com.eucom.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eucom.dao.EuNoticeDAO;
import com.eucom.dao.EuUserDAO;

public class EuNoticeAction implements Action {

    private String topCode = "B";
    private String subCode = "a";

    EuNoticeDAO noticeDao = new EuNoticeDAO();

    // 소식홍보는 B
    // 세부순서는 공지사항 a 학사일정 b 동아리홍보 c 학식 d
    @Override
    public ActionForward execute(HttpServletRequest request,
	    HttpServletResponse response) throws Exception {

	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

	System.out.println("여기로 이동했을거야");

	PrintWriter out = response.getWriter();

	request.setAttribute("topCode", topCode);
	request.setAttribute("subCode", subCode);

	try {

	    HashMap<String, Object> hMap = new HashMap<String, Object>();

	    ArrayList<HashMap<String, Object>> noticeList = noticeDao
		    .selectNoticeNewsList(hMap);

	    request.setAttribute("noticelist", noticeList);

	} catch (Exception e) {

	}

	ActionForward forward = new ActionForward();
	forward.setRedirect(false);
	System.out.println("1");

	forward.setPath("/NoticePage/noticeSchoolNewsList.jsp");
	System.out.println("2");

	return forward;

    }

    @Override
    public ActionForward actionView(HttpServletRequest request,
	    HttpServletResponse response) throws Exception {
	// TODO Auto-generated method stub
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

	PrintWriter out = response.getWriter();
	

	request.setAttribute("topCode", topCode);
	request.setAttribute("subCode", subCode);
	String seq = request.getParameter("seq");
	String order = request.getParameter("order");

	int rtn = 0;

	try {

		

		HashMap<String, Object> hMap = new HashMap<String, Object>();

		hMap.put("NEWS_SEQ", seq);

		HashMap<String, Object> newsMap = noticeDao.selectNoticeNewsOne(hMap);

		request.setAttribute("newsMap", newsMap);

	} catch (Exception e) {

	}

	ActionForward forward = new ActionForward();
	forward.setRedirect(false);
	if(order.equals("VIEW")){
	 	   forward.setPath("/NoticePage/noticeSchoolNewsView.jsp");
	}else if(order.equals("MODIFY")){
	 	   forward.setPath("/NoticePage/noticeSchoolNewsModify.jsp");
	}
	return forward;
    }

    @Override
    public ActionForward actionWrite(HttpServletRequest request,
	    HttpServletResponse response) throws Exception {
	// TODO Auto-generated method stub
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

	PrintWriter out = response.getWriter();

	request.setAttribute("topCode", topCode);
	request.setAttribute("subCode", subCode);
	String seq = request.getParameter("seq");
	String order = request.getParameter("order");

	String news_title = request.getParameter("news_title");
	String news_content = request.getParameter("news_content");

	System.out.println("news_title  ==> " + news_title);
	System.out.println("news_content  ==> " + news_content);

	int rtn = 0;

	try {

	    HashMap<String, Object> hMap = new HashMap<String, Object>();

	    hMap.put("NEWS_TITLE", news_title);
	    hMap.put("NEWS_CONTENT", news_content);

	    rtn = noticeDao.insertNoticeNews(hMap);

	    ArrayList<HashMap<String, Object>> noticeList = noticeDao
		    .selectNoticeNewsList(hMap);

	    request.setAttribute("noticelist", noticeList);

	} catch (Exception e) {

	}
	System.out.println("rtn : " + rtn);

	ActionForward forward = new ActionForward();
	System.out.println("1");

	forward.setRedirect(false);

	if (order.equals("REGIST")) {
	    forward.setPath("/NoticePage/noticeSchoolNewsList.jsp");
	}
	System.out.println("2");
	if (rtn != 0) {

	    System.out.println("3");
	    System.out.println("4");
	}
	System.out.println("5");
	return forward;
    }

    @Override
    public ActionForward actionModify(HttpServletRequest request,
	    HttpServletResponse response) throws Exception {
	// TODO Auto-generated method stub
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

	PrintWriter out = response.getWriter();
	request.setAttribute("topCode", topCode);
	request.setAttribute("subCode", subCode);
	String seq = request.getParameter("seq");
	String order = request.getParameter("order");

	String news_title = request.getParameter("news_title");
	String news_content = request.getParameter("news_content");

	int rtn = 0;

	try {

	    HashMap<String, Object> hMap = new HashMap<String, Object>();

	    hMap.put("NEWS_SEQ", seq);
	    hMap.put("NEWS_TITLE", news_title);
	    hMap.put("NEWS_CONTENT", news_content);

	    rtn = noticeDao.updateNoticeNews(hMap);
	    System.out.println("업데이트 결과 : " + rtn);

	    ArrayList<HashMap<String, Object>> noticeList = noticeDao
		    .selectNoticeNewsList(hMap);

	    request.setAttribute("noticelist", noticeList);

	} catch (Exception e) {

	}

	ActionForward forward = new ActionForward();
	forward.setRedirect(false);
	forward.setPath("/NoticePage/noticeSchoolNewsList.jsp");
	return forward;
    }

    @Override
    public ActionForward actionDelete(HttpServletRequest request,
	    HttpServletResponse response) throws Exception {
	// TODO Auto-generated method stub

	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	request.setAttribute("topCode", topCode);
	request.setAttribute("subCode", subCode);
	PrintWriter out = response.getWriter();

	String seq = request.getParameter("seq");
	String order = request.getParameter("order");

	int rtn = 0;

	try {

	    HashMap<String, Object> hMap = new HashMap<String, Object>();

	    hMap.put("NEWS_SEQ", seq);

	    rtn = noticeDao.deleteNoticeNews(hMap);
	    System.out.println("업데이트 결과 : " + rtn);

	    ArrayList<HashMap<String, Object>> noticeList = noticeDao
		    .selectNoticeNewsList(hMap);

	    request.setAttribute("noticelist", noticeList);

	} catch (Exception e) {

	}

	ActionForward forward = new ActionForward();
	forward.setRedirect(false);
	forward.setPath("/NoticePage/noticeSchoolNewsList.jsp");
	return forward;

    }

}
