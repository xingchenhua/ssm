package com.neusoft.wuye.baseinfo.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.wuye.baseinfo.mapper.IHouseTypeMapper;
import com.neusoft.wuye.baseinfo.model.HouseTypeModel;
import com.neusoft.wuye.baseinfo.service.IHouseTypeService;
//房屋户型业务实现类
@Service("HouseTypeService")
@Transactional
public class HouseTypeServiceImpl implements IHouseTypeService {

	private IHouseTypeMapper htmp=null;
	@Autowired
	public void setHtmp(IHouseTypeMapper htmp) {
		this.htmp = htmp;
	}

	@Override
	public void add(HouseTypeModel htm) throws Exception {
		htmp.insert(htm);
	}

	@Override
	public void modify(HouseTypeModel htm) throws Exception {
		htmp.update(htm);

	}

	@Override
	public void delete(HouseTypeModel htm) throws Exception {
		htmp.delet(htm);

	}

	@Override
	public HouseTypeModel get(int typeNo) throws Exception {
		
		return htmp.select(typeNo);
	}

	@Override
	public List<HouseTypeModel> getListByAll() throws Exception {
		
		return htmp.selectListByAll();
	}

	@Override
	public List<HouseTypeModel> getListByAllWithPage(int rows, int page) throws Exception {
		RowBounds rb=new RowBounds(rows*(page-1),rows);
		return htmp.selectListByAllWithPage(rb);
	}

	@Override
	public int getCountByAll() throws Exception {
		return htmp.selectCountByAll();
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

	@Override
	public boolean checkCanDelete(int typeNo) throws Exception {
		
		return false;
	}

}
