package com.neusoft.wuye.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.wuye.admin.model.FunctionModel;
import com.neusoft.wuye.admin.model.UserModel;
import com.neusoft.wuye.admin.service.IUserService;
import com.neusoft.wuye.baseinfo.model.AreaModel;
import com.neusoft.wuye.baseinfo.model.BuildingModel;
import com.neusoft.wuye.baseinfo.model.BuildingTypeModel;
import com.neusoft.wuye.baseinfo.service.IAreaService;
import com.neusoft.wuye.baseinfo.service.IBuildingService;
import com.neusoft.wuye.baseinfo.service.IBuildingTypeService;

public class Test {

	public static void main(String[] args) {

		ApplicationContext ac=new ClassPathXmlApplicationContext("context.xml");
		
		IBuildingTypeService cts=ac.getBean("BuildingTypeService", IBuildingTypeService.class);
		IAreaService as=ac.getBean("AreaService",IAreaService.class);
		IBuildingService bs=ac.getBean("BuildingService",IBuildingService.class);
		IUserService us=ac.getBean("UserService",IUserService.class);
		/*
		BuildingTypeModel btm=new BuildingTypeModel();

		btm.setNo(3);
		AreaModel am=new AreaModel();
		am.setNo(4);
		
		BuildingModel bm=new BuildingModel();
		bm.setAddress("地址2");
		bm.setCode("C7");
		bm.setDirection("南");
		bm.setArea(am);
		bm.setBuildingType(btm);
		*/
		/*
		
		
		AreaModel am=new AreaModel();
		am.setName("万达广场");
		am.setAddress("开源大道12号");
		am.setTotalArea(10);
		am.setTotalHome(20);
		am.setTotalUseArea(30);
		am.setTotalHouse(10);
		am.setTotalPackArea(40);
		am.setTotalPack(20);
		am.setDeveloper("万达集团");
		*/
		
		UserModel um=new UserModel();
		um.setUserid("1002");
		um.setPassword("1002");
		um.setName("张西西");
		
		
		
		try {
			//cts.add(btm);
			//System.out.println(cts.getCountByAll());
			//System.out.println(cts.getPageCountByAll(2));
			
			//as.add(am);
			
			//bs.add(bm);
			
			//us.add(um);
			
			//us.grantFunction("1001", 1);
			
			//us.grantFunctions("1002", new int[]{1,3,5});
			
			UserModel um01=us.get("1002");
			System.out.println(um01.getName());
			
			for(FunctionModel fm:um01.getFunctions()){
				System.out.println(fm.getName());
			}

			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
