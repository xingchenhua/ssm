package com.neusoft.wuye.baseinfo.model;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

//小区Model类
@Alias("Student")
public class StudentModel {
	
	private String address=null;
	
	//
	private double totalStudent=0;
	//
	private double totalUseStudent=0;
	//
	private double totalPackStudent=0;
		//序号
		private int no;
		//编号
		private String code;
		//姓名
		private String name;
		//电话
		private String phone;
		//班级编号
		private String classNo;
		//地址
		private String saddress;		
		//入学时间
		@DateTimeFormat(pattern="yyyy-MM-dd") 
		@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  
		private Date mutDate;
	//小区入住日期
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  
	private Date startDate=null;
	//小区的附件, 
	@JsonIgnore
	private byte[] photo=null;
	//附件文件名
	private String photoFileName=null;
	//附件文件类型
	private String photoContentType=null;	
	//
	private List<BuildingModel> buildings=null;
	
	
}
