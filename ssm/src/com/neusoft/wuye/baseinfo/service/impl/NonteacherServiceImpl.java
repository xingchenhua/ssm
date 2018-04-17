package com.neusoft.wuye.baseinfo.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.wuye.baseinfo.mapper.INonteacherMapper;
import com.neusoft.wuye.baseinfo.mapper.ICarMapper;
import com.neusoft.wuye.baseinfo.model.NonteacherModel;
import com.neusoft.wuye.baseinfo.service.INonteacherService;

//小区的业务实现类
@Service("NonteacherService")
@Transactional
public class NonteacherServiceImpl implements INonteacherService {
	private INonteacherMapper nmp=null;
	private ICarMapper cmp=null;
	@Autowired
	public void setAmp(INonteacherMapper nmp) {
		this.nmp = nmp;
	}
	@Autowired
	public void setBmp(ICarMapper cmp) {
		this.cmp = cmp;
	}



	@Override
	public void add(NonteacherModel am) throws Exception {
		if(am.getPhotoFileName()!=null){
			nmp.insertWithPhoto(am);
		}
		else{
			nmp.insert(am);
		}
		
		
	}

	@Override
	public void modify(NonteacherModel am) throws Exception {
		nmp.update(am);
	}

	@Override
	public void delete(NonteacherModel am) throws Exception {
		nmp.delete(am);

	}

	@Override
	public NonteacherModel get(int nonteacherNo) throws Exception {
		
		return nmp.select(nonteacherNo);
	}

	@Override
	public List<NonteacherModel> getListByAll() throws Exception {
		
		return nmp.selectListByAll();
	}

	@Override
	public List<NonteacherModel> getListByAllWithPage(int rows, int page) throws Exception {
		RowBounds rb=new RowBounds(rows*(page-1),rows);
		return nmp.selectListByAllWithPage(rb);
	}

	@Override
	public int getCountByAll() throws Exception {
		return nmp.selectCountByAll();
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
		
		int pageCount=0;
		int count=this.getCountByAll();
		if(count%rows==0){
			pageCount=count/rows;
		}
		else{
			pageCount=count/rows+1;
		}
		return pageCount;
	}
	//检查指定的小区能否被删除
	@Override
	public boolean checkCanDelete(int nonteacherNo) throws Exception {
	
		boolean result=true;
		//如果此小区的楼宇个数大于0，此小区不能被删除
		if(cmp.selectCountByCondition(nonteacherNo, 0, "")>0){
			result=false;
		}
		return result;
	}
	@Override
	public boolean checkNameExist(String name) throws Exception {
		boolean result=false;
		List<NonteacherModel> list=this.getListByAll();
		for(NonteacherModel am:list){
			if(am!=null&&am.getName()!=null&&am.getName().equals(name)){
				result=true;
				break;
			}
		}
		
		return result;
	}
	@Override
	public void importFromExcel(InputStream excelFile) throws Exception {
		//打开上传的excel文件
		Workbook wb = WorkbookFactory.create(excelFile);
		//取得第1个sheet
		Sheet sheet=wb.getSheetAt(0);
		//
		Row row0=sheet.getRow(0);
		for (Row row : sheet) {
            if(row.getRowNum()!=0){
            	Cell c0=row.getCell(0);
            	String code=c0.getStringCellValue();
            	Cell c1=row.getCell(1);
            	String name=c1.getStringCellValue();
            	Cell c2=row.getCell(2);
            	String sex=c2.getStringCellValue();
            	Cell c3=row.getCell(3);
            	String age=c3.getStringCellValue();
            	Cell c4=row.getCell(4);
            	String job=c4.getStringCellValue();
            	Cell c5=row.getCell(5);
            	String phone=c5.getStringCellValue();            	
            	Cell c6=row.getCell(6);
            	Date creatDate=c6.getDateCellValue();
            	NonteacherModel am=new NonteacherModel();            
            	am.setCode(code);
            	am.setName(name);
            	am.setSex(sex);
            	am.setAge(age);
            	am.setJob(job);
            	am.setPhone(phone);
            	am.setHireDate(creatDate);
            	
            	this.add(am);
            }
            
        }
		wb.close();
		excelFile.close();
	}
	@Override
	public void exportToExcel(File source, File exportFile) throws Exception {
		//打开excel模板文件
		Workbook wb = WorkbookFactory.create(source);
		//取得第1个sheet
		Sheet sheet=wb.getSheetAt(0);
		//取得所有的职工列表
		List<NonteacherModel> nonteacherList=nmp.selectListByAll();
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		
		int i=1;
		for(NonteacherModel am:nonteacherList){
			Row row = sheet.createRow(i);
			Cell c0 = row.createCell(0);
			c0.setCellValue(am.getCode());			
			Cell c1 = row.createCell(1);
			c1.setCellValue(am.getName());
			Cell c2 = row.createCell(2);
			c2.setCellValue(am.getSex());
			Cell c3 = row.createCell(3);
			c3.setCellValue(am.getAge());
			Cell c4 = row.createCell(4);
			c4.setCellValue(am.getJob());
			Cell c5 = row.createCell(5);
			c5.setCellValue(am.getPhone());
			//日期
			Cell c6 = row.createCell(6);
			if(am.getHireDate()!=null){
				c6.setCellValue(df.format(am.getHireDate()));
			}
			
			i++;
		}
		
		FileOutputStream fileOut = new FileOutputStream(exportFile);
		wb.write(fileOut);
		fileOut.close();
		
		wb.close();
		
		
	}
	@Override
	public void modifyWithPhoto(NonteacherModel am) throws Exception {
		nmp.updateWithPhoto(am);
		
	}
	@Override
	public void modifyForDeletePhoto(NonteacherModel am) throws Exception {
		nmp.updateForDeletePhoto(am);
		
	}

}
