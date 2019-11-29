package com.lc.pojo;

import java.util.List;

public class PageInfo {

	private int pageSize;
	private int PageNumber;
	private long total;
	private List<?> list;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return PageNumber;
	}
	public void setPageNumber(int pageNumber) {
		PageNumber = pageNumber;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public PageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageInfo(int pageSize, int pageNumber, long total, List<?> list) {
		super();
		this.pageSize = pageSize;
		PageNumber = pageNumber;
		this.total = total;
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageInfo [pageSize=" + pageSize + ", PageNumber=" + PageNumber + ", total=" + total + ", list=" + list
				+ "]";
	}
	
	
	
}
