package com.wq.system.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wq.system.exception.DataAccessException;
import com.wq.system.util.JdbcUtil;
//10.28
public class VolJueseDaoImpl implements VolJueseDao
{
	private static final Logger log = LoggerFactory.getLogger(VolenteerinfoDaoimpl.class);

	public void deleteByvolName(String volname)
	{
	Connection conn = null;
	PreparedStatement ps = null;
	try{
		conn = JdbcUtil.getConn();
		String sql = "delete from juese_volenteer where vol_name=?";//需要重写 多表查询  通过名字查用户表和用户角色中间表然后删除相应数据
		ps = conn.prepareStatement(sql);
		ps.setString(1, volname);
		ps.executeUpdate();
	}catch(Exception e){
		log.error("删除用户对应角色失败！",e);
		throw new DataAccessException("删除用户对应角色失败！",e);
	}finally{
		JdbcUtil.closeAll(ps);
	}
}

/////给新用户赋予普通用户角色
public void insertByvolNameAndRoleIds(String volname)
{
	Connection conn = null;
	PreparedStatement ps = null;
	try{
		conn = JdbcUtil.getConn();
		String sql = "insert into juese_volenteer(vol_name,juese_id) values(?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, volname);
		ps.setInt(2,6);//普通用户角色的id
		ps.addBatch();
		ps.executeBatch();
	}catch(Exception e){
		log.error("插入用户对应角色失败！",e);
		throw new DataAccessException("插入用户对应角色失败！",e);
	}finally{
		JdbcUtil.closeAll(ps,conn);
	}
}



}
