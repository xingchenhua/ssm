package com.neusoft.wuye.baseinfo.service;

import java.util.List;

import com.neusoft.wuye.baseinfo.model.MaintainTypeModel;

//维修类型业务接口
public interface IMaintainTypeService {

	public void add(MaintainTypeModel mtm) throws Exception;
	
	public void modify(MaintainTypeModel mtm) throws Exception;
	
	public void delete(MaintainTypeModel mtm) throws Exception;
	
	public MaintainTypeModel get(int typeNo) throws Exception;
	
	public List<MaintainTypeModel> getListByAll() throws Exception;
	
	
	public List<MaintainTypeModel> getListByAllWithPage(int rows,int page) throws Exception;
	
	public int getCountByAll() throws Exception;
	
	public int getPageCountByAll(int rows) throws Exception;
}
