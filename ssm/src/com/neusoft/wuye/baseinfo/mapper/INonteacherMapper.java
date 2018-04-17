package com.neusoft.wuye.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.neusoft.wuye.baseinfo.model.NonteacherModel;

//ְ��Mapper�ӿ�
public interface INonteacherMapper {
	
	//����ְ��
	public void insert(NonteacherModel btm) throws Exception;
	public void insertWithPhoto(NonteacherModel btm) throws Exception;
	//�޸�ְ������ͼƬ����
	public void update(NonteacherModel btm) throws Exception;
	//�޸�ְ������ͼƬ����
	public void updateWithPhoto(NonteacherModel btm) throws Exception;
	//ɾ��ְ��ͼƬ
	public void updateForDeletePhoto(NonteacherModel btm) throws Exception;
	//ɾ��ְ��
	public void delete(NonteacherModel btm) throws Exception;
	//ȡ��ָ����ְ��
	public NonteacherModel select(int nonteacherNo) throws Exception;
	//ȡ������ְ���б�
	public List<NonteacherModel> selectListByAll() throws Exception;
	//��ҳ��ʽȡ��ְ���б�
	public List<NonteacherModel> selectListByAllWithPage(RowBounds rb) throws Exception;
	//ȡ��ְ���ĸ���
	public int selectCountByAll() throws Exception;
	
	

}
