package com.eucom.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 


 




import com.eucom.action.*;

 

/**
 * Servlet implementation class ForwardController
 */

public class ForwardController extends HttpServlet implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			 	throws ServletException, IOException {
		 
		 request.setCharacterEncoding("UTF-8"); 
		 response.setCharacterEncoding("UTF-8"); 
		 
		 String RequestURI=request.getRequestURI();
		 System.out.println("RequestURI : "+RequestURI);
		 String contextPath=request.getContextPath();
		 System.out.println("contextPath : "+contextPath);
		 String command=RequestURI.substring(contextPath.length());
		 System.out.println("command : "+command);
		 ActionForward forward=null;
		 Action action=null;
		 
		  String topCode = "M";
		  String subCode = "a";
		
		if(command.equals("/main.do")){
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/mainPage/mainPage.jsp");
		}else if(command.equals("/login.do")){
			action = new LoginAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/join.do")){
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/UserPage/join.jsp");
		}
		
		request.setAttribute("topCode", "");
		request.setAttribute("subCode", "");
		
		if(forward != null){
		  if(forward.isRedirect()){
			response.sendRedirect(forward.getPath());
		  }else{
			RequestDispatcher dispatcher=
				request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
		  }
		}
	}
	 
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
				
				doProcess(request,response);
			}  	
			
			protected void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
				doProcess(request,response);
			}	  
	 

}
