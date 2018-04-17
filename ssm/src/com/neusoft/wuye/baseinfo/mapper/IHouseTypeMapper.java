package com.neusoft.wuye.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.neusoft.wuye.baseinfo.model.HouseTypeModel;

//客户类型Mapper接口
public interface IHouseTypeMapper {

	public void insert(HouseTypeModel htm) throws Exception;
	
	public void update(HouseTypeModel htm) throws Exception;
	
	public void delet(HouseTypeModel htm) throws Exception;
	
	public HouseTypeModel select(int typeNo) throws Exception;
	
	public List<HouseTypeModel> selectListByAll() throws Exception;
	
	public List<HouseTypeModel> selectListByAllWithPage(RowBounds rb) throws Exception;
	
	public int selectCountByAll() throws Exception;
	
	
}
