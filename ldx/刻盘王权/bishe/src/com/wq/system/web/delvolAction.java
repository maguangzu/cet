package com.wq.system.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wq.system.service.SystemService;
import com.wq.system.service.SystemServiceImpl;

//2016.10.28 
@WebServlet("/delvol.do")
public class delvolAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SystemService sysService = new SystemServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String volname = request.getParameter("volname");
		sysService.deletevol(volname);
		response.sendRedirect("volsl.do");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
