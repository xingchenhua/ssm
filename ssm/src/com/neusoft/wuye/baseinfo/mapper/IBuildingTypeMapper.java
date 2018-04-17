package com.neusoft.wuye.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.neusoft.wuye.baseinfo.model.BuildingTypeModel;

//�������͵�Mapper�ӿ�
public interface IBuildingTypeMapper {
	//��������
	public void insert(BuildingTypeModel btm) throws Exception;
	//�޸�����
	public void update(BuildingTypeModel btm) throws Exception;
	//ɾ������
	public void delete(BuildingTypeModel btm) throws Exception;
	//ȡ��ָ��������
	public BuildingTypeModel select(int typeNo) throws Exception;
	//ȡ�����������б�
	public List<BuildingTypeModel> selectListByAll() throws Exception;
	//��ҳ��ʽȡ�������б�
	public List<BuildingTypeModel> selectListByAllWithPage(RowBounds rb) throws Exception;
	//ȡ�ý������͵ĸ���
	public int selectCountByAll() throws Exception;
	
	
	

}
