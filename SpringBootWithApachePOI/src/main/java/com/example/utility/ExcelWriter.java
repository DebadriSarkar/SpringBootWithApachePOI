package com.example.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.example.model.City;
import com.example.model.Country;
import com.example.model.State;

@Service
public class ExcelWriter {

	public String WriteDataToExcelForCountries(List<Country> countrylist,String sheetname,List data) throws IOException {
		
		
		/*Implementation using Map*/
		/*
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet(sheetname);
        XSSFRow row;
        Map<String, Object[]> countryData = new TreeMap<String, Object[]>();
        countryData.put("1",new Object[] { "Country Id", "Sort Name", "Name", "Phone Code" });
        
        
        for(int i=0 ; i<list.size(); i++) {
        	Country country = list.get(i);
        	System.out.println(i);
        	countryData.put(String.valueOf(i+2),new Object[] {country.getCountryId() ,country.getSortname() ,country.getName(),country.getPhonecode()});
        }
        
        Set<String> keyid = countryData.keySet();
        int rowid = 0;
        
     
        for (String key : keyid) {
        	  
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = countryData.get(key);
            int cellid = 0;
  
            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                System.out.println(obj.getClass().getName());
                if(obj.getClass().getName().equalsIgnoreCase("java.lang.Integer")) {
                	cell.setCellValue((Integer)obj);
                }else {
                	cell.setCellValue((String)obj);
                }
                
            }
        }
        
        
        String filename=StringConstants.FOLDER_LOCATION+"excelfile"+new Date().getTime()+".xlsx";
        FileOutputStream out = new FileOutputStream(new File(filename));
  
        workbook.write(out);
        out.close();
		return filename;
		*/
		
		/*Implementation using List*/
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet(sheetname);
        XSSFRow row;
        
        data.add(new Object[] { "Country Id", "Sort Name", "Name", "Phone Code" });
        
        int rownum = 0;
        for(Iterator iterator = countrylist.iterator(); iterator.hasNext();) {
        	Country country = (Country) iterator.next();
        	data.add(new Object[] {country.getCountryId() ,country.getSortname() ,country.getName(),country.getPhonecode()});
        }
        
        for(Iterator iterator = data.iterator(); iterator.hasNext();) {
        	row = spreadsheet.createRow(rownum++);
            Object [] objArr = (Object[]) iterator.next();
            
            int cellnum = 0;
            for (Object obj : objArr)
            {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
                else if(obj instanceof Long)
                    cell.setCellValue(((Long)obj).longValue());
            }
        }
        
        String filename=StringConstants.FOLDER_LOCATION+"excelfile"+"Country"+"_"+new Date().getTime()+".xlsx";
        
		File dfile=new File(filename);
	    FileOutputStream out = new FileOutputStream(dfile);
	    workbook.write(out);
	    out.flush();
	    out.close();
	    
		return filename;
        
        
        
        
	}
	
public String WriteDataToExcelForStates(List<State> statelist,String sheetname,List data) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet(sheetname);
        XSSFRow row;
        
        data.add(new Object[] { "State Id", "State Name", "Country Id" });
        
        int rownum = 0;
        for(Iterator iterator = statelist.iterator(); iterator.hasNext();) {
        	State state = (State) iterator.next();
        	data.add(new Object[] {state.getStateId(),state.getName(),state.getCountryId()});
        }
        
        for(Iterator iterator = data.iterator(); iterator.hasNext();) {
        	row = spreadsheet.createRow(rownum++);
            Object [] objArr = (Object[]) iterator.next();
            
            int cellnum = 0;
            for (Object obj : objArr)
            {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
                else if(obj instanceof Long)
                    cell.setCellValue(((Long)obj).longValue());
            }
        }
        
        String filename=StringConstants.FOLDER_LOCATION+"excelfile"+"State"+"_"+new Date().getTime()+".xlsx";
        
		File dfile=new File(filename);
	    FileOutputStream out = new FileOutputStream(dfile);
	    workbook.write(out);
	    out.flush();
	    out.close();
	    
		return filename;
        
        
        
        
	}

public String WriteDataToExcelForCities(List<City> citylist,String sheetname,List data) throws IOException {
	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet spreadsheet = workbook.createSheet(sheetname);
    XSSFRow row;
    
    data.add(new Object[] { "City Id", "City Name", "State Id" });
    
    int rownum = 0;
    for(Iterator iterator = citylist.iterator(); iterator.hasNext();) {
    	City city = (City) iterator.next();
    	data.add(new Object[] {city.getCityId(),city.getName(),city.getStateId()});
    }
    
    for(Iterator iterator = data.iterator(); iterator.hasNext();) {
    	row = spreadsheet.createRow(rownum++);
        Object [] objArr = (Object[]) iterator.next();
        
        int cellnum = 0;
        for (Object obj : objArr)
        {
           Cell cell = row.createCell(cellnum++);
           if(obj instanceof String)
                cell.setCellValue((String)obj);
            else if(obj instanceof Integer)
                cell.setCellValue((Integer)obj);
            else if(obj instanceof Long)
                cell.setCellValue(((Long)obj).longValue());
        }
    }
    
    String filename=StringConstants.FOLDER_LOCATION+"excelfile"+"City"+"_"+new Date().getTime()+".xlsx";
    
	File dfile=new File(filename);
    FileOutputStream out = new FileOutputStream(dfile);
    workbook.write(out);
    out.flush();
    out.close();
    
	return filename;
    
    
    
    
}
}
