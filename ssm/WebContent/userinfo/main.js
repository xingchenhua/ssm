/**
 * 系统操作员管理主控制JS
 */
$(function(){
	var userid=null;
	
	//显示系统操作员表格
	$("#userGrid").jqGrid({
		url: 'user/list/page.mvc',
		datatype: "json",
		mtype:"GET",		
		colModel: [
			{ label: '账号', name: 'userid', width: 150 },
			{ label: '姓名', name: 'name', width: 200 },
			{ label: '性别', name: 'sex', width: 100 },
			{ label: '登录状态', name: 'loginStatus', width: 100 }
	
		],
		viewrecords: true, // show the current page, data rang and total records on the toolbar
		autowidth:true,
		height: 370,
		rowNum: 10,
		rowList:[10,15,20],
		jsonReader:{
			root:"list",
			page:"page",
			total:"pageCount",
			records:"count",
			id:"userid"
		},
		pager: "#userGridPager",
		multiselect:false,
		onSelectRow:function(id){
			userid=id;
		},
		loadComplete:function(data){
			if(data.message){
				BootstrapDialog.alert({title:"提示",message:data.message});
			}
			
		},
		loadError:function(xhr,status,error){
			BootstrapDialog.alert({title:"提示",message:error});
			
		}
		
	});
	//点击增加处理
	$("a#userAddLink").on("click",function(){
		$("#modelbody").load("userinfo/add.html",function(){
			$("#ModalLabel").html("增加系统操作员");
			//取得系统功能列表
			$.getJSON("function/list/all.mvc",function(funtionList){
				if(funtionList!=null){
					if(funtionList.message){
						BootstrapDialog.alert({title:"提示",message:data.message});
					}
					else{
						for(var i=0;i<funtionList.length;i++){
							$("div#userfunctions").append("<label class='checkbox-inline'><input type='checkbox' name='functionNos' value='"+funtionList[i].no+"'>"+funtionList[i].name+"</label>");
						}
					}
					
				}
			});
			//验证
			$("form#userAddForm").validate({
				rules:{
					userid:{
						required:true,
						remote:"user/useridvalidate.mvc"
					},
					password:{
						required:true
					},
					name:{required:true},
					zipcode:{
						required:true,
						zipcode:true
					}
					
				},
				messages:{
					userid:{
						remote:"此用户账号已经存在"
					}
				}
				
			});
			//拦截用户增加
			$("form#userAddForm").ajaxForm(function(data){
				if(data.result=="Y"){
					$("#userGrid").trigger("reloadGrid");
				}
				BootstrapDialog.alert({title:"提示",message:data.message});
				$('#UserInfoModal').modal("hide");
			});
			//点击取消按钮处理
			$("button[type='reset']").on("click",function(){
				$('#UserInfoModal').modal("hide");
			});
		});
		$('#UserInfoModal').modal("show");
		
	});
	//点击修改处理
	$("a#userModifyLink").on("click",function(){
		if(userid==null){
			BootstrapDialog.alert({title:"提示",message:"请选择要修改的操作员"});
		}
		else{
			$("#modelbody").load("userinfo/modify.html",function(){
				$("#ModalLabel").html("修改系统操作员");
				//取得系统功能列表
				$.getJSON("function/list/all.mvc",function(funtionList){
					if(funtionList!=null){
						for(var i=0;i<funtionList.length;i++){
							$("div#userfunctions").append("<label class='checkbox-inline'><input type='checkbox' name='functionNos' value='"+funtionList[i].no+"'>"+funtionList[i].name+"</label>");
						}
					}
					//取得指定的用户
					$.getJSON("user/get.mvc",{userid:userid},function(userdata){
						$("input[name='userid']").val(userdata.userid);
						$("input[name='password']").val(userdata.password);
						$("input[name='name']").val(userdata.name);
						$("input[name='sex'][value='"+userdata.sex+"']").attr("checked","true");
						$("input[name='status'][value='"+userdata.status+"']").attr("checked","true");
						if(userdata.functions!=null){
							for(var i=0;i<userdata.functions.length;i++){
								$("input[name='functionNos'][value='"+userdata.functions[i].no+"']").attr("checked","true");
							}
						}
					});
				});
				//验证
				$("form#userModifyForm").validate({
					rules:{
						password:{
							required:true
						},
						name:{required:true}
						
					}
				});
				//拦截用户修改表单提交
				$("form#userModifyForm").ajaxForm(function(data){
					if(data.result=="Y"){
						$("#userGrid").trigger("reloadGrid");
					}
					BootstrapDialog.alert({title:"提示",message:data.message});
					$('#UserInfoModal').modal("hide");
				});
				$("button[type='reset']").on("click",function(){
					$('#UserInfoModal').modal("hide");
				});
			});
			$('#UserInfoModal').modal("show");
		}
	});
	
	//点击删除处理
	$("a#userDeleteLink").on("click",function(){
		if(userid==null){
			BootstrapDialog.alert({title:"提示",message:"请选择要删除的操作员"});
		}
		else{
			$.getJSON("user/checkcandelete.mvc",{userid:userid},function(data){
				if(data.result=="Y"){
					
					BootstrapDialog.confirm({
						title:"删除确认",
						message:"您确认要删除此操作员么?",
						callback:function(result){
							if(result){
								$.post("user/delete.mvc",{userid:userid},function(data){
									if(data.result=="Y"){
										userid=null;
										 $("#userGrid").trigger("reloadGrid");
									}
									BootstrapDialog.alert({title:"提示",message:data.message});
								});
							}
						}
					});
					
				}
				else{
					BootstrapDialog.alert({title:"警告",message:data.message});
				}
			});
		}
	});
	
	//点击查看处理
	$("a#userViewLink").on("click",function(){
		if(userid==null){
			BootstrapDialog.alert({title:"提示",message:"请选择要查看的操作员"});
		}
		else{
			$("#ModalLabel").html("查看系统操作员");
			$("#modelbody").load("userinfo/view.html",function(){
				
				$.getJSON("user/get.mvc",{userid:userid},function(userdata){
					if(userdata!=null){
						$("span#userid").html(userdata.userid);
						$("span#username").html(userdata.name);
						$("span#usersex").html(userdata.sex);
						$("span#loginstatus").html(userdata.loginStatus);
						if(userdata.functions!=null){
							for(var i=0;i<userdata.functions.length;i++){
								$("span#userfunctions").append(" "+userdata.functions[i].name+" " );
							}
						}
					}
				});
				
				$("button[type='reset']").on("click",function(){
					$('#UserInfoModal').modal("hide");
				});
				
			});
			$('#UserInfoModal').modal("show");
		}
	});
	//操作员登录设置
	$("a#userLoginSetLink").on("click",function(){
		if(userid==null){
			BootstrapDialog.alert({title:"提示",message:"请选择要设置的操作员"});
		}
		else{
			$("#modelbody").load("userinfo/loginsetting.html",function(){
				$("#ModalLabel").html("设置操作员登录状态");
				
				
				//取得指定的用户
				$.getJSON("user/get.mvc",{userid:userid},function(userdata){
					$("input[name='userid']").val(userdata.userid);
					$("input[name='status'][value='"+userdata.status+"']").attr("checked","true");
					
				});
				//拦截用户登录设置表单提交
				$("form#userLoginSettingForm").ajaxForm(function(data){
					if(data.result=="Y"){
						$("#userGrid").trigger("reloadGrid");
					}
					BootstrapDialog.alert({title:"提示",message:data.message});
					$('#UserInfoModal').modal("hide");
				});
				$("button[type='reset']").on("click",function(){
					$('#UserInfoModal').modal("hide");
				});
			});
			$('#UserInfoModal').modal("show");
		}
		
	});
	
});