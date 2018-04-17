package com.neusoft.wuye.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.neusoft.wuye.baseinfo.model.RoomModel;

//����Mapper�ӿ�
public interface IRoomMapper {
	//���ӷ���
	public void insert(RoomModel rm) throws Exception;
	//�޸ķ���
	public void update(RoomModel rm) throws Exception;
	//ɾ������
	public void delete(RoomModel rm) throws Exception;
	//ȡ��ָ���ķ���
	public RoomModel select(int roomNo) throws Exception;
	//ȡ�����з����б�
	public List<RoomModel> selectListByAll() throws Exception;
	//�������ļ�������ȡ�÷����б��޷�ҳ
	public List<RoomModel> selectListByCondition(int areaNo,int buildingTypeNo,int buildingNo,int houseTypeNo,String department,String floor,String code) throws Exception;
	
	//�������ļ�������ȡ�÷����б��з�ҳ
	public List<RoomModel> selectListByConditionWithPage(@Param("areaNo") int areaNo,@Param("buildingTypeNo") int buildingTypeNo,@Param("buildingNo") int buildingNo,@Param("houseTypeNo") int houseTypeNo,@Param("department") String department,@Param("floor") String floor,@Param("code") String code,RowBounds rb) throws Exception;
	//ȡ�����з������
	public int selectCountByAll() throws Exception;
	//����������ȡ�÷������
	public int selectCountByCondition(@Param("areaNo") int areaNo,@Param("buildingTypeNo") int buildingTypeNo,@Param("buildingNo") int buildingNo,@Param("houseTypeNo") int houseTypeNo,@Param("department") String department,@Param("floor") String floor,@Param("code") String code) throws Exception;
	//
	
	
	
	
	
	
	
}
