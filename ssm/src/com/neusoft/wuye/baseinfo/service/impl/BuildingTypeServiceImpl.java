package com.neusoft.wuye.baseinfo.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.wuye.baseinfo.mapper.IBuildingMapper;
import com.neusoft.wuye.baseinfo.mapper.IBuildingTypeMapper;
import com.neusoft.wuye.baseinfo.model.BuildingTypeModel;
import com.neusoft.wuye.baseinfo.service.IBuildingTypeService;
//建筑类型业务实现类
@Service("BuildingTypeService")
@Transactional
public class BuildingTypeServiceImpl implements IBuildingTypeService {

	private IBuildingTypeMapper btmp=null; //建筑类型Mapper接口
	private IBuildingMapper bmp=null; //楼宇Mapper接口
	@Autowired
	public void setBtmp(IBuildingTypeMapper btmp) {
		this.btmp = btmp;
	}
	@Autowired
		public void setBmp(IBuildingMapper bmp) {
		this.bmp = bmp;
	}



	@Override
	public void add(BuildingTypeModel btm) throws Exception {
		btmp.insert(btm);

	}

	@Override
	public void modify(BuildingTypeModel btm) throws Exception {
		btmp.update(btm);

	}

	@Override
	public void delete(BuildingTypeModel btm) throws Exception {
		btmp.delete(btm);

	}

	@Override
	public BuildingTypeModel get(int typeNo) throws Exception {
		
		return btmp.select(typeNo);
	}

	@Override
	public List<BuildingTypeModel> getListByAll() throws Exception {
		
		return btmp.selectListByAll();
	}

	@Override
	public List<BuildingTypeModel> getListByAllWithPage(int rows, int page) throws Exception {
		RowBounds rb=new RowBounds(rows*(page-1),rows);
		
		return btmp.selectListByAllWithPage(rb);
	}

	@Override
	public int getCountByAll() throws Exception {
		
		return btmp.selectCountByAll();
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
	//检查指定的建筑类型是否可以被删除
	@Override
	public boolean checkCanDelete(int typeNo) throws Exception {
		boolean result=true;
		//取得指定建筑类型的楼宇个数
		int buildingCount=bmp.selectCountByCondition(0, typeNo, "");
		if(buildingCount>0){
			result=false;
		}
		return result;
	}

}
