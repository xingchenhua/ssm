package com.neusoft.wuye.result;

//����������JSON
public class ResultMessage {
	private String result=null;
	private String message=null;
	private String errors=null;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrors() {
		return errors;
	}
	public void setErrors(String errors) {
		this.errors = errors;
	}
	

}
