package com.neusoft.wuye.baseinfo.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.neusoft.wuye.baseinfo.model.AreaModel;

//小区的业务接口
public interface IAreaService {
	//增加小区
	public void add(AreaModel am) throws Exception;
	//修改小区
	public void modify(AreaModel am) throws Exception;
	public void modifyWithPhoto(AreaModel am) throws Exception;
	public void modifyForDeletePhoto(AreaModel am) throws Exception;
	//删除小区
	public void delete(AreaModel am) throws Exception;
	//取得指定小区的列表
	public AreaModel get(int areaNo) throws Exception;
	//取得所有小区列表
	public List<AreaModel> getListByAll() throws Exception;
	//取得所有小区列表，分页方式
	public List<AreaModel> getListByAllWithPage(int rows,int page) throws Exception;
	//取得小区个数
	public int getCountByAll() throws Exception;
	//取得小区页数
	public int getPageCountByAll(int rows) throws Exception;
	//检查指定小区是否可以被删除
	public boolean checkCanDelete(int areaNo) throws Exception;
	//检查小区名称是否存在
	public boolean checkNameExist(String name) throws Exception;
	//从Excel文件导入小区信息
	public void importFromExcel(InputStream excelFile) throws Exception;
	//将小区信息写到Excel文件中
	public void exportToExcel(File source,File exportFile) throws Exception;
	
	
	
	
}
