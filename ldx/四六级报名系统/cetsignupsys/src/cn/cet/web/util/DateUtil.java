package cn.cet.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static String pattern = "yyyyMMdd";
	
	/**
	 * 获取当前系统时间
	 * @param args
	 */
	
	public static String getTime(String pattern) {
		
		Date nowTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		return sdf.format(nowTime);
	}
	
	
	
	public static void main(String[] args) {
		Date nowTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println(sdf.format(nowTime));
		
	}

}
