package com.neusoft.wuye.baseinfo.model;

import org.apache.ibatis.type.Alias;

//车位Model类
@Alias("Park")
public class ParkModel {
	private int no=0;
	private String code=null;
	private String location=null;
	private String unit=null;
	private double area=0;
	private double price=0;
	private String status=null;
	private ParkTypeModel packType=null; //车位类型
	private BuildingModel building=null; //楼宇
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ParkTypeModel getPackType() {
		return packType;
	}
	public void setPackType(ParkTypeModel packType) {
		this.packType = packType;
	}
	public BuildingModel getBuilding() {
		return building;
	}
	public void setBuilding(BuildingModel building) {
		this.building = building;
	} 
		
}
