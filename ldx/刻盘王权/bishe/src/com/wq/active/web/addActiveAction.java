package com.wq.active.web;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wq.active.domain.Active;
import com.wq.active.service.activeServiceDao;
import com.wq.active.service.activeServiceDaoimpl;
import com.wq.system.domain.Volenteer;
import com.wq.system.exception.UserNotFoundException;

/**
 * Servlet implementation class addActiveAction
 */
@WebServlet("/addactive.do")
public class addActiveAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private activeServiceDao activeservice=new activeServiceDaoimpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		HttpSession session = request.getSession();
		Volenteer vol=(Volenteer)session.getAttribute("login_user_key");
		try{
		//	activeservice.addactiveInfo(at,vol);
			response.sendRedirect("findmyactive.do");
		}catch(UserNotFoundException e){
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("addUser.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String activename=request.getParameter("activename");
	String begintime=request.getParameter("begintime");
	String endtime=request.getParameter("endtime");
	String activeshichang=request.getParameter("activeshichang");
	String actvievolnum=request.getParameter("activeaddrees");
	String activeaddrees=request.getParameter("activeaddrees");
	String activemajor=request.getParameter("activemajor");
	Active active=new Active(); 
	active.setActivename(activename);
	active.setBegintime(begintime);
	active.setEndtime(endtime);
	active.setActiveshichang(Integer.parseInt(activeshichang));
	active.setActivevolnum(Integer.parseInt(actvievolnum));
	active.setActiveaddrees(activeaddrees);
	active.setActivemajor(activemajor);
	HttpSession session = request.getSession();
	Volenteer vol=(Volenteer)session.getAttribute("login_user_key");
	active.setActiveuser(vol.getVolid());
	activeservice.addactiveInfo(active,vol);
	//变更角色信息
	
	response.sendRedirect("activetip.jsp");	
	}

}
