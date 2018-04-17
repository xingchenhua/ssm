package com.neusoft.wuye.admin.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

//系统功能Model类
@Alias("Function")
public class FunctionModel {
	//功能序号
	private int no=0;
	//功能名称
	private String name=null;
	//功能地址
	private String url=null;
	//功能需要的级别
	private int level=0;
	//功能模块
	private ModuleModel module=null;
	//拥有此功能的用户列表
	private List<UserModel> users=null;
	
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public List<UserModel> getUsers() {
		return users;
	}
	public void setUsers(List<UserModel> users) {
		this.users = users;
	}
	public ModuleModel getModule() {
		return module;
	}
	public void setModule(ModuleModel module) {
		this.module = module;
	}
	
	
	
	
}
