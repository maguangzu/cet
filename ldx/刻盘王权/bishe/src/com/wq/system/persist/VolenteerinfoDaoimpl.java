package com.wq.system.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wq.system.domain.Page;
import com.wq.system.domain.Volenteer;
import com.wq.system.exception.DataAccessException;
import com.wq.system.util.Constants;
import com.wq.system.util.JdbcUtil;

public class VolenteerinfoDaoimpl extends BaseDao implements VolenteerinfoDao
{
	private static final Logger log = LoggerFactory.getLogger(VolenteerinfoDaoimpl.class);
	
//....//登录时用的查找方法,返回当前用户的所有信息包括基本属性和角色权限
	public Volenteer findvolInfoByvolName(String volName)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Volenteer vol= null;
		try
		{
			conn = JdbcUtil.getConn();
			String sql = "select * from volenteer where vol_name=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, volName);

			rs = ps.executeQuery();
			while (rs.next())
			{
				vol = new Volenteer();
				vol.setVolname(volName);
				vol.setPassword(rs.getString("vol_password"));
				vol.setVoltel(rs.getString("vol_tel"));
				vol.setTeamid(rs.getInt("team_id"));
				vol.setVolid(rs.getInt("vol_id"));
				vol.setVolidnumber(rs.getString("vol_idnumber"));
				vol.setVolshichang(rs.getInt("vol_times"));
				
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			JdbcUtil.closeAll(rs, ps,conn);
		}
		return vol;

	}
//..........//查找所有用户的信息 分页显示
	public Page<Volenteer> findAllvols(Volenteer vol, int currentPage)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Volenteer> list = new ArrayList<Volenteer>();
		Page<Volenteer> page = new Page<Volenteer>();
		page.setCurrentPage(currentPage);
		try
		{
			conn = JdbcUtil.getConn();
			String sql = "select * from volenteer where vol_name like ?";
			genTotalPageAndTotalNumber(sql, page, new Object[] { "%" + vol.getVolname() + "%" },new int[] { Types.VARCHAR });
			String findSql = "select v.* from volenteer v where v.vol_name like  ?  LIMIT ?,?";
			ps = conn.prepareStatement(findSql);
			ps.setString(1, "%" + vol.getVolname() + "%");

			int from =  (int)((currentPage - 1) * Constants.ITEM_PER_PAGE );
			int to = (int)(from + Constants.ITEM_PER_PAGE );
			ps.setInt(2, from);
			ps.setInt(3, to);
			rs = ps.executeQuery();
			while (rs.next())
			{
				Volenteer r = new Volenteer();
				r.setVolid(rs.getInt("vol_id"));
				r.setVolname(rs.getString("vol_name"));
				r.setVolidnumber(rs.getString("vol_idnumber"));
				r.setVoltel(rs.getString("vol_tel"));
				r.setVolshichang(rs.getInt("vol_times"));
				r.setTeamid(rs.getInt("team_id"));
				list.add(r);
			}
			page.setList(list);
		} catch (Exception e)
		{
			log.error("查询全部角色信息失败！", e);
			throw new DataAccessException("查询全部角色信息失败！", e);
		} finally
		{
			JdbcUtil.closeAll(rs, ps,conn);
		}
		return page;
	}

// .....//根据用户名字查找用户信息
	public Volenteer findvolByvolName(String volName)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Volenteer r = null;
		try
		{
			conn = JdbcUtil.getConn();
			String sql = "select * from volenteer where Vol_name=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, volName);
			rs = ps.executeQuery();
			while (rs.next())
			{
				r = new Volenteer();
				r.setVolid(rs.getInt("vol_id"));// 把数据库数据装入对象

			}
		} catch (Exception e)
		{
			log.error("根据角色名字查询角色信息失败！", e);
			throw new DataAccessException("根据角色名字查询角色信息失败！", e);
		} finally
		{
			JdbcUtil.closeAll(rs, ps,conn);
		}
		return r;
	}
//.................................................................................
	public Volenteer findvolByvolId(Integer volId)   //根据ID查找用户
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Volenteer r = null;
		try
		{
			conn = JdbcUtil.getConn();
			String sql = "select * from volenteer where vol_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, volId);
			rs = ps.executeQuery();
			while (rs.next())
			{
				r = new Volenteer();
				r.setVolid(volId);
				r.setVolname(rs.getString("vol_name"));// 把数据库数据装入对象
				r.setVolidnumber(rs.getString("vol_idnumber"));
				r.setVoltel(rs.getString("vol_tel"));
				r.setVolshichang(rs.getInt("vol_times"));
				r.setTeamid(rs.getInt("team_id"));
			}
		} catch (Exception e)
		{
			log.error("根据角色id查询失败", e);
			throw new DataAccessException("根据角色id查询失败", e);
		} finally
		{
			JdbcUtil.closeAll(rs, ps,conn);
		}
		return r;
	}
//...............................................................
	public void updateRole(Volenteer v)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			conn = JdbcUtil.getConn();
			String sql = "update volenteer set vol_name=? where role_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, v.getVolname());
			ps.setInt(2, v.getVolid());

			ps.executeUpdate();
		} catch (Exception e)
		{
			log.error("更新角色失败！", e);
			throw new DataAccessException("更新角色失败！", e);
		} finally
		{
			JdbcUtil.closeAll(ps,conn);
		}

	}

//...........................................................................
	private VolJueseDao voljuedao=new VolJueseDaoImpl();
	public void insertvolInfo(Volenteer vol)//插入用户
	{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = JdbcUtil.getConn();
			String sql = "insert into volenteer(vol_name,vol_password,vol_idnumber,vol_tel) values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vol.getVolname());
			ps.setString(2, vol.getPassword());
			ps.setString(4, vol.getVolidnumber());
			ps.setString(3, vol.getVoltel());
			ps.executeUpdate();
			voljuedao.insertByvolNameAndRoleIds(vol.getVolname());//给用户赋予普通用户的角色		
		}catch(Exception e){
			log.error("插入用户信息失败",e);
			throw new DataAccessException("插入活动信息失败",e);
		}finally{
			JdbcUtil.closeAll(ps,conn);
		}
		
	}
//10.28.................
	public void deletevolByvolName(String volname) //删除一个用户
	{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = JdbcUtil.getConn();
			String sql = "delete from volenteer where vol_name=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, volname);
			ps.executeUpdate();
		}catch(Exception e){
			log.error("删除用户信息失败",e);
			throw new DataAccessException("删除用户信息失败",e);
		}finally{
			JdbcUtil.closeAll(ps,conn);
		}
		
	}
	public void modfiymyselfinfo(Volenteer vol)//用户修改个人信息
	{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = JdbcUtil.getConn();
			String sql = " UPDATE volenteer SET   vol_idnumber=?, vol_tel=?, vol_password=? WHERE (vol_id=?) AND (vol_name=?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vol.getVolidnumber());
			ps.setString(2, vol.getVoltel());
			ps.setString(3, vol.getPassword());
			ps.setInt(4, vol.getVolid());
			ps.setString(5, vol.getVolname());
			ps.executeUpdate();
		}catch(Exception e){
			log.error("修改用户信息失败",e);
			throw new DataAccessException("修改用户信息失败",e);
		}finally{
			JdbcUtil.closeAll(ps,conn);
		}
	
	}
}
