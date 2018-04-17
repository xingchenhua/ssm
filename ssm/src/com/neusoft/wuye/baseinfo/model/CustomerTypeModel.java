package com.neusoft.wuye.baseinfo.model;

import org.apache.ibatis.type.Alias;

//客户类型Model类
@Alias("CustomerType")
public class CustomerTypeModel {

	private int no=0;
	private String name=null;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
