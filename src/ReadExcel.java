/*import java.io.File;
import java.util.Scanner;

public class Cargador {
    
    public static Sistema readFile ()
    {
        try
        {
            Sistema sistema = new Sistema ();
            Scanner scanner = new Scanner (new File(/*ruta de archivo ""));
            
            scanner.close();
            return sistema;
       
        }
        catch (Exception e)
        {
                System.out.println("No se pudo leer el archivo"+e);
                return new Sistema();
        }
    }
}*/

import java.io.*; 
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadExcel { 
    private void leerArchivoExcel(String archivoDestino) { 

        try { 
            Workbook archivoExcel = Workbook.getWorkbook(new File( archivoDestino)); 
            System.out.println("Número de Hojas\t" + archivoExcel.getNumberOfSheets()); 
            for (int sheetNo = 0; sheetNo < archivoExcel.getNumberOfSheets(); sheetNo++) // Recorre 
            // cada    
            // hoja                                                                                                                                                       
            { 
                Sheet hoja = archivoExcel.getSheet(sheetNo); 
                int numColumnas = hoja.getColumns(); 
                int numFilas = hoja.getRows(); 
                String data; 
                System.out.println("Nombre de la Hoja\t" 
                + archivoExcel.getSheet(sheetNo).getName()); 
                for (int fila = 0; fila < numFilas; fila++) { // Recorre cada 
                    // fila de la 
                    // hoja 
                    for (int columna = 0; columna < numColumnas; columna++) { // Recorre                                                                                
                        // cada                                                                                
                        // columna                                                                            
                        // de                                                                                
                        // la                                                                                
                        // fila 
                        data = hoja.getCell(columna, fila).getContents(); 
                        System.out.print(data + " "); 

                    } 
                    System.out.println("\n"); 
                } 
            } 
        } catch (Exception ioe) { 
            ioe.printStackTrace(); 
        } 

    } 

    /*public static void main(String arg[]) { 
        ReadExcel excel = new ReadExcel(); 
        excel.leerArchivoExcel("archivoPrueba.xls"); 
    } 
}*/