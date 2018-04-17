/**
 * 班级类型管理主JS程序
 */
$(document).ready(function(){
	
	var rows=10;
	var page=1;
	var count=0;
	var totalPage=0;
	var buildingTypeNo=0;
	
	
	
	//取得班级类型列表，分页模式
	function getBuildingTypeList(){
		
		
		
		$.get("buildingtype/list/page.mvc",{rows:rows,page:page},function(data){
			
			count=data.count;
			pageCount=data.pageCount;
			$("div#pageinfo").html("个数:"+count+" 页数:"+page+"/"+pageCount);
			var typeList=data.list;
			if(typeList!=null&&typeList.length>0){
				$("table#buildingTypeTable tbody").html("");
				for(var i=0;i<typeList.length;i++){
					$("table#buildingTypeTable tbody").append("<tr><td>"+typeList[i].no+"</td><td>"+typeList[i].name+"</td></tr>");
				}
				//定义每个TR的点击事件
				$("table#buildingTypeTable tbody tr").on("click",function(){
					buildingTypeNo=parseInt($(this).find("td:first").html());
					$("table#buildingTypeTable tbody tr").css("background-color","#FFF");
					$(this).css("background-color","#BBB");
					
				});
				
				
			}
		});
	}
	
	//点击分页导航处理
	$("ul#pagenav li a").on("click",function(event){
		
		var href=$(this).attr("href");
		if(href=="first"){
			page=1;
		}
		else if(href=="previous"){
			if(page>1){
				page=page-1;
			}
		}
		else if(href=="next"){
			if(page>pageCount){
				page=pageCount;
			}
			else{
				page=page+1;
			}
		}
		else {
			page=pageCount;
		}
		getBuildingTypeList();
		
		event.preventDefault();
	});
	//点击增加班级类型处理
	$("a#buildingTypeAddLink").on("click",function(){
		 $("#ModalLabel").html("增加班级类型");
		 $("#modelbody").load("class/add.html",function(){
			 $("button[type='reset']").on("click",function(){
				 $('#buildingTypeModal').modal("hide");
			 });
			 
			 $("button#buildingTypeAddSubmit").on("click",function(){
				var typeName=$("input[name='name']").val();
				if(typeName==null||typeName==''){
					$("p#namemessage").html("类型名称为空");
					$("p#namemessage").css("color","red");
				}
				else{
					$("p#namemessage").html("");
					$.post("buildingtype/add.mvc",{name:typeName},function(data){
						alert(data.message);
						getBuildingTypeList(); //刷新显示列表
						$('#buildingTypeModal').modal("hide");
						
					});
				}
				 
			 });
		 });
		 $('#buildingTypeModal').modal("show");
		
	});
	//点击修改处理
	$("a#buildingTypeModifyLink").on("click",function(){
		if(buildingTypeNo==0){
			BootstrapDialog.alert({title:"提示",message:'请选择要修改的班级类型!'});
		
		}
		else{
			$("#ModalLabel").html("修改班级类型");
			$("#modelbody").load("class/modify.html",function(){
				 $.getJSON("buildingtype/get.mvc",{typeNo:buildingTypeNo},function(data){
					 $("input[name='name']").val(data.name)
				 });
				 
				 $("button[type='reset']").on("click",function(){
					 $('#buildingTypeModal').modal("hide");
				 });
				 
				 $("button#buildingTypeModifySubmit").on("click",function(){
					var typeName=$("input[name='name']").val();
					if(typeName==null||typeName==''){
						$("p#namemessage").html("类型名称为空");
						$("p#namemessage").css("color","red");
					}
					else{
						$("p#namemessage").html("");
						$.post("buildingtype/modify.mvc",{no:buildingTypeNo,name:typeName},function(data){
							alert(data.message);
							getBuildingTypeList(); //刷新显示列表
							$('#buildingTypeModal').modal("hide");
							
						});
					}
					 
				 });
			 });
			 $('#buildingTypeModal').modal("show");
		}
		
	});
	//点击删除处理
	$("a#buildingTypeDeleteLink").on("click",function(){
		if(buildingTypeNo==0){
			BootstrapDialog.alert({title:"提示",message:'请选择要删除的班级类型!'});
		}
		else{
			//检查此对象能否被删除
			$.getJSON("buildingtype/checkcandelete.mvc",{typeNo:buildingTypeNo},function(data){
				if(data.result=="N"){
					BootstrapDialog.alert({title:"提示",message:'此班级类型有关联的学生，不能被删除!'});
				}
				else{
					//让用户确认执行删除操作
					BootstrapDialog.confirm({
							title:"删除确认",
							message:"您确认要删除此班级类型么?",
							callback:function(result){
								if(result){
									$.post("buildingtype/delete.mvc",{no:buildingTypeNo},function(data){
										if(data.result=="Y"){
											buildingTypeNo=0;
											getBuildingTypeList();
										}
										BootstrapDialog.alert({title:"提示",message:data.message});
										
									});
								}
							}
					});
					
					
				}
			});
			
			
			
		}
	});
	//点击查看处理
	$("a#buildingTypeViewLink").on("click",function(){
		if(buildingTypeNo==0){
			BootstrapDialog.alert({title:"提示",message:'请选择要查看的班级类型!'});
		}
		else{
			$("#ModalLabel").html("查看班级类型");
			$("#modelbody").load("class/view.html",function(){
				 $.getJSON("buildingtype/get.mvc",{typeNo:buildingTypeNo},function(data){
					 $("span#buildingtypename").html(data.name)
					 $("span#buildingtypeno").html(data.no)
				 });
				 
				 $("button[type='reset']").on("click",function(){
					 $('#buildingTypeModal').modal("hide");
				 });
				 
				
			 });
			$('#feeItemModal').modal("show");		
			}
	});
	//初次显示班级类型列表
	getBuildingTypeList();
	
});