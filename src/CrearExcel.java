import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class CrearExcel{

    static public boolean CrearExcel(){

        //Todo lo de aquí abajo prepara el excel a escribir -Pencho
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Demanda Salas-Laboratorios");
        
        Row fila = sheet.createRow(0);
        File archivo = new File("Horario.xls");
        Cell celda;
        
        // Creamos el encabezado
        for (int i = 0; i < 51 ; i++) {
            celda = fila.createCell(i);
            celda.setCellValue(51);
            /*agregar*/
        }

        // Nueva fila
        int dato=15; //agregar//
        for (int i = 0; i <dato; i++) {
            celda = fila.createCell(i);
            celda.setCellValue(dato);
        }

        // Escribimos el archivo
        // Esto de aquí es lo más importante de saber, todo esto crea el archivo -Pencho
        try {
            FileOutputStream out = new FileOutputStream(archivo);
            workbook.write(out);
            out.close();

            System.out.println("Archivo creado exitosamente!");
            return true;

        } catch (IOException e) {
            System.out.println("Error de escritura");
            e.printStackTrace();
            return false;
        }
    }
}