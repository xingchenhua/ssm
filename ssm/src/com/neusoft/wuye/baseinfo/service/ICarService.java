package com.neusoft.wuye.baseinfo.service;

import java.util.List;

import com.neusoft.wuye.baseinfo.model.CarModel;

//¥���ҵ���
public interface ICarService {
	//����¥��
	public void add(CarModel bm) throws Exception;
	//�޸�¥��
	public void modify(CarModel bm) throws Exception;
	//ɾ��¥��
	public void delete(CarModel bm) throws Exception;
	//ȡ��ָ����¥��
	public CarModel get(int carNo) throws Exception;
	//��ҳ��ʽȡ������¥���б�
	public List<CarModel> getListByAllWithPage(int rows,int page) throws Exception;
	//����������ȡ��¥���б�����ҳ
	public List<CarModel> getListByCondition(int areaNo,int buildingTypeNo,String code) throws Exception;
	//����������ȡ��¥���б���ҳ
	public List<CarModel> getListByConditionWithPage(int areaNo,int buildingTypeNo,String code,int rows,int page) throws Exception;
	//����������ȡ��¥�����
	public int getCountByCondition(int areaNo,int buildingTypeNo,String code) throws Exception;
	//����������ȡ��¥���ҳ��
	public int getPageCountByCondition(int areaNo,int buildingTypeNo,String code,int rows) throws Exception;
	
}
