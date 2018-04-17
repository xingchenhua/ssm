package com.neusoft.wuye.baseinfo.service;

import java.util.List;

import com.neusoft.wuye.baseinfo.model.CustomerModel;

//客户业务接口
public interface ICustomerService {
	//增加客户
	public void add(CustomerModel cm) throws Exception;
	//修改客户
	public void modify(CustomerModel cm) throws Exception;
	//删除客户
	public void delete(CustomerModel cm) throws Exception;
	//取得指定的客户
	public CustomerModel get(int customerNo) throws Exception;
	//按检索条件取得客户列表，不分页
	public List<CustomerModel> getListByCondition(int typeNo,String name,String mobile,String status) throws Exception;
	//按检索条件取得客户列表，不分页
	public List<CustomerModel> getListByConditionWithPage(int typeNo,String name,String mobile,String status,int rows,int page) throws Exception;
	//按检索条件取得客户个数
	public int getCountByCondition(int typeNo,String name,String mobile,String status) throws Exception;
	//按检索条件取得客户页数
	public int getPageCountByCondition(int typeNo,String name,String mobile,String status,int rows) throws Exception;
	
	
	
	
	
}
