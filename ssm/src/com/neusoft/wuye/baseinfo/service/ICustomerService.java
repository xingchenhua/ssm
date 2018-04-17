package com.neusoft.wuye.baseinfo.service;

import java.util.List;

import com.neusoft.wuye.baseinfo.model.CustomerModel;

//�ͻ�ҵ��ӿ�
public interface ICustomerService {
	//���ӿͻ�
	public void add(CustomerModel cm) throws Exception;
	//�޸Ŀͻ�
	public void modify(CustomerModel cm) throws Exception;
	//ɾ���ͻ�
	public void delete(CustomerModel cm) throws Exception;
	//ȡ��ָ���Ŀͻ�
	public CustomerModel get(int customerNo) throws Exception;
	//����������ȡ�ÿͻ��б�����ҳ
	public List<CustomerModel> getListByCondition(int typeNo,String name,String mobile,String status) throws Exception;
	//����������ȡ�ÿͻ��б�����ҳ
	public List<CustomerModel> getListByConditionWithPage(int typeNo,String name,String mobile,String status,int rows,int page) throws Exception;
	//����������ȡ�ÿͻ�����
	public int getCountByCondition(int typeNo,String name,String mobile,String status) throws Exception;
	//����������ȡ�ÿͻ�ҳ��
	public int getPageCountByCondition(int typeNo,String name,String mobile,String status,int rows) throws Exception;
	
	
	
	
	
}
