package com.neusoft.wuye.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.neusoft.wuye.baseinfo.model.CarModel;

//楼宇的Mapper接口
public interface ICarMapper {
	
	//增加楼宇
	public void insert(CarModel btm) throws Exception;
	//修改楼宇
	public void update(CarModel btm) throws Exception;
	//删除楼宇
	public void delete(CarModel btm) throws Exception;
	//取得指定的楼宇
	public CarModel select(int carNo) throws Exception;
	//取得所有楼宇列表
	public List<CarModel> selectListByAll() throws Exception;
	//按小区取得楼宇列表
	public List<CarModel> selectListByArea(int areaNo) throws Exception;
	//按建筑取得楼宇列表
	public List<CarModel> selectListByBuildingType(int typeNo) throws Exception;
	//按检索条件取得楼宇列表
	public List<CarModel> selectListByCondition(@Param("areaNo") int areaNo,@Param("buildingTypeNo") int buildingTypeNo,@Param("code") String code) throws Exception;
	//分页方式取得楼宇列表
	public List<CarModel> selectListByAllWithPage(RowBounds rb) throws Exception;
	//按检索条件取得楼宇列表,分页方式
	public List<CarModel> selectListByConditionWithPage(@Param("areaNo") int areaNo,@Param("buildingTypeNo") int buildingTypeNo,@Param("code") String code,RowBounds rb) throws Exception;
	//取得建筑楼宇的个数
	public int selectCount() throws Exception;
	//按检索条件取得建筑楼宇的个数
	public int selectCountByCondition(@Param("areaNo") int areaNo,@Param("buildingTypeNo") int buildingTypeNo,@Param("code") String code) throws Exception;

}
