package com.neusoft.wuye.admin.model;

import org.apache.ibatis.type.Alias;

//ϵͳģ��Model��
@Alias("Module")
public class ModuleModel {
	private int no=0; //���
	private String name=null; //ģ������
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
