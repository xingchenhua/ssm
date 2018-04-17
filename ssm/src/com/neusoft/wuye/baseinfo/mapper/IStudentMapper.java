package com.neusoft.wuye.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.neusoft.wuye.baseinfo.model.AreaModel;

//С��Mapper�ӿ�
public interface IStudentMapper {
	
	//����С��
	public void insert(AreaModel btm) throws Exception;
	public void insertWithPhoto(AreaModel btm) throws Exception;
	//�޸�С������ͼƬ����
	public void update(AreaModel btm) throws Exception;
	//�޸�С������ͼƬ����
	public void updateWithPhoto(AreaModel btm) throws Exception;
	//ɾ��С��ͼƬ
	public void updateForDeletePhoto(AreaModel btm) throws Exception;
	//ɾ��С��
	public void delete(AreaModel btm) throws Exception;
	//ȡ��ָ����С��
	public AreaModel select(int areaNo) throws Exception;
	//ȡ������С���б�
	public List<AreaModel> selectListByAll() throws Exception;
	//��ҳ��ʽȡ��С���б�
	public List<AreaModel> selectListByAllWithPage(RowBounds rb) throws Exception;
	//ȡ�ý���С���ĸ���
	public int selectCountByAll() throws Exception;
	
	

}
