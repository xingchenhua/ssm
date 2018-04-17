package com.neusoft.wuye.baseinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.wuye.baseinfo.model.BuildingTypeModel;
import com.neusoft.wuye.baseinfo.service.IBuildingTypeService;
import com.neusoft.wuye.result.ResultInfo;
import com.neusoft.wuye.result.ResultMessage;
//�༶��������
@RestController
@RequestMapping(value="/buildingtype")
public class BuildingTypeController {
	
	
	
	private IBuildingTypeService bts=null;
	@Autowired
	public void setBts(IBuildingTypeService bts) {
		this.bts = bts;
	}
	
	@RequestMapping(value="/add",method={RequestMethod.POST})
	public ResultMessage add(BuildingTypeModel btm) throws Exception
	{
		ResultMessage result=new ResultMessage();
		result.setMessage("���Ӱ༶ʧ��");
		bts.add(btm);
		result.setResult("Y");
		result.setMessage("���Ӱ༶�ɹ�");
		return result;
		
		
	}
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	public ResultMessage modify(BuildingTypeModel btm) throws Exception
	{
		
		ResultMessage result=new ResultMessage();
		bts.modify(btm);
		result.setResult("Y");
		result.setMessage("�޸İ༶�ɹ�");
		return result;
		
		
	}
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	public ResultMessage delete(BuildingTypeModel btm) throws Exception
	{
		
		ResultMessage result=new ResultMessage();
		bts.delete(btm);
		result.setResult("Y");
		result.setMessage("ɾ���༶�ɹ�");
		return result;
		
		
	}
	@RequestMapping(value="/get",method=RequestMethod.GET,produces="application/json")
	public BuildingTypeModel get(@RequestParam int typeNo) throws Exception
	{
		return bts.get(typeNo);
		
	}
	
	@RequestMapping(value="/list/all",method=RequestMethod.GET,produces="application/json")
	public List<BuildingTypeModel> getListByAll() throws Exception
	{
		return bts.getListByAll();				
	}
	
	@RequestMapping(value="/list/page",method=RequestMethod.GET,produces="application/json")
	public ResultInfo<BuildingTypeModel> getListByAllWithPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception
	{
		int count=bts.getCountByAll();
		int pageCount=bts.getPageCountByAll(rows);
		List<BuildingTypeModel> list=bts.getListByAllWithPage(rows, page);
		ResultInfo<BuildingTypeModel> result=new ResultInfo<BuildingTypeModel>();
		result.setCount(count);
		result.setPageCount(pageCount);
		result.setPage(page);
		result.setRows(rows);
		result.setList(list);
		return result;		
	}
	
	//���˰༶�ܷ�ɾ��
	@RequestMapping(value="/checkcandelete",method=RequestMethod.GET,produces="application/json")
	public ResultMessage checkCanDelete(@RequestParam int typeNo) throws Exception
	{
		ResultMessage result=new ResultMessage();
		if(bts.checkCanDelete(typeNo)){
			result.setResult("Y");
			result.setMessage("�˰༶����ɾ��!");
		}
		else{
			result.setResult("N");
			result.setMessage("�˰༶����ɾ�����Ѿ��й�����ѧ��!");
		}
		return result;
	}

}
