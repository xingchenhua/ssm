package com.neusoft.wuye.baseinfo.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.wuye.baseinfo.mapper.ICustomerTypeMapper;
import com.neusoft.wuye.baseinfo.model.CustomerTypeModel;
import com.neusoft.wuye.baseinfo.service.ICustomerTypeService;
//客户类型业务实现类
@Service("CustomerTypeService")
@Transactional
public class CustomerTypeServiceImpl implements ICustomerTypeService {

	private ICustomerTypeMapper ctmp=null;
	@Autowired
	public void setCtmp(ICustomerTypeMapper ctmp) {
		this.ctmp = ctmp;
	}

	@Override
	public void add(CustomerTypeModel ctm) throws Exception {
		ctmp.insert(ctm);
	}

	@Override
	public void modify(CustomerTypeModel ctm) throws Exception {
		ctmp.update(ctm);
	}

	@Override
	public void delete(CustomerTypeModel ctm) throws Exception {
		ctmp.delet(ctm);

	}

	@Override
	public CustomerTypeModel get(int typeNo) throws Exception {
		return ctmp.select(typeNo);
	}

	@Override
	public List<CustomerTypeModel> getListByAll() throws Exception {
		
		return ctmp.selectListByAll();
	}

	@Override
	public List<CustomerTypeModel> getListByAllWithPage(int rows, int page) throws Exception {
		RowBounds rb=new RowBounds(rows*(page-1),rows);
		
		return ctmp.selectListByAllWithPage(rb);
	}

	@Override
	public int getCountByAll() throws Exception {
	
		return ctmp.selectCountByAll();
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
