package com.neusoft.wuye.feeinfo.model;

import org.apache.ibatis.type.Alias;

//付款类型Model类
@Alias("PayType")
public class PayTypeModel {
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
