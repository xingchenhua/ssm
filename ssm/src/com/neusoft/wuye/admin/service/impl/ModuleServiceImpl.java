package com.neusoft.wuye.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.wuye.admin.mapper.IModuleMapper;
import com.neusoft.wuye.admin.model.ModuleModel;
import com.neusoft.wuye.admin.service.IModuleService;
//模块功能实现类
@Service("ModuleService")
@Transactional
public class ModuleServiceImpl implements IModuleService {

	private IModuleMapper mmp=null;
	@Autowired
	public void setMmp(IModuleMapper mmp) {
		this.mmp = mmp;
	}

	@Override
	public ModuleModel get(int moduleNo) throws Exception {
		
		return mmp.select(moduleNo);
	}

	@Override
	public List<ModuleModel> getListByAll() throws Exception {
		
		return mmp.selectListByAll();
	}

}
