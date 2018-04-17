package com.neusoft.wuye.baseinfo.model;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

//С��Model��
@Alias("Student")
public class StudentModel {
	
	private String address=null;
	
	//
	private double totalStudent=0;
	//
	private double totalUseStudent=0;
	//
	private double totalPackStudent=0;
		//���
		private int no;
		//���
		private String code;
		//����
		private String name;
		//�绰
		private String phone;
		//�༶���
		private String classNo;
		//��ַ
		private String saddress;		
		//��ѧʱ��
		@DateTimeFormat(pattern="yyyy-MM-dd") 
		@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  
		private Date mutDate;
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
	
	
}
