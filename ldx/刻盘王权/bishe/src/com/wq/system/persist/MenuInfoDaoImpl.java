package com.wq.system.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wq.system.domain.Menu;
import com.wq.system.util.JdbcUtil;

public class MenuInfoDaoImpl implements MenuInfoDao
{
	@Override
	public List<Menu> findFirstLevelMenusByvolName(String volName)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Menu> list = new ArrayList<Menu>();
		try{
			conn = JdbcUtil.getConn();
			String sql = "select distinct m.* from volenteer v,juese_volenteer jv,juese j,juese_quanxian jq,quanxian q ,quanxian_menu qm,menu m where v.vol_name=jv.vol_name and jv.juese_id=j.juese_id and j.juese_id=jq.juese_id and jq.quanxian_id=q.quanxian_id and q.quanxian_id=qm.quanxian_id and qm.menu_id=m.menu_id and v.vol_name=? and men_menu_id ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, volName);
			rs = ps.executeQuery();
			while(rs.next())
			{
				Menu m = new Menu();
				m.setMenuid(rs.getInt("menu_id"));
				m.setMenmenuid(rs.getInt("men_menu_id"));
				m.setMenuname(rs.getString("menu_name"));
		
				m.setMenuurl(rs.getString("menu_url"));
				List<Menu> sons = findSecondLevelMenusByFatherId(rs.getInt("menu_id"));
				m.setSons(sons);
				
				list.add(m);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(rs,ps);
		}
		return list;
	}

	@Override
	public List<Menu> findSecondLevelMenusByFatherId(Integer fatherId)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Menu> list = new ArrayList<Menu>();
		try{
			conn = JdbcUtil.getConn();
			String sql = "select * from menu where men_menu_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fatherId);
			rs = ps.executeQuery();
			while(rs.next())
			{
				Menu m = new Menu();
				m.setMenuid(rs.getInt("menu_id"));
				m.setMenmenuid(rs.getInt("men_menu_id"));
				m.setMenuname(rs.getString("menu_name"));
				
				m.setMenuurl(rs.getString("menu_url"));
				list.add(m);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(rs,ps);
		}
		return list;
	}
}
