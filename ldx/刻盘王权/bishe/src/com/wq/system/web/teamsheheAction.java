package com.wq.system.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wq.Team.persist.TeaminfoDaoimpl;
import com.wq.active.persist.ActiveinfaoDaoimpl;


@WebServlet("/teamsh.do")
public class teamsheheAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String activeid=request.getParameter("teamid");
		 
	      TeaminfoDaoimpl tma=new TeaminfoDaoimpl();
		  int ac=Integer.parseInt(activeid);
		  tma.modfiyteam(ac,"通过");
		  response.sendRedirect("activetip3.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
