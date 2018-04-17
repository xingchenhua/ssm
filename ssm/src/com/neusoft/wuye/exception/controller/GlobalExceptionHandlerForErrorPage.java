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
		
		System.out.println("��ת��ʽ��ȫ���쳣����������");
		//�쳣������룬�洢�����쳣��Ϣ��QQ��Mail��΢�š�
		//
		model.addAttribute("message",ex.getMessage());
		return "/error/error.jsp";
	}
	
}
