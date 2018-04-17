package com.neusoft.wuye.feeinfo.service;

import java.util.List;

import com.neusoft.wuye.feeinfo.model.FeeTypeModel;

//缴费类型业务接口
public interface IFeeTypeService {
	
	public void add(FeeTypeModel ftm) throws Exception;
	
	public void modify(FeeTypeModel ftm) throws Exception;
	
	public void delete(FeeTypeModel ftm) throws Exception;
	
	public FeeTypeModel  get(int typeNo) throws Exception;
	
	public List<FeeTypeModel>  getListByAll() throws Exception;
	
	public List<FeeTypeModel>  getListByAllWithPage(int rows,int page) throws Exception;
	
	public int getCountByAll() throws Exception;
	
	public int getPageCountByAll(int rows) throws Exception;
	
	

}
