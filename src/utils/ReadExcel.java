package utils;
import intervalo.Intervalo;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel
{
	public ArrayList<Object> arrData = new ArrayList<Object>();
	
	public ArrayList<Object> readColumn(String fileName){
		try{
			File excel = new File (fileName);
		    FileInputStream fis = new FileInputStream(excel);    
		    XSSFWorkbook wb = new XSSFWorkbook(fis);
		    FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
		    XSSFSheet ws = wb.getSheetAt(0);
		    int rowNum = ws.getLastRowNum();
		    int colNum = ws.getRow(0).getLastCellNum();

		    for (int i=0; i<colNum; i++){
		    	ArrayList<Object> tmp = new ArrayList<Object>();
		    	boolean aux= false;
		        for (int j=1; j<=rowNum; j++){
		            if(i!=1&&i!=7&&i!=10&&i!=12){
		            	aux = true;
		            	XSSFRow row = ws.getRow(j);
		            	if(i==0||i==6||i==9||i==11)
		            		tmp.add(new Intervalo((Double)cellToObject(row.getCell(i),evaluator),(Double)cellToObject(row.getCell(i+1),evaluator)));
		            	else if(i!=0&&i!=6&&i!=9&&i!=11)
		            		tmp.add(cellToObject(row.getCell(i),evaluator));             
		            }
		        }
		        if(aux)
		        	this.arrData.add(tmp);
		    }
		}
        catch (Exception e)
        {
            e.printStackTrace();
        }
		return this.arrData;
	}
	
	public static Object cellToObject (XSSFCell cell,FormulaEvaluator fe){		
		Object result=null;
		switch(fe.evaluateInCell(cell).getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
		        result = cell.getNumericCellValue();
		        break;
		    case Cell.CELL_TYPE_STRING:
		        result = cell.getStringCellValue();
		        break;
		    case Cell.CELL_TYPE_BOOLEAN:
		        result = cell.getBooleanCellValue();
		        break;
		    default:
		    	break;
		}
		return result;
	}	
}
