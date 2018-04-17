package com.neusoft.wuye.admin.model;

import org.apache.ibatis.type.Alias;

//系统模块Model类
@Alias("Module")
public class ModuleModel {
	private int no=0; //编号
	private String name=null; //模块名称
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
