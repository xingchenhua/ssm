package com.neusoft.wuye.baseinfo.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

//客户Model类
@Alias("Customer")
public class CustomerModel {

	private int no=0; //客户编号，自增
	private String code=null; //客户编码
	private String name=null; //客户名称
	private String contact=null; //联系人
	private String card=null; //身份证号码
	private String mobile=null;
	private String tel=null;
	private String fax=null;
	private String mail=null;
	private String qq=null;
	private String weixin=null;
	private String desc=null;
	private Date feeStartDate=null;
	private Date feeEndDate=null;
	private String status=null; //客户状态,Y:与Room关联，N：与Room无关系
	private CustomerTypeModel customerType=null; //客户类型
	
	
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
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getFeeStartDate() {
		return feeStartDate;
	}
	public void setFeeStartDate(Date feeStartDate) {
		this.feeStartDate = feeStartDate;
	}
	public Date getFeeEndDate() {
		return feeEndDate;
	}
	public void setFeeEndDate(Date feeEndDate) {
		this.feeEndDate = feeEndDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public CustomerTypeModel getCustomerType() {
		return customerType;
	}
	public void setCustomerType(CustomerTypeModel customerType) {
		this.customerType = customerType;
	}
	
	
	
}
