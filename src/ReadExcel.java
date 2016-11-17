
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadExcel{
    public static void LeerExcel(){
        try {
            //Recibir el archivo a leer -Pencho
            FileInputStream file = new FileInputStream(new File("Horario.xls"));

            //Crear un Workbook con el archivo leido
            HSSFWorkbook workbook = new HSSFWorkbook(file);

            //Obtener la primera hoja
            HSSFSheet sheet = workbook.getSheetAt(0);

            //Crear un Iterador que nos recorra las filas mientras existan datos
            Iterator<Row> rowIterator = sheet.iterator();
            while(rowIterator.hasNext()) {
                Row row = rowIterator.next();

                //En cada fila, iteramos sobre cada columna
                Iterator<Cell> cellIterator = row.cellIterator();
                    while(cellIterator.hasNext()) {

                    //Obtenemos la celda a revisar
                    Cell cell = cellIterator.next();

                    //Comparamos el valor que existe en la celda para guardarlo en la variable del mismo tipo
                    switch(cell.getCellType()) {
                        case Cell.CELL_TYPE_BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t\t");
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t\t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue() + "\t\t");
                            break;
                    }
                }
                System.out.println("");
            }
            
            //Cerramos el archivo al terminar
            file.close();
            FileOutputStream out = new FileOutputStream(new File("C:\\test.xls"));
            workbook.write(out);
            out.close();

    } catch (FileNotFoundException e) {
            e.printStackTrace();
    } catch (IOException e) {
            e.printStackTrace();
    }

    }
}