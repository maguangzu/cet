package cn.cet.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cet.entity.User;
import cn.cet.service.UserService;

@Controller
public class LoginAction {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/loginUI")
	public String loginUI(){
		System.out.println("loginUI");
		return "admin/loginUI";
	}
	
	@RequestMapping(value="/login")
	public String login(String account,String password,HttpSession session,HttpServletRequest request){
		
		User user = userService.login(account, password);
		
		if(user!=null){
			session.setAttribute("ADMININFO", user);
			
			return "admin/index";
		}else{
			request.setAttribute("msg", "请检查用户名或者密码是否正确");
			return "admin/loginUI";
		}
	}
	
	@RequestMapping(value="/quit")
	public String quit(HttpSession session){
		session.removeAttribute("ADMININFO");
		return "admin/loginUI";
	}
	
}
