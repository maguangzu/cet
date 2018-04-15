package cn.cet.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



import cn.cet.entity.Candidate;
import cn.cet.entity.User;
import cn.cet.service.CandidateService;
import cn.cet.service.UserService;
import cn.cet.web.util.AdmissionUtil;
import cn.cet.web.util.DateUtil;



@Controller
@RequestMapping("/user")
public class UserAction {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CandidateService candidateService;
	
	
	@RequestMapping("/loginUI")
	public String toLoginUI(){
		System.out.println("user:login");
		return "user/loginUI.jsp";
	}
	
	@RequestMapping("/registerUI")
	public String toRegisterUI(){
		return "user/registerUI.jsp";
	}
	
	@RequestMapping("/userPwdUI")
	public String toUserPwdUI(){
		
		return "user/userPwdUI.jsp";
	}
	
	
	@RequestMapping("/userInfoUI")
	public String userInfoUI(HttpSession session){
		
		User user=(User) session.getAttribute("USERINFO");
		if(user!=null) {
			Candidate candidate= candidateService.findCandidateByUid(user.getId());
			session.setAttribute("USERINFO", user);
			//报名信息
			session.setAttribute("CANDIDATEINFO", candidate);
			return "user/userInfo.jsp";

		}
		return "user/loginUI.jsp";
	}
	
	
	@RequestMapping("/printAdmission")
	@ResponseBody
	public Map<String,String> printAdmission(HttpSession session,HttpServletRequest request) throws IOException{
		Map<String,String> map=new HashMap<>();
		User user=(User) session.getAttribute("USERINFO");
		if(user!=null) {
			Candidate candidate= candidateService.findCandidateByUid(user.getId());
			
			if(candidate!=null) {
				
				session.setAttribute("USERINFO", user);
				//报名信息
				
				System.out.println("ajax 请求");
				map.put("id", candidate.getAdmissionCard());
				map.put("name", candidate.getName());
				map.put("sex", candidate.getSex());
				map.put("idcard", candidate.getIdcard());
				map.put("cetType", candidate.getCetType());
				map.put("personImg", candidate.getPersonImg());
				
				
			}	

		}
		return map;
		
	}
	
	
	@RequestMapping("/login")
	public String login(String account,String password,HttpSession session,HttpServletRequest request){
		
		User user = userService.login(account,password);
		
		System.out.println("log2....");
		if(user!=null){
			
			
			Candidate candidate= candidateService.findCandidateByUid(user.getId());
			
			System.out.println("candidate = "+candidate);
			
			session.setAttribute("USERINFO", user);
			//报名信息
			session.setAttribute("CANDIDATEINFO", candidate);
			
			return "user/userInfo.jsp";
		}else{
			request.setAttribute("msg", "帐号或者密码错误");
			return "user/loginUI.jsp";
		}
	}
	
	
	@RequestMapping("/register")
	public String register(User user,String valideCode,HttpSession session,HttpServletRequest request){
		try{
			String code = (String) session.getAttribute("VerifyCode");
			code = code.replaceAll(" ", "");
			if(code.equals(valideCode)){
				userService.save(user);
			}else{
				request.setAttribute("errorIdx", "valideCode");
				return "user/registerUI.jsp";
			}
		}catch (Exception e) {
			request.setAttribute("errorIdx", "account");
			return "user/registerUI.jsp";
		}
		return "user/loginUI.jsp";
	}
	
	
	@RequestMapping("/quit")
	public String quit(HttpSession session){
		session.removeAttribute("USERINFO");
		return "user/loginUI.jsp";
	}
	
	
	/**
	 * 完善个人信息的并报名四六级方法
	 * @param user
	 * @param file
	 * @return
	 */
	@RequestMapping("/signUp")
	public String signUp(Candidate candidate,HttpServletRequest request,@RequestParam(value ="file",required = false) MultipartFile file,
			HttpSession session){
		try{
			String path = request.getSession().getServletContext().getRealPath("upload/user");
			String fileName = file.getOriginalFilename();
			fileName = System.currentTimeMillis()+fileName.substring(fileName.lastIndexOf("."));
			File targetFile = new File(path,fileName);
			//保存
			file.transferTo(targetFile);
			
			candidate.setPersonImg(request.getContextPath()+"/upload/user/"+fileName);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * 为了防止页面过来的数据覆盖了密码
		 */
		User userInfo = (User) session.getAttribute("USERINFO");
		candidate.setUser(userInfo);
		
		//查找candidate表中最后一条记录，提取出顺序号四位；
		String queueCode=AdmissionUtil.getQueueCode(candidateService.findLastRecord());
		String admissionCode = DateUtil.getTime(DateUtil.pattern);
		//设置准考证号
		candidate.setAdmissionCard(admissionCode+queueCode);
		candidate.setCreateTime(new Date());
		
		candidateService.save(candidate);
		
		session.setAttribute("USERINFO", userService.findObjectById(userInfo.getId()));
		session.setAttribute("CANDIDATEINFO", candidate);
		
		return "user/userInfo.jsp";
	}
	
	@RequestMapping("/modifyPwd.action")
	public String modifyPwd(String oldPwd,String newPwd,HttpSession session,Model model){
		User userinfo = (User) session.getAttribute("USERINFO");
		//密码正确
		if(userinfo.getPassword().equals(oldPwd)){
			userinfo.setPassword(newPwd);
			userService.update(userinfo);
			model.addAttribute("msg","密码修改成功！");
		}else{
			model.addAttribute("msg","旧密码错误,请重新输入！!");
		}
		return "user/userPwdUI.jsp";
	}

}
