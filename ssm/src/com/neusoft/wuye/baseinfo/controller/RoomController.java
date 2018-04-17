package com.neusoft.wuye.baseinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.wuye.baseinfo.model.RoomModel;
import com.neusoft.wuye.baseinfo.service.IRoomService;
import com.neusoft.wuye.result.ResultInfo;
import com.neusoft.wuye.result.ResultMessage;

//�����������
@RestController
@RequestMapping(value="/room")
public class RoomController {

	private IRoomService rs=null;
	@Autowired
	public void setRs(IRoomService rs) {
		this.rs = rs;
	}
	//���ӷ���
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResultMessage add(RoomModel am) throws Exception
	{
	   ResultMessage result=new ResultMessage();
	   rs.add(am);
	   result.setResult("Y");
	   result.setMessage("���ӷ���ɹ�");
	   return result;
	   
	  
	}
	//�޸ķ���
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public ResultMessage modify(RoomModel am) throws Exception
	{
	   ResultMessage result=new ResultMessage();
	   rs.modify(am);
	   result.setResult("Y");
	   result.setMessage("�޸ķ���ɹ�");
	   return result;
	   
	  
	}
	//ɾ������
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public ResultMessage delete(RoomModel am) throws Exception
	{
	   ResultMessage result=new ResultMessage();
	   rs.delete(am);
	   result.setResult("Y");
	   result.setMessage("ɾ������ɹ�");
	   return result;
	}
	//ȡ��ָ���ķ������
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public RoomModel get(@RequestParam int roomNo) throws Exception
	{
	   return rs.get(roomNo);
	}
	//ȡ�����з����б�����ҳ
	@RequestMapping(value="/list/all",method=RequestMethod.GET)
	public List<RoomModel> getListByAll() throws Exception
	{
	   return rs.getListByAll();
	}
	//ȡ�����з����б���ҳ��ʽ,�ɵķ���
	@RequestMapping(value="/list/page/old",method=RequestMethod.GET)
	public List<RoomModel> getListByAllWithPageOld(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception
	{
		return rs.getListByAllWithPage(rows, page);
	}
	//ȡ�����з����б���ҳ��ʽ,�µķ���
	@RequestMapping(value="/list/page",method=RequestMethod.GET)
	public ResultInfo<RoomModel> getListByAllWithPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception
	{
		ResultInfo<RoomModel> result=new ResultInfo<RoomModel>();
		result.setCount(rs.getCountByAll());
		result.setPageCount(rs.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(rs.getListByAllWithPage(rows, page));
		return result;
	}
	//����������ȡ�÷����б���ҳ
	@RequestMapping(value="/list/condition/page",method=RequestMethod.POST)
	public ResultInfo<RoomModel> getListByConditionWithPage(
			@RequestParam(required=false,defaultValue="0") int areaNo,
			@RequestParam(required=false,defaultValue="0") int buildingTypeNo,
			@RequestParam(required=false,defaultValue="0") int buildingNo,
			@RequestParam(required=false,defaultValue="0") int houseTypeNo,
			@RequestParam(required=false,defaultValue="") String department,
			@RequestParam(required=false,defaultValue="") String floor,
			@RequestParam(required=false,defaultValue="") String code,
			@RequestParam(required=false,defaultValue="10") int rows,
			@RequestParam(required=false,defaultValue="1") int page) throws Exception
	{
		System.out.println(buildingNo);
		ResultInfo<RoomModel> result=new ResultInfo<RoomModel>();
		result.setCount(rs.getCountByConditon(areaNo, buildingTypeNo, buildingNo, houseTypeNo, department, floor, code));
		result.setPageCount(rs.getPageCountByConditon(areaNo, buildingTypeNo, buildingNo, houseTypeNo, department, floor, code, rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(rs.getListByConditionWithPage(areaNo, buildingTypeNo, buildingNo, houseTypeNo, department, floor, code, rows, page));
		return result;
	}
	
}
