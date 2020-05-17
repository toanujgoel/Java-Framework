package pageObjects.UsefulTools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


//How to read excel files using Apache POI
public class ExcelWork {
	
 public static Map< Integer, List> readExcel (String path, int sheetNum) throws IOException{
	 
	 FileInputStream fis = new FileInputStream(path);
	 
	 Workbook workbook = null;
	 String fileExtensionName = path.substring(path.indexOf("."));
	    if(fileExtensionName.equals(".xlsx"))
	    	workbook = new XSSFWorkbook(fis);
	    else if(fileExtensionName.equals(".xls"))
	    	workbook = new HSSFWorkbook(fis);
	    
	 Sheet sheet = workbook.getSheetAt(sheetNum);

	 Map< Integer, List> map_data =  new HashMap< Integer, List>(); 
	 
	 for (Row row: sheet) {
		 List<String> values = new ArrayList<>();
		 for(Cell cell: row)
			 values.add(cell.toString());
		 map_data.put(row.getRowNum(), values);	 
	 }
	 
	 workbook.close();
//	 Set< Map.Entry< Integer, List> > data_sheet = map_data.entrySet();
	 return map_data;
 
 } 
}