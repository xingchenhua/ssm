package com.neusoft.wuye.baseinfo.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

//建筑类型Model类
@Alias("BuildingType")
public class BuildingTypeModel {
	//类型编号
	private int no=0; 
	//类型名称
	private String name=null;
	//
	private List<BuildingModel> buildings=null;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<BuildingModel> getBuildings() {
		return buildings;
	}
	public void setBuildings(List<BuildingModel> buildings) {
		this.buildings = buildings;
	}
	
	
	
	
}
