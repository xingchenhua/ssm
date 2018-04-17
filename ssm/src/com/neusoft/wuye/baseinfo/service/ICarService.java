package com.neusoft.wuye.baseinfo.service;

import java.util.List;

import com.neusoft.wuye.baseinfo.model.CarModel;

//楼宇的业务层
public interface ICarService {
	//增加楼宇
	public void add(CarModel bm) throws Exception;
	//修改楼宇
	public void modify(CarModel bm) throws Exception;
	//删除楼宇
	public void delete(CarModel bm) throws Exception;
	//取得指定的楼宇
	public CarModel get(int carNo) throws Exception;
	//分页方式取得所有楼宇列表
	public List<CarModel> getListByAllWithPage(int rows,int page) throws Exception;
	//按检索条件取得楼宇列表，不分页
	public List<CarModel> getListByCondition(int areaNo,int buildingTypeNo,String code) throws Exception;
	//按检索条件取得楼宇列表，分页
	public List<CarModel> getListByConditionWithPage(int areaNo,int buildingTypeNo,String code,int rows,int page) throws Exception;
	//按检索条件取得楼宇个数
	public int getCountByCondition(int areaNo,int buildingTypeNo,String code) throws Exception;
	//按检索条件取得楼宇的页数
	public int getPageCountByCondition(int areaNo,int buildingTypeNo,String code,int rows) throws Exception;
	
}
