/**
 * 房间户型管理JS
 */
$(function(){
	var houseTypeNo=0; 
	$("#houseTypeGrid").jqGrid({
		url: 'housetype/list/page.mvc',
		datatype: "json",
		mtype:"GET",		
		colModel: [
			{ label: '编号', name: 'no', width: 100 },
			{ label: '名称', name: 'name', width: 200 }
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
		pager: "#houseTypeGridPager",
		multiselect:false,
		postData:{houseTypeNo:1,buildingTypeNo:2},
		onSelectRow:function(id){
			houseTypeNo=parseInt(id);
		}
		
		
	});
	
	//点击增加处理
	$("a#houseTypeAddLink").on("click",function(){
		$("#ModalLabel").html("增加户型");
		$("#modelbody").load("houseType/add.html",function(){
			 $("input[type='button'][value='取消']").on("click",function(){
				 $('#houseTypeModal').modal("hide");
			 });
			 //验证增加数据
			 $("#houseTypeAddForm").validate({
				 rules:{
					 name:{
						 required: true,
						 minlength:2,
						 remote:"houseType/checkNameExist.mvc"
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
						 required:"户型名称不能为空",
						 minlength:"户型名称必须大于2个字符",
						 remote:"此户型名称已经存在!"
					 },
				 }
			 });
			 
			 $('#houseTypeAddForm').ajaxForm(function(data) {
				 BootstrapDialog.alert({title:"提示",message:data.message});
				 if(data.result=="Y"){
					 $("#houseTypeGrid").trigger("reloadGrid");
				 }
				 $('#houseTypeModal').modal("hide");
				 
	         });
			
			 
		});
		$("div.modal-dialog").css("width","900px");
		$('#houseTypeModal').modal("show");
	});
	
	//点击修改处理
	$("a#houseTypeModifyLink").on("click",function(){
		if(houseTypeNo==0){
			BootstrapDialog.alert({title:"提示",message:"请选择要修改的户型"});
		}
		else{
			$("#ModalLabel").html("修改户型");
			$("#modelbody").load("houseType/modify.html",function(){
				//取得户型信息，回填户型修改表单
				$.getJSON("houseType/get.mvc",{houseTypeNo:houseTypeNo},function(data){
					$("input[name='no']").val(data.no);
					$("input[name='name']").val(data.name);
					$("input[name='address']").val(data.address);
					$("input[name='developer']").val(data.developer);
					$("input[name='totalHome']").val(data.totalHome);
					$("input[name='totalHouse']").val(data.totalHouse);
					$("input[name='totalPack']").val(data.totalPack);
					$("input[name='totalhouseType']").val(data.totalhouseType);
					$("input[name='totalUsehouseType']").val(data.totalUsehouseType);
					$("input[name='totalPackhouseType']").val(data.totalPackhouseType);
					$("input[name='startDate']").val(data.startDate);
				});
				$("input[type='button'][value='取消']").on("click",function(){
					 $('#houseTypeModal').modal("hide");
				});
				 $('#houseTypeModifyForm').ajaxForm(function(data) {
					 BootstrapDialog.alert({title:"提示",message:data.message});
					 if(data.result=="Y"){
						 $("#houseTypeGrid").trigger("reloadGrid");
					 }
					 $('#houseTypeModal').modal("hide");
					 
		         });
				
				
				 
			});
			$("div.modal-dialog").css("width","900px");
			$('#houseTypeModal').modal("show");
		}
		
		
	});
	
	//点击删除处理
	$("a#houseTypeDeleteLink").on("click",function(){
		if(houseTypeNo==0){
			BootstrapDialog.alert({title:"提示",message:"请选择要删除的户型"});
		}
		else{
			
		}
	});
	//点击查看处理
	$("a#houseTypeViewLink").on("click",function(){
		if(houseTypeNo==0){
			BootstrapDialog.alert({title:"提示",message:"请选择要查看的户型"});
		}
		else{
			$("#ModalLabel").html("查看户型");
			$("#modelbody").load("houseType/view.html",function(){
				//取得户型信息，回填户型修改表单
				$.getJSON("houseType/get.mvc",{houseTypeNo:houseTypeNo},function(data){
					
					$("div#houseTypename").html(data.name);
					$("#houseTypeaddress").html(data.address);
					$("#houseTypedeveloper").html(data.developer);
					$("#houseTypeTotalhouseType").html(data.totalHome);
					$("#totalUsehouseType").html(data.totalHouse);
					$("#totalParkhouseType").html(data.totalPack);
					$("#totalHome").html(data.totalhouseType);
					$("#totalHouse").html(data.totalUsehouseType);
					$("#totalPark").html(data.totalPackhouseType);
					$("#startDate").html(data.startDate);
					
					
					if(data.photoFileName!=null){
						if(data.photoContentType.indexOf("image")==0){
							$("div#houseTypePhoto").html("<img src='houseType/downphoto.mvc?houseTypeNo="+data.no+"' width='300' height='270' />");
						}
						else{
							$("div#houseTypePhoto").html("<a href='houseType/downphoto.mvc?houseTypeNo="+data.no+"' >下载</a>");
						}
						
					}
					else{
						$("div#houseTypePhoto").html("无附件");
					}
					
				});
				
				$("input[type='button'][value='返回']").on("click",function(){
					 $('#houseTypeModal').modal("hide");
				});
				 
			});
			$("div.modal-dialog").css("width","900px");
			$('#houseTypeModal').modal("show");
		}
		
	});
	//点击导入处理
	$("a#houseTypeImportLink").on("click",function(){
		$("#ModalLabel").html("导入户型");
		$("#modelbody").load("houseType/import.html",function(){
			$("input[type='button'][value='取消']").on("click",function(){
				 $('#houseTypeModal').modal("hide");
			});
			
			$("form#houseTypeImportForm").ajaxForm(function(data){
				if(data.result=="Y"){
					 $("#houseTypeGrid").trigger("reloadGrid");
				}
				BootstrapDialog.alert({title:"提示",message:data.message});
				$('#houseTypeModal').modal("hide");
			});
			
			 
		});
		$("div.modal-dialog").css("width","600px");
		$('#houseTypeModal').modal("show");
	});
	
	//点击导出处理
	$("a#houseTypeExportLink").on("click",function(){
		$("#ModalLabel").html("导出户型数据");
		$("#modelbody").load("houseType/export.html",function(){
			$("input[type='button'][value='关闭']").on("click",function(){
				 $('#houseTypeModal').modal("hide");
			});
			
			
			
			 
		});
		$("div.modal-dialog").css("width","600px");
		$('#houseTypeModal').modal("show");
	});
	
	
	
});