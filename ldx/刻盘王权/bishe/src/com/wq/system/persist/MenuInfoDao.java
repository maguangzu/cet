package com.wq.system.persist;

import java.util.List;

import com.wq.system.domain.Menu;

public interface MenuInfoDao
{
	public List<Menu> findFirstLevelMenusByvolName(String userName);
	
	public List<Menu> findSecondLevelMenusByFatherId(Integer fatherId);
}
