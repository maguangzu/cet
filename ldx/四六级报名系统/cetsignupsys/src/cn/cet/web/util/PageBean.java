package cn.cet.web.util;

import java.util.List;

public class PageBean<T> {

	private int totalSize;	//总记录
	
	private List<T> items; 
	
	private int pageNo;	//当前页
	
	private int totalPage;	//总页数
	
	private int pageSize = 3;	//每页显示几条记录,默认三条

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalPage() {
		totalPage = totalSize / pageSize;
		if(totalSize % pageSize != 0){
			totalPage++;
		}
		return totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
	
	
}
