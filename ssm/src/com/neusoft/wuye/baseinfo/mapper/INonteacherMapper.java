package com.neusoft.wuye.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.neusoft.wuye.baseinfo.model.NonteacherModel;

//职工Mapper接口
public interface INonteacherMapper {
	
	//增加职工
	public void insert(NonteacherModel btm) throws Exception;
	public void insertWithPhoto(NonteacherModel btm) throws Exception;
	//修改职工，无图片处理
	public void update(NonteacherModel btm) throws Exception;
	//修改职工，有图片处理
	public void updateWithPhoto(NonteacherModel btm) throws Exception;
	//删除职工图片
	public void updateForDeletePhoto(NonteacherModel btm) throws Exception;
	//删除职工
	public void delete(NonteacherModel btm) throws Exception;
	//取得指定的职工
	public NonteacherModel select(int nonteacherNo) throws Exception;
	//取得所有职工列表
	public List<NonteacherModel> selectListByAll() throws Exception;
	//分页方式取得职工列表
	public List<NonteacherModel> selectListByAllWithPage(RowBounds rb) throws Exception;
	//取得职工的个数
	public int selectCountByAll() throws Exception;
	
	

}
