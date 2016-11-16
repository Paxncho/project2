
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;	
	
import org.apache.poi.ss.usermodel.Cell;	
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;	
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImportarExportarExcel
{
	
    public static void main(String args[]) throws IOException
    {

<<<<<<< HEAD
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
	workbook.close();
=======
public class ImportarExportarExcel {
    Workbook wb;
    
    public String ImportarExportarExcel(File archivo, JTable tablaD) throws InvalidFormatException{
        String respuesta="No se pudo realizar la importación.";
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        tablaD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        try {
            wb = WorkbookFactory.create(new FileInputStream(archivo));
            Sheet hoja = wb.getSheetAt(0);
            Iterator filaIterator = hoja.rowIterator();
            int indiceFila=-1;
            while (filaIterator.hasNext()) {                
                indiceFila++;
                Row fila = (Row) filaIterator.next();
                Iterator columnaIterator = fila.cellIterator();
                Object[] listaColumna = new Object[1000];
                int indiceColumna=-1;
                while (columnaIterator.hasNext()) {                    
                    indiceColumna++;
                    Cell celda = (Cell) columnaIterator.next();
                    if(indiceFila==0){
                        modeloT.addColumn(celda.getStringCellValue());
                    }else{
                        if(celda!=null){
                            switch(celda.getCellType()){
                                case Cell.CELL_TYPE_NUMERIC:
                                    listaColumna[indiceColumna]= (int)Math.round(celda.getNumericCellValue());
                                    break;
                                case Cell.CELL_TYPE_STRING:
                                    listaColumna[indiceColumna]= celda.getStringCellValue();
                                    break;
                                case Cell.CELL_TYPE_BOOLEAN:
                                    listaColumna[indiceColumna]= celda.getBooleanCellValue();
                                    break;
                                default:
                                    listaColumna[indiceColumna]=celda.getDateCellValue();
                                    break;
                            }
                            System.out.println("col"+indiceColumna+" valor: true - "+celda+".");
                        }                        
                    }
                }
                if(indiceFila!=0)modeloT.addRow(listaColumna);
            }
            respuesta="Importación exitosa";
        } catch (IOException | EncryptedDocumentException e) {
            System.err.println(e.getMessage());
        }
        return respuesta;
    }
    
    public String Exportar(File archivo, JTable tablaD){
        String respuesta="No se realizo con exito la exportación.";
        int numFila=tablaD.getRowCount(), numColumna=tablaD.getColumnCount();
        if(archivo.getName().endsWith("xls")){
            wb = new HSSFWorkbook();
        }else{
            wb = new XSSFWorkbook();
        }
        Sheet hoja = wb.createSheet("Pruebita");
        
        try {
            for (int i = -1; i < numFila; i++) {
                Row fila = hoja.createRow(i+1);
                for (int j = 0; j < numColumna; j++) {
                    Cell celda = fila.createCell(j);
                    if(i==-1){
                        celda.setCellValue(String.valueOf(tablaD.getColumnName(j)));
                    }else{
                        celda.setCellValue(String.valueOf(tablaD.getValueAt(i, j)));
                    }
                    wb.write(new FileOutputStream(archivo));
                }
            }
            respuesta="Exportación exitosa.";
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return respuesta;
>>>>>>> origin/master
    }
}