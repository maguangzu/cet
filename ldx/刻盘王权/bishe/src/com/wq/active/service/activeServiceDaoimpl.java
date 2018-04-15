package com.wq.active.service;

import java.util.HashSet;
import java.util.Set;

import com.wq.active.domain.Active;
import com.wq.active.persist.ActiveinfaoDao;
import com.wq.active.persist.ActiveinfaoDaoimpl;
import com.wq.system.domain.Page;
import com.wq.system.domain.Volenteer;

public class activeServiceDaoimpl implements activeServiceDao 
{
    private ActiveinfaoDao activeinfaodao=new ActiveinfaoDaoimpl();


	public void addactiveInfo(Active at,Volenteer vol) {
		
		activeinfaodao.addActiveInfo(at,vol);
	}


	
	public Page<Active> findAllactive(Active at, int currentPage) 
	{
		ActiveinfaoDao activeinfaoDao=new ActiveinfaoDaoimpl();
		return activeinfaoDao.findAllats(at, currentPage);
		
	}



	@Override
	public Page<Active> findMyActive(int volid,int currentPage) {
		ActiveinfaoDao activeinfaoDao=new ActiveinfaoDaoimpl();
		return activeinfaoDao.findmyactive(volid,currentPage);
	}



	@Override
	public Page<Active> findallshactive(int volid, int page) {
		ActiveinfaoDao activeinfaoDao=new ActiveinfaoDaoimpl();
		return activeinfaoDao.findallshactive(volid,page);
	}

  

}
