package com.neusoft.wuye.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.neusoft.wuye.baseinfo.model.CarModel;

//¥���Mapper�ӿ�
public interface ICarMapper {
	
	//����¥��
	public void insert(CarModel btm) throws Exception;
	//�޸�¥��
	public void update(CarModel btm) throws Exception;
	//ɾ��¥��
	public void delete(CarModel btm) throws Exception;
	//ȡ��ָ����¥��
	public CarModel select(int carNo) throws Exception;
	//ȡ������¥���б�
	public List<CarModel> selectListByAll() throws Exception;
	//��С��ȡ��¥���б�
	public List<CarModel> selectListByArea(int areaNo) throws Exception;
	//������ȡ��¥���б�
	public List<CarModel> selectListByBuildingType(int typeNo) throws Exception;
	//����������ȡ��¥���б�
	public List<CarModel> selectListByCondition(@Param("areaNo") int areaNo,@Param("buildingTypeNo") int buildingTypeNo,@Param("code") String code) throws Exception;
	//��ҳ��ʽȡ��¥���б�
	public List<CarModel> selectListByAllWithPage(RowBounds rb) throws Exception;
	//����������ȡ��¥���б�,��ҳ��ʽ
	public List<CarModel> selectListByConditionWithPage(@Param("areaNo") int areaNo,@Param("buildingTypeNo") int buildingTypeNo,@Param("code") String code,RowBounds rb) throws Exception;
	//ȡ�ý���¥��ĸ���
	public int selectCount() throws Exception;
	//����������ȡ�ý���¥��ĸ���
	public int selectCountByCondition(@Param("areaNo") int areaNo,@Param("buildingTypeNo") int buildingTypeNo,@Param("code") String code) throws Exception;

}
