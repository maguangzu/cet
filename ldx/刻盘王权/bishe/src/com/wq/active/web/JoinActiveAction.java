package com.wq.active.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wq.active.persist.ActiveinfaoDaoimpl;
import com.wq.system.domain.Volenteer;
import com.wq.system.util.Constants;


@WebServlet("/joinactive.do")
public class JoinActiveAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String activeid=request.getParameter("activeid");
		int ac=0;
		if(activeid==null){				
		}else{
			ac=Integer.parseInt(activeid);
		}
		HttpSession session = request.getSession();
		Volenteer vol=(Volenteer) session.getAttribute(Constants.LOGIN_USER_KEY);
		//先查询是否已经加入 加入了提示已经加入
		ActiveinfaoDaoimpl activeinfo=new ActiveinfaoDaoimpl();
		int volid=vol.getVolid();
		
		boolean jieguo=activeinfo.selectjoinactive(volid, ac);
		if(jieguo){
			//提示您已经加入
			response.sendRedirect("activetip1.jsp");
		}else{
			activeinfo.joinactive(volid, ac);
			response.sendRedirect("activetip2.jsp");
			//提示加入成功
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
