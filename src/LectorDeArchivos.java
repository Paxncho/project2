
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

public class LectorDeArchivos{
    public static void LeerExcel(String rutaArchivo, Sistema sistema){
        try {
            String nombreRamo = null;
            int cantidadAlumnos = 0;
            //Recibir el archivo a leer -Pencho
            FileInputStream file = new FileInputStream(new File(rutaArchivo));

            //Crear un Workbook con el archivo leido
            HSSFWorkbook workbook = new HSSFWorkbook(file);

            //Obtiene la primera hoja
            HSSFSheet sheet = workbook.getSheetAt(0);

            //Crear un Iterador que nos recorra las filas mientras existan datos
            Iterator<Row> rowIterator = sheet.iterator();
            while(rowIterator.hasNext()) {
                Row row = rowIterator.next();

                //Creamos un Iterador para cada celda de la fila
                Iterator<Cell> cellIterator = row.cellIterator();

                //Recorremos la fila con un for, ya que sabemos que siempre tendrá 52 valores.
                for (int i = 0; i < 52; i++){
                    
                    //Obtenemos la celda a revisar
                    Cell cell = cellIterator.next();
                    
                    //Si leemos la primera, lo asigno al nombre
                    if (i == 0){
                        nombreRamo = cell.getStringCellValue();
                    //Si leemos la segunda, lo asigno a la cantidad de Alumnos
                    } else if (i == 1){
                        cantidadAlumnos = Integer.parseInt(cell.getStringCellValue());
                    //Si leemos dentro de las primeras 10, lo asigno al día Lunes
                    } else if (i < 12) {
                        switch(cell.getStringCellValue()){
                            case "s":
                            case "LF":
                            case "LC":
                            case "LM":
                            case "G":
                                //Creo el ramo con su nombre y su cantidad de alumnos
                                Ramo ramo = new Ramo(nombreRamo, cantidadAlumnos);
                                //Asocio el ramo a la actividad, como no se le asigna aún una sala se inicializa como null ese parametro
                                Actividad actividad = new Actividad(ramo, i-1, Dia.LUNES, null);
                                //Con la actividad ya creada, la agrego de vuelta al sistema
                                sistema.agregarActividad(actividad);
                        }
                    //Si leemos entre la 12 y la 22, corresponde al Martes
                    } else if (i < 22) {
                        switch(cell.getStringCellValue()){
                            case "s":
                            case "LF":
                            case "LC":
                            case "LM":
                            case "G":
                                Ramo ramo = new Ramo(nombreRamo, cantidadAlumnos);
                                Actividad actividad = new Actividad(ramo, i-1, Dia.MARTES, null);
                                sistema.agregarActividad(actividad);
                        }
                    //Si leemos entre la 22 y la 32, corresponde al Miercoles
                    } else if (i < 32) {
                        switch(cell.getStringCellValue()){
                            case "s":
                            case "LF":
                            case "LC":
                            case "LM":
                            case "G":
                                Ramo ramo = new Ramo(nombreRamo, cantidadAlumnos);
                                Actividad actividad = new Actividad(ramo, i-1, Dia.MIERCOLES, null);
                                sistema.agregarActividad(actividad);
                        }
                    //Si leemos entre la 32 y la 42, corresponde al Jueves
                    } else if (i < 42) {
                        switch(cell.getStringCellValue()){
                            case "s":
                            case "LF":
                            case "LC":
                            case "LM":
                            case "G":
                                Ramo ramo = new Ramo(nombreRamo, cantidadAlumnos);
                                Actividad actividad = new Actividad(ramo, i-1, Dia.JUEVES, null);
                                sistema.agregarActividad(actividad);
                        }
                    //Finalmente las últiimas 10 corresponden al dia Viernes
                    } else if (i < 52) {
                        switch(cell.getStringCellValue()){
                            case "s":
                            case "LF":
                            case "LC":
                            case "LM":
                            case "G":
                                Ramo ramo = new Ramo(nombreRamo, cantidadAlumnos);
                                Actividad actividad = new Actividad(ramo, i-1, Dia.VIERNES, null);
                                sistema.agregarActividad(actividad);
                        }
                    } 
                }
            }
            
            //Cerramos el archivo al terminar
            file.close();
            FileOutputStream out = new FileOutputStream(new File(rutaArchivo));
            workbook.write(out);
            out.close();

        } catch (Exception e) {
            System.out.println("Ruta de archivo no encontrada.");
        }
    }
}