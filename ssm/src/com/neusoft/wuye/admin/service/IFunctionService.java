package com.neusoft.wuye.admin.service;

import java.util.List;

import com.neusoft.wuye.admin.model.FunctionModel;

//ϵͳ����ҵ��ӿ�

public interface IFunctionService {
	//ȡ��ָ���Ĺ���
	public FunctionModel get(int functionNo) throws Exception;
	//ȡ�����й����б�
	public List<FunctionModel> getListByAll() throws Exception;
	//ȡ��ָ���û��Ĺ����б�
	public List<FunctionModel> getListByUser(String userid) throws Exception;
	
	

}
