package com.neusoft.wuye.baseinfo.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.wuye.baseinfo.mapper.ILivingTypeMapper;
import com.neusoft.wuye.baseinfo.model.LivingTypeModel;
import com.neusoft.wuye.baseinfo.service.ILivingTypeService;

//房屋户型业务实现类
@Service("LivingTypeService")
@Transactional
public class LivingTypeServiceImpl implements ILivingTypeService {

	private ILivingTypeMapper ltmp=null;
	@Autowired
	public void setLtmp(ILivingTypeMapper ltmp) {
		this.ltmp = ltmp;
	}

	@Override
	public void add(LivingTypeModel ltm) throws Exception {
		ltmp.insert(ltm);
	}

	@Override
	public void modify(LivingTypeModel ltm) throws Exception {
		ltmp.update(ltm);
	}

	@Override
	public void delete(LivingTypeModel ltm) throws Exception {
		ltmp.delet(ltm);

	}

	@Override
	public LivingTypeModel get(int typeNo) throws Exception {
		
		return ltmp.select(typeNo);
	}

	@Override
	public List<LivingTypeModel> getListByAll() throws Exception {
		
		return ltmp.selectListByAll();
	}

	@Override
	public List<LivingTypeModel> getListByAllWithPage(int rows, int page) throws Exception {
		RowBounds rb=new RowBounds(rows*(page-1),rows);
		return ltmp.selectListByAllWithPage(rb);
	}

	@Override
	public int getCountByAll() throws Exception {
		
		return ltmp.selectCountByAll();
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
		int pageCount=0;
		int count=this.getCountByAll();
		if(count%rows==0){
			pageCount=count/rows;
		}
		else{
			pageCount=count/rows+1;
		}
		return pageCount;
	}

}
