package com.neusoft.wuye.baseinfo.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.wuye.baseinfo.mapper.IRoomMapper;
import com.neusoft.wuye.baseinfo.model.RoomModel;
import com.neusoft.wuye.baseinfo.service.IRoomService;

//房间业务实现类
@Service("RoomService")
@Transactional
public class RoomServiceImpl implements IRoomService {

	private IRoomMapper rmp=null;
	@Autowired
	public void setRmp(IRoomMapper rmp) {
		this.rmp = rmp;
	}

	@Override
	public void add(RoomModel rm) throws Exception {
		rmp.insert(rm);

	}

	@Override
	public void modify(RoomModel rm) throws Exception {
		rmp.update(rm);

	}

	@Override
	public void delete(RoomModel rm) throws Exception {
		rmp.delete(rm);

	}

	@Override
	public RoomModel get(int roomNo) throws Exception {
		
		return rmp.select(roomNo);
	}

	@Override
	public List<RoomModel> getListByAll() throws Exception {
		
		return null;
	}

	@Override
	public List<RoomModel> getListByAllWithPage(int rows, int page) throws Exception {
		
		return null;
	}

	@Override
	public int getCountByAll() throws Exception {
		
		return 0;
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
		
		return 0;
	}

	@Override
	public List<RoomModel> getListByCondition(int areaNo, int buildingTypeNo, int buildingNo, int houseTypeNo,
			String department, String floor, String code) throws Exception {
		
		return rmp.selectListByCondition(areaNo, buildingTypeNo, buildingNo, houseTypeNo, department, floor, code);
	}

	@Override
	public List<RoomModel> getListByConditionWithPage(int areaNo, int buildingTypeNo, int buildingNo, int houseTypeNo,
			String department, String floor, String code, int rows, int page) throws Exception {
		RowBounds rb=new RowBounds(rows*(page-1),rows);
		System.out.println(buildingNo);
		return rmp.selectListByConditionWithPage(areaNo, buildingTypeNo, buildingNo, houseTypeNo, department, floor, code, rb);
	}

	@Override
	public int getCountByConditon(int areaNo, int buildingTypeNo, int buildingNo, int houseTypeNo, String department,
			String floor, String code) throws Exception {
		System.out.println(buildingNo);
		return rmp.selectCountByCondition(areaNo, buildingTypeNo, buildingNo, houseTypeNo, department, floor, code);
	}

	@Override
	public int getPageCountByConditon(int areaNo, int buildingTypeNo, int buildingNo, int houseTypeNo,
			String department, String floor, String code, int rows) throws Exception {
		int pageCount=0;
		int count=this.getCountByConditon(areaNo, buildingTypeNo, buildingNo, houseTypeNo, department, floor, code);
		if(count%rows==0){
			pageCount=count/rows;
		}
		else{
			pageCount=count/rows+1;
		}
		return pageCount;
	}

}
