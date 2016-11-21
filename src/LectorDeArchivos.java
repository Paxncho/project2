
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * @author Luis Aburto, M. Fernanda Matera, Jose F. Riffo
 * @version 

*/

public class LectorDeArchivos{
    /**
     * 
     * @param rutaArchivo Es un String, corresponde a la ruta donde se encuentra el archivo a leer
     * @param sistema Es una clase Sistema, corresponde al objeto que guardará la información cargada
     */
    public static void LeerExcel(String rutaArchivo, Sistema sistema){
        try {
            String nombreRamo = null;
            int cantidadAlumnos = 0;
            Ramo ramo;
            Actividad actividad;
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
                                //Creo el ramo con su nombre y su cantidad de alumnos
                                ramo = new Ramo(nombreRamo, cantidadAlumnos);
                                //Asocio el ramo a la actividad
                                actividad = new Actividad(ramo, i-1, Dia.LUNES, TipoSala.SALA);
                                //Con la actividad ya creada, la agrego de vuelta al sistema
                                sistema.agregarActividad(actividad);
                                break;
                            case "LF":
                            case "LC":
                            case "LM":
                                ramo = new Ramo(nombreRamo, cantidadAlumnos);
                                actividad = new Actividad(ramo, i-1, Dia.LUNES, TipoSala.LABORATORIO);
                                sistema.agregarActividad(actividad);
                                break;
                        }
                    //Si leemos entre la 12 y la 22, corresponde al Martes
                    } else if (i < 22) {
                        switch(cell.getStringCellValue()){
                            case "s":
                                ramo = new Ramo(nombreRamo, cantidadAlumnos);
                                actividad = new Actividad(ramo, i-11, Dia.MARTES, TipoSala.SALA);
                                sistema.agregarActividad(actividad);
                                break;
                            case "LF":
                            case "LC":
                            case "LM":
                                ramo = new Ramo(nombreRamo, cantidadAlumnos);
                                actividad = new Actividad(ramo, i-11, Dia.MARTES, TipoSala.LABORATORIO);
                                sistema.agregarActividad(actividad);
                                break;
                        }
                    //Si leemos entre la 22 y la 32, corresponde al Miercoles
                    } else if (i < 32) {
                        switch(cell.getStringCellValue()){
                            case "s":
                                ramo = new Ramo(nombreRamo, cantidadAlumnos);
                                actividad = new Actividad(ramo, i-21, Dia.MIERCOLES, TipoSala.SALA);
                                sistema.agregarActividad(actividad);
                                break;
                            case "LF":
                            case "LC":
                            case "LM":
                                ramo = new Ramo(nombreRamo, cantidadAlumnos);
                                actividad = new Actividad(ramo, i-21, Dia.MIERCOLES, TipoSala.LABORATORIO);
                                sistema.agregarActividad(actividad);
                                break;
                        }
                    //Si leemos entre la 32 y la 42, corresponde al Jueves
                    } else if (i < 42) {
                        switch(cell.getStringCellValue()){
                            case "s":
                                ramo = new Ramo(nombreRamo, cantidadAlumnos);
                                actividad = new Actividad(ramo, i-31, Dia.JUEVES, TipoSala.SALA);
                                sistema.agregarActividad(actividad);
                                break;
                            case "LF":
                            case "LC":
                            case "LM":
                                ramo = new Ramo(nombreRamo, cantidadAlumnos);
                                actividad = new Actividad(ramo, i-31, Dia.JUEVES, TipoSala.LABORATORIO);
                                sistema.agregarActividad(actividad);
                                break;
                        }
                    //Finalmente las últiimas 10 corresponden al dia Viernes
                    } else if (i < 52) {
                        switch(cell.getStringCellValue()){
                            case "s":
                                ramo = new Ramo(nombreRamo, cantidadAlumnos);
                                actividad = new Actividad(ramo, i-41, Dia.VIERNES, TipoSala.SALA);
                                sistema.agregarActividad(actividad);
                                break;
                            case "LF":
                            case "LC":
                            case "LM":
                                ramo = new Ramo(nombreRamo, cantidadAlumnos);
                                actividad = new Actividad(ramo, i-41, Dia.VIERNES, TipoSala.LABORATORIO);
                                sistema.agregarActividad(actividad);
                                break;
                        }
                    } 
                }
            }
            
            //Cerramos el archivo al terminar
            file.close();
            FileOutputStream out = new FileOutputStream(new File(rutaArchivo));
            workbook.write(out);
            out.close();

        } catch (IOException | NumberFormatException e) {
            System.out.println("Ruta de archivo no encontrada.");
        }
    }
    /**
     * 
     * @return Devuelve una clase Sistema, corresponde a toda la informacion cargada del archivo
     */
    public static Sistema cargarArchivo(){
        try
        {
            int cantidad;
            Sistema sistema = new Sistema();
            Scanner scanner = new Scanner(new File("\\temp\\save.proyecto"));
            
            cantidad = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < cantidad; i++){
                String nombre = scanner.nextLine();
                int cantidadAlumnos = Integer.parseInt(scanner.nextLine());
                Ramo ramo = new Ramo(nombre, cantidadAlumnos);
                
                String diaActividad = scanner.nextLine();
                diaActividad = diaActividad.toUpperCase();
                Dia dia = null;
                switch (diaActividad){
                    case "LUNES":
                        dia = Dia.LUNES;
                        break;
                    case "MARTES":
                        dia = Dia.MARTES;
                        break;
                    case "MIERCOLES":
                        dia = Dia.MIERCOLES;
                        break;
                    case "JUEVES":
                        dia = Dia.JUEVES;
                        break;
                    case "VIERNES":
                        dia = Dia.VIERNES;
                        break;
                }
                
                int bloque = Integer.parseInt(scanner.nextLine());
                
                String tipoRequerido = scanner.nextLine();
                tipoRequerido = tipoRequerido.toUpperCase();
                TipoSala tipo = null;
                switch(tipoRequerido){
                    case "SALA":
                        tipo = TipoSala.SALA;
                        break;
                    case "LABORATORIO":
                        tipo = TipoSala.LABORATORIO;
                        break;  
                }
                
                Actividad actividad = new Actividad(ramo, bloque, dia, tipo);
                sistema.agregarActividad(actividad);
            }
            
            cantidad = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < cantidad; i++){
                String nombre = scanner.nextLine();
                int capacidadAlumnos = Integer.parseInt(scanner.nextLine());
                Sala sala = new Sala(nombre, capacidadAlumnos);
                
                int cantidadActividades = Integer.parseInt(scanner.nextLine());
                for (int j = 0; j < cantidadActividades; j++){
                    String nombreActividad = scanner.nextLine();
                    
                    String diaActividad = scanner.nextLine();
                    diaActividad = diaActividad.toUpperCase();
                    Dia dia = null;
                    switch (diaActividad){
                        case "LUNES":
                            dia = Dia.LUNES;
                            break;
                        case "MARTES":
                            dia = Dia.MARTES;
                            break;
                        case "MIERCOLES":
                            dia = Dia.MIERCOLES;
                            break;
                        case "JUEVES":
                            dia = Dia.JUEVES;
                            break;
                        case "VIERNES":
                            dia = Dia.VIERNES;
                            break;
                    }
                    
                    int bloque = Integer.parseInt(scanner.nextLine());
                    Actividad actividad = sistema.obtenerActividad(nombreActividad, dia, bloque);
                    sala.getHorario().agregarActividad(actividad);
                }
            }
            
            cantidad = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < cantidad; i++){
                String nombre = scanner.nextLine();
                int capacidadAlumnos = Integer.parseInt(scanner.nextLine());
                Laboratorio laboratorio = new Laboratorio(nombre, capacidadAlumnos);
                
                int cantidadActividades = Integer.parseInt(scanner.nextLine());                
                for (int j = 0; j < cantidadActividades; j++){
                    String nombreActividad = scanner.nextLine();
                    
                    String diaActividad = scanner.nextLine();
                    diaActividad = diaActividad.toUpperCase();
                    Dia dia = null;
                    switch (diaActividad){
                        case "LUNES":
                            dia = Dia.LUNES;
                            break;
                        case "MARTES":
                            dia = Dia.MARTES;
                            break;
                        case "MIERCOLES":
                            dia = Dia.MIERCOLES;
                            break;
                        case "JUEVES":
                            dia = Dia.JUEVES;
                            break;
                        case "VIERNES":
                            dia = Dia.VIERNES;
                            break;
                    }
                    
                    int bloque = Integer.parseInt(scanner.nextLine());
                    Actividad actividad = sistema.obtenerActividad(nombreActividad, dia, bloque);
                    laboratorio.getHorario().agregarActividad(actividad);
                }
                
                int cantidadInstrumentos = Integer.parseInt(scanner.nextLine());
                for (int j = 0; j < cantidadInstrumentos; j++){
                    laboratorio.agregarInstrumento(scanner.nextLine());
                }
            }
            
            scanner.close();
            return sistema;
        }
        catch(FileNotFoundException e)
        {
            return new Sistema();
        }
    }
}