package com.wq.active.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wq.active.domain.Active;
import com.wq.active.service.activeServiceDao;
import com.wq.active.service.activeServiceDaoimpl;
import com.wq.system.domain.Page;
import com.wq.system.domain.Volenteer;
import com.wq.system.service.SystemService;
import com.wq.system.service.SystemServiceImpl;
import com.wq.system.util.Constants;



@WebServlet("/findmyactive.do")
public class FindMyactiveAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private activeServiceDao activeservice = new activeServiceDaoimpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPage = request.getParameter("page");
		int page = 1;
		if(currentPage != null){
			page = Integer.parseInt(currentPage);
		}
		HttpSession session = request.getSession();
		Volenteer vol=(Volenteer) session.getAttribute(Constants.LOGIN_USER_KEY);
	    int volid=vol.getVolid();    
	    Page<Active> pag = activeservice.findMyActive(volid, page);
	    request.setAttribute("activepage", pag);
		request.getRequestDispatcher("myactive.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
