package cn.cet.dao.impl;


import java.io.Serializable;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.cet.dao.CandidateDao;
import cn.cet.dao.UserDao;
import cn.cet.entity.Candidate;
import cn.cet.entity.User;
import cn.cet.web.util.PageBean;



@Repository("candidateDao")
public class CandidateDaoImpl extends BaseDaoImpl<Candidate> implements CandidateDao {

	@Override
	public Candidate findCandidateByUid(String uid) {
		Query query=getSessionFactory().getCurrentSession().createQuery("from Candidate c where c.user.id = ?");
		query.setString(0, uid);
		return (Candidate) query.uniqueResult();
	}

	@Override
	public PageBean<Candidate> pageLists(int currentPage, int pageSize,String condition) {
		
		System.out.println("condition="+condition);
		String hql = "from Candidate ";
		boolean flag = false;
		if(condition!=null&&condition!="") {
			hql="from Candidate as h where h.cetType=?";
			flag=true;
		}
		
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		
		
		Query query2 = getSessionFactory().getCurrentSession().createQuery(hql);
		
		if(flag) {
			query.setParameter(0,condition);
			query2.setParameter(0, condition);
		}
		
		query.setFirstResult((currentPage-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Candidate> list =query.list();
		
		int totalSize=query2.list().size();
		int totalPage=0;
		if(totalSize==0) {
			totalPage=1;
		}else{
			totalPage=(totalSize-1)/pageSize + 1;
		}
		
		
		PageBean<Candidate> pg=new PageBean<>();
		
		pg.setItems(list);
		
		pg.setPageNo(currentPage);
		
		pg.setTotalSize(totalSize);
		
		pg.setTotalPage(totalPage);
		
		return pg;
	}

	@Override
	public Candidate findLastRecord() {
		// TODO Auto-generated method stub
		String hql="from Candidate order by createTime desc";
		
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(1);
		
		return (Candidate) query.uniqueResult();
	}

	

	

}
