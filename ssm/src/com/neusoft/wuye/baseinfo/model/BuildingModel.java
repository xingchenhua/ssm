package com.neusoft.wuye.baseinfo.model;

import org.apache.ibatis.type.Alias;

@Alias("Building")
public class BuildingModel {
	private int no=0;
	private String code=null;
	private String address=null;
	private String direction=null;
	private int totalHomes=0;
	private int totoalHouses=0;
	//关联的小区对象
	private AreaModel area=null;
	//关联的建筑类型对象
	private BuildingTypeModel buildingType=null;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public int getTotalHomes() {
		return totalHomes;
	}
	public void setTotalHomes(int totalHomes) {
		this.totalHomes = totalHomes;
	}
	public int getTotoalHouses() {
		return totoalHouses;
	}
	public void setTotoalHouses(int totoalHouses) {
		this.totoalHouses = totoalHouses;
	}
	public AreaModel getArea() {
		return area;
	}
	public void setArea(AreaModel area) {
		this.area = area;
	}
	public BuildingTypeModel getBuildingType() {
		return buildingType;
	}
	public void setBuildingType(BuildingTypeModel buildingType) {
		this.buildingType = buildingType;
	}
	
	
	
	

}
