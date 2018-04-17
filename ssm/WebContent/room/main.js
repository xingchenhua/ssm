/**
 * 住宅Room管理JS
 */
$(function(){
	var areaNo=0;
	var buildingTypeNo=0;
	var buildingNo=0;
	var houseTypeNo=0;
	var department=null;
	var floor=null;
	var roomCode=null; 
	var roomNo=0;
	var buildingCode="";
	var roomCode="";
	
	function reloadRoomList(){
		$("#roomGrid").jqGrid('setGridParam',{postData:{areaNo:areaNo,buildingTypeNo:buildingTypeNo,buildingNo:buildingNo,houseTypeNo:houseTypeNo,department:department,floor:floor,code:roomCode}}).trigger("reloadGrid");
	}
	
	function reloadBuildingList(){
		$("#buildingGrid").jqGrid('setGridParam',{postData:{areaNo:areaNo,buildingTypeNo:buildingTypeNo,code:buildingCode}}).trigger("reloadGrid");
	}
	
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
			reloadRoomList();
			$('#roomTab li a:eq(1)').tab('show');//初始化显示哪个tab  
			
		}
	
	});
	//更改小区选择事件
	$("select#areaSelect").on("change",function(){
		areaNo=parseInt($(this).val());
		reloadBuildingList();
		reloadRoomList();
		
		
	});
	//更改建筑类型选择事件
	$("select#buildingTypeSelect").on("change",function(){
		buildingTypeNo=parseInt($(this).val());
		reloadBuildingList();
		reloadRoomList();
		
	});
	
	$("input[name='buildingcode']").on("blur",function(){
		buildingCode=$("input[name='buildingcode']").val();
		reloadBuildingList();
		//reloadRoomList();
		
	});
	
	//显示房间列表
	$("#roomGrid").jqGrid({
		url: 'room/list/condition/page.mvc',
		datatype: "json",
		mtype:"POST",		
		colModel: [
			{ label: '小区', name: 'building.area.name', width: 80 },
			{ label: '楼宇', name: 'building.code', width: 80 },
			{ label: '单元', name: 'department', width: 50 },
			{ label: '楼层', name: 'floor', width: 50 },
			{ label: '房间号', name: 'code', width: 80 },
			{ label: '户型', name: 'houseType.name', width: 100 },
			{ label: '建筑面积', name: 'buildingArea', width: 100 },
			{ label: '房间类型', name: 'roomType', width: 100 },
		],
		caption:"房间列表",
		viewrecords: true, // show the current page, data rang and total records on the toolbar
		width:670,
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
		pager: "#roomGridPager",
		multiselect:false,		
		onSelectRow:function(id){
			roomNo=parseInt(id);
		}
	
	});
	
	
	//点击增加Room处理
	$("a#roomAddLink").on("click",function(){
		if(buildingNo==0){
			BootstrapDialog.alert({title:"提示",message:"请先选择楼宇，才能增加房间"});
		}
		else{
			$("#ModalLabel").html("增加房间");
			$("#modelbody").load("room/add.html",function(){
				 $("input[value='取消']").on("click",function(){
					 $('#roomModal').modal("hide");
				 });
				 
				 $('form#roomAddForm').ajaxForm(function(data) {
					 BootstrapDialog.alert({title:"提示",message:data.message});
					 if(data.result=="Y"){
						 $("#roomGrid").trigger("reloadGrid");
					 }
					 $('#roomModal').modal("hide");
					 
		         });
				
				 
			});
			$("div.modal-dialog").css("width","800px");
			$('#roomModal').modal("show");
		}
		
		
	});
	//点击修改处理
	$("a#roomModifyLink").on("click",function(){
		if(roomNo==0){
			BootstrapDialog.alert({title:"提示",message:"请选择要修改的房间"});
		}
		else{
			$("#ModalLabel").html("修改房间");
			$("#modelbody").load("room/modify.html",function(){
				 $("input[value='取消']").on("click",function(){
					 $('#roomModal').modal("hide");
				 });
				 
			});
			$("div.modal-dialog").css("width","800px");
			$('#roomModal').modal("show");
			
		}
	});
	//点击删除处理
	$("a#roomDeleteLink").on("click",function(){
		if(roomNo==0){
			BootstrapDialog.alert({title:"提示",message:"请选择要修改的房间"});
		}
		else{
			
			
		}
	});
	//点击查看处理
	$("a#roomViewLink").on("click",function(){
		if(roomNo==0){
			BootstrapDialog.alert({title:"提示",message:"请选择要查看的房间"});
		}
		else{
			$("#ModalLabel").html("查看房间");
			$("#modelbody").load("room/view.html",function(){
				 $("input[value='关闭']").on("click",function(){
					 $('#roomModal').modal("hide");
				 });
				 
			});
			$("div.modal-dialog").css("width","600px");
			$('#roomModal').modal("show");
			
		}
	});
	
	
});