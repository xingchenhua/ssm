package com.neusoft.wuye.admin.mapper;

import java.util.List;

import com.neusoft.wuye.admin.model.ModuleModel;

//ϵͳ����ģ���Mapper�ӿ�
public interface IModuleMapper {
	//ȡ��ָ���Ĺ���ģ�����
	public ModuleModel select(int moduleNo) throws Exception;
	//ȡ������ģ���б�
	public List<ModuleModel> selectListByAll() throws Exception;

}
