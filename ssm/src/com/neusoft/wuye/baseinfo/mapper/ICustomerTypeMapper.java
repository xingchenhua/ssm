package com.neusoft.wuye.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.neusoft.wuye.baseinfo.model.CustomerTypeModel;

//客户类型Mapper接口
public interface ICustomerTypeMapper {

	public void insert(CustomerTypeModel ctm) throws Exception;
	
	public void update(CustomerTypeModel ctm) throws Exception;
	
	public void delet(CustomerTypeModel ctm) throws Exception;
	
	public CustomerTypeModel select(int typeNo) throws Exception;
	
	public List<CustomerTypeModel> selectListByAll() throws Exception;
	
	public List<CustomerTypeModel> selectListByAllWithPage(RowBounds rb) throws Exception;
	
	public int selectCountByAll() throws Exception;
	
	
}
