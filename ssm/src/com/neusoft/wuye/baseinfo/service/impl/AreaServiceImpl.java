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

import com.neusoft.wuye.baseinfo.mapper.IAreaMapper;
import com.neusoft.wuye.baseinfo.mapper.IBuildingMapper;
import com.neusoft.wuye.baseinfo.model.AreaModel;
import com.neusoft.wuye.baseinfo.service.IAreaService;

//小区的业务实现类
@Service("AreaService")
@Transactional
public class AreaServiceImpl implements IAreaService {
	private IAreaMapper amp=null;
	private IBuildingMapper bmp=null;
	@Autowired
	public void setAmp(IAreaMapper amp) {
		this.amp = amp;
	}
	@Autowired
	public void setBmp(IBuildingMapper bmp) {
		this.bmp = bmp;
	}



	@Override
	public void add(AreaModel am) throws Exception {
		if(am.getPhotoFileName()!=null){
			amp.insertWithPhoto(am);
		}
		else{
			amp.insert(am);
		}
		
		
	}

	@Override
	public void modify(AreaModel am) throws Exception {
		amp.update(am);
	}

	@Override
	public void delete(AreaModel am) throws Exception {
		amp.delete(am);

	}

	@Override
	public AreaModel get(int areaNo) throws Exception {
		
		return amp.select(areaNo);
	}

	@Override
	public List<AreaModel> getListByAll() throws Exception {
		
		return amp.selectListByAll();
	}

	@Override
	public List<AreaModel> getListByAllWithPage(int rows, int page) throws Exception {
		RowBounds rb=new RowBounds(rows*(page-1),rows);
		return amp.selectListByAllWithPage(rb);
	}

	@Override
	public int getCountByAll() throws Exception {
		return amp.selectCountByAll();
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
	public boolean checkCanDelete(int areaNo) throws Exception {
	
		boolean result=true;
		//如果此小区的楼宇个数大于0，此小区不能被删除
		if(bmp.selectCountByCondition(areaNo, 0, "")>0){
			result=false;
		}
		return result;
	}
	@Override
	public boolean checkNameExist(String name) throws Exception {
		boolean result=false;
		List<AreaModel> list=this.getListByAll();
		for(AreaModel am:list){
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
            	String name=c0.getStringCellValue();
            	Cell c1=row.getCell(1);
            	String address=c1.getStringCellValue();
            	Cell c2=row.getCell(2);
            	String developer=c2.getStringCellValue();
            	Cell c3=row.getCell(3);
            	double totalBuildingArea=c3.getNumericCellValue();
            	Cell c4=row.getCell(4);
            	double totalUserArea=c4.getNumericCellValue();
            	Cell c5=row.getCell(5);
            	double totalParkArea=c5.getNumericCellValue();
            	Cell c6=row.getCell(6);
            	int totalHome=(int)c6.getNumericCellValue();
            	Cell c7=row.getCell(7);
            	int totalHouse=(int)c7.getNumericCellValue();
            	Cell c8=row.getCell(8);
            	int totalPark=(int)c8.getNumericCellValue();
            	Cell c9=row.getCell(9);
            	Date creatDate=c9.getDateCellValue();
            	AreaModel am=new AreaModel();
            	am.setName(name);
            	am.setAddress(address);
            	am.setDeveloper(developer);
            	am.setTotalArea(totalBuildingArea);
            	am.setTotalUseArea(totalUserArea);
            	am.setTotalPackArea(totalParkArea);
            	am.setTotalHome(totalHome);
            	am.setTotalHouse(totalHouse);
            	am.setTotalPack(totalPark);
            	am.setStartDate(creatDate);
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
		//取得所有的小区列表
		List<AreaModel> areaList=amp.selectListByAll();
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		
		int i=1;
		for(AreaModel am:areaList){
			Row row = sheet.createRow(i);
			Cell c0 = row.createCell(0);
			c0.setCellValue(am.getName());
			
			Cell c1 = row.createCell(1);
			c1.setCellValue(am.getAddress());
			Cell c2 = row.createCell(2);
			c2.setCellValue(am.getDeveloper());
			Cell c3 = row.createCell(3);
			c3.setCellValue(am.getTotalArea());
			Cell c4 = row.createCell(4);
			c4.setCellValue(am.getTotalUseArea());
			Cell c5 = row.createCell(5);
			c5.setCellValue(am.getTotalPackArea());
			Cell c6 = row.createCell(6);
			c6.setCellValue(am.getTotalHome());
			Cell c7 = row.createCell(7);
			c7.setCellValue(am.getTotalHouse());
			Cell c8 = row.createCell(8);
			c8.setCellValue(am.getTotalPack());
			Cell c9 = row.createCell(9);
			if(am.getStartDate()!=null){
				c9.setCellValue(df.format(am.getStartDate()));
			}
			
			i++;
		}
		
		FileOutputStream fileOut = new FileOutputStream(exportFile);
		wb.write(fileOut);
		fileOut.close();
		
		wb.close();
		
		
	}
	@Override
	public void modifyWithPhoto(AreaModel am) throws Exception {
		amp.updateWithPhoto(am);
		
	}
	@Override
	public void modifyForDeletePhoto(AreaModel am) throws Exception {
		amp.updateForDeletePhoto(am);
		
	}

}
