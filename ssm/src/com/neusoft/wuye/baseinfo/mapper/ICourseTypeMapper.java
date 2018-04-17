package com.neusoft.wuye.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.neusoft.wuye.baseinfo.model.CourseTypeModel;

//课程类型的Mapper接口
public interface ICourseTypeMapper {
	//增加类型
	public void insert(CourseTypeModel btm) throws Exception;
	//修改类型
	public void update(CourseTypeModel btm) throws Exception;
	//删除类型
	public void delete(CourseTypeModel btm) throws Exception;
	//取得指定的类型
	public CourseTypeModel select(int typeNo) throws Exception;
	//取得所有类型列表
	public List<CourseTypeModel> selectListByAll() throws Exception;
	//分页方式取得类型列表
	public List<CourseTypeModel> selectListByAllWithPage(RowBounds rb) throws Exception;
	//取得课程类型的个数
	public int selectCountByAll() throws Exception;
	
	
	

}
