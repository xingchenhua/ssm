package com.neusoft.wuye.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.neusoft.wuye.baseinfo.model.BuildingModel;

//¥���Mapper�ӿ�
public interface IBuildingMapper {
	
	//����¥��
	public void insert(BuildingModel btm) throws Exception;
	//�޸�¥��
	public void update(BuildingModel btm) throws Exception;
	//ɾ��¥��
	public void delete(BuildingModel btm) throws Exception;
	//ȡ��ָ����¥��
	public BuildingModel select(int buildingNo) throws Exception;
	//ȡ������¥���б�
	public List<BuildingModel> selectListByAll() throws Exception;
	//��С��ȡ��¥���б�
	public List<BuildingModel> selectListByArea(int areaNo) throws Exception;
	//������ȡ��¥���б�
	public List<BuildingModel> selectListByBuildingType(int typeNo) throws Exception;
	//����������ȡ��¥���б�
	public List<BuildingModel> selectListByCondition(@Param("areaNo") int areaNo,@Param("buildingTypeNo") int buildingTypeNo,@Param("code") String code) throws Exception;
	//��ҳ��ʽȡ��¥���б�
	public List<BuildingModel> selectListByAllWithPage(RowBounds rb) throws Exception;
	//����������ȡ��¥���б�,��ҳ��ʽ
	public List<BuildingModel> selectListByConditionWithPage(@Param("areaNo") int areaNo,@Param("buildingTypeNo") int buildingTypeNo,@Param("code") String code,RowBounds rb) throws Exception;
	//ȡ�ý���¥��ĸ���
	public int selectCount() throws Exception;
	//����������ȡ�ý���¥��ĸ���
	public int selectCountByCondition(@Param("areaNo") int areaNo,@Param("buildingTypeNo") int buildingTypeNo,@Param("code") String code) throws Exception;

}
