package com.neusoft.wuye.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.neusoft.wuye.admin.model.UserModel;

//ϵͳ����ԱMapper
public interface IUserMapper {
	//���Ӳ���Ա
	public void insert(UserModel um) throws Exception;
	//�޸Ĳ���Ա
	public void update(UserModel um) throws Exception;
	//�޸Ĳ���Ա��¼״̬
	public void updateForLoginStatus(UserModel um) throws Exception;
	//�޸Ĳ���Ա����
	public void updateForPasswowrd(UserModel um) throws Exception;
	//ɾ������Ա
	public void delete(UserModel um) throws Exception;
	//ȡ��ָ���Ĳ���Ա����
	public UserModel select(String userid) throws Exception;
	//ȡ�����в���Ա�б��޷�ҳ
	public List<UserModel> selectListByAll() throws Exception;
	//ȡ�����в���Ա�б��з�ҳ
	public List<UserModel> selectListByAllWithPage(RowBounds rb) throws Exception;
	//ȡ�ò���Ա����
	public int selectCountByAll() throws Exception;
	//ȡ������ָ�������Ĳ���Ա����
	public int selectByCondition(String userid,String password) throws Exception;
	//ȡ��ָ�����ܵ��û��б�
	public List<UserModel> selectListByFunction(int functionNo) throws Exception;
	//Ϊָ��Ա������ָ���Ĺ���
	public void grantFunction(@Param("userid") String userid,@Param("functionNo") int functionNo) throws Exception;
	//Ϊָ��Ա���������Ĺ���
	public void grantFunctions(@Param("userid") String userid,@Param("functionNos") int[] functionNos) throws Exception;
	//����ָ���û�������Ȩ��
	public void revokeFunctions(@Param("userid") String userid) throws Exception;
	
}
