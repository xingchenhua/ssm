package com.neusoft.wuye.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.wuye.admin.model.UserModel;
import com.neusoft.wuye.admin.service.IUserService;
import com.neusoft.wuye.result.ResultInfo;
import com.neusoft.wuye.result.ResultMessage;
import com.neusoft.wuye.result.UserInfo;

//系统操作员控制器类
@RestController
@RequestMapping(value="/user")
public class UserController {
	
	private IUserService us=null;
	@Autowired
	public void setUs(IUserService us) {
		this.us = us;
	}
	/*
	@ExceptionHandler(Exception.class)
	public ResultMessage handleException(Exception ex) {
		ResultMessage result=new ResultMessage();
		//异常处理代码，存储或发生异常信息。QQ，Mail，微信。
		//
		result.setResult("N");
		result.setMessage("操作员处理异常,异常原因:"+ex.getMessage());
		return result;
	}
	*/
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResultMessage add(UserModel um,@RequestParam(required=false) int[] functionNos ) throws Exception
	{
		ResultMessage result=new ResultMessage();
		
		us.add(um);
		if(functionNos!=null){
			us.grantFunctions(um.getUserid(), functionNos);
		}
		result.setResult("Y");
		result.setMessage("增加系统操作员成功");
		return result;
		
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public ResultMessage modify(UserModel um,@RequestParam(required=false) int[] functionNos) throws Exception
	{
		ResultMessage result=new ResultMessage();
		us.modify(um);
		us.revoleFunctions(um.getUserid());
		if(functionNos!=null){
			us.grantFunctions(um.getUserid(), functionNos);
		}
		result.setResult("Y");
		result.setMessage("修改系统操作员成功");
		return result;
		
	}
	
	@RequestMapping(value="/loginsetting",method=RequestMethod.POST)
	public ResultMessage loginStatusSetting(UserModel um) throws Exception
	{
		ResultMessage result=new ResultMessage();
		us.settingLoginStatus(um);
		result.setResult("Y");
		result.setMessage("设置操作员登录状态成功");
		return result;
		
	}
	
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public ResultMessage delete(UserModel um) throws Exception
	{
		ResultMessage result=new ResultMessage();
		us.delete(um);
		result.setResult("Y");
		result.setMessage("删除系统操作员成功");
		return result;
		
	}
	//验证操作员方法,用于操作员登录验证
	@RequestMapping(value="/validate",method=RequestMethod.POST)
	public ResultMessage validate(@RequestParam String userid,@RequestParam String password,HttpSession session) throws Exception
	{
		ResultMessage result=new ResultMessage();
		if(us.validate(userid, password)){
			//将用户保存到会话对象
			UserModel um=us.get(userid);
			
			session.setAttribute("user", um);
			//
			result.setResult("Y");
			result.setMessage("验证系统操作员成功");
		}
		else{
			result.setResult("N");
			result.setMessage("验证系统操作员失败");
		}
		
		return result;
		
	}
	//取得指定的系统操作员
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public UserModel get(@RequestParam String userid) throws Exception
	{
		return us.get(userid);
		
	}
	//取得所有操作员列表，无分页
	@RequestMapping(value="/list/all",method=RequestMethod.GET)
	public List<UserModel> getListByAll() throws Exception
	{
		return us.getListByAll();
		
	}
	
	//取得所有操作员列表，分页模式(旧方法)
	@RequestMapping(value="/list/page/old",method=RequestMethod.GET)
	public List<UserModel> getListByAllWithPageOld(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1")int page) throws Exception
	{
		return us.getListByAllWithPage(rows, page);
		
	}
	
	//取得所有操作员列表，分页模式
	@RequestMapping(value="/list/page",method=RequestMethod.GET)
	public ResultInfo<UserModel> getListByAllWithPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1")int page) throws Exception
	{
		ResultInfo<UserModel> result=new ResultInfo<UserModel>();
		result.setCount(us.getCountByAll());
		result.setPageCount(us.getPageCountByAll(rows));
		result.setPage(page);
		result.setRows(rows);
		result.setList(us.getListByAllWithPage(rows, page));
		return result;
		
	}
	
	//取得会话对象中保存的操作员对象
	@RequestMapping(value="/getfromsession",method=RequestMethod.GET)
	public UserInfo<UserModel> get(HttpSession session) throws Exception
	{
		UserInfo<UserModel> userInfo=new UserInfo<UserModel>();
		//从会话对象中取得用户信息直接返回
		UserModel um=(UserModel)session.getAttribute("user");
		if(um==null){
			userInfo.setResult("N");
			userInfo.setMessage("操作员没有登录");
		}
		else{
			userInfo.setResult("Y");
			userInfo.setMessage("操作员已经登录");
			userInfo.setUser(um);
		}
		return userInfo;
		
	}
	//检查指定的操作员能否被删除
	@RequestMapping(value="/checkcandelete",method=RequestMethod.GET)
	public ResultMessage checkCanDelete(@RequestParam String userid) throws Exception
	{
		ResultMessage result=new ResultMessage();
		if(us.checkCanDelete(userid)){
			result.setResult("Y");
			result.setMessage("此操作员可以被删除!");
		}
		else{
			result.setResult("N");
			result.setMessage("此操作员不能被删除!");
		}
		return result;
	}
	
	//操作员注销
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ResultMessage logout(HttpSession session) throws Exception
	{
		ResultMessage result=new ResultMessage();
		session.invalidate(); //销毁会话对象
		result.setResult("Y");
		result.setMessage("操作员注销成功");
		
		return result;
	}
	//验证用户ID是否存在
	@RequestMapping(value="/useridvalidate",method=RequestMethod.GET)
	public boolean checkUserIdValidate(@RequestParam String userid) throws Exception{
		if(us.get(userid)!=null){
			return false;
		}
		else{
			return true;
		}
	}
	
	//验证用户ID是否允许登录
	@RequestMapping(value="/usercanlogin",method=RequestMethod.GET)
	public boolean checkUserCanLogin(@RequestParam String userid) throws Exception{
		UserModel um=us.get(userid);
		if(um!=null&&um.getStatus()!=null&&um.getStatus().equals("Y")){
			return true;
		}
		else{
			return false;
		}
	}
	//检查操作员的旧密码是否正确
	@RequestMapping(value="/checkpasswordvalidate",method=RequestMethod.POST)
	public boolean checkPasswordValidate(@RequestParam String userid,@RequestParam String password) throws Exception{
		return us.validate(userid, password);
	}
	
	//操作员注销
	@RequestMapping(value="/changepassword",method=RequestMethod.POST)
	public ResultMessage changePassword(UserModel um) throws Exception
	{
		ResultMessage result=new ResultMessage();
		us.changePassword(um);
		result.setResult("Y");
		result.setMessage("操作员密码修改成功");
		
		return result;
	}
		

}
