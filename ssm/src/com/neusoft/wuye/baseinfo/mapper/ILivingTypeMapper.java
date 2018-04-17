package com.neusoft.wuye.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.neusoft.wuye.baseinfo.model.LivingTypeModel;

//居住类型Mapper接口
public interface ILivingTypeMapper {

	public void insert(LivingTypeModel ltm) throws Exception;
	
	public void update(LivingTypeModel ltm) throws Exception;
	
	public void delet(LivingTypeModel ltm) throws Exception;
	
	public LivingTypeModel select(int typeNo) throws Exception;
	
	public List<LivingTypeModel> selectListByAll() throws Exception;
	
	public List<LivingTypeModel> selectListByAllWithPage(RowBounds rb) throws Exception;
	
	public int selectCountByAll() throws Exception;
	
	
}
