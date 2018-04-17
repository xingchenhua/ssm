/**
 * 小区管理主程序
 */

$(function(){
	var areaNo=0; 
	$("#areaGrid").jqGrid({
		url: 'area/list/page.mvc',
		datatype: "json",
		mtype:"GET",		
		colModel: [
			{ label: '名称', name: 'name', width: 150 },
			{ label: '地址', name: 'address', width: 200 },
			{ label: '开发商', name: 'developer', width: 100 },
			{ label: '入住日期', name: 'startDate', width: 100 }
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
		pager: "#areaGridPager",
		multiselect:false,
		postData:{areaNo:1,buildingTypeNo:2},
		onSelectRow:function(id){
			areaNo=parseInt(id);
		}
		
		
	});
	
	//点击增加处理
	$("a#areaAddLink").on("click",function(){
		$("#ModalLabel").html("增加小区");
		$("#modelbody").load("area/add.html",function(){
			 $("input[type='button'][value='取消']").on("click",function(){
				 $('#areaModal').modal("hide");
			 });
			 //验证增加数据
			 $("#areaAddForm").validate({
				 rules:{
					 name:{
						 required: true,
						 minlength:2,
						 remote:"area/checkNameExist.mvc"
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
						 required:"小区名称不能为空",
						 minlength:"小区名称必须大于2个字符",
						 remote:"此小区名称已经存在!"
					 },
				 }
			 });
			 
			 $('#areaAddForm').ajaxForm(function(data) {
				 BootstrapDialog.alert({title:"提示",message:data.message});
				 if(data.result=="Y"){
					 $("#areaGrid").trigger("reloadGrid");
				 }
				 $('#areaModal').modal("hide");
				 
	         });
			
			 
		});
		$("div.modal-dialog").css("width","900px");
		$('#areaModal').modal("show");
	});
	
	//点击修改处理
	$("a#areaModifyLink").on("click",function(){
		if(areaNo==0){
			BootstrapDialog.alert({title:"提示",message:"请选择要修改的小区"});
		}
		else{
			$("#ModalLabel").html("修改小区");
			$("#modelbody").load("area/modify.html",function(){
				//取得小区信息，回填小区修改表单
				$.getJSON("area/get.mvc",{areaNo:areaNo},function(data){
					$("input[name='no']").val(data.no);
					$("input[name='name']").val(data.name);
					$("input[name='address']").val(data.address);
					$("input[name='developer']").val(data.developer);
					$("input[name='totalHome']").val(data.totalHome);
					$("input[name='totalHouse']").val(data.totalHouse);
					$("input[name='totalPack']").val(data.totalPack);
					$("input[name='totalArea']").val(data.totalArea);
					$("input[name='totalUseArea']").val(data.totalUseArea);
					$("input[name='totalPackArea']").val(data.totalPackArea);
					$("input[name='startDate']").val(data.startDate);
					
				});
				$("input[type='button'][value='取消']").on("click",function(){
					 $('#areaModal').modal("hide");
				});
				 $('#areaModifyForm').ajaxForm(function(data) {
					 BootstrapDialog.alert({title:"提示",message:data.message});
					 if(data.result=="Y"){
						 $("#areaGrid").trigger("reloadGrid");
					 }
					 $('#areaModal').modal("hide");
					 
		         });
				
				
				 
			});
			$("div.modal-dialog").css("width","900px");
			$('#areaModal').modal("show");
		}
		
		
	});
	
	//点击删除处理
	$("a#areaDeleteLink").on("click",function(){
		if(areaNo==0){
			BootstrapDialog.alert({title:"提示",message:"请选择要删除的小区"});
		}
		else{
			
		}
	});
	//点击查看处理
	$("a#areaViewLink").on("click",function(){
		if(areaNo==0){
			BootstrapDialog.alert({title:"提示",message:"请选择要查看的小区"});
		}
		else{
			$("#ModalLabel").html("查看小区");
			$("#modelbody").load("area/view.html",function(){
				//取得小区信息，回填小区修改表单
				$.getJSON("area/get.mvc",{areaNo:areaNo},function(data){
					
					$("div#areaname").html(data.name);
					$("#areaaddress").html(data.address);
					$("#areadeveloper").html(data.developer);
					$("#areaTotalArea").html(data.totalHome);
					$("#totalUseArea").html(data.totalHouse);
					$("#totalParkArea").html(data.totalPack);
					$("#totalHome").html(data.totalArea);
					$("#totalHouse").html(data.totalUseArea);
					$("#totalPark").html(data.totalPackArea);
					$("#startDate").html(data.startDate);
					
					
					if(data.photoFileName!=null){
						if(data.photoContentType.indexOf("image")==0){
							$("div#areaPhoto").html("<img src='area/downphoto.mvc?areaNo="+data.no+"' width='300' height='270' />");
						}
						else{
							$("div#areaPhoto").html("<a href='area/downphoto.mvc?areaNo="+data.no+"' >下载</a>");
						}
						
					}
					else{
						$("div#areaPhoto").html("无附件");
					}
					
				});
				
				$("input[type='button'][value='返回']").on("click",function(){
					 $('#areaModal').modal("hide");
				});
				 
			});
			$("div.modal-dialog").css("width","900px");
			$('#areaModal').modal("show");
		}
		
	});
	//点击导入处理
	$("a#areaImportLink").on("click",function(){
		$("#ModalLabel").html("导入小区");
		$("#modelbody").load("area/import.html",function(){
			$("input[type='button'][value='取消']").on("click",function(){
				 $('#areaModal').modal("hide");
			});
			
			$("form#areaImportForm").ajaxForm(function(data){
				if(data.result=="Y"){
					 $("#areaGrid").trigger("reloadGrid");
				}
				BootstrapDialog.alert({title:"提示",message:data.message});
				$('#areaModal').modal("hide");
			});
			
			 
		});
		$("div.modal-dialog").css("width","600px");
		$('#areaModal').modal("show");
	});
	
	//点击导出处理
	$("a#areaExportLink").on("click",function(){
		$("#ModalLabel").html("导出小区数据");
		$("#modelbody").load("area/export.html",function(){
			$("input[type='button'][value='关闭']").on("click",function(){
				 $('#areaModal').modal("hide");
			});
			
			
			
			 
		});
		$("div.modal-dialog").css("width","600px");
		$('#areaModal').modal("show");
	});
	
	
	
});