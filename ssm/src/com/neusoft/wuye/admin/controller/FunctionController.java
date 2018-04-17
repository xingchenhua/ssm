package com.neusoft.wuye.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.wuye.admin.model.FunctionModel;
import com.neusoft.wuye.admin.service.IFunctionService;
import com.neusoft.wuye.result.ResultInfo;

//ϵͳ���ܿ�������
@RestController
@RequestMapping(value="/function")
public class FunctionController {
	
	private IFunctionService fs=null;
	@Autowired
	public void setFs(IFunctionService fs) {
		this.fs = fs;
	}
	//ȡ��ָ���Ĺ��ܶ���
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public FunctionModel get(@RequestParam int functionNo) throws Exception{
		return fs.get(functionNo);
	}
	
	//ȡ�����й����б�
	@RequestMapping(value="/list/all")
	public List<FunctionModel> getListByAll() throws Exception
	{
		return fs.getListByAll();
	}
	@RequestMapping(value="/list/all/grid")
	public ResultInfo<FunctionModel> getListByAllForGrid() throws Exception
	{
		ResultInfo<FunctionModel> result=new ResultInfo<FunctionModel>();
		List<FunctionModel> list=fs.getListByAll(); 
		result.setList(list);
		result.setCount(list.size());
		result.setPageCount(1);
		result.setRows(list.size());
		result.setPage(1);
		return result;
	}
	
	//ȡ��ָ���û��Ĺ����б�
	@RequestMapping(value="/list/user")
	public List<FunctionModel> getListByUser(@RequestParam String userid) throws Exception
	{
		return fs.getListByUser(userid);
	}

}
