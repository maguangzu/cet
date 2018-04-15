package com.wq.Team.Web;

import java.io.IOException;
import java.util.Date;

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
 * Servlet implementation class CreatTeamAction
 */
@WebServlet("/createteam.do")
public class CreatTeamAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
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
				response.sendRedirect("createteam.jsp");
			}else
			{
				request.setAttribute("teaminfo", returnteam);
				request.getRequestDispatcher("teamtip.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("teaminfo", returnteam);
			request.getRequestDispatcher("teamtip.jsp").forward(request, response);
		}
		
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String  team_name=request.getParameter("team_name");
		String  team_desc=request.getParameter("team_desc");
		String  team_js=request.getParameter("team_js");
		int team_usernum=Integer.parseInt(request.getParameter("team_usernum"));
	    String[] team_shuxing =request.getParameterValues("team_shuxing");
		Team team=new Team();
		team.setTeamname(team_name);
		team.setTeamusername(((Volenteer)session.getAttribute(Constants.LOGIN_USER_KEY)).getVolname());
		team.setTeamjs(team_js);
		team.setTeammadetime(new Date().getTime()+"");
		team.setTeamusernum(team_usernum);
		team.setTeamdesc(team_desc);
		team.setTeamzhtai("申请中");
		team.setTeamshuxing(team_shuxing);
		
		
	}

}
