package com.neusoft.wuye.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.neusoft.wuye.baseinfo.model.BuildingTypeModel;

//建筑类型的Mapper接口
public interface IBuildingTypeMapper {
	//增加类型
	public void insert(BuildingTypeModel btm) throws Exception;
	//修改类型
	public void update(BuildingTypeModel btm) throws Exception;
	//删除类型
	public void delete(BuildingTypeModel btm) throws Exception;
	//取得指定的类型
	public BuildingTypeModel select(int typeNo) throws Exception;
	//取得所有类型列表
	public List<BuildingTypeModel> selectListByAll() throws Exception;
	//分页方式取得类型列表
	public List<BuildingTypeModel> selectListByAllWithPage(RowBounds rb) throws Exception;
	//取得建筑类型的个数
	public int selectCountByAll() throws Exception;
	
	
	

}
