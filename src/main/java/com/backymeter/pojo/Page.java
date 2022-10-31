package com.backymeter.pojo;

import java.util.List;

// 採用泛型 可因應各式Bean
public class Page<T> {
	
	public static final Integer PAGE_SIZE = 15;
	
	// 當前頁碼
	private Integer pageNo;
	// 總頁碼
	private Integer pageTotal;
	// 總筆數
	private Integer pageTotalCount;
	// 分頁筆數
	private Integer pageSize = PAGE_SIZE;
	// 分頁數據
	private List<T> items;
	// 後來新增 抽取以便之後應用 分頁條的請求地址
	private String url;
	
	
	public Page(Integer pageNo, Integer pageTotal, Integer pageTotalCount,
				List<T> items) {
		
		this.pageNo = pageNo;
		this.pageTotal = pageTotal;
		this.pageTotalCount = pageTotalCount;
		this.items = items;
		
	}
	
	public Page() {
		
	}
	
	public Integer getPageNo() {
		return pageNo;
	}
	
	public void setPageNo(Integer pageNo) {
		// 確保分頁邊界在有效範圍內
		if(pageNo<1) {
			pageNo = 1;
		}
		if(pageNo>pageTotal) {
			pageNo = pageTotal;
		}
		
		this.pageNo = pageNo;
	}
	
	public Integer getPageTotal() {
		return pageTotal;
	}
	
	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}
	
	public Integer getPageTotalCount() {
		return pageTotalCount;
	}
	
	public void setPageTotalCount(Integer pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}
	
	public Integer getPageSize(){
		return pageSize;
	}
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public List<T> getItems() {
		return items;
	}
	
	public void setItems(List<T> items) {
		this.items = items;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String toString() {
		return "Page{" + 
			   "pageNo=" + pageNo +
			   ", pageTotal=" + pageTotal +
			   ", pageTotalCount=" + pageTotalCount +
			   ", pageSize=" + pageSize +
			   ", items=" + items +
			   ", url='" + url + "'" +
			   "}";
	}
	
}
