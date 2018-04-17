package com.neusoft.wuye.admin.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

//系统操作员Model类
@Alias("User")
public class UserModel {
	private String userid=null;
	private String password=null;
	private String name=null;
	private String sex=null;
	private String status=null; //操作是否允许登录状态
	private String loginStatus=null;
	//用户拥有的功能集合
	private List<FunctionModel> functions=null;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public List<FunctionModel> getFunctions() {
		return functions;
	}
	public void setFunctions(List<FunctionModel> functions) {
		this.functions = functions;
	}
	public String getLoginStatus() {
		if(status!=null&&status.equals("Y")){
			loginStatus="允许登录";
		}
		else{
			loginStatus="禁止登录";
		}
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

}
