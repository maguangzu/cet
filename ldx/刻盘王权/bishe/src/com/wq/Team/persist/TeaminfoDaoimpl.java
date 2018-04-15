package com.wq.Team.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.wq.Team.domain.Team;
import com.wq.active.domain.Active;
import com.wq.system.domain.Menu;
import com.wq.system.domain.Page;
import com.wq.system.exception.DataAccessException;
import com.wq.system.persist.BaseDao;
import com.wq.system.util.Constants;
import com.wq.system.util.JdbcUtil;

public class TeaminfoDaoimpl extends BaseDao implements TeaminfoDao {

	
	public Team findteamByvolname(String volName)  //通过用户名返回一个team
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Team tm=null;
		try{
			conn = JdbcUtil.getConn();//多表查询，通过volname查出Team的信息
			String sql = "select t.* from volenteer vol,team t where vol.team_id=t.team_id and vol_name=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, volName);
			rs = ps.executeQuery();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			while(rs.next())
			{
				tm = new Team();//把数据库数据装入一个TEAM对象，
				tm.setTeamid(rs.getInt("team_id"));
//			    tm.setTeammadetime(sdf.format(rs.getDate("team_madetime"));
//				tm.setTeamdeltime(sdf.format(rs.getDate("team_deltime")));
				tm.setTeammadetime(rs.getString("team_madetime"));
				tm.setTeamdeltime(rs.getString("team_deltime"));
				tm.setTeamname(rs.getString("team_name"));
				tm.setTeamusername(rs.getString("team_username"));
				tm.setTeamusernum(rs.getInt("team_usernum"));
				tm.setTeamdeltime(rs.getString("team_desc"));
				tm.setTeamjs(rs.getString("team_js"));
				tm.setTeamzhtai(rs.getString("team_zhtai"));				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(rs,ps);
		}
		return tm;
		
	}

	@Override
	public void addTeam(Team team) {
		
		
	}
/**
 * 查找我创建的团队
 * @param volname
 */
	public Team findMyCreateTeambyvolname(String volname) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Team tm=null;
		try{
			conn = JdbcUtil.getConn();//查询团队表
			String sql = "select * from team where team_username=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, volname);
			rs = ps.executeQuery();
			//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			while(rs.next())
			{
				tm = new Team();//把数据库数据装入一个TEAM对象，
				tm.setTeamid(rs.getInt("team_id"));
//			    tm.setTeammadetime(sdf.format(rs.getDate("team_madetime")));
//				tm.setTeamdeltime(sdf.format(rs.getDate("team_deltime")));
				tm.setTeammadetime(rs.getString("team_madetime"));
				tm.setTeamdeltime(rs.getString("team_deltime"));
				tm.setTeamname(rs.getString("team_name"));
				tm.setTeamusername(rs.getString("team_username"));
				tm.setTeamusernum(rs.getInt("team_usernum"));
				tm.setTeamdeltime(rs.getString("team_desc"));
				tm.setTeamjs(rs.getString("team_js"));
				tm.setTeamzhtai(rs.getString("team_zhtai"));				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(rs,ps);
		}
		return tm;
	}
	/**
	 * 查找我参加的团队
	 * @param volname
	 */
	public Team findMyJoinTeambyvolname(String volname){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Team tm=null;
		try{
			conn = JdbcUtil.getConn();//团队表和志愿者表关联查询
			String sql = "select tt.* from team tt,volenteer vv  WHERE vv.team_id=tt.team_id AND vv.vol_name=?";
			ps.setString(1, volname);
			rs = ps.executeQuery();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			while(rs.next())
			{
				tm = new Team();//把数据库数据装入一个TEAM对象，
				tm.setTeamid(rs.getInt("team_id"));
//			    tm.setTeammadetime(sdf.format(rs.getDate("team_madetime")));
//				tm.setTeamdeltime(sdf.format(rs.getDate("team_deltime")));
				tm.setTeammadetime(rs.getString("team_madetime"));
				tm.setTeamdeltime(rs.getString("team_deltime"));
				tm.setTeamname(rs.getString("team_name"));
				tm.setTeamusername(rs.getString("team_username"));
				tm.setTeamusernum(rs.getInt("team_usernum"));
				tm.setTeamdeltime(rs.getString("team_desc"));
				tm.setTeamjs(rs.getString("team_js"));
				tm.setTeamzhtai(rs.getString("team_zhtai"));				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(rs,ps,conn);
		}
		return tm;
	}
	/**
	 * 查找所有通过审核的团队
	 * @param volname
	 */
	public Page<Team> findallshTeam(int volid, int currentPage) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Team> list = new ArrayList<Team>();
		Page<Team> page = new Page<Team>();
		page.setCurrentPage(currentPage);
		try
		{
			conn = JdbcUtil.getConn();
			String sql = "select * from team where team_zhtai like ?";
			genTotalPageAndTotalNumber(sql, page, new Object[] { "%通过%" },new int[] { Types.VARCHAR});
			String findSql = "select v.* from team v where v.team_zhtai like ?  LIMIT ?,?";
			ps = conn.prepareStatement(findSql);
			String ssss="%通过%";
			ps.setString(1, ssss);
			int from =  (int)((currentPage - 1) * Constants.ITEM_PER_PAGE );
			int to = (int)(from + Constants.ITEM_PER_PAGE );
			ps.setInt(2, from);
			ps.setInt(3, to);
			rs = ps.executeQuery();
			System.out.println("11111111111");
			while (rs.next())
			{
				Team tm = new Team();
				tm.setTeamid(rs.getInt("team_id"));
//			    tm.setTeammadetime(sdf.format(rs.getDate("team_madetime")));
//				tm.setTeamdeltime(sdf.format(rs.getDate("team_deltime")));
				tm.setTeammadetime(rs.getString("team_madetime"));
				tm.setTeamdeltime(rs.getString("team_deltime"));
				tm.setTeamname(rs.getString("team_name"));
				tm.setTeamusername(rs.getString("team_username"));
				tm.setTeamusernum(rs.getInt("team_usernum"));
				tm.setTeamdeltime(rs.getString("team_desc"));
				tm.setTeamjs(rs.getString("team_js"));
				tm.setTeamzhtai(rs.getString("team_zhtai"));
				System.out.println(tm.getTeamid());
				list.add(tm);
			}
			page.setList(list);
		} catch (Exception e)
		{
			
			throw new DataAccessException("查询全部角色信息失败！", e);
		} finally
		{
			JdbcUtil.closeAll(rs, ps,conn);
		}
		return page;
	}
	
	/**
	 * 查找所有通过审核的团队
	 * @param volname
	 */
	public Page<Team> findallteam(int volid, int currentPage) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Team> list = new ArrayList<Team>();
		Page<Team> page = new Page<Team>();
		page.setCurrentPage(currentPage);
		try
		{
			conn = JdbcUtil.getConn();
			String sql = "select * from team where team_name like ?";
			genTotalPageAndTotalNumber(sql, page, new Object[] { "%%" },new int[] { Types.VARCHAR});
			String findSql = "select v.* from team v where v.team_name like ?  LIMIT ?,?";
			ps = conn.prepareStatement(findSql);
			ps.setString(1, "%%");
			int from =  (int)((currentPage - 1) * Constants.ITEM_PER_PAGE );
			int to = (int)(from + Constants.ITEM_PER_PAGE );
			ps.setInt(2, from);
			ps.setInt(3, to);
			rs = ps.executeQuery();
			while (rs.next())
			{
				Team tm = new Team();
				tm.setTeamid(rs.getInt("team_id"));
//			    tm.setTeammadetime(sdf.format(rs.getDate("team_madetime")));
//				tm.setTeamdeltime(sdf.format(rs.getDate("team_deltime")));
				tm.setTeammadetime(rs.getString("team_madetime"));
				tm.setTeamdeltime(rs.getString("team_deltime"));
				tm.setTeamname(rs.getString("team_name"));
				tm.setTeamusername(rs.getString("team_username"));
				tm.setTeamusernum(rs.getInt("team_usernum"));
				tm.setTeamdeltime(rs.getString("team_desc"));
				tm.setTeamjs(rs.getString("team_js"));
				tm.setTeamzhtai(rs.getString("team_zhtai"));		
				list.add(tm);
			}
			page.setList(list);
		} catch (Exception e)
		{
			
			throw new DataAccessException("查询全部角色信息失败！", e);
		} finally
		{
			JdbcUtil.closeAll(rs, ps,conn);
		}
		return page;
	}

	public void modfiyteam(int ac, String string) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			conn = JdbcUtil.getConn();
			String sql = "UPDATE team SET  team_zhtai=? WHERE team_id=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, string);
			ps.setInt(2, ac);
			ps.executeUpdate();
			
		} catch (Exception e)
		{
		
			throw new DataAccessException("关闭活动失败！", e);
		} finally
		{
			JdbcUtil.closeAll( ps,conn);
		}
    	
	}
}
