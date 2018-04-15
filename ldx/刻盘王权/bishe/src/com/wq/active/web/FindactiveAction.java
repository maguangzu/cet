package com.wq.active.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wq.active.domain.Active;
import com.wq.active.service.activeServiceDao;
import com.wq.active.service.activeServiceDaoimpl;
import com.wq.system.domain.Page;


@WebServlet("/findat.do")
public class FindactiveAction extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		activeServiceDao activeservice=new activeServiceDaoimpl();
		String activename = request.getParameter("activename");
		String activebegtime = request.getParameter("activebegtime");
		String activeaddrees = request.getParameter("activeaddrees");
		String activeshuxing = request.getParameter("activeshuxing");
		
		Active at = new Active();
		if(activename!=null && activename.length()>0)
		{
			at.setActivename(activename);
		}
		if(activebegtime!=null && activebegtime.length()>0)
		{
			at.setBegintime(activebegtime);
		}
		if(activeaddrees!=null && activeaddrees.length()>0)
		{
			at.setActiveaddrees(activeaddrees);
		}
		if(activeshuxing!=null && activeshuxing.length()>0)
		{
			at.setActiveshuxing(activeshuxing);
		}
		
		String page = request.getParameter("page");
		int currentPage = 1;
		if(page != null)
		{
			currentPage = Integer.parseInt(page);
		}
		Page<Active> p = activeservice.findAllactive(at,currentPage);
		request.setAttribute("p", p);
		request.setAttribute("uuu", at);
		request.getRequestDispatcher("activeManager.jsp").forward(request, response);
	}
		
		
		
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
