package com.amazon.testing;
import static com.amazon.testing.util.Constants.EXCEL_LOCATION;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	private Map<Object, Object> data =null;
	public void prepareData() {
		data = new HashMap<Object, Object>();
		try {
			File file = new File(EXCEL_LOCATION);
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			Iterator<Row> itr = sheet.iterator();
			while(itr.hasNext()) {
				Row row = itr.next(); 
				Iterator<Cell> cellIterator = row.cellIterator();
				int cells =1;
				Object key = null;
				Object value = null;
				while(cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch(cell.getCellType()) {
					case STRING : 
						if(cells == 1) key = cell.getStringCellValue();
						else value = cell.getStringCellValue();
						break;
					case NUMERIC : 
						if(cells == 1) key = cell.getNumericCellValue();
						else value = cell.getNumericCellValue();
						break;
					default : 
					}
					cells++;
				}
				data.put(key, value);
				System.out.println();
				}
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	public Map<Object, Object> getData(){
		return data;
	}
	public String getValue(Object key) {
		return data.get(key).toString();
	}
}
