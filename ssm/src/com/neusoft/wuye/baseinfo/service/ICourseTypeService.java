package com.neusoft.wuye.baseinfo.service;

import java.util.List;

import com.neusoft.wuye.baseinfo.model.CourseTypeModel;

//建筑类型的业务接口
public interface ICourseTypeService {
	//增加建筑类型
	public void add(CourseTypeModel btm) throws Exception;
	//修改建筑类型
	public void modify(CourseTypeModel btm) throws Exception;
	//删除建筑类型
	public void delete(CourseTypeModel btm) throws Exception;
	//取得指定的建筑类型
	public CourseTypeModel get(int typeNo) throws Exception;
	//取得所有建筑类型列表
	public List<CourseTypeModel> getListByAll() throws Exception;
	//取得所有建筑类型列表，分页
	public List<CourseTypeModel> getListByAllWithPage(int rows,int page) throws Exception;
	//取得所有建筑类型个数
	public int getCountByAll() throws Exception;
	//取得所有建筑类型页数
	public int getPageCountByAll(int rows) throws Exception;
	//检查此建筑类型能否被删除，如果有关联的楼宇，就不能删除
	public boolean checkCanDelete(int typeNo) throws Exception;
	
	
	
	
	
}
