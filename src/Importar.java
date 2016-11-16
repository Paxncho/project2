import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	
public class Importar {

    public static void main(String args[]) throws IOException
    {
	
	FileInputStream file = new FileInputStream(new File("C:\\prueb_excel.xls"));
	
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheetAt(0);
	Iterator<Row> rowIterator = sheet.iterator();

	Row row;

	while (rowIterator.hasNext())
        {
	
	    row = rowIterator.next();

	    Iterator<Cell> cellIterator = row.cellIterator();
	
	    Cell celda;

	    while (cellIterator.hasNext())
            {

		celda = cellIterator.next();

		switch(celda.getCellType()) 
                {
	
		case Cell.CELL_TYPE_NUMERIC:

		    if( DateUtil.isCellDateFormatted(celda) )
                    {
		       System.out.println(celda.getDateCellValue());
			    }else{
			       System.out.println(celda.getNumericCellValue());
		    }
		    break;
	
		case Cell.CELL_TYPE_STRING:
	
		    System.out.println(celda.getStringCellValue());
                    
		    break;
		case Cell.CELL_TYPE_BOOLEAN:
		    System.out.println(celda.getBooleanCellValue());
		    break;
		}
	    }
	}
	workbook.close();
        
    }
}