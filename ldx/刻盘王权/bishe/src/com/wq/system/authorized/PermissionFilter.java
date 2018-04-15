package com.wq.system.authorized;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

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

import com.wq.system.domain.Quanxian;
import com.wq.system.domain.Volenteer;
import com.wq.system.util.Constants;

/**
 * 过滤登录用户是否有权限访问对应资源。
 */
@WebFilter("*.do")
public class PermissionFilter implements Filter {

    public PermissionFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession session = req.getSession(false);
		String uri = req.getRequestURI();   //    http://localhost:8080/CarRent/user/addUser.do?name=ralph  URL  URI
		if(uri.endsWith("login.do")|| uri.endsWith("addvol.do"))
		{
			chain.doFilter(req, resp);
		}else{
			Volenteer vol = (Volenteer) session.getAttribute(Constants.LOGIN_USER_KEY);
			String res = uri.indexOf("?")<0 ? uri.substring(uri.lastIndexOf("/")+1) : uri.substring(uri.lastIndexOf("/")+1,uri.indexOf("?"));	
			Set<Quanxian> set = vol.getQuanxian();
			Iterator<Quanxian> it = set.iterator();
			boolean flag = false;
			while(it.hasNext())
			{
				Quanxian p = it.next();
				if(res.equals(p.getQuanxianurl()))
				{
					flag = true;
					break;
				}
			}			
			if(flag){
				//放行
				chain.doFilter(req, resp);
			}else{
				//无权限访问该资源
				resp.sendRedirect("noPermission.jsp");
			}
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
