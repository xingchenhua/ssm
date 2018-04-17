/**
 * 校车管理JS
 */

$(function(){
	var areaNo=0; 
	var buildingTypeNo=0;
	var carNo=0; 
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

	//显示校车Grid
	$("#carGrid").jqGrid({
		url: 'car/list/condition/page.mvc',
		datatype: "json",
		mtype:"POST",		
		colModel: [
			{ label: '校车车牌号', name: 'code', width: 80 },
			{ label: '司机', name: 'address', width: 200 },
			{ label: '负责区域', name: 'direction', width: 100 },
			{ label: '小区', name: 'area.name', width: 100 },
			{ label: '建筑类型', name: 'buildingType.name', width: 100 }
		],
		caption:"校车列表",
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
		pager: "#carGridPager",
		multiselect:false,
		onSelectRow:function(id){
			carNo=parseInt(id);
		}
	
	});
	//更改小区选择事件
	$("select#areaSelect").on("change",function(){
		areaNo=parseInt($(this).val());
		$("#carGrid").jqGrid('setGridParam',{postData:{areaNo:areaNo,buildingTypeNo:buildingTypeNo,code:code}}).trigger("reloadGrid");
		
	});
	//更改建筑类型选择事件
	$("select#buildingTypeSelect").on("change",function(){
		buildingTypeNo=parseInt($(this).val());
		$("#carGrid").jqGrid('setGridParam',{postData:{areaNo:areaNo,buildingTypeNo:buildingTypeNo,code:code}}).trigger("reloadGrid");
		
	});
	
	$("input[name='carcode']").on("blur",function(){
		code=$("input[name='carcode']").val();
		$("#carGrid").jqGrid('setGridParam',{postData:{areaNo:areaNo,buildingTypeNo:buildingTypeNo,code:code}}).trigger("reloadGrid");
	});
	
	
	
	//
	$("a#carAddLink").on("click",function(){
		$("#ModalLabel").html("增加校车");
		$("#modelbody").load("car/add.html",function(){
			 $("button[type='reset']").on("click",function(){
				 $('#carModal').modal("hide");
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
			 
			 
			 
			 $('form#carAddForm').ajaxForm(function(data) {
				 BootstrapDialog.alert({title:"提示",message:data.message});
				 if(data.result=="Y"){
					 $("#carGrid").trigger("reloadGrid");
				 }
				 $('#carModal').modal("hide");
				 
	         });
			
			 
		});
		$("div.modal-dialog").css("width","600px");
		$('#carModal').modal("show");
		
	});
	//点击修改处理
	$("a#carModifyLink").on("click",function(){
		if(carNo==0){
			BootstrapDialog.alert({title:"提示",message:"请选择要修改的校车"});
		}
		else{
			$("#ModalLabel").html("修改校车");
			$("#modelbody").load("car/modify.html",function(){
				 $("button[type='reset']").on("click",function(){
					 $('#carModal').modal("hide");
				 });
				 
				//取得小区列表，填充小区选择下拉框
				$.getJSON("area/list/all.mvc",function(areadata){
					if(areadata!=null){
						for(var i=0;i<areadata.length;i++){
							$("select[name='area.no']").append("<option value='"+areadata[i].no+"'>"+areadata[i].name+"</option>");
						}
						
					}
					//取得建筑类型列表，填充建筑类型选择下拉框
					$.getJSON("cartype/list/all.mvc",function(typedata){
						if(typedata!=null){
							for(var i=0;i<typedata.length;i++){
								$("select[name='buildingType.no']").append("<option value='"+typedata[i].no+"'>"+typedata[i].name+"</option>");
							}						
						}
						
						//取得校车的信息
						$.getJSON("car/get.mvc",{carNo:carNo},function(data){
							alert(data.direction);
							$("input[name='code']").val(data.code);
							
							$("select[name='area.no']").val(data.area.no);
							$("select[name='buildingType.no']").val(data.buildingType.no);
							$("input[name='direction'][value='"+data.direction+"']").attr("checked","true");
							
						});
						
						
					});
					
					
					
					
				});
				
					
				 
				 $('form#carModifyForm').ajaxForm(function(data) {
					 BootstrapDialog.alert({title:"提示",message:data.message});
					 if(data.result=="Y"){
						 $("#carGrid").trigger("reloadGrid");
					 }
					 $('#carModal').modal("hide");
					 
		         });
				
				 
			});
			$("div.modal-dialog").css("width","600px");
			$('#carModal').modal("show");
		}
	});
	
	//点击删除处理
	$("a#carDeleteLink").on("click",function(){
		if(carNo==0){
			BootstrapDialog.alert({title:"提示",message:"请选择要删除的校车"});
		}
		else{
			
		}
	});
	
	//点击查看处理
	$("a#carViewLink").on("click",function(){
		if(carNo==0){
			BootstrapDialog.alert({title:"提示",message:"请选择要查看的校车"});
		}
		else{
			$("#ModalLabel").html("查看校车");
			$("#modelbody").load("car/view.html",function(){
				 $("button[type='reset']").on("click",function(){
					 $('#carModal').modal("hide");
				 });
 
			});
			$("div.modal-dialog").css("width","600px");
			$('#carModal').modal("show");
		}
	});
	
	
	
});	