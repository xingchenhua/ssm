package com.neusoft.wuye.admin.service;

import java.util.List;

import com.neusoft.wuye.admin.model.ModuleModel;

//ϵͳģ��ҵ��ӿ�

public interface IModuleService {
	//ȡ��ָ����ģ��
	public ModuleModel get(int moduleNo) throws Exception;
	//ȡ�����е�ģ���б�
	public List<ModuleModel> getListByAll() throws Exception;
	
}
