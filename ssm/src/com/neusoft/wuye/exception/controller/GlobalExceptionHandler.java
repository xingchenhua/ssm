package com.neusoft.wuye.exception.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.wuye.result.ResultMessage;

//ȫ�ֵ��쳣�����������
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResultMessage handleException(Exception ex) {
		ResultMessage result=new ResultMessage();
		//�쳣������룬�洢�����쳣��Ϣ��QQ��Mail��΢�š�
		//
		result.setResult("N");
		result.setMessage("ȫ�ִ����׳��쳣,�쳣ԭ��:"+ex.getMessage());
		return result;
	}
	
}
