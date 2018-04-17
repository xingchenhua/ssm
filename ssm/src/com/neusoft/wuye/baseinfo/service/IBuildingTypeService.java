package com.neusoft.wuye.baseinfo.service;

import java.util.List;

import com.neusoft.wuye.baseinfo.model.BuildingTypeModel;

//�������͵�ҵ��ӿ�
public interface IBuildingTypeService {
	//���ӽ�������
	public void add(BuildingTypeModel btm) throws Exception;
	//�޸Ľ�������
	public void modify(BuildingTypeModel btm) throws Exception;
	//ɾ����������
	public void delete(BuildingTypeModel btm) throws Exception;
	//ȡ��ָ���Ľ�������
	public BuildingTypeModel get(int typeNo) throws Exception;
	//ȡ�����н��������б�
	public List<BuildingTypeModel> getListByAll() throws Exception;
	//ȡ�����н��������б���ҳ
	public List<BuildingTypeModel> getListByAllWithPage(int rows,int page) throws Exception;
	//ȡ�����н������͸���
	public int getCountByAll() throws Exception;
	//ȡ�����н�������ҳ��
	public int getPageCountByAll(int rows) throws Exception;
	//���˽��������ܷ�ɾ��������й�����¥��Ͳ���ɾ��
	public boolean checkCanDelete(int typeNo) throws Exception;
	
	
	
	
	
}
