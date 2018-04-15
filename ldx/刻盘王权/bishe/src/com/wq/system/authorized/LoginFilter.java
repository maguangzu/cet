package com.wq.system.authorized;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wq.system.domain.Volenteer;
import com.wq.system.util.Constants;

/**
 * 判断发送请求的客户端是否登录，只有登录以后才能访问系统资源。
 */
@WebFilter({ "*.jsp","*.do"})
public class LoginFilter implements Filter {

    public LoginFilter() {
    }
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession session = req.getSession(false);
		
		String uri = req.getRequestURI();
		if(uri.endsWith("login.jsp") || uri.endsWith("login.do")||uri.endsWith("zhuce.jsp") || uri.endsWith("addvol.do")||uri.endsWith("hello.jsp"))
		{
			chain.doFilter(req, resp);
		}
		
		else{
			if(session == null)
			{
				//未登录
				resp.sendRedirect("login.jsp");
			}else{
				Volenteer vol = (Volenteer) session.getAttribute(Constants.LOGIN_USER_KEY);
				if(vol == null){
					//未登录
					resp.sendRedirect("login.jsp");
				}else{
					//登录了
					chain.doFilter(req, resp);
				}
			}
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
