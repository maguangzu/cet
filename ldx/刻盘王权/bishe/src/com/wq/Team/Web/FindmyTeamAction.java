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
import com.wq.system.domain.Volenteer;
import com.wq.system.util.Constants;

/**
 * Servlet implementation class FindmyTeamAction
 */
@WebServlet("/findmyteam.do")
public class FindmyTeamAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Volenteer vol=(Volenteer) session.getAttribute(Constants.LOGIN_USER_KEY);
		TeaminfoDaoimpl tt=new TeaminfoDaoimpl();
		Team returnteam=tt.findMyCreateTeambyvolname(vol.getVolname());
		//如果返回空说明没创建就查是否参加了团队。如果不空说明创建了 就提示存在团队
		if(returnteam==null){
			returnteam=tt.findMyJoinTeambyvolname(vol.getVolname());
			if(returnteam==null)
			{
				response.sendRedirect("teamtip2.jsp");
			}else
			{
				request.setAttribute("myjointeaminfo", returnteam);
				request.getRequestDispatcher("myjointeam.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("myteaminfo", returnteam);
			request.getRequestDispatcher("myteam.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
