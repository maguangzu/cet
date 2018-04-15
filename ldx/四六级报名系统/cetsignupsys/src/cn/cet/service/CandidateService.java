package cn.cet.service;

import java.io.Serializable;
import java.util.List;

import cn.cet.entity.Candidate;
import cn.cet.entity.User;
import cn.cet.web.util.PageBean;

public interface CandidateService extends BaseService<Candidate>{
	
	/**
	 * 根据uid查找考生信息
	 * @param uid
	 * @return
	 */
	public Candidate findCandidateByUid(String uid);
	
	public PageBean<Candidate> pageLists(int currentPage,int pageSize,String condition);
	
	public Candidate findLastRecord();

}
