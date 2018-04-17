package com.neusoft.wuye.admin.mapper;

import java.util.List;

import com.neusoft.wuye.admin.model.ModuleModel;

//系统功能模块的Mapper接口
public interface IModuleMapper {
	//取得指定的功能模块对象
	public ModuleModel select(int moduleNo) throws Exception;
	//取得所有模块列表
	public List<ModuleModel> selectListByAll() throws Exception;

}
