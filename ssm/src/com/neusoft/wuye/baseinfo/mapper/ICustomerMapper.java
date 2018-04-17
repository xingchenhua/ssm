package com.neusoft.wuye.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.neusoft.wuye.baseinfo.model.CustomerModel;

//�ͻ�Mapper�ӿ�
public interface ICustomerMapper {
	//���ӿͻ�
	public void insert(CustomerModel cm) throws Exception;
	//�޸Ŀͻ�
	public void update(CustomerModel cm) throws Exception;
	//ɾ���ͻ�
	public void delete(CustomerModel cm) throws Exception;
	//ȡ��ָ���Ŀͻ�����
	public CustomerModel select(int customerNo) throws Exception;
	//ȡ�����пͻ��б��޷�ҳ
	public List<CustomerModel> selectListByAll() throws Exception;
	//ȡ��ָ�����Ŀͻ��б��޷�ҳ
	public List<CustomerModel> selectListByType(int typeNo) throws Exception;
	//ȡ�����пͻ��б���ҳ
	public List<CustomerModel> selectListByAllWithPage(RowBounds rd) throws Exception;
	//ȡ��ָ�����Ŀͻ��б���ҳ
	public List<CustomerModel> selectListByTypeWithPage(@Param("typeNo") int typeNo,RowBounds rd) throws Exception;	
	//ȡ�����пͻ�����
	public int selectCountByAll() throws Exception;
	//ȡ��ָ�����͵Ŀͻ�����
	public int selectCountByType(int typeNo) throws Exception;
	
	
	

}
