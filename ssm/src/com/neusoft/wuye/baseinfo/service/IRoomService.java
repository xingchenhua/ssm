package com.neusoft.wuye.baseinfo.service;

import java.util.List;

import com.neusoft.wuye.baseinfo.model.RoomModel;

//房间的业务接口
public interface IRoomService {

	public void add(RoomModel rm) throws Exception;
	
	public void modify(RoomModel rm) throws Exception;
	
	public void delete(RoomModel rm) throws Exception;
	
	public RoomModel get(int roomNo) throws Exception;
	
	public List<RoomModel> getListByAll() throws Exception;
	public List<RoomModel> getListByAllWithPage(int rows,int page) throws Exception;
	public int getCountByAll() throws Exception;
	public int getPageCountByAll(int rows) throws Exception;
	
	public List<RoomModel> getListByCondition(int areaNo,int buildingTypeNo,int buildingNo,int houseTypeNo,String department,String floor,String code) throws Exception;
	public List<RoomModel> getListByConditionWithPage(int areaNo,int buildingTypeNo,int buildingNo,int houseTypeNo,String department,String floor,String code,int rows,int page) throws Exception;
	public int getCountByConditon(int areaNo,int buildingTypeNo,int buildingNo,int houseTypeNo,String department,String floor,String code) throws Exception;
	public int getPageCountByConditon(int areaNo,int buildingTypeNo,int buildingNo,int houseTypeNo,String department,String floor,String code,int rows) throws Exception;
	
	
	
}
