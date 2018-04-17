package com.neusoft.wuye.feeinfo.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.neusoft.wuye.baseinfo.model.RoomModel;

//房间缴费表
@Alias("RoomFee")
public class RoomFeeModel {
	
	private int no=0; //缴费编号
	private String year=null;
	private String month=null;
	private RoomModel room=null; //缴费房间
	private FeeItemModel feeItem=null; //缴费项目
	private double shouldPay=0; //应缴金额
	private double autualPay=0; //已缴金额
	private double creditPay=0; //欠缴金额
	private Date startDate=null; //缴费项目开始日期
	private Date endDate=null; //缴费截止日期
	private String status=null; //缴费状态，Y:  N:
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public RoomModel getRoom() {
		return room;
	}
	public void setRoom(RoomModel room) {
		this.room = room;
	}
	public FeeItemModel getFeeItem() {
		return feeItem;
	}
	public void setFeeItem(FeeItemModel feeItem) {
		this.feeItem = feeItem;
	}
	public double getShouldPay() {
		return shouldPay;
	}
	public void setShouldPay(double shouldPay) {
		this.shouldPay = shouldPay;
	}
	public double getAutualPay() {
		return autualPay;
	}
	public void setAutualPay(double autualPay) {
		this.autualPay = autualPay;
	}
	public double getCreditPay() {
		return creditPay;
	}
	public void setCreditPay(double creditPay) {
		this.creditPay = creditPay;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
