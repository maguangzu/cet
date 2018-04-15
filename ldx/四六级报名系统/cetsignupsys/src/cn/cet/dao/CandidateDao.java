package cn.cet.dao;

import java.io.Serializable;



import java.util.List;

import cn.cet.entity.Candidate;
import cn.cet.entity.User;
import cn.cet.web.util.PageBean;



public interface CandidateDao extends BaseDao<Candidate> {

	
	public Candidate findCandidateByUid(String uid);
  

	
	public PageBean<Candidate> pageLists(int currentPage,int pageSize,String condition);
	
	
	public Candidate findLastRecord();
}
