package com.neusoft.wuye.baseinfo.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.neusoft.wuye.baseinfo.model.NonteacherModel;

//ְ����ҵ��ӿ�
public interface INonteacherService {
	//����ְ��
	public void add(NonteacherModel am) throws Exception;
	//�޸�ְ��
	public void modify(NonteacherModel am) throws Exception;
	public void modifyWithPhoto(NonteacherModel am) throws Exception;
	public void modifyForDeletePhoto(NonteacherModel am) throws Exception;
	//ɾ��ְ��
	public void delete(NonteacherModel am) throws Exception;
	//ȡ��ָ��ְ�����б�
	public NonteacherModel get(int nonteacherNo) throws Exception;
	//ȡ������ְ���б�
	public List<NonteacherModel> getListByAll() throws Exception;
	//ȡ������ְ���б���ҳ��ʽ
	public List<NonteacherModel> getListByAllWithPage(int rows,int page) throws Exception;
	//ȡ��ְ������
	public int getCountByAll() throws Exception;
	//ȡ��ְ��ҳ��
	public int getPageCountByAll(int rows) throws Exception;
	//���ָ��ְ���Ƿ���Ա�ɾ��
	public boolean checkCanDelete(int areaNo) throws Exception;
	//���ְ�������Ƿ����
	public boolean checkNameExist(String name) throws Exception;
	//��Excel�ļ�����ְ����Ϣ
	public void importFromExcel(InputStream excelFile) throws Exception;
	//��ְ����Ϣд��Excel�ļ���
	public void exportToExcel(File source,File exportFile) throws Exception;
	
	
	
	
}
