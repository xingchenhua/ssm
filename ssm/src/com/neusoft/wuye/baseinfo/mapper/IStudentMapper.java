package com.neusoft.wuye.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.neusoft.wuye.baseinfo.model.AreaModel;

//小区Mapper接口
public interface IStudentMapper {
	
	//增加小区
	public void insert(AreaModel btm) throws Exception;
	public void insertWithPhoto(AreaModel btm) throws Exception;
	//修改小区，无图片处理
	public void update(AreaModel btm) throws Exception;
	//修改小区，有图片处理
	public void updateWithPhoto(AreaModel btm) throws Exception;
	//删除小区图片
	public void updateForDeletePhoto(AreaModel btm) throws Exception;
	//删除小区
	public void delete(AreaModel btm) throws Exception;
	//取得指定的小区
	public AreaModel select(int areaNo) throws Exception;
	//取得所有小区列表
	public List<AreaModel> selectListByAll() throws Exception;
	//分页方式取得小区列表
	public List<AreaModel> selectListByAllWithPage(RowBounds rb) throws Exception;
	//取得建筑小区的个数
	public int selectCountByAll() throws Exception;
	
	

}
