package com.neusoft.wuye.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.neusoft.wuye.baseinfo.model.RoomModel;

//房间Mapper接口
public interface IRoomMapper {
	//增加房间
	public void insert(RoomModel rm) throws Exception;
	//修改房间
	public void update(RoomModel rm) throws Exception;
	//删除房间
	public void delete(RoomModel rm) throws Exception;
	//取得指定的房间
	public RoomModel select(int roomNo) throws Exception;
	//取得所有房间列表
	public List<RoomModel> selectListByAll() throws Exception;
	//按给定的检索条件取得房间列表，无分页
	public List<RoomModel> selectListByCondition(int areaNo,int buildingTypeNo,int buildingNo,int houseTypeNo,String department,String floor,String code) throws Exception;
	
	//按给定的检索条件取得房间列表，有分页
	public List<RoomModel> selectListByConditionWithPage(@Param("areaNo") int areaNo,@Param("buildingTypeNo") int buildingTypeNo,@Param("buildingNo") int buildingNo,@Param("houseTypeNo") int houseTypeNo,@Param("department") String department,@Param("floor") String floor,@Param("code") String code,RowBounds rb) throws Exception;
	//取得所有房间个数
	public int selectCountByAll() throws Exception;
	//按检索条件取得房间个数
	public int selectCountByCondition(@Param("areaNo") int areaNo,@Param("buildingTypeNo") int buildingTypeNo,@Param("buildingNo") int buildingNo,@Param("houseTypeNo") int houseTypeNo,@Param("department") String department,@Param("floor") String floor,@Param("code") String code) throws Exception;
	//
	
	
	
	
	
	
	
}
