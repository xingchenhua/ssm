package com.neusoft.wuye.baseinfo.service;

import java.util.List;

import com.neusoft.wuye.baseinfo.model.HouseTypeModel;

//房屋户型业务接口
public interface IHouseTypeService {

	public void add(HouseTypeModel btm) throws Exception;
	
	public void modify(HouseTypeModel btm) throws Exception;
	
	public void delete(HouseTypeModel btm) throws Exception;
	
	public HouseTypeModel get(int typeNo) throws Exception;
	
	public List<HouseTypeModel> getListByAll() throws Exception;
	
	
	public List<HouseTypeModel> getListByAllWithPage(int rows,int page) throws Exception;
	
	public int getCountByAll() throws Exception;
	
	public int getPageCountByAll(int rows) throws Exception;
	
	public boolean checkCanDelete(int typeNo) throws Exception;
}
