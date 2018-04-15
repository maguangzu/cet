package com.wq.system.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class JdbcUtil
{
	private static final Logger log = LoggerFactory.getLogger(JdbcUtil.class);
	private static MysqlDataSource ds;
	private static String CLASS_NAME;
	private static String USER_NAME;
	private static String USER_PWD;
	private static String DB_URL;
	public static ThreadLocal<Connection> tl = new ThreadLocal<Connection>(); 	
	static
	{
		ResourceBundle rb = ResourceBundle.getBundle("db");
		CLASS_NAME = rb.getString("class_name");
		USER_NAME = rb.getString("user_name");
		USER_PWD = rb.getString("user_pwd");
		DB_URL = rb.getString("db_url");
		
		ds = new MysqlDataSource();
		ds.setDatabaseName(CLASS_NAME);
		ds.setUrl(DB_URL);
		ds.setServerName(USER_NAME);
		ds.setPassword(USER_PWD);
		ds.setCharacterEncoding("utf_8");
	}	
	public static Connection createConn()
	{
		Connection conn = null;
		try{
			Class.forName(CLASS_NAME);
			conn = DriverManager.getConnection(DB_URL, USER_NAME, USER_PWD);
		}catch(Exception e){
			log.error("从连接池获取连接失败",e);
		}		
		return conn;
	}

	public static Connection getConn()
	{
		Connection conn = null;
		try
		{
			Class.forName(CLASS_NAME);
			conn = DriverManager.getConnection(DB_URL, USER_NAME, USER_PWD);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeAll(ResultSet rs, PreparedStatement ps, Connection conn)
	{
		if (rs != null)
		{
			try
			{
				rs.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		if (ps != null)
		{
			try
			{
				ps.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		if (conn != null)
		{
			try
			{
				conn.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	public static void closeAll(PreparedStatement ps, Connection conn)
	{
		closeAll(null, ps, conn);
	}

	public static void closeAll(Connection conn)
	{
		closeAll(null, null, conn);
	}
	
	public static void closeAll(ResultSet rs, PreparedStatement ps)
	{
		if (rs != null)
		{
			try
			{
				rs.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		if (ps != null)
		{
			try
			{
				ps.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	public static void closeAll(PreparedStatement ps)
	{
		if (ps != null)
		{
			try
			{
				ps.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
