package com.neusoft.wuye.feeinfo.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

//缴费项目年度价格表
@Alias("FeeItemYearPrice")
public class FeeItemYearPriceModel {
	private String year=null; //年份
	private FeeItemModel feeItem=null; //缴费项目
	private double price=0; //价格
	private Date startDate=null;
	private Date endDate=null;
	private String desc=null; //价格说明
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public FeeItemModel getFeeItem() {
		return feeItem;
	}
	public void setFeeItem(FeeItemModel feeItem) {
		this.feeItem = feeItem;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
