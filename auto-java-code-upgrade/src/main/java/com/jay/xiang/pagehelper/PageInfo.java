package com.jay.xiang.pagehelper;

import java.util.List;

/**
 * @author xiang.wei
 * @param <T>
 */
public class PageInfo<T>{
	/**
	 * 	//当前页
	 */
	private int pageNum = 1;
	/**
	 * 一页显示几行
	 */
	private int pageSize = 10;
	/**
	 * 总行数
	 */
	private int total;
	/**
	 * 总页数
	 */
	private int pages;
	/**
	 * 数据
	 */
	private List<T> list;
	/**
	 * 跳转url
	 */
	private String requestMapping;

	/**
	 * 是否第一页
	 */
	private boolean isFirstPage = false;
	/**
	 * 是否最后一页
	 */
	private boolean isLastPage = false;
	
	public PageInfo(){
		
	}
	
	public PageInfo(List<T> list) {
		this.list = list;
	}
	
	public PageInfo(int pageNum, int pageSize) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getPages() {
		int pPages = 0;
		if (total > pageSize && total % pageSize == 0) {
			pPages = total / pageSize;
        } else {
        	pPages = total / pageSize + 1;
        }
		return pPages;
	}
	
	public void setPages(int pages) {
		this.pages = pages;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
	public boolean getIsFirstPage() {
		if (pageNum == 1) {
           return true;
        }else{
           return false;
        }
	}
	
	public boolean isFirstPage() {
		return getIsFirstPage();
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}
	
	
	public boolean getIsLastPage() {
		if (pageNum == getPages()) {
	       return true;
	    }else{
	        return false;
	    }
	}
	
	public boolean isLastPage() {
		return getIsLastPage();
	}
	
	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getRequestMapping() {
		return requestMapping;
	}

	public void setRequestMapping(String requestMapping) {
		this.requestMapping = requestMapping;
	}

	@Override
	public String toString() {
		return "PageInfo [pageNum=" + pageNum + ", pageSize=" + pageSize
				+ ", pages=" + pages + ", isFirstPage=" + isFirstPage
				+ ", isLastPage=" + isLastPage + "]";
	}
}
