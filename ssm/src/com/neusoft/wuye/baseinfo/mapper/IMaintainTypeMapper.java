package com.neusoft.wuye.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.neusoft.wuye.baseinfo.model.MaintainTypeModel;

//维修类型Mapper接口
public interface IMaintainTypeMapper {

	public void insert(MaintainTypeModel ltm) throws Exception;
	
	public void update(MaintainTypeModel ltm) throws Exception;
	
	public void delet(MaintainTypeModel ltm) throws Exception;
	
	public MaintainTypeModel select(int typeNo) throws Exception;
	
	public List<MaintainTypeModel> selectListByAll() throws Exception;
	
	public List<MaintainTypeModel> selectListByAllWithPage(RowBounds rb) throws Exception;
	
	public int selectCountByAll() throws Exception;
	
	
}
