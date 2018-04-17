package com.neusoft.wuye.baseinfo.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

//�ͻ�Model��
@Alias("Customer")
public class CustomerModel {

	private int no=0; //�ͻ���ţ�����
	private String code=null; //�ͻ�����
	private String name=null; //�ͻ�����
	private String contact=null; //��ϵ��
	private String card=null; //���֤����
	private String mobile=null;
	private String tel=null;
	private String fax=null;
	private String mail=null;
	private String qq=null;
	private String weixin=null;
	private String desc=null;
	private Date feeStartDate=null;
	private Date feeEndDate=null;
	private String status=null; //�ͻ�״̬,Y:��Room������N����Room�޹�ϵ
	private CustomerTypeModel customerType=null; //�ͻ�����
	
	
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
