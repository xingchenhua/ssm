package com.neusoft.wuye.admin.service;

import java.util.List;

import com.neusoft.wuye.admin.model.FunctionModel;
import com.neusoft.wuye.admin.model.UserModel;

//ϵͳ����Աҵ��ӿ�
public interface IUserService {
	//�����û�
	public void add(UserModel um) throws Exception;
	//�޸��û�
	public void modify(UserModel um) throws Exception;
	//ɾ���û�
	public void delete(UserModel um) throws Exception;
	//
	public UserModel get(String userid) throws Exception;
	//ȡ�����й���Ա�б�
	public List<UserModel> getListByAll() throws Exception;
	
	//ȡ�����й���Ա�б�,��ҳģʽ
	public List<UserModel> getListByAllWithPage(int rows,int page) throws Exception;
	//ȡ�����в���Ա����
	public int getCountByAll() throws Exception;
	//ȡ�����в���Աҳ��
	public int getPageCountByAll(int rows) throws Exception;
	//����Ա��֤���������ڵ�¼��֤
	public boolean validate(String userid,String password) throws Exception;
	//���ָ���Ĳ���Ա�Ƿ������¼ϵͳ
	public boolean checkCanLogin(String userid) throws Exception;
	//���ָ����ID�Ƿ���ڣ������������û�ʱ���
	public boolean checkUserExist(String userid) throws Exception;
	//Ϊָ����Ա������һ������
	public void grantFunction(String userid,int functionNo) throws Exception;
	//Ϊָ����Ա������������
	public void grantFunctions(String userid,int[] functionNos) throws Exception;
	//ȡ��ָ���û��Ĺ����б�
	public List<FunctionModel> getFunctionsByUser(String userid) throws Exception;
	//���˲���Ա�ܷ�ɾ��
	public boolean checkCanDelete(String userid) throws Exception;
	//�����û������й���Ȩ��
	public void revoleFunctions(String userid) throws Exception;
	//���ò���Ա��¼״̬
	public void settingLoginStatus(UserModel um) throws Exception;
	//�޸Ĳ���Ա����
	public void changePassword(UserModel um) throws Exception;
	
}
