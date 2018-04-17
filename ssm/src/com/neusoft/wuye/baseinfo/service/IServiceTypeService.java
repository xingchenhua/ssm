package com.neusoft.wuye.baseinfo.service;

import java.util.List;

import com.neusoft.wuye.baseinfo.model.ServiceTypeModel;

//服务类型业务接口
public interface IServiceTypeService {

	public void add(ServiceTypeModel stm) throws Exception;
	
	public void modify(ServiceTypeModel stm) throws Exception;
	
	public void delete(ServiceTypeModel stm) throws Exception;
	
	public ServiceTypeModel get(int typeNo) throws Exception;
	
	public List<ServiceTypeModel> getListByAll() throws Exception;
	
	
	public List<ServiceTypeModel> getListByAllWithPage(int rows,int page) throws Exception;
	
	public int getCountByAll() throws Exception;
	
	public int getPageCountByAll(int rows) throws Exception;
}
