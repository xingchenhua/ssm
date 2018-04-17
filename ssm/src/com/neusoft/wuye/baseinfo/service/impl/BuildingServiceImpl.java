package com.neusoft.wuye.baseinfo.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.wuye.baseinfo.mapper.IBuildingMapper;
import com.neusoft.wuye.baseinfo.model.BuildingModel;
import com.neusoft.wuye.baseinfo.service.IBuildingService;
@Service("BuildingService")
@Transactional
public class BuildingServiceImpl implements IBuildingService {

	private IBuildingMapper bmp=null;
	@Autowired
	public void setBmp(IBuildingMapper bmp) {
		this.bmp = bmp;
	}

	@Override
	public void add(BuildingModel bm) throws Exception {
		bmp.insert(bm);

	}
	@Override
	public void modify(BuildingModel bm) throws Exception {
		bmp.update(bm);
		
	}

	@Override
	public void delete(BuildingModel bm) throws Exception {
		bmp.delete(bm);
		
	}

	@Override
	public BuildingModel get(int buildingNo) throws Exception {
		
		return bmp.select(buildingNo);
	}

	@Override
	public List<BuildingModel> getListByAllWithPage(int rows, int page) throws Exception {
		RowBounds rb=new RowBounds(rows*(page-1),rows);
		return bmp.selectListByAllWithPage(rb);
		
	}

	@Override
	public List<BuildingModel> getListByCondition(int areaNo, int buildingTypeNo, String code) throws Exception {
		
		return bmp.selectListByCondition(areaNo, buildingTypeNo,"%"+code+"%");
	}

	@Override
	public List<BuildingModel> getListByConditionWithPage(int areaNo, int buildingTypeNo, String code, int rows,
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
