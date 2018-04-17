package com.neusoft.wuye.feeinfo.model;

import org.apache.ibatis.type.Alias;

//缴费项目Model类
@Alias("FeeItem")
public class FeeItemModel {
	private int no=0;
	private String code=null;
	private String name=null;
	private String unit=null;
	private String method=null; //计费方式
	private String cycle=null;
	private String status=null;
	private String desc=null;
	private FeeTypeModel feeType=null; //费用类型
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
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getCycle() {
		return cycle;
	}
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public FeeTypeModel getFeeType() {
		return feeType;
	}
	public void setFeeType(FeeTypeModel feeType) {
		this.feeType = feeType;
	}
	

}
