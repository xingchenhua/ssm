package com.neusoft.wuye.baseinfo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.wuye.baseinfo.model.NonteacherModel;
import com.neusoft.wuye.baseinfo.service.INonteacherService;
import com.neusoft.wuye.result.ResultInfo;
import com.neusoft.wuye.result.ResultMessage;

//职工控制器类
@RestController
@RequestMapping(value="/nonteacher")
public class NonteacherController {
   private INonteacherService as=null;
   @Autowired
   public void setAs(INonteacherService as) {
	   this.as = as;
   }
   @RequestMapping(value="/add",method=RequestMethod.POST)
   public ResultMessage add(NonteacherModel am,@RequestPart(required=false) MultipartFile uploadphoto,HttpSession session) throws Exception
   {
	   ResultMessage result=new ResultMessage();
	  
	   if(uploadphoto!=null&&(!uploadphoto.isEmpty())){
		   String fileName=uploadphoto.getOriginalFilename();
		   String contentType=uploadphoto.getContentType();
		   ServletContext application=session.getServletContext();
		   
		   String path=application.getRealPath("/upload/"+fileName);
		   uploadphoto.transferTo(new File(path));
		   
		   am.setPhoto(uploadphoto.getBytes());
		   am.setPhotoFileName(fileName);
		   am.setPhotoContentType(contentType);
	   }
	   
	   as.add(am);
	   result.setResult("Y");
	   result.setMessage("增加职工成功");
	   return result;
	   
	  
   }
   
   @RequestMapping(value="/modify",method=RequestMethod.POST)
   public ResultMessage modify(NonteacherModel am,@RequestParam String photoOption,@RequestPart(required=false) MultipartFile uploadphoto,HttpSession session) throws Exception
   {
	   ResultMessage result=new ResultMessage();
	   if(photoOption.equals("change")){
		   if(uploadphoto!=null&&(!uploadphoto.isEmpty())){
			   String fileName=uploadphoto.getOriginalFilename();
			   String contentType=uploadphoto.getContentType();
			   ServletContext application=session.getServletContext();
			   
			   String path=application.getRealPath("/upload/"+fileName);
			   uploadphoto.transferTo(new File(path));
			   
			   am.setPhoto(uploadphoto.getBytes());
			   am.setPhotoFileName(fileName);
			   am.setPhotoContentType(contentType);
			   as.modifyWithPhoto(am);
		   }
		   else{
			   as.modify(am);
			   as.modifyForDeletePhoto(am);
		   }
		   
		   
	   }
	   else if(photoOption.equals("keep")){
		   as.modify(am);
	   }
	   else {
		   as.modify(am);
		   as.modifyForDeletePhoto(am);
	   }
	 
	   result.setResult("Y");
	   result.setMessage("修改职工成功");
	   return result;
	   
	  
   }
   
   @RequestMapping(value="/delete",method=RequestMethod.POST)
   public ResultMessage delete(NonteacherModel am) throws Exception
   {
	   ResultMessage result=new ResultMessage();
	   as.delete(am);
	   result.setResult("Y");
	   result.setMessage("删除职工成功");
	   return result;
   }
   @RequestMapping(value="/get",method=RequestMethod.GET)
   public NonteacherModel get(@RequestParam int nonteacherNo) throws Exception
   {
	   return as.get(nonteacherNo);
   }
   //取得所有小区列表，不分页
   @RequestMapping(value="/list/all",method=RequestMethod.GET)
   public List<NonteacherModel> getListByAll() throws Exception
   {
	   return as.getListByAll();
   }
   //取得所有职工列表，分页方式
   @RequestMapping(value="/list/page",method=RequestMethod.GET)
   public ResultInfo<NonteacherModel> getListByAllWithPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception
   {
	   ResultInfo<NonteacherModel> result=new ResultInfo<NonteacherModel>();
	   result.setCount(as.getCountByAll());
	   result.setPageCount(as.getPageCountByAll(rows));
	   result.setRows(rows);
	   result.setPage(page);
	   result.setList(as.getListByAllWithPage(rows, page));
	   
	   return result;
   }
   
	//检查此建筑类型能否被删除
	@RequestMapping(value="/checkcandelete",method=RequestMethod.GET,produces="application/json")
	public ResultMessage checkCanDelete(@RequestParam int nonteacherNo) throws Exception
	{
		ResultMessage result=new ResultMessage();
		if(as.checkCanDelete(nonteacherNo)){
			result.setResult("Y");
			result.setMessage("此职工可以删除");
		}
		else{
			result.setResult("N");
			result.setMessage("此职工不能删除");
		}
		return result;
	}
	//
	@RequestMapping(value="/checkNameExist",method=RequestMethod.GET,produces="application/json")
	public boolean checkNameExist(@RequestParam String name) throws Exception{
		return !as.checkNameExist(name);
		
	}
	//下载文件的方法
	@RequestMapping(value="/downphoto",method=RequestMethod.GET)
	public ResponseEntity<byte[]> downloadPhoto(@RequestParam int nonteacherNo) throws Exception
	{
		NonteacherModel am=as.get(nonteacherNo);
		String fileName=new String(am.getPhotoFileName().getBytes("UTF-8"),"iso-8859-1");
		String contentType=am.getPhotoContentType();
		
		
		String mainType=contentType.substring(0,contentType.indexOf("/"));
		
		String subType=contentType.substring(contentType.indexOf("/")+1);
	
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(new MediaType(mainType,subType));
		return new ResponseEntity<byte[]>(am.getPhoto(),headers,HttpStatus.CREATED);
		
		
		
	}
	@RequestMapping(value="/import",method=RequestMethod.POST)
	public ResultMessage importFromExcel(@RequestPart MultipartFile importfile) throws Exception
	{
		 ResultMessage result=new ResultMessage();
		 if(importfile!=null&&(!importfile.isEmpty())){
			 as.importFromExcel(importfile.getInputStream());
			 result.setResult("Y");
			 result.setMessage("导入职工成功");
		 }
		 else{
			 result.setResult("N");
			 result.setMessage("没有上传导入Excel文件");
		 }
		 return result;
		
	}
	
	@RequestMapping(value="/exportnonteachertoexcel",method=RequestMethod.GET)
	public ResponseEntity<byte[]>  exportToExcel(HttpSession session) throws Exception
	{
		ServletContext application=session.getServletContext();
		String sourcepath=application.getRealPath("/excelexport/nonteacherexport.xlsx");
		String exportfilepath=application.getRealPath("/download/exportexcel"+(int)(Math.random()*1000)+".xlsx");
		
		
		as.exportToExcel(new File(sourcepath),new File(exportfilepath));
		
		String mainType="application";
		
		String subType="vnd.openxmlformats-officedocument.spreadsheetml.sheet";
		String fileName=new String("职工导出.xlsx".getBytes("UTF-8"),"iso-8859-1");
		
		InputStream in=new FileInputStream(exportfilepath);
		byte[] data=new byte[in.available()];
		in.read(data, 0, data.length);
		in.close();
		HttpHeaders headers=new HttpHeaders();
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(new MediaType(mainType,subType));
		File excelFile=new File(exportfilepath);
		excelFile.delete();
		
		return new ResponseEntity<byte[]>(data,headers,HttpStatus.CREATED);
		
	}
   
}
