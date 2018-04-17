package com.neusoft.wuye.baseinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.wuye.baseinfo.model.BuildingModel;
import com.neusoft.wuye.baseinfo.service.IBuildingService;
import com.neusoft.wuye.result.ResultInfo;
import com.neusoft.wuye.result.ResultMessage;

//¥���������
@RestController
@RequestMapping(value="/building")
public class BuildingController {

	private IBuildingService ds=null;
	@Autowired
	public void setDs(IBuildingService ds) {
		this.ds = ds;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
   public ResultMessage add(BuildingModel bm) throws Exception
   {
	   ResultMessage result=new ResultMessage();
	   ds.add(bm);
	   result.setResult("Y");
	   result.setMessage("����¥��ɹ�");
	   return result;
	   
	  
   }
   
   @RequestMapping(value="/modify",method=RequestMethod.POST)
   public ResultMessage modify(BuildingModel bm) throws Exception
   {
	   ResultMessage result=new ResultMessage();
	   ds.modify(bm);
	   result.setResult("Y");
	   result.setMessage("�޸�¥��ɹ�");
	   return result;
	   
	  
   }
   
   @RequestMapping(value="/delete",method=RequestMethod.POST)
   public ResultMessage delete(BuildingModel bm) throws Exception
   {
	   ResultMessage result=new ResultMessage();
	   ds.delete(bm);
	   result.setResult("Y");
	   result.setMessage("ɾ��¥��ɹ�");
	   return result;
   }
   //ȡ��ָ����¥��
   @RequestMapping(value="/get",method=RequestMethod.GET)
   public BuildingModel get(@RequestParam int buildingNo) throws Exception
   {
	   return ds.get(buildingNo);
   }
   //ȡ������¥���б�����ҳ
   @RequestMapping(value="/list/all",method=RequestMethod.GET)
   public List<BuildingModel> getListByAll() throws Exception
   {
	   return ds.getListByCondition(0,0, "");
   }
   //����������ȡ��¥���б��޷�ҳ
   @RequestMapping(value="/list/condition",method=RequestMethod.POST)
   public List<BuildingModel> getListByCondition(@RequestParam(required=false,defaultValue="0") int areaNo,
		   @RequestParam(required=false,defaultValue="0") int buildingTypeNo,
		   @RequestParam(required=false,defaultValue="") String code) throws Exception
   {
	   return ds.getListByCondition(areaNo,buildingTypeNo, code);
   }
   //ȡ������¥���б���ҳ��ʽ
   @RequestMapping(value="/list/page",method=RequestMethod.GET)
   public List<BuildingModel> getListByAllWithPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception
   {
	   return ds.getListByAllWithPage(rows, page);
   }
   //����������ȡ��¥���б��з�ҳ
   @RequestMapping(value="/list/condition/page00",method=RequestMethod.POST)
   public List<BuildingModel> getListByConditionWithPage00(@RequestParam(required=false,defaultValue="0") int areaNo,
		   @RequestParam(required=false,defaultValue="0") int buildingTypeNo,
		   @RequestParam(required=false,defaultValue="") String code,
		   @RequestParam(required=false,defaultValue="10") int rows,
		   @RequestParam(required=false,defaultValue="1") int page) throws Exception
   {
	   return ds.getListByConditionWithPage(areaNo, buildingTypeNo, code, rows, page);
   }
   
   //����������ȡ��¥���б��з�ҳ,һ���Է��ط�ҳ��������Ϣ
   @RequestMapping(value="/list/condition/page",method=RequestMethod.POST)
   public ResultInfo<BuildingModel> getListByConditionWithPage(
		   @RequestParam(required=false,defaultValue="0") int areaNo,
		   @RequestParam(required=false,defaultValue="0") int buildingTypeNo,
		   @RequestParam(required=false,defaultValue="") String code,
		   @RequestParam(required=false,defaultValue="10") int rows,
		   @RequestParam(required=false,defaultValue="1") int page) throws Exception
   {
	   System.out.println(areaNo);
	   ResultInfo<BuildingModel> result=new ResultInfo<BuildingModel>();
	   result.setCount(ds.getCountByCondition(areaNo, buildingTypeNo, code));
	   result.setPageCount(ds.getPageCountByCondition(areaNo, buildingTypeNo, code, rows));
	   result.setRows(rows);
	   result.setPage(page);
	   result.setList(ds.getListByConditionWithPage(areaNo, buildingTypeNo, code, rows, page));
	   return result;
   }
   
   //���ָ����¥���ܷ�ɾ��
   @RequestMapping(value="/checkcandelete",method=RequestMethod.GET)
   public ResultMessage checkCanDelete(@RequestParam int buildingNo) throws Exception
   {
	   ResultMessage result=new ResultMessage();
	   
	   
	   return result;
   }
   
   
}
