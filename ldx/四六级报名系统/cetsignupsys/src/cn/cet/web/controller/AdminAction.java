package cn.cet.web.controller;

import java.io.File;
import java.lang.ProcessBuilder.Redirect;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.cet.entity.Candidate;
import cn.cet.entity.User;
import cn.cet.service.CandidateService;
import cn.cet.service.UserService;
import cn.cet.web.util.PageBean;





@Controller
@RequestMapping("/admin")
public class AdminAction {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CandidateService candidateService;
	
	@RequestMapping("/loginUI")
	public String loginUI(){
		System.out.println("loginUI");
		return "admin/loginUI.jsp";
	}
	
	
	@RequestMapping(value="/login")
	public String login(String account,String password,HttpSession session,HttpServletRequest request){
		User admin = userService.login(account, password);
		if(admin!=null&&admin.isRole()){//继续判断是否是管理员
	
			session.setAttribute("ADMININFO", admin);
			return "admin/index.jsp";
			
		}else{
			request.setAttribute("msg", "请检查用户名或者密码是否正确");
			return "admin/loginUI.jsp";
		}
	}
	
	@RequestMapping(value="/quit")
	public String quit(HttpSession session){
		session.removeAttribute("ADMININFO");
		return "admin/loginUI.jsp";
	}
	
	
	/**
	 * 跳转用户列表页面 
	 * @return
	 */
	@RequestMapping(value="/userList")
	public String userList(Model model,@RequestParam(defaultValue = "1") int currentPage){
		
		PageBean<User> page=new PageBean<>();
		
		page = userService.pageLists(currentPage, page.getPageSize());
		
		model.addAttribute("page", page);
		
		return "admin/user/userList.jsp";
	}
	
	/**
	 * 跳转到用户详细页面
	 * @return
	 */
	@RequestMapping(value="/userDetailUI")
	public String userDetailUI(String uid,Model model){
		User user = userService.findObjectById(uid);
		model.addAttribute("user", user);
		return "admin/user/userDetail.jsp";
	}
	
	
	/**
	 * 删除指定用户信息
	 * @return
	 */
	@RequestMapping(value="/removeUser")
	public String removeUser(String uid,HttpServletRequest request){
		
		//先删除四六级报名信息
		Candidate candidate=candidateService.findCandidateByUid(uid);
		candidateService.delete(candidate.getId());
		userService.delete(uid);
		
		return "forward:/admin/userList.action";
	}
	
	
	/**
	 * 修改用户权限信息页面
	 * @return
	 */
	@RequestMapping(value="/modifyUserUI")
	public String modifyUserUI(String id,Model model){
		
		User user = userService.findObjectById(id);
		
		model.addAttribute("user", user);
		
		return "admin/user/userModify.jsp";
	}
	
	
	/**
	 * 修改用户权限信息
	 * @return
	 */
	@RequestMapping(value="/modifyUserRight")
	public String modifyUserRight(User user,Model model){
		
		userService.update(user);;
		
		return "redirect:/admin/userList.jsp";
	}
	
	
	/**
	 * 考生信息列表页面 
	 * @return
	 */
	@RequestMapping(value="/candidateList")
	public String houseList(Model model,@RequestParam(defaultValue = "1") int currentPage){
		
		PageBean<Candidate> page=new PageBean<>();
		
		page = candidateService.pageLists(currentPage, page.getPageSize(), null);
		
		
		model.addAttribute("page", page);
		
		return "admin/candidate/candidateList.jsp";
	}
	
	
	/**
	 * 跳转到考生详细页面
	 * @return
	 */
	@RequestMapping(value="/candidateDetailUI")
	public String candidateDetailUI(String id,Model model){
		Candidate candidate = candidateService.findObjectById(id);
		
		model.addAttribute("candidate", candidate);
		return "admin/candidate/candidateDetail.jsp";
	}
	
	/**
	 * 跳转到考生信息修改页面
	 * @return
	 */
	@RequestMapping(value="/candidateModifyUI")
	public String candidateModifyUI(String id,Model model){
		
		Candidate candidate = candidateService.findObjectById(id);
		
		model.addAttribute("candidate", candidate);
		
		return "admin/candidate/candidateModify.jsp";
	}
	
	
	/**
	 * 修改考生信息
	 * @param car
	 * @param request
	 * @param file
	 * @return
	 */
	@RequestMapping(value="/modifyCandidate")
	public String modifyCandidate(Candidate candidate,String uid,HttpServletRequest request,@RequestParam(value ="file",required = false) MultipartFile file){
		
		if(file!=null){
			try{
				String path = request.getSession().getServletContext().getRealPath("upload/user");
				String fileName = file.getOriginalFilename();
				fileName = System.currentTimeMillis()+fileName.substring(fileName.lastIndexOf("."));
				File targetFile = new File(path,fileName);
				candidate.setPersonImg(request.getContextPath()+"/upload/user/"+fileName);
				//保存
				file.transferTo(targetFile);
			}catch (Exception e) {
				System.out.println("modifyCandidate ：报异常");
			}
		}
		User user = userService.findObjectById(uid);
		candidate.setUser(user);
		candidateService.update(candidate);
		return "forward:/admin/candidateList.action";
	}
	
	
	/**
	 * 考试列表
	 * @return
	 */
	@RequestMapping(value="/testListUI")
	public String testListUI(Model model,String cetType,@RequestParam(defaultValue = "1") int currentPage){
		
		PageBean<Candidate> page = new PageBean<>();
		model.addAttribute("cetType", cetType);
		
		if(cetType!=null&&cetType!=""&&cetType.equals("all")) {
			cetType = null;
		}
		
		page = candidateService.pageLists(currentPage, page.getPageSize(), cetType);
		
		
		model.addAttribute("page", page);
		
		
		return "admin/candidate/testList.jsp";
	}
	
	/**
	 * 跳转到考生详细页面
	 * @return
	 */
	@RequestMapping(value="/perListDetailUI")
	public String perListDetailUI(String id,Model model){
		Candidate candidate = candidateService.findObjectById(id);
		
		model.addAttribute("candidate", candidate);
		return "admin/candidate/perListDetail.jsp";
	}
	

}
 