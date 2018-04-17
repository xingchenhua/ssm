/**
 * 小区管理主程序
 */

$(function(){
	var nonteacherNo=0; 
	$("#nonteacherGrid").jqGrid({
		url: 'nonteacher/list/page.mvc',
		datatype: "json",
		mtype:"GET",		
		colModel: [
			{ label: '编号', name: 'code', width: 150 },
			{ label: '姓名', name: 'name', width: 200 },
			{ label: '岗位', name: 'job', width: 100 },
			{ label: '入职时间', name: 'hireDate', width: 100 }
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
			id:"no"
		},
		pager: "#nonteacherGridPager",
		multiselect:false,
		postData:{nonteacherNo:1,buildingTypeNo:2},
		onSelectRow:function(id){
			nonteacherNo=parseInt(id);
		}
		
		
	});
	
	//点击增加处理
	$("a#nonteacherAddLink").on("click",function(){
		$("#ModalLabel").html("增加职工");
		$("#modelbody").load("nonteacher/add.html",function(){
			 $("input[type='button'][value='取消']").on("click",function(){
				 $('#nonteacherModal').modal("hide");
			 });
			 //验证增加数据
			 $("#nonteacherAddForm").validate({
				 rules:{
					 name:{
						 required: true,
						 minlength:2,
						 remote:"nonteacher/checkNameExist.mvc"
					 },
					 address:{
						 required: true
					 },
					 developer:{
						 required: true
					 }
				 },
				 messages:{
					 name:{
						 required:"职工姓名不能为空",
						 minlength:"职工姓名必须大于2个字符",
						 remote:"此职工已经存在!"
					 },
				 }
				 
			 });
			 
			 $('#nonteacherAddForm').ajaxForm(function(data) {
				 BootstrapDialog.alert({title:"提示",message:data.message});
				 if(data.result=="Y"){
					 $("#nonteacherGrid").trigger("reloadGrid");
				 }
				 $('#nonteacherModal').modal("hide");
				 
	         });
			
			 
		});
		$("div.modal-dialog").css("width","900px");
		$('#nonteacherModal').modal("show");
	});
	
	//点击修改处理
	$("a#nonteacherModifyLink").on("click",function(){
		if(nonteacherNo==0){
			BootstrapDialog.alert({title:"提示",message:"请选择要修改的小区"});
		}
		else{
			$("#ModalLabel").html("修改职工信息");
			$("#modelbody").load("nonteacher/modify.html",function(){
				//取得职工信息，回填职工修改表单
				$.getJSON("nonteacher/get.mvc",{nonteacherNo:nonteacherNo},function(data){
					$("input[name='no']").val(data.no);
					$("input[name='code']").val(data.code);
					$("input[name='name']").val(data.name);
					$("input[name='sex'][value='"+data.sex+"']").attr("checked","true");
					$("input[name='age']").val(data.age);
					$("input[name='job']").val(data.job);
					$("input[name='phone']").val(data.phone);
					$("input[name='hireDate']").val(data.hireDate);
				});
				$("input[type='button'][value='取消']").on("click",function(){
					 $('#nonteacherModal').modal("hide");
				});
				 $('#nonteacherModifyForm').ajaxForm(function(data) {
					 BootstrapDialog.alert({title:"提示",message:data.message});
					 if(data.result=="Y"){
						 $("#nonteacherGrid").trigger("reloadGrid");
					 }
					 $('#nonteacherModal').modal("hide");
					 
		         });
				
				
				 
			});
			$("div.modal-dialog").css("width","900px");
			$('#nonteacherModal').modal("show");
		}
		
		
	});
	
	//点击删除处理
	$("a#nonteacherDeleteLink").on("click",function(){
		if(nonteacherNo==0){
			BootstrapDialog.alert({title:"提示",message:"请选择要删除的小区"});
		}
		else{
			
		}
	});
	//点击查看处理
	$("a#nonteacherViewLink").on("click",function(){
		if(nonteacherNo==0){
			BootstrapDialog.alert({title:"提示",message:"请选择要查看的职工"});
		}
		else{
			$("#ModalLabel").html("查看职工");
			$("#modelbody").load("nonteacher/view.html",function(){
				//取得职工信息，回填职工修改表单
				$.getJSON("nonteacher/get.mvc",{nonteacherNo:nonteacherNo},function(data){
					
					$("#code").html(data.code);
					$("#name").html(data.name);
					$("#sex").html(data.sex);
					$("#age").html(data.age);
					$("#job").html(data.job);
					$("#phone").html(data.phone);
					$("#hireDate").html(data.hireDate);
					
					
					if(data.photoFileName!=null){
						if(data.photoContentType.indexOf("image")==0){
							$("div#photo").html("<img src='nonteacher/downphoto.mvc?nonteacherNo="+data.no+"' width='270' height='250' />");
						}
						else{
							$("div#photo").html("<a href='nonteacher/downphoto.mvc?nonteacherNo="+data.no+"' >下载</a>");
						}
						
					}
					else{
						$("div#photo").html("无附件");
					}
					
				});
				
				$("input[type='button'][value='返回']").on("click",function(){
					 $('#nonteacherModal').modal("hide");
				});
				 
			});
			$("div.modal-dialog").css("width","900px");
			$('#nonteacherModal').modal("show");
		}
		
	});
	//点击导入处理
	$("a#nonteacherImportLink").on("click",function(){
		$("#ModalLabel").html("导入小区");
		$("#modelbody").load("nonteacher/import.html",function(){
			$("input[type='button'][value='取消']").on("click",function(){
				 $('#nonteacherModal').modal("hide");
			});
			
			$("form#nonteacherImportForm").ajaxForm(function(data){
				if(data.result=="Y"){
					 $("#nonteacherGrid").trigger("reloadGrid");
				}
				BootstrapDialog.alert({title:"提示",message:data.message});
				$('#nonteacherModal').modal("hide");
			});
			
			 
		});
		$("div.modal-dialog").css("width","600px");
		$('#nonteacherModal').modal("show");
	});
	
	//点击导出处理
	$("a#nonteacherExportLink").on("click",function(){
		$("#ModalLabel").html("导出小区数据");
		$("#modelbody").load("nonteacher/export.html",function(){
			$("input[type='button'][value='关闭']").on("click",function(){
				 $('#nonteacherModal').modal("hide");
			});
			
			
			
			 
		});
		$("div.modal-dialog").css("width","600px");
		$('#nonteacherModal').modal("show");
	});
	
	
	
});