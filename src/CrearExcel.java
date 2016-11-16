/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class CrearExcel {
    private ArrayList <Actividad> actividades;
    private ArrayList <Sala> salas; 

    static public void main(String[] args) {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(“Demanda Salas/Laboratorios”);
        
        Row fila = sheet.createRow(0);
        File archivo = new File(“Horario.xls”);
        Cell celda;

        int i;

    // Creamos el encabezado

        for (i = 0; i < 51 ; i++) {
              celda = fila.createCell(i);
              celda.setCellValue(51);
             /*agregar*/
        }

        // Nueva fila
        int dato=15; //agregar//
        for (i = 0; i <dato; i++) {
              celda = fila.createCell(i);
              celda.setCellValue(dato);
        }

    // Escribimos el archivo
    try {
          FileOutputStream out = new FileOutputStream(archivo);
          workbook.write(out);
          out.close();

          System.out.println(“Archivo creado exitosamente!”);

    } catch (IOException e) {
          System.out.println(“Error de escritura”);
    e.printStackTrace();
    }
    }
    }
public class CrearExcel {

}
