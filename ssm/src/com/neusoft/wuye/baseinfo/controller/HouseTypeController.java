package com.neusoft.wuye.baseinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.wuye.baseinfo.model.HouseTypeModel;
import com.neusoft.wuye.baseinfo.service.IHouseTypeService;
import com.neusoft.wuye.result.ResultInfo;
import com.neusoft.wuye.result.ResultMessage;

//房屋户型控制器类
@RestController
@RequestMapping(value="/housetype")
public class HouseTypeController {
	private IHouseTypeService hts=null;
	@Autowired
	public void setHts(IHouseTypeService hts) {
		this.hts = hts;
	}
	
	@RequestMapping(value="/add",method={RequestMethod.POST})
	public ResultMessage add(HouseTypeModel btm) throws Exception
	{
		ResultMessage result=new ResultMessage();
		result.setMessage("增加户型类型失败");
		hts.add(btm);
		result.setResult("Y");
		result.setMessage("增加户型类型成功");
		return result;
		
		
	}
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	public ResultMessage modify(HouseTypeModel btm) throws Exception
	{
		
		ResultMessage result=new ResultMessage();
		hts.modify(btm);
		result.setResult("Y");
		result.setMessage("修改户型类型成功");
		return result;
		
		
	}
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	public ResultMessage delete(HouseTypeModel btm) throws Exception
	{
		
		ResultMessage result=new ResultMessage();
		hts.delete(btm);
		result.setResult("Y");
		result.setMessage("删除户型类型成功");
		return result;
		
		
	}
	@RequestMapping(value="/get",method=RequestMethod.GET,produces="application/json")
	public HouseTypeModel get(@RequestParam int typeNo) throws Exception
	{
		return hts.get(typeNo);
		
	}
	
	@RequestMapping(value="/list/all",method=RequestMethod.GET,produces="application/json")
	public List<HouseTypeModel> getListByAll() throws Exception
	{
		return hts.getListByAll();				
	}
	
	@RequestMapping(value="/list/page",method=RequestMethod.GET,produces="application/json")
	public ResultInfo<HouseTypeModel> getListByAllWithPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception
	{
		int count=hts.getCountByAll();
		int pageCount=hts.getPageCountByAll(rows);
		List<HouseTypeModel> list=hts.getListByAllWithPage(rows, page);
		ResultInfo<HouseTypeModel> result=new ResultInfo<HouseTypeModel>();
		result.setCount(count);
		result.setPageCount(pageCount);
		result.setPage(page);
		result.setRows(rows);
		result.setList(list);
		return result;		
	}
	//检查此户型类型能否被删除
	@RequestMapping(value="/checkcandelete",method=RequestMethod.GET,produces="application/json")
	public ResultMessage checkCanDelete(@RequestParam int typeNo) throws Exception
	{
		ResultMessage result=new ResultMessage();
		if(hts.checkCanDelete(typeNo)){
			result.setResult("Y");
			result.setMessage("此户型类型可以删除!");
		}
		else{
			result.setResult("N");
			result.setMessage("此户型类型不能删除，已经有关联的楼宇!");
		}
		return result;
	}	
	
}
