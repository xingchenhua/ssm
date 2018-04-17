/**
 * 楼宇管理JS
 */

$(function(){
	var areaNo=0; 
	var buildingTypeNo=0;
	var buildingNo=0; 
	var code="";
	
	//取得小区列表，填充小区选择下拉框
	$.getJSON("area/list/all.mvc",function(data){
		if(data!=null){
			for(var i=0;i<data.length;i++){
				$("select#areaSelect").append("<option value='"+data[i].no+"'>"+data[i].name+"</option>");
			}
		}
	});
	//取得建筑类型列表，填充建筑类型选择下拉框
	$.getJSON("buildingtype/list/all.mvc",function(data){
		if(data!=null){
			for(var i=0;i<data.length;i++){
				$("select#buildingTypeSelect").append("<option value='"+data[i].no+"'>"+data[i].name+"</option>");
			}
		}
	});

	//显示楼宇Grid
	$("#buildingGrid").jqGrid({
		url: 'building/list/condition/page.mvc',
		datatype: "json",
		mtype:"POST",		
		colModel: [
			{ label: '编码', name: 'code', width: 80 },
			{ label: '地址', name: 'address', width: 200 },
			{ label: '朝向', name: 'direction', width: 100 },
			{ label: '小区', name: 'area.name', width: 100 },
			{ label: '建筑类型', name: 'buildingType.name', width: 100 }
		],
		caption:"楼宇列表",
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
		pager: "#buildingGridPager",
		multiselect:false,
		onSelectRow:function(id){
			buildingNo=parseInt(id);
		}
	
	});
	//更改小区选择事件
	$("select#areaSelect").on("change",function(){
		areaNo=parseInt($(this).val());
		$("#buildingGrid").jqGrid('setGridParam',{postData:{areaNo:areaNo,buildingTypeNo:buildingTypeNo,code:code}}).trigger("reloadGrid");
		
	});
	//更改建筑类型选择事件
	$("select#buildingTypeSelect").on("change",function(){
		buildingTypeNo=parseInt($(this).val());
		$("#buildingGrid").jqGrid('setGridParam',{postData:{areaNo:areaNo,buildingTypeNo:buildingTypeNo,code:code}}).trigger("reloadGrid");
		
	});
	
	$("input[name='buildingcode']").on("blur",function(){
		code=$("input[name='buildingcode']").val();
		$("#buildingGrid").jqGrid('setGridParam',{postData:{areaNo:areaNo,buildingTypeNo:buildingTypeNo,code:code}}).trigger("reloadGrid");
	});
	
	
	
	//
	$("a#buildingAddLink").on("click",function(){
		$("#ModalLabel").html("增加楼宇");
		$("#modelbody").load("building/add.html",function(){
			 $("button[type='reset']").on("click",function(){
				 $('#buildingModal').modal("hide");
			 });
			
			//取得小区列表，填充小区选择下拉框
			$.getJSON("area/list/all.mvc",function(data){
					if(data!=null){
						for(var i=0;i<data.length;i++){
							$("select[name='area.no']").append("<option value='"+data[i].no+"'>"+data[i].name+"</option>");
						}
						if(areaNo!=0){
							$("select[name='area.no']").val(areaNo);
						}
						
					}
			});
			//取得建筑类型列表，填充建筑类型选择下拉框
			$.getJSON("buildingtype/list/all.mvc",function(data){
					if(data!=null){
						for(var i=0;i<data.length;i++){
							$("select[name='buildingType.no']").append("<option value='"+data[i].no+"'>"+data[i].name+"</option>");
						}
						if(buildingTypeNo!=0){
							$("select[name='buildingType.no']").val(buildingTypeNo);
						}
						
						
					}
			});
			 
			 
			 
			 $('form#buildingAddForm').ajaxForm(function(data) {
				 BootstrapDialog.alert({title:"提示",message:data.message});
				 if(data.result=="Y"){
					 $("#buildingGrid").trigger("reloadGrid");
				 }
				 $('#buildingModal').modal("hide");
				 
	         });
			
			 
		});
		$("div.modal-dialog").css("width","600px");
		$('#buildingModal').modal("show");
		
	});
	//点击修改处理
	$("a#buildingModifyLink").on("click",function(){
		if(buildingNo==0){
			BootstrapDialog.alert({title:"提示",message:"请选择要修改的楼宇"});
		}
		else{
			$("#ModalLabel").html("修改楼宇");
			$("#modelbody").load("building/modify.html",function(){
				 $("button[type='reset']").on("click",function(){
					 $('#buildingModal').modal("hide");
				 });
				 
				//取得小区列表，填充小区选择下拉框
				$.getJSON("area/list/all.mvc",function(areadata){
					if(areadata!=null){
						for(var i=0;i<areadata.length;i++){
							$("select[name='area.no']").append("<option value='"+areadata[i].no+"'>"+areadata[i].name+"</option>");
						}
						
					}
					//取得建筑类型列表，填充建筑类型选择下拉框
					$.getJSON("buildingtype/list/all.mvc",function(typedata){
						if(typedata!=null){
							for(var i=0;i<typedata.length;i++){
								$("select[name='buildingType.no']").append("<option value='"+typedata[i].no+"'>"+typedata[i].name+"</option>");
							}						
						}
						
						//取得楼宇的信息
						$.getJSON("building/get.mvc",{buildingNo:buildingNo},function(data){
							alert(data.direction);
							$("input[name='code']").val(data.code);
							
							$("select[name='area.no']").val(data.area.no);
							$("select[name='buildingType.no']").val(data.buildingType.no);
							$("input[name='direction'][value='"+data.direction+"']").attr("checked","true");
							
						});
						
						
					});
					
					
					
					
				});
				
					
				 
				 $('form#buildingModifyForm').ajaxForm(function(data) {
					 BootstrapDialog.alert({title:"提示",message:data.message});
					 if(data.result=="Y"){
						 $("#buildingGrid").trigger("reloadGrid");
					 }
					 $('#buildingModal').modal("hide");
					 
		         });
				
				 
			});
			$("div.modal-dialog").css("width","600px");
			$('#buildingModal').modal("show");
		}
	});
	
	//点击删除处理
	$("a#buildingDeleteLink").on("click",function(){
		if(buildingNo==0){
			BootstrapDialog.alert({title:"提示",message:"请选择要删除的楼宇"});
		}
		else{
			
		}
	});
	
	//点击查看处理
	$("a#buildingViewLink").on("click",function(){
		if(buildingNo==0){
			BootstrapDialog.alert({title:"提示",message:"请选择要查看的楼宇"});
		}
		else{
			$("#ModalLabel").html("查看楼宇");
			$("#modelbody").load("building/view.html",function(){
				 $("button[type='reset']").on("click",function(){
					 $('#buildingModal').modal("hide");
				 });
 
			});
			$("div.modal-dialog").css("width","600px");
			$('#buildingModal').modal("show");
		}
	});
	
	
	
});	