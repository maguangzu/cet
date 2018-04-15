 package com.wq.system.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wq.system.domain.Page;
import com.wq.system.domain.Volenteer;
import com.wq.system.service.SystemService;
import com.wq.system.service.SystemServiceImpl;


@WebServlet("/volsl.do")
public class FindvolAction extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private SystemService sysService = new SystemServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String volName = request.getParameter("volName");
		String currentPage = request.getParameter("page");
		if(volName == null)
		{
			volName = "";
		}
		int page = 1;
		if(currentPage != null){
			page = Integer.parseInt(currentPage);
		}
		Volenteer v = new Volenteer();
		v.setVolname(volName);
		Page<Volenteer> pag = sysService.findAllvols(v, page);
		request.setAttribute("p", pag);
		request.getRequestDispatcher("volsl.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
