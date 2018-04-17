package com.neusoft.wuye.exception.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.wuye.result.ResultMessage;

//全局的异常处理控制器器
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResultMessage handleException(Exception ex) {
		ResultMessage result=new ResultMessage();
		//异常处理代码，存储或发生异常信息。QQ，Mail，微信。
		//
		result.setResult("N");
		result.setMessage("全局处理抛出异常,异常原因:"+ex.getMessage());
		return result;
	}
	
}
