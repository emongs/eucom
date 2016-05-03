package com.eucom.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eucom.action.Action;
import com.eucom.action.ActionForward;
import com.eucom.action.EuNoticeAction;
import com.eucom.action.LoginAction;

@WebServlet("/notice.eu")
public class NoticeController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public NoticeController() {
	super();
    }

    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	request.setCharacterEncoding("UTF-8");

	String RequestURI = request.getRequestURI();
	System.out.println("RequestURI : " + RequestURI);
	String contextPath = request.getContextPath();
	System.out.println("contextPath : " + contextPath);
	String command = RequestURI.substring(contextPath.length());
	System.out.println("command : " + command);
	ActionForward forward = null;
	Action action = null;

	System.out.println("notice.eu");
	System.out.println("a");
	
	action = new EuNoticeAction();
	
	try {
		forward = action.execute(request, response);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	if (command.equals("/main.do")) {
	    forward = new ActionForward();
	    forward.setRedirect(false);
	    forward.setPath("/mainPage/mainPage.jsp");
	} else if (command.equals("/login.do")) {
	    System.out.println("#####");
	    action = new LoginAction();
	    try {
		forward = action.execute(request, response);
	    } catch (Exception e) {
		e.printStackTrace();
	    }

	} else if (command.equals("/join.do")) {
	    forward = new ActionForward();
	    forward.setRedirect(false);
	    forward.setPath("/UserPage/join.jsp");
	    // /////////////////////////////////////////////////////////////////////////////////
	} else if (command.equals("/noticeSchoolTime.no")) {
	    forward = new ActionForward();
	    forward.setRedirect(false);
	    forward.setPath("/NoticePage/noticeSchoolTime.jsp");
	    // /////////////////////////////////////////////////////////////////////////////////
	} else if (command.equals("/notice.no")) {
	    System.out.println("#####");
	    forward = new ActionForward();
	    forward.setRedirect(false);
	    System.out.println("123");
	    forward.setPath("/NoticePage/noticeSchoolNewsList.jsp");
	    // /////////////////////////////////////	//////////////////////////////////////////////
	} else if (command.equals("/noticeSchoolNewsWrite.no")) {
	    forward = new ActionForward();
	    forward.setRedirect(false);
	    forward.setPath("/NoticePage/noticeSchoolNewsWrite.jsp");
	    // ////////////////////////////////////////////////////////////////////////////////

	} else if (command.equals("/noticeParty.no")) {
	    forward = new ActionForward();
	    forward.setRedirect(false);
	    forward.setPath("/NoticePage/noticeParty.jsp");
	    // ////////////////////////////////////////////////////////////////////////////////////
	} else if (command.equals("/noticeSchoolFood.no")) {
	    forward = new ActionForward();
	    forward.setRedirect(false);
	    forward.setPath("/NoticePage/noticeSchoolFood.jsp");

	}

	if (forward != null) {
	    if (forward.isRedirect()) {
		response.sendRedirect(forward.getPath());
	    } else {
		RequestDispatcher dispatcher = request
			.getRequestDispatcher(forward.getPath());
		dispatcher.forward(request, response);
	    }
	}
    }
    
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException{
	
	request.setCharacterEncoding("UTF-8");

	String RequestURI = request.getRequestURI();
	System.out.println("RequestURI : " + RequestURI);
	String contextPath = request.getContextPath();
	System.out.println("contextPath : " + contextPath);
	String command = RequestURI.substring(contextPath.length());
	System.out.println("command : " + command);
	ActionForward forward = null;
	Action action = null;
	
	String order = request.getParameter("order");
	System.out.println("Controller order ==== "+order);

	action = new EuNoticeAction();

	try {
	    if (order.equals("VIEW") || order.equals("MODIFY")) {
		forward = action.actionView(request, response);
	    } else if (order.equals("UPDATE")) {
		forward = action.actionModify(request, response);
	    } else if (order.equals("DELETE")) {
		forward = action.actionDelete(request, response);
	    } else if (order.equals("REGIST")) {
		forward = action.actionWrite(request, response);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

	if (forward != null) {
	    if (forward.isRedirect()) {
		response.sendRedirect(forward.getPath());
	    } else {
		RequestDispatcher dispatcher = request
			.getRequestDispatcher(forward.getPath());
		dispatcher.forward(request, response);
	    }

	}
    }
}
