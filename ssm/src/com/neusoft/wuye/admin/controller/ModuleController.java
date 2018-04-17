package com.neusoft.wuye.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.wuye.admin.model.ModuleModel;
import com.neusoft.wuye.admin.service.IModuleService;

//ϵͳģ���������
@RestController
@RequestMapping(value="/module")
public class ModuleController {
	private IModuleService ms=null;
	@Autowired
	public void setMs(IModuleService ms) {
		this.ms = ms;
	}
	//ȡ��ָ����ģ�����
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public ModuleModel get(@RequestParam int moduleNo) throws Exception{
		return ms.get(moduleNo);
	}
	
	//ȡ�����е�ģ������б�
	@RequestMapping(value="/list/all",method=RequestMethod.GET)
	public List<ModuleModel> getListByAll() throws Exception{
		return ms.getListByAll();
	}
	
	
}
