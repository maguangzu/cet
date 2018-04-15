package com.wq.system.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wq.system.domain.Volenteer;
import com.wq.system.exception.UserNotFoundException;
import com.wq.system.exception.UserPasswordWrongException;
import com.wq.system.service.SystemService;
import com.wq.system.service.SystemServiceImpl;
import com.wq.system.util.Constants;



@WebServlet("/login.do")//页面点击之后首先跳转到这里,登录时候调用
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SystemService sysService = new SystemServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String volName = request.getParameter("volName");
		String volPwd = request.getParameter("volPwd");
		
		try{
			Volenteer vol = sysService.login(volName, volPwd);
			HttpSession session = request.getSession();
			session.setAttribute(Constants.LOGIN_USER_KEY, vol);
			response.sendRedirect("index.jsp");
		}catch(UserNotFoundException e){
			request.setAttribute("msg", "用户名错误！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}catch(UserPasswordWrongException e){
			request.setAttribute("msg", "密码错误！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
