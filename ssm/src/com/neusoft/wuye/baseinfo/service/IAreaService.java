package com.neusoft.wuye.baseinfo.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.neusoft.wuye.baseinfo.model.AreaModel;

//С����ҵ��ӿ�
public interface IAreaService {
	//����С��
	public void add(AreaModel am) throws Exception;
	//�޸�С��
	public void modify(AreaModel am) throws Exception;
	public void modifyWithPhoto(AreaModel am) throws Exception;
	public void modifyForDeletePhoto(AreaModel am) throws Exception;
	//ɾ��С��
	public void delete(AreaModel am) throws Exception;
	//ȡ��ָ��С�����б�
	public AreaModel get(int areaNo) throws Exception;
	//ȡ������С���б�
	public List<AreaModel> getListByAll() throws Exception;
	//ȡ������С���б���ҳ��ʽ
	public List<AreaModel> getListByAllWithPage(int rows,int page) throws Exception;
	//ȡ��С������
	public int getCountByAll() throws Exception;
	//ȡ��С��ҳ��
	public int getPageCountByAll(int rows) throws Exception;
	//���ָ��С���Ƿ���Ա�ɾ��
	public boolean checkCanDelete(int areaNo) throws Exception;
	//���С�������Ƿ����
	public boolean checkNameExist(String name) throws Exception;
	//��Excel�ļ�����С����Ϣ
	public void importFromExcel(InputStream excelFile) throws Exception;
	//��С����Ϣд��Excel�ļ���
	public void exportToExcel(File source,File exportFile) throws Exception;
	
	
	
	
}
