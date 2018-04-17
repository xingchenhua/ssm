package com.neusoft.wuye.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.wuye.result.ResultMessage;

//@Controller
//@ControllerAdvice
public class GlobalExceptionHandlerForErrorPage {

	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex,Model model) {
		
		System.out.println("跳转方式的全局异常。。。。。");
		//异常处理代码，存储或发生异常信息。QQ，Mail，微信。
		//
		model.addAttribute("message",ex.getMessage());
		return "/error/error.jsp";
	}
	
}
