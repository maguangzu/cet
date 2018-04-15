package com.wq.Team.Web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wq.Team.domain.Team;
import com.wq.Team.persist.TeaminfoDaoimpl;
import com.wq.system.domain.Page;
import com.wq.system.domain.Volenteer;
import com.wq.system.util.Constants;


@WebServlet("/findallteam.do")
public class FindAllTamAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	TeaminfoDaoimpl tminfodao=new TeaminfoDaoimpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPage = request.getParameter("page");
		int page = 1;
		if(currentPage != null){
			page = Integer.parseInt(currentPage);
		}
		HttpSession session = request.getSession();
		Volenteer vol=(Volenteer) session.getAttribute(Constants.LOGIN_USER_KEY);
	    int volid=vol.getVolid();    
	    Page<Team> pag = tminfodao.findallshTeam(volid, page);
	    request.setAttribute("shteampage", pag);
		request.getRequestDispatcher("allshteam.jsp").forward(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
