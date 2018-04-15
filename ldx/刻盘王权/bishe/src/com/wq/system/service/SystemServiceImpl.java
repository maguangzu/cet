package com.wq.system.service;

import java.util.List;
import java.util.Set;

import com.wq.Team.domain.Team;
import com.wq.Team.persist.TeaminfoDao;
import com.wq.Team.persist.TeaminfoDaoimpl;
import com.wq.active.domain.Active;
import com.wq.active.persist.ActiveinfaoDao;
import com.wq.active.persist.ActiveinfaoDaoimpl;
import com.wq.system.domain.Juese;
import com.wq.system.domain.Menu;
import com.wq.system.domain.Page;
import com.wq.system.domain.Quanxian;
import com.wq.system.domain.Volenteer;
import com.wq.system.exception.UserNotFoundException;
import com.wq.system.exception.UserPasswordWrongException;
import com.wq.system.persist.JueseinfoDao;
import com.wq.system.persist.JueseinfoDaoimpl;
import com.wq.system.persist.MenuInfoDao;
import com.wq.system.persist.MenuInfoDaoImpl;
import com.wq.system.persist.QuanxianinfaoDao;
import com.wq.system.persist.QuanxianinfaoDaoimpl;
import com.wq.system.persist.VolJueseDao;
import com.wq.system.persist.VolJueseDaoImpl;
import com.wq.system.persist.VolenteerinfoDao;
import com.wq.system.persist.VolenteerinfoDaoimpl;




public class SystemServiceImpl implements SystemService
{
	private VolenteerinfoDao volInfoDao = new VolenteerinfoDaoimpl();	
    private JueseinfoDao jueseInfoDao = new JueseinfoDaoimpl();	
	private QuanxianinfaoDao quanxianDao = new QuanxianinfaoDaoimpl();	
	private MenuInfoDao menuDao = new MenuInfoDaoImpl();
	private VolJueseDao voljuesedao=new VolJueseDaoImpl();
	private ActiveinfaoDao activeinfaodao=new ActiveinfaoDaoimpl();
	private TeaminfoDao teaminfaodao=new TeaminfoDaoimpl();

	public Volenteer login(String volName, String volPwd)  //登录时用得方法,查找当前用户的角色,权限,菜单信息
	{
		//用户名是否正确，密码是否正确
		Volenteer vol = volInfoDao.findvolInfoByvolName(volName);
		if(vol == null){
			//没查到，用户名错误！
			throw new UserNotFoundException("404");
		}else
		{
			//查到了
			if(!volPwd.equals(vol.getPassword()))
			{	//密码错误！
				throw new UserPasswordWrongException("300");
			}
			else{
				//当前用户的角色信息2当前用户的所有权限3当前用户的菜单信息4当前用户的活动信息5当前用户的团队信息
				Juese juese = jueseInfoDao.findjueseByvolName(volName);
				vol.setJuese(juese);
				Set<Quanxian> quanxian = quanxianDao.findquanxianByvolName(volName);
				vol.setQuanxian(quanxian);
				List<Menu> menus = menuDao.findFirstLevelMenusByvolName(volName);
				vol.setMenus(menus);
				Set<Active> active=activeinfaodao.findactiveByvolname(volName);
			    vol.setActive(active);
			    Team team= teaminfaodao.findteamByvolname(volName);
			    vol.setTeam(team);			    
			}
		}
		return vol;
	}
 //查询显示所有用户 分页技术  
	public Page<Volenteer> findAllvols(Volenteer vol,int currentPage)
	{
		return volInfoDao.findAllvols(vol, currentPage);
		
	}

//删除用户
	public void addvolInfo(Volenteer vol)
	{
		
		Volenteer v = volInfoDao.findvolInfoByvolName(vol.getVolname());
		if(v!=null){
			throw new UserNotFoundException("用户已经存在");
		}else{
			volInfoDao.insertvolInfo(vol);
		}
	}
//10.28  删除用户
	@Override
	public void deletevol(String volname) {
	    voljuesedao.deleteByvolName(volname);//解除关联 删除用户对应的角色
		volInfoDao.deletevolByvolName(volname);//删除用户
		
	}
	@Override
	public void createteam(Team team) {
		
		
	}
	@Override
	public void createActive(String acttive) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delActive(String acttive) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delTeam(Team team) {
		// TODO Auto-generated method stub
		
	}

	


	
}
