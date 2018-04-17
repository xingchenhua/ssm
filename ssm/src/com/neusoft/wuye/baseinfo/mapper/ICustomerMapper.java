package com.neusoft.wuye.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.neusoft.wuye.baseinfo.model.CustomerModel;

//客户Mapper接口
public interface ICustomerMapper {
	//增加客户
	public void insert(CustomerModel cm) throws Exception;
	//修改客户
	public void update(CustomerModel cm) throws Exception;
	//删除客户
	public void delete(CustomerModel cm) throws Exception;
	//取得指定的客户对象
	public CustomerModel select(int customerNo) throws Exception;
	//取得所有客户列表，无分页
	public List<CustomerModel> selectListByAll() throws Exception;
	//取得指定类别的客户列表，无分页
	public List<CustomerModel> selectListByType(int typeNo) throws Exception;
	//取得所有客户列表，分页
	public List<CustomerModel> selectListByAllWithPage(RowBounds rd) throws Exception;
	//取得指定类别的客户列表，分页
	public List<CustomerModel> selectListByTypeWithPage(@Param("typeNo") int typeNo,RowBounds rd) throws Exception;	
	//取得所有客户个数
	public int selectCountByAll() throws Exception;
	//取得指定类型的客户个数
	public int selectCountByType(int typeNo) throws Exception;
	
	
	

}
