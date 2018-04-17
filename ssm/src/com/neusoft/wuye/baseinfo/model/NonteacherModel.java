package com.neusoft.wuye.baseinfo.model;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Alias("Nonteacher")
public class NonteacherModel {
		//
		private int no=0;
		//职工编号
		private String code=null;
		//姓名
		private String name=null;
		//性别
		private String sex=null;
		//年龄
		private String age=null;
		//岗位
		private String job=null;
		//电话
		private String phone=null;
		//入职日期
		@DateTimeFormat(pattern="yyyy-MM-dd") 
		@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  
		private Date hireDate=null;
		//职工的附件, 
		@JsonIgnore
		private byte[] photo=null;
		//附件文件名
		private String photoFileName=null;
		//附件文件类型
		private String photoContentType=null;	
		//
		private List<CarModel> cars=null;
		
		
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
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getJob() {
			return job;
		}
		public void setJob(String job) {
			this.job = job;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public Date getHireDate() {
			return hireDate;
		}
		public void setHireDate(Date hireDate) {
			this.hireDate = hireDate;
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
		public List<CarModel> getCars() {
			return cars;
		}
		public void setCars(List<CarModel> cars) {
			this.cars = cars;
		}
	
	
}
