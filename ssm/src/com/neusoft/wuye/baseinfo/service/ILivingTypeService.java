package com.neusoft.wuye.baseinfo.service;

import java.util.List;

import com.neusoft.wuye.baseinfo.model.LivingTypeModel;

//房屋户型业务接口
public interface ILivingTypeService {

	public void add(LivingTypeModel ltm) throws Exception;
	
	public void modify(LivingTypeModel ltm) throws Exception;
	
	public void delete(LivingTypeModel ltm) throws Exception;
	
	public LivingTypeModel get(int typeNo) throws Exception;
	
	public List<LivingTypeModel> getListByAll() throws Exception;
	
	
	public List<LivingTypeModel> getListByAllWithPage(int rows,int page) throws Exception;
	
	public int getCountByAll() throws Exception;
	
	public int getPageCountByAll(int rows) throws Exception;
}
