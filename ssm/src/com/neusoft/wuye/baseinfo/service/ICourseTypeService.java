package com.neusoft.wuye.baseinfo.service;

import java.util.List;

import com.neusoft.wuye.baseinfo.model.CourseTypeModel;

//�������͵�ҵ��ӿ�
public interface ICourseTypeService {
	//���ӽ�������
	public void add(CourseTypeModel btm) throws Exception;
	//�޸Ľ�������
	public void modify(CourseTypeModel btm) throws Exception;
	//ɾ����������
	public void delete(CourseTypeModel btm) throws Exception;
	//ȡ��ָ���Ľ�������
	public CourseTypeModel get(int typeNo) throws Exception;
	//ȡ�����н��������б�
	public List<CourseTypeModel> getListByAll() throws Exception;
	//ȡ�����н��������б���ҳ
	public List<CourseTypeModel> getListByAllWithPage(int rows,int page) throws Exception;
	//ȡ�����н������͸���
	public int getCountByAll() throws Exception;
	//ȡ�����н�������ҳ��
	public int getPageCountByAll(int rows) throws Exception;
	//���˽��������ܷ�ɾ��������й�����¥��Ͳ���ɾ��
	public boolean checkCanDelete(int typeNo) throws Exception;
	
	
	
	
	
}
