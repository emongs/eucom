package com.eucom.action;

import javax.servlet.http.*;

public interface Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
	public ActionForward actionView(HttpServletRequest request,HttpServletResponse response) throws Exception;
	public ActionForward actionWrite(HttpServletRequest request,HttpServletResponse response) throws Exception;
	public ActionForward actionModify(HttpServletRequest request,HttpServletResponse response) throws Exception;
	public ActionForward actionDelete(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
