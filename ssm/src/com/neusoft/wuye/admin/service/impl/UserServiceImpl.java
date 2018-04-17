package com.neusoft.wuye.admin.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.wuye.admin.mapper.IFunctionMapper;
import com.neusoft.wuye.admin.mapper.IUserMapper;
import com.neusoft.wuye.admin.model.FunctionModel;
import com.neusoft.wuye.admin.model.UserModel;

import com.neusoft.wuye.admin.service.IUserService;
//�û�ҵ��ʵ����
@Service("UserService")
@Transactional
public class UserServiceImpl implements IUserService {
	private IUserMapper ump=null;
	private IFunctionMapper fmp=null;
	
	@Autowired
	public void setUmp(IUserMapper ump) {
		this.ump = ump;
	}
	@Autowired
	public void setFmp(IFunctionMapper fmp) {
		this.fmp = fmp;
	}



	@Override
	public void add(UserModel um) throws Exception {
		ump.insert(um);
	}

	@Override
	public void modify(UserModel um) throws Exception {
		ump.update(um);

	}

	@Override
	public void delete(UserModel um) throws Exception {
		ump.delete(um);

	}

	@Override
	public UserModel get(String userid) throws Exception {
		
		return ump.select(userid);
	}

	@Override
	public List<UserModel> getListByAll() throws Exception {
		return ump.selectListByAll();
	}

	@Override
	public boolean validate(String userid, String password) throws Exception {
		boolean result=false;
		UserModel um=ump.select(userid);
		if(um!=null&&um.getPassword()!=null&&um.getPassword().equals(password)){
			result=true;
		}
		return result;
	}

	@Override
	public boolean checkCanLogin(String userid) throws Exception {
		boolean result=false;
		UserModel um=ump.select(userid);
		if(um!=null&&um.getStatus().equals("Y")){
			result=true;
		}
		return result;
	}

	@Override
	public boolean checkUserExist(String userid) throws Exception {
		
		boolean result=false;
		UserModel um=ump.select(userid);
		if(um!=null){
			result=true;
		}
		return result;
	}
	//Ϊ����Ա����һ��ָ���Ĺ���Ȩ��
	@Override
	public void grantFunction(String userid, int functionNo) throws Exception {
		ump.grantFunction(userid, functionNo);

	}
	//Ϊ����Ա����������Ȩ��
	@Override
	public void grantFunctions(String userid, int[] functionNos) throws Exception {
		ump.grantFunctions(userid, functionNos);
		

	}
	//ȡ��ָ��Ա���Ĺ����б�
	@Override
	public List<FunctionModel> getFunctionsByUser(String userid) throws Exception {
		
		return fmp.selectListByUser(userid);
	}

	@Override
	public List<UserModel> getListByAllWithPage(int rows, int page) throws Exception {
		RowBounds rb=new RowBounds(rows*(page-1),rows);
		//int i=10/0;
		
		return ump.selectListByAllWithPage(rb);
	}
	@Override
	public int getCountByAll() throws Exception {
		
		return ump.selectCountByAll();
	}
	@Override
	public int getPageCountByAll(int rows) throws Exception {
		
		int pageCount=0;
		int count=this.getCountByAll();
		if(count%rows==0){
			pageCount=count/rows;
		}
		else{
			pageCount=count/rows+1;
		}
		return pageCount;
	}
	@Override
	public boolean checkCanDelete(String userid) throws Exception {
		
		return true;
	}
	@Override
	public void revoleFunctions(String userid) throws Exception {
		ump.revokeFunctions(userid);
		
	}
	@Override
	public void settingLoginStatus(UserModel um) throws Exception {
		ump.updateForLoginStatus(um);
		
	}
	//�޸Ĳ���Ա����
	@Override
	public void changePassword(UserModel um) throws Exception {
		ump.updateForPasswowrd(um);
		
	}

}
