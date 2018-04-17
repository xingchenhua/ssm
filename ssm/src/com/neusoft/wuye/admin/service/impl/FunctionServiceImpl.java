package com.neusoft.wuye.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.wuye.admin.mapper.IFunctionMapper;
import com.neusoft.wuye.admin.model.FunctionModel;
import com.neusoft.wuye.admin.service.IFunctionService;
//系统功能业务实现类
@Service("FunctionService")
@Transactional
public class FunctionServiceImpl implements IFunctionService {

	private IFunctionMapper fmp=null;
	@Autowired
	public void setFmp(IFunctionMapper fmp) {
		this.fmp = fmp;
	}

	@Override
	public FunctionModel get(int functionNo) throws Exception {
		
		return fmp.select(functionNo);
	}

	@Override
	public List<FunctionModel> getListByAll() throws Exception {
		return fmp.selectListByAll();
		
	}

	@Override
	public List<FunctionModel> getListByUser(String userid) throws Exception {
		
		return fmp.selectListByUser(userid);
	}

}
