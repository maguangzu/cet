package com.wq.myself.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wq.system.domain.Volenteer;
import com.wq.system.persist.VolenteerinfoDaoimpl;
import com.wq.system.util.Constants;

/**
 * Servlet implementation class findmyself
 */
@WebServlet("/myself.do")
public class findmyself extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Volenteer vol=(Volenteer)session.getAttribute("login_user_key");
		VolenteerinfoDaoimpl sss=new VolenteerinfoDaoimpl();
		Volenteer newvol=new Volenteer();	
		newvol=sss.findvolInfoByvolName(vol.getVolname());
		session.setAttribute("newmyselfinfo", newvol);
		response.sendRedirect("myself.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vol_id=request.getParameter("vol_id");
		String volidnumber=request.getParameter("volidnumber");
		String voltel=request.getParameter("voltel");
		String volname=request.getParameter("volname");
		String password=request.getParameter("password");
		
		Volenteer vv=new Volenteer();
		vv.setVolid(Integer.parseInt(vol_id));
		vv.setVolidnumber(volidnumber);
		vv.setVoltel(voltel);
		vv.setVolname(volname);
		vv.setPassword(password);
		VolenteerinfoDaoimpl sss=new VolenteerinfoDaoimpl();
		sss.modfiymyselfinfo(vv);
	    doGet(request, response);
	}

}
