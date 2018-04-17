/**
 * 课程类型管理主JS程序
 */
$(document).ready(function(){
	
	var rows=10;
	var page=1;
	var count=0;
	var totalPage=0;
	var courseTypeNo=0;
	
	
	
	//取得课程类型列表，分页模式
	function getCourseTypeList(){
		
		
		
		$.get("coursetype/list/page.mvc",{rows:rows,page:page},function(data){
			
			count=data.count;
			pageCount=data.pageCount;
			$("div#pageinfo").html("个数:"+count+" 页数:"+page+"/"+pageCount);
			var typeList=data.list;
			if(typeList!=null&&typeList.length>0){
				$("table#courseTypeTable tbody").html("");
				for(var i=0;i<typeList.length;i++){
					$("table#courseTypeTable tbody").append("<tr><td>"+typeList[i].no+"</td><td>"+typeList[i].name+"</td></tr>");
				}
				//定义每个TR的点击事件
				$("table#courseTypeTable tbody tr").on("click",function(){
					courseTypeNo=parseInt($(this).find("td:first").html());
					$("table#courseTypeTable tbody tr").css("background-color","#FFF");
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
		getCourseTypeList();
		
		event.preventDefault();
	});
	//点击增加课程类型处理
	$("a#courseTypeAddLink").on("click",function(){
		 $("#ModalLabel").html("增加课程类型");
		 $("#modelbody").load("course/add.html",function(){
			 $("button[type='reset']").on("click",function(){
				 $('#courseTypeModal').modal("hide");
			 });
			 
			 $("button#courseTypeAddSubmit").on("click",function(){
				var typeName=$("input[name='name']").val();
				if(typeName==null||typeName==''){
					$("p#namemessage").html("类型名称为空");
					$("p#namemessage").css("color","red");
				}
				else{
					$("p#namemessage").html("");
					$.post("coursetype/add.mvc",{name:typeName},function(data){
						alert(data.message);
						getCourseTypeList(); //刷新显示列表
						$('#courseTypeModal').modal("hide");
						
					});
				}
				 
			 });
		 });
		 $('#courseTypeModal').modal("show");
		
	});
	//点击修改处理
	$("a#courseTypeModifyLink").on("click",function(){
		if(courseTypeNo==0){
			BootstrapDialog.alert({title:"提示",message:'请选择要修改的课程类型!'});
		
		}
		else{
			$("#ModalLabel").html("修改课程类型");
			$("#modelbody").load("course/modify.html",function(){
				 $.getJSON("coursetype/get.mvc",{typeNo:courseTypeNo},function(data){
					 $("input[name='name']").val(data.name)
				 });
				 
				 $("button[type='reset']").on("click",function(){
					 $('#courseTypeModal').modal("hide");
				 });
				 
				 $("button#courseTypeModifySubmit").on("click",function(){
					var typeName=$("input[name='name']").val();
					if(typeName==null||typeName==''){
						$("p#namemessage").html("类型名称为空");
						$("p#namemessage").css("color","red");
					}
					else{
						$("p#namemessage").html("");
						$.post("coursetype/modify.mvc",{no:courseTypeNo,name:typeName},function(data){
							alert(data.message);
							getCourseTypeList(); //刷新显示列表
							$('#courseTypeModal').modal("hide");
							
						});
					}
					 
				 });
			 });
			 $('#courseTypeModal').modal("show");
		}
		
	});
	//点击删除处理
	$("a#courseTypeDeleteLink").on("click",function(){
		if(courseTypeNo==0){
			BootstrapDialog.alert({title:"提示",message:'请选择要删除的课程类型!'});
		}
		else{
			//检查此对象能否被删除
			$.getJSON("coursetype/checkcandelete.mvc",{typeNo:courseTypeNo},function(data){
				if(data.result=="N"){
					BootstrapDialog.alert({title:"提示",message:'此课程类型有关联的学生，不能被删除!'});
				}
				else{
					//让用户确认执行删除操作
					BootstrapDialog.confirm({
							title:"删除确认",
							message:"您确认要删除此课程类型么?",
							callback:function(result){
								if(result){
									$.post("coursetype/delete.mvc",{no:courseTypeNo},function(data){
										if(data.result=="Y"){
											courseTypeNo=0;
											getCourseTypeList();
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
	$("a#courseTypeViewLink").on("click",function(){
		if(courseTypeNo==0){
			BootstrapDialog.alert({title:"提示",message:'请选择要查看的课程类型!'});
		}
		else{
			$("#ModalLabel").html("查看课程类型");
			$("#modelbody").load("course/view.html",function(){
				 $.getJSON("coursetype/get.mvc",{typeNo:courseTypeNo},function(data){
					 $("span#coursetypename").html(data.name)
					 $("span#coursetypeno").html(data.no)
				 });
				 
				 $("button[type='reset']").on("click",function(){
					 $('#courseTypeModal').modal("hide");
				 });
				 
				
			 });
			$('#feeItemModal').modal("show");		
			}
	});
	//初次显示课程类型列表
	getCourseTypeList();
	
});