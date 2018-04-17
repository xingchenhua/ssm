package com.neusoft.wuye.baseinfo.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.wuye.baseinfo.mapper.ICarMapper;
import com.neusoft.wuye.baseinfo.model.CarModel;
import com.neusoft.wuye.baseinfo.service.ICarService;
@Service("CarService")
@Transactional
public class CarServiceImpl implements ICarService {

	private ICarMapper bmp=null;
	@Autowired
	public void setBmp(ICarMapper bmp) {
		this.bmp = bmp;
	}

	@Override
	public void add(CarModel bm) throws Exception {
		bmp.insert(bm);

	}
	@Override
	public void modify(CarModel bm) throws Exception {
		bmp.update(bm);
		
	}

	@Override
	public void delete(CarModel bm) throws Exception {
		bmp.delete(bm);
		
	}

	@Override
	public CarModel get(int carNo) throws Exception {
		
		return bmp.select(carNo);
	}

	@Override
	public List<CarModel> getListByAllWithPage(int rows, int page) throws Exception {
		RowBounds rb=new RowBounds(rows*(page-1),rows);
		return bmp.selectListByAllWithPage(rb);
		
	}

	@Override
	public List<CarModel> getListByCondition(int areaNo, int buildingTypeNo, String code) throws Exception {
		
		return bmp.selectListByCondition(areaNo, buildingTypeNo,"%"+code+"%");
	}

	@Override
	public List<CarModel> getListByConditionWithPage(int areaNo, int buildingTypeNo, String code, int rows,
			int page) throws Exception {
		RowBounds rb=new RowBounds(rows*(page-1),rows);
		return bmp.selectListByConditionWithPage(areaNo, buildingTypeNo, "%"+code+"%", rb);
	}

	@Override
	public int getCountByCondition(int areaNo, int buildingTypeNo, String code) throws Exception {
		
		return bmp.selectCountByCondition(areaNo, buildingTypeNo, "%"+code+"%");
		
	}

	@Override
	public int getPageCountByCondition(int areaNo, int buildingTypeNo, String code, int rows) throws Exception {
		int pageCount=0;
		int count=this.getCountByCondition(areaNo, buildingTypeNo, code);
		if(count%rows==0){
			pageCount=count/rows;
		}
		else{
			pageCount=count/rows+1;
		}
		return pageCount;
		
	}

	

}
