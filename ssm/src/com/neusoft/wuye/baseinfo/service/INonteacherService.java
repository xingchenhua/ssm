package com.neusoft.wuye.baseinfo.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.neusoft.wuye.baseinfo.model.NonteacherModel;

//职工的业务接口
public interface INonteacherService {
	//增加职工
	public void add(NonteacherModel am) throws Exception;
	//修改职工
	public void modify(NonteacherModel am) throws Exception;
	public void modifyWithPhoto(NonteacherModel am) throws Exception;
	public void modifyForDeletePhoto(NonteacherModel am) throws Exception;
	//删除职工
	public void delete(NonteacherModel am) throws Exception;
	//取得指定职工的列表
	public NonteacherModel get(int nonteacherNo) throws Exception;
	//取得所有职工列表
	public List<NonteacherModel> getListByAll() throws Exception;
	//取得所有职工列表，分页方式
	public List<NonteacherModel> getListByAllWithPage(int rows,int page) throws Exception;
	//取得职工个数
	public int getCountByAll() throws Exception;
	//取得职工页数
	public int getPageCountByAll(int rows) throws Exception;
	//检查指定职工是否可以被删除
	public boolean checkCanDelete(int areaNo) throws Exception;
	//检查职工名称是否存在
	public boolean checkNameExist(String name) throws Exception;
	//从Excel文件导入职工信息
	public void importFromExcel(InputStream excelFile) throws Exception;
	//将职工信息写到Excel文件中
	public void exportToExcel(File source,File exportFile) throws Exception;
	
	
	
	
}
