package com.neusoft.wuye.baseinfo.model;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

//С��Model��
@Alias("Area")
public class AreaModel {
	//С�����
	private int no=0;
	//
	private String name=null;
	//
	private String address=null;
	//
	private String developer=null;
	//
	private double totalArea=0;
	//
	private double totalUseArea=0;
	//
	private double totalPackArea=0;
	//סլ����
	private int totalHome=0;
	//��������
	private int totalHouse=0;
	//��ͣ��λ����
	private int totalPack=0;
	//С����ס����
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  
	private Date startDate=null;
	//С���ĸ���, 
	@JsonIgnore
	private byte[] photo=null;
	//�����ļ���
	private String photoFileName=null;
	//�����ļ�����
	private String photoContentType=null;	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public double getTotalArea() {
		return totalArea;
	}
	public void setTotalArea(double totalArea) {
		this.totalArea = totalArea;
	}
	public double getTotalUseArea() {
		return totalUseArea;
	}
	public void setTotalUseArea(double totalUseArea) {
		this.totalUseArea = totalUseArea;
	}
	public double getTotalPackArea() {
		return totalPackArea;
	}
	public void setTotalPackArea(double totalPackArea) {
		this.totalPackArea = totalPackArea;
	}
	public int getTotalHome() {
		return totalHome;
	}
	public void setTotalHome(int totalHome) {
		this.totalHome = totalHome;
	}
	public int getTotalHouse() {
		return totalHouse;
	}
	public void setTotalHouse(int totalHouse) {
		this.totalHouse = totalHouse;
	}
	public int getTotalPack() {
		return totalPack;
	}
	public void setTotalPack(int totalPack) {
		this.totalPack = totalPack;
	}
	public List<BuildingModel> getBuildings() {
		return buildings;
	}
	public void setBuildings(List<BuildingModel> buildings) {
		this.buildings = buildings;
	}
	//
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public String getPhotoContentType() {
		return photoContentType;
	}
	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

}
