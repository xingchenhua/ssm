package com.neusoft.wuye.baseinfo.model;

import org.apache.ibatis.type.Alias;

//����Model��
@Alias("Room")
public class RoomModel {
	private int no=0;
	private BuildingModel building=null; //¥��
	private HouseTypeModel houseType=null; //����
	private String department=null;
	private String floor=null;
	private String code=null;
	private double buildingArea=0; //�������
	private double useArea=0; //ʹ�����
	private double feeArea=0; //�շ����
	private String status=null; //�շ�״̬
	private String roomType=null; //�������� סլ�򹲽�
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public BuildingModel getBuilding() {
		return building;
	}
	public void setBuilding(BuildingModel building) {
		this.building = building;
	}
	public HouseTypeModel getHouseType() {
		return houseType;
	}
	public void setHouseType(HouseTypeModel houseType) {
		this.houseType = houseType;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getBuildingArea() {
		return buildingArea;
	}
	public void setBuildingArea(double buildingArea) {
		this.buildingArea = buildingArea;
	}
	public double getUseArea() {
		return useArea;
	}
	public void setUseArea(double useArea) {
		this.useArea = useArea;
	}
	public double getFeeArea() {
		return feeArea;
	}
	public void setFeeArea(double feeArea) {
		this.feeArea = feeArea;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	

}
