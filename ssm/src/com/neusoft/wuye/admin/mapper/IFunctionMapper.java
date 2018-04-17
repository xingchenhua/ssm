package com.neusoft.wuye.admin.mapper;

import java.util.List;

import com.neusoft.wuye.admin.model.FunctionModel;


//系统功能Mapper接口
public interface IFunctionMapper {
	
	//取得指定的功能对象
	public FunctionModel select(int functionNo) throws Exception;
	//取得所有功能列表
	public List<FunctionModel> selectListByAll() throws Exception;
	//取得指定用户的功能列表
	public List<FunctionModel> selectListByUser(String userid) throws Exception;

}
