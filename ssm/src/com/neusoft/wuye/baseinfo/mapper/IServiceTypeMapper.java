package com.neusoft.wuye.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.neusoft.wuye.baseinfo.model.ServiceTypeModel;

//服务类型Mapper接口
public interface IServiceTypeMapper {

	public void insert(ServiceTypeModel ltm) throws Exception;
	
	public void update(ServiceTypeModel ltm) throws Exception;
	
	public void delet(ServiceTypeModel ltm) throws Exception;
	
	public ServiceTypeModel select(int typeNo) throws Exception;
	
	public List<ServiceTypeModel> selectListByAll() throws Exception;
	
	public List<ServiceTypeModel> selectListByAllWithPage(RowBounds rb) throws Exception;
	
	public int selectCountByAll() throws Exception;
	
	
}
