package com.wq.system.persist;

import java.util.Set;


import com.wq.system.domain.Quanxian;

public interface QuanxianinfaoDao
{
	public Set<Quanxian> findquanxianByvolName(String volName);
}
