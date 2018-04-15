package com.wq.system.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wq.system.domain.Volenteer;
import com.wq.system.exception.UserNotFoundException;
import com.wq.system.service.SystemService;
import com.wq.system.service.SystemServiceImpl;

/**
 * Servlet implementation class AddvolAction
 */
@WebServlet("/addvol.do")
public class AddvolAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SystemService sysService = new SystemServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String volname = request.getParameter("volname");
		String volpassword= request.getParameter("volpassword");
		String volidnumber = request.getParameter("volidnumber");
		String voltel = request.getParameter("voltel");
		
	
		Volenteer vol = new Volenteer();
		if(volname!=null && volname.length()>0)
		{
			vol.setVolname(volname);
		}
		if(volpassword!=null && volpassword.length()>0)
		{
			vol.setPassword(volpassword);
		}
		if(volidnumber!=null && volidnumber.length()>0)
		{
			vol.setVolidnumber(volidnumber);
		}
		if(voltel!=null && voltel.length()>0)
		{
			vol.setVoltel(voltel);
		}
		try{
			sysService.addvolInfo(vol);
			response.sendRedirect("login.jsp");
		}catch(UserNotFoundException e){
			request.setAttribute("msg", e.getMessage());	
			request.getRequestDispatcher("zhuce.jsp").forward(request, response);
		}

	   
		
	}

}
