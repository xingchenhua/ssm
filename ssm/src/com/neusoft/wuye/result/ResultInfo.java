package com.neusoft.wuye.result;

import java.util.List;
//��װ��������������
//������Model���������ҳ������ǰҳpage,ÿҳ��ʾ����rows,Model�����б�
public class ResultInfo<T> {

	private int count=0; //����
	private int pageCount=0; //ҳ��
	private int page=0;
	private int rows=0;
	private List<T> list=null;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
