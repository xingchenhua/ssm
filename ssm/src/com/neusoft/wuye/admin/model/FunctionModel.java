package com.neusoft.wuye.admin.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

//ϵͳ����Model��
@Alias("Function")
public class FunctionModel {
	//�������
	private int no=0;
	//��������
	private String name=null;
	//���ܵ�ַ
	private String url=null;
	//������Ҫ�ļ���
	private int level=0;
	//����ģ��
	private ModuleModel module=null;
	//ӵ�д˹��ܵ��û��б�
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
