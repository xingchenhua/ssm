package com.neusoft.wuye.baseinfo.service;

import java.util.List;

import com.neusoft.wuye.baseinfo.model.CustomerTypeModel;

//维修类型业务接口
public interface ICustomerTypeService {

	public void add(CustomerTypeModel ctm) throws Exception;
	
	public void modify(CustomerTypeModel ctm) throws Exception;
	
	public void delete(CustomerTypeModel ctm) throws Exception;
	
	public CustomerTypeModel get(int typeNo) throws Exception;
	
	public List<CustomerTypeModel> getListByAll() throws Exception;
	
	
	public List<CustomerTypeModel> getListByAllWithPage(int rows,int page) throws Exception;
	
	public int getCountByAll() throws Exception;
	
	public int getPageCountByAll(int rows) throws Exception;
}
