package com.neusoft.wuye.admin.mapper;

import java.util.List;

import com.neusoft.wuye.admin.model.FunctionModel;


//ϵͳ����Mapper�ӿ�
public interface IFunctionMapper {
	
	//ȡ��ָ���Ĺ��ܶ���
	public FunctionModel select(int functionNo) throws Exception;
	//ȡ�����й����б�
	public List<FunctionModel> selectListByAll() throws Exception;
	//ȡ��ָ���û��Ĺ����б�
	public List<FunctionModel> selectListByUser(String userid) throws Exception;

}
