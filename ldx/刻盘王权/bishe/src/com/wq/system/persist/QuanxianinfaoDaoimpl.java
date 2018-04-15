package com.wq.system.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import com.wq.system.domain.Quanxian;
import com.wq.system.util.JdbcUtil;

public class QuanxianinfaoDaoimpl implements QuanxianinfaoDao
{
	@Override
	public Set<Quanxian> findquanxianByvolName(String volName)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		Set<Quanxian> set = new HashSet<Quanxian>();
		try
		{
			conn = JdbcUtil.getConn();
			String str = "select q.* from volenteer v,juese_volenteer jv,juese j,juese_quanxian jq,quanxian q where v.vol_name=jv.vol_name and jv.juese_id=j.juese_id and v.vol_name=? and j.juese_id=jq.juese_id and jq.quanxian_id=q.quanxian_id";
			ps = conn.prepareStatement(str);
			ps.setString(1, volName);
			res = ps.executeQuery();
			while (res.next())
			{
				Quanxian p = new Quanxian();
				p.setQuanxianid(res.getInt("quanxian_id"));
				p.setQuanxianname(res.getString("quanxian_name"));
				p.setQuanxianurl(res.getString("quanxian_url"));
				set.add(p);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			JdbcUtil.closeAll(res, ps);
		}
		return set;
	}
}
