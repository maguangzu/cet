package com.wq.system.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wq.active.persist.ActiveinfaoDaoimpl;


@WebServlet("/activeshenhe.do")
public class ActivesheheAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String activeid=request.getParameter("activeid");
		 
		  ActiveinfaoDaoimpl activeinfo=new ActiveinfaoDaoimpl();
		  int ac=Integer.parseInt(activeid);
		  activeinfo.modfiyactive(ac,1);
		  response.sendRedirect("activetip3.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
