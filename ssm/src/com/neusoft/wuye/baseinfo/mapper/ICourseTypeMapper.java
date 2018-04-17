package com.neusoft.wuye.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.neusoft.wuye.baseinfo.model.CourseTypeModel;

//�γ����͵�Mapper�ӿ�
public interface ICourseTypeMapper {
	//��������
	public void insert(CourseTypeModel btm) throws Exception;
	//�޸�����
	public void update(CourseTypeModel btm) throws Exception;
	//ɾ������
	public void delete(CourseTypeModel btm) throws Exception;
	//ȡ��ָ��������
	public CourseTypeModel select(int typeNo) throws Exception;
	//ȡ�����������б�
	public List<CourseTypeModel> selectListByAll() throws Exception;
	//��ҳ��ʽȡ�������б�
	public List<CourseTypeModel> selectListByAllWithPage(RowBounds rb) throws Exception;
	//ȡ�ÿγ����͵ĸ���
	public int selectCountByAll() throws Exception;
	
	
	

}
