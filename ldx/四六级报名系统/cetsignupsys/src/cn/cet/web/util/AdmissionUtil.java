package cn.cet.web.util;

import cn.cet.entity.Candidate;

public class AdmissionUtil {
	
	public static String getQueueCode(Candidate c) {
		
		if(c!=null) {
			
			String queueCode = c.getAdmissionCard().substring(8, c.getAdmissionCard().length());
		
			//将序号变成int型
			
			int queueNum = Integer.parseInt(queueCode);
			
			int nowQueue = queueNum+1;
			
			return queueToString(nowQueue);
			
		}
		
		return "0000";
	}
	
	/**
	 * 将序列号转为字符型
	 * @param queue
	 * @return
	 */
	private static String queueToString(int queue) {
		
		String queueString = "";
		if(queue%1000==0) {//三位数
			queueString ="0"+queue+"";
			
		}else if(queue%100==0) {//两位数
			queueString ="00"+queue+"";
		}else  if(queue%10==0) {//一位数
			queueString ="000"+queue;
		}else {
			//四位数不需要管
			queueString = queue+"";
		}

		return queueString;
	}
	
	
	public static void main(String[] args) {
		String str="201804120005";
		System.out.println(str.substring(8, str.length()));
	}

	

}
