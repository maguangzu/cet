package com.wq.active.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wq.active.domain.Active;
import com.wq.system.domain.Page;
import com.wq.system.domain.Quanxian;
import com.wq.system.domain.Volenteer;
import com.wq.system.exception.DataAccessException;
import com.wq.system.persist.BaseDao;
import com.wq.system.persist.VolenteerinfoDaoimpl;
import com.wq.system.util.Constants;
import com.wq.system.util.JdbcUtil;

public class ActiveinfaoDaoimpl extends BaseDao implements ActiveinfaoDao {

	SimpleDateFormat sdf=new SimpleDateFormat();
	private static final Logger log = LoggerFactory.getLogger(VolenteerinfoDaoimpl.class);

	//查找当前用户的活动信息
	public Set<Active> findactiveByvolname(String volName) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		Set<Active> set = new HashSet<Active>();
		try
		{
			conn = JdbcUtil.getConn();//多表查询 通过name查出当前用户的active的信息
			String str = "select at.* from volenteer vol, volteer_active va,active at where vol.vol_id=va.vol_id and va.active_id=at.active_id and vol_name =?";
			ps = conn.prepareStatement(str);
			ps.setString(1, volName);
			res = ps.executeQuery();
			while (res.next())
			{//将active的信息装入at对象
				Active at = new Active();
				at.setActiveid(res.getInt("active_id"));
				at.setActivename(res.getString("active_name"));
				at.setBegintime(res.getString("active_begtime"));
				at.setEndtime(res.getString("active_endtime"));
				at.setActiveshichang(res.getInt("active_shichang"));
				at.setActivevolnum(res.getInt("active_volnum"));
				at.setActiveaddrees(res.getString("active_addrees"));
				at.setActivemajor(res.getString("active_major"));
				at.setActivezhtai(res.getInt("active_zhtai"));	
				set.add(at);
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

	
	
	//创建活动信息
	public void addActiveInfo(Active at,Volenteer vol) {
		
			Connection conn = null;
			PreparedStatement ps = null;
			try{
				conn = JdbcUtil.getConn();
				String sql = "INSERT INTO active ( active_name, active_begtime, active_endtime, active_shichang, active_userid,  active_volnum, active_addrees, active_major, active_zhtai) VALUES (?,?,?,?,?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
                ps.setString(1,at.getActivename());
                ps.setString(2,at.getBegintime());
                ps.setString(3,at.getEndtime());
                ps.setInt(4, at.getActiveshichang());
                ps.setInt(5, vol.getVolid());//用户的id
                ps.setInt(6,at.getActivevolnum());
                ps.setString(7,at.getActiveaddrees());
                ps.setString(8, at.getActivemajor());
				ps.setInt(9,0);
				ps.executeUpdate();
			}catch(Exception e){
				log.error("发起活动失败！",e);
				throw new DataAccessException("发起活动失败！",e);
			}finally{
				JdbcUtil.closeAll(ps);
			}			
	}


	public Page<Active> findAllats(Active at, int currentPage) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Page<Active> page = new Page<Active>();
		List<Active> list = new ArrayList<Active>();
		try{
			conn = JdbcUtil.getConn();
			String sql = genSql(at);
			page.setCurrentPage(currentPage);
			genTotalPageAndTotalNumber(sql, page<Active>, new SetParameter()
			{
				
				public void setParameter(PreparedStatement ps)
				{
					
				}
			});
			
			String sql2 = genPageSql(at);
			ps = conn.prepareStatement(sql2);
			int begin = (int) ((currentPage-1)*Constants.ITEM_PER_PAGE+1);
			int end = (int) (begin + Constants.ITEM_PER_PAGE - 1);
			ps.setInt(1, begin);
			ps.setInt(2, end);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Active at2 = new Active();
				at2.setActivename(rs.getString("active_name"));
				at2.setActiveaddrees(rs.getString("active_addrees"));
				at2.setActiveshuxing(rs.getString("active_shuxing"));
				at2.setActiveuser(rs.getInt("active_user"));
				at2.setActivevolnum(rs.getInt("active_volnum"));
				at2.setBegintime(sdf.format(rs.getDate("active_begtime")));
				at2.setEndtime(sdf.format(rs.getDate("active_endtime")));
				at2.setActiveshichang(rs.getInt("active_shichang"));
				list.add(at2);
			}
			
			page.setList(list);
		}catch(Exception e){
			log.error("分页查询用户信息失败",e);
			throw new DataAccessException("分页查询用户信息失败",e);
		}finally{
			JdbcUtil.closeAll(rs,ps);
		}
		return page;
	}

	private String genSql(Active at)
	{
		StringBuilder sql = new StringBuilder("select a.* from active a where 1=1");
		if(at.getActivename()!=null && at.getActivename().length()>0)
		{
			sql.append(" and active_name like '%").append(at.getActivename()).append("%'");
		}
		if(at.getBegintime()!=null && at.getBegintime().length()>0)
		{
			sql.append(" and active_begtime like '%").append(at.getBegintime()).append("%'");
		}
		if(at.getActiveaddrees()!=null && at.getActiveaddrees().length()>0)
		{
			sql.append(" and active_addrees like '%").append(at.getActiveaddrees()).append("%'");
		}
		if(at.getActiveshuxing()!=null && at.getActiveshuxing().length()>0)
		{
			sql.append(" and user_sex ='").append(at.getActiveshuxing()).append("'");
		}
		return sql.toString();
	}
	
	private String genPageSql(Active at)
	{
		StringBuilder sql = new StringBuilder("select a.* from (select rownum rn,u.* from active u where 1=1");
		if(at.getActivename()!=null && at.getActivename().length()>0)
		{
			sql.append(" and active_name like '%").append(at.getActivename()).append("%'");
		}
		if(at.getBegintime()!=null && at.getBegintime().length()>0)
		{
			sql.append(" and active_begtime like '%").append(at.getBegintime()).append("%'");
		}
		if(at.getActiveaddrees()!=null && at.getActiveaddrees().length()>0)
		{
			sql.append(" and active_addrees like '%").append(at.getActiveaddrees()).append("%'");
		}
		if(at.getActiveshuxing()!=null && at.getActiveshuxing().length()>0)
		{
			sql.append(" and user_sex ='").append(at.getActiveshuxing()).append("'");
		}
		sql.append(") a where a.rn between ? and ?");
		return sql.toString();
	}



    /**
     * 查找我创建的活动
     */
	public Page<Active> findmyactive(int volid,int currentPage) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Active> list = new ArrayList<Active>();
		Page<Active> page = new Page<Active>();
		page.setCurrentPage(currentPage);
		try
		{
			conn = JdbcUtil.getConn();
			String sql = "select * from active where active_userid = ?";
			genTotalPageAndTotalNumber(sql, page, new Object[] { volid },new int[] { Types.INTEGER });
			String findSql = "select v.* from active v where v.active_userid =  ?  LIMIT ?,?";
			ps = conn.prepareStatement(findSql);
			ps.setInt(1, volid);

			int from =  (int)((currentPage - 1) * Constants.ITEM_PER_PAGE );
			int to = (int)(from + Constants.ITEM_PER_PAGE );
			ps.setInt(2, from);
			ps.setInt(3, to);
			rs = ps.executeQuery();
			while (rs.next())
			{
				Active at = new Active();
				at.setActiveid(rs.getInt("active_id"));
				at.setActivename(rs.getString("active_name"));
				at.setBegintime(rs.getString("active_begtime"));
				at.setEndtime(rs.getString("active_endtime"));
				at.setActiveshichang(rs.getInt("active_shichang"));
				at.setActivevolnum(rs.getInt("active_volnum"));
				at.setActiveaddrees(rs.getString("active_addrees"));
				at.setActivemajor(rs.getString("active_major"));
				at.setActivezhtai(rs.getInt("active_zhtai"));
				list.add(at);
			}
			page.setList(list);
		} catch (Exception e)
		{
			log.error("查询全部角色信息失败！", e);
			throw new DataAccessException("查询全部角色信息失败！", e);
		} finally
		{
			JdbcUtil.closeAll(rs, ps);
		}
		return page;
	}
	/**
     * 查找所有通过审核的活动
     */
	public Page<Active> findallshactive(int volid,int currentPage) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Active> list = new ArrayList<Active>();
		Page<Active> page = new Page<Active>();
		page.setCurrentPage(currentPage);
		try
		{
			conn = JdbcUtil.getConn();
			String sql = "select * from active where active_zhtai = ?";
			genTotalPageAndTotalNumber(sql, page, new Object[] { 1 },new int[] { Types.INTEGER });
			String findSql = "select v.* from active v where v.active_zhtai =?  LIMIT ?,?";
			ps = conn.prepareStatement(findSql);
			ps.setInt(1, 1);

			int from =  (int)((currentPage - 1) * Constants.ITEM_PER_PAGE );
			int to = (int)(from + Constants.ITEM_PER_PAGE );
			ps.setInt(2, from);
			ps.setInt(3, to);
			rs = ps.executeQuery();
			while (rs.next())
			{
				Active at = new Active();
				at.setActiveid(rs.getInt("active_id"));
				at.setActivename(rs.getString("active_name"));
				at.setBegintime(rs.getString("active_begtime"));
				at.setEndtime(rs.getString("active_endtime"));
				at.setActiveshichang(rs.getInt("active_shichang"));
				at.setActivevolnum(rs.getInt("active_volnum"));
				at.setActiveaddrees(rs.getString("active_addrees"));
				at.setActivemajor(rs.getString("active_major"));
				at.setActivezhtai(rs.getInt("active_zhtai"));
				list.add(at);
			}
			page.setList(list);
		} catch (Exception e)
		{
			log.error("查询全部角色信息失败！", e);
			throw new DataAccessException("查询全部角色信息失败！", e);
		} finally
		{
			JdbcUtil.closeAll(rs, ps);
		}
		return page;
	}
	/**
     * 查找所有活动
     */
	public Page<Active> findallactive(int volid,int currentPage) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Active> list = new ArrayList<Active>();
		Page<Active> page = new Page<Active>();
		page.setCurrentPage(currentPage);
		try
		{
			conn = JdbcUtil.getConn();
			String sql = "select * from active where active_name like ?";
			genTotalPageAndTotalNumber(sql, page, new Object[] { "%%" },new int[] { Types.VARCHAR });
			String findSql = "select v.* from active v where v.active_name like ?  LIMIT ?,?";
			ps = conn.prepareStatement(findSql);
			ps.setString(1, "%%");

			int from =  (int)((currentPage - 1) * Constants.ITEM_PER_PAGE );
			int to = (int)(from + Constants.ITEM_PER_PAGE );
			ps.setInt(2, from);
			ps.setInt(3, to);
			rs = ps.executeQuery();
			while (rs.next())
			{
				Active at = new Active();
				at.setActiveid(rs.getInt("active_id"));
				at.setActivename(rs.getString("active_name"));
				at.setBegintime(rs.getString("active_begtime"));
				at.setEndtime(rs.getString("active_endtime"));
				at.setActiveshichang(rs.getInt("active_shichang"));
				at.setActivevolnum(rs.getInt("active_volnum"));
				at.setActiveaddrees(rs.getString("active_addrees"));
				at.setActivemajor(rs.getString("active_major"));
				at.setActivezhtai(rs.getInt("active_zhtai"));
				list.add(at);
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
	/**
	 * 加入活动
	 */
    public void joinactive(int volid,int activeid){
    	Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			conn = JdbcUtil.getConn();
			String sql = "INSERT INTO volteer_active  (vol_id, active_id) VALUES (?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, volid);
			ps.setInt(2, activeid);
			ps.executeUpdate();
			
		} catch (Exception e)
		{
			log.error("加入活动失败！", e);
			throw new DataAccessException("加入活动失败！", e);
		} finally
		{
			JdbcUtil.closeAll( ps,conn);
		}
    	
    	
    }
    /**
	 * 查询是否存加入活动     true 加入了
	 */
    public boolean selectjoinactive(int volid ,int activeid){
    	Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean returnrs=false;
		try
		{
			conn = JdbcUtil.getConn();
			String sql = "select * from volteer_active where vol_id= ? And active_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, volid);
			ps.setInt(2, activeid);
			rs = ps.executeQuery();
			while (rs.next())
			{
				returnrs=true;
			}
			
		} catch (Exception e)
		{
			log.error("查询全部角色信息失败！", e);
			throw new DataAccessException("查询全部角色信息失败！", e);
		} finally
		{
			JdbcUtil.closeAll(rs, ps,conn);
		}
		return returnrs;
    }



	public void modfiyactive(int ac,int zhtai) {
		Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			conn = JdbcUtil.getConn();
			String sql = "UPDATE active SET  active_zhtai=? WHERE active_id=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, zhtai);
			ps.setInt(2, ac);
			ps.executeUpdate();
			
		} catch (Exception e)
		{
			log.error("关闭活动失败！", e);
			throw new DataAccessException("关闭活动失败！", e);
		} finally
		{
			JdbcUtil.closeAll( ps,conn);
		}
    	
		
	}
}
