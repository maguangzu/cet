package cn.cet.service.impl;

import java.io.Serializable;
import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.cet.dao.CandidateDao;
import cn.cet.dao.UserDao;
import cn.cet.entity.Candidate;
import cn.cet.entity.User;
import cn.cet.service.BaseService;
import cn.cet.service.CandidateService;
import cn.cet.service.UserService;
import cn.cet.web.util.PageBean;

@Service("candidateService")
public class CandidateServiceImpl extends BaseServiceImpl<Candidate> implements CandidateService {
	
	private CandidateDao candidateDao;
	
	@Resource(name="candidateDao")
	public void setCandidateDao(CandidateDao candidateDao) {
		super.setBaseDao(candidateDao);
		this.candidateDao=candidateDao;
	}

	@Override
	public Candidate findCandidateByUid(String uid) {
		// TODO Auto-generated method stub
		return candidateDao.findCandidateByUid(uid);
	}

	@Override
	public PageBean<Candidate> pageLists(int currentPage, int pageSize, String condition) {
		// TODO Auto-generated method stub
		return candidateDao.pageLists(currentPage, pageSize, condition);
	}

	@Override
	public Candidate findLastRecord() {
		// TODO Auto-generated method stub
		return candidateDao.findLastRecord();
	}

	

	
	

	

}
