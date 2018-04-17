package com.neusoft.wuye.baseinfo.service;

import java.util.List;

import com.neusoft.wuye.baseinfo.model.BuildingModel;

//¥���ҵ���
public interface IBuildingService {
	//����¥��
	public void add(BuildingModel bm) throws Exception;
	//�޸�¥��
	public void modify(BuildingModel bm) throws Exception;
	//ɾ��¥��
	public void delete(BuildingModel bm) throws Exception;
	//ȡ��ָ����¥��
	public BuildingModel get(int buildingNo) throws Exception;
	//��ҳ��ʽȡ������¥���б�
	public List<BuildingModel> getListByAllWithPage(int rows,int page) throws Exception;
	//����������ȡ��¥���б�����ҳ
	public List<BuildingModel> getListByCondition(int areaNo,int buildingTypeNo,String code) throws Exception;
	//����������ȡ��¥���б���ҳ
	public List<BuildingModel> getListByConditionWithPage(int areaNo,int buildingTypeNo,String code,int rows,int page) throws Exception;
	//����������ȡ��¥�����
	public int getCountByCondition(int areaNo,int buildingTypeNo,String code) throws Exception;
	//����������ȡ��¥���ҳ��
	public int getPageCountByCondition(int areaNo,int buildingTypeNo,String code,int rows) throws Exception;
	
}
