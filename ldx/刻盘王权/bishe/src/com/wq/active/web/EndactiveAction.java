package com.wq.active.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wq.active.persist.ActiveinfaoDaoimpl;


@WebServlet("/endactive.do")
public class EndactiveAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String activeid=request.getParameter("activeid");
	  //删除关联表数据
	  ActiveinfaoDaoimpl activeinfo=new ActiveinfaoDaoimpl();
	  int ac=Integer.parseInt(activeid);
	  activeinfo.modfiyactive(ac,2);
	  response.sendRedirect("activetip3.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
