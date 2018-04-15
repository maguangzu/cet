package com.wq.system.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wq.system.domain.Page;

import com.wq.system.exception.DataAccessException;
import com.wq.system.util.Constants;
import com.wq.system.util.JdbcUtil;

public class BaseDao
{
	private static final Logger log = LoggerFactory.getLogger(BaseDao.class);
	
	public void genTotalPageAndTotalNumber(String sql,Page<?> p,Object[] data,int[] types)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConn();
			String countSql = "select count(*) from ("+sql+") As aa";
			ps = conn.prepareStatement(countSql);
			
			for(int i=0;i<data.length;i++)
			{
				ps.setObject(i+1, data[i], types[i]);
			}
			
			rs = ps.executeQuery();
			int totalNumber = 0;
			while(rs.next())
			{
				totalNumber = (int) rs.getLong(1);
			}			
			p.setTotalNumber(totalNumber);
			//查询总页数失败
			int totalPage = (int)Math.ceil(totalNumber/Constants.ITEM_PER_PAGE);
			p.setTotalPage(totalPage);
		}catch(Exception e){
			log.error("查询总页数失败",e);
			throw new DataAccessException("查询总页数失败",e);
		}finally{
			JdbcUtil.closeAll(rs,ps);
		}	
	}
}
