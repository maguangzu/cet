package com.wq.system.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import com.wq.system.domain.Juese;
import com.wq.system.util.JdbcUtil;

public class JueseinfoDaoimpl implements JueseinfoDao
{ 
	
	/**
	 * 通过用户名查找对应角色
	 */
	public Juese findjueseByvolName(String volName){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		Set<Juese> s = new HashSet<Juese>();
		Juese r = new Juese();
		try
		{
			conn = JdbcUtil.getConn();
			String str = "select j.* from volenteer v,juese_volenteer jv,juese j where v.vol_name=jv.vol_name and jv.juese_id=j.juese_id and v.vol_name=?";
			ps = conn.prepareStatement(str);
			ps.setString(1, volName);
			res = ps.executeQuery();
			
			while (res.next())
			{
				
				r.setJueseid(res.getInt("juese_id"));
				r.setJuesename(res.getString("juese_name"));
				r.setJueseurl("juese_url");
				
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			JdbcUtil.closeAll(res, ps);
		}
		return r;
	}
}
