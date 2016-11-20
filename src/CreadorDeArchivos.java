import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class CreadorDeArchivos {

    public static void crearArchivo(String save){
        try{
            File guardar = new File("\\temp\\save.proyecto");
            guardar.getParentFile().mkdirs();
            FileWriter escritor = new FileWriter(guardar);
            escritor.write(save);
            escritor.close();
        }
        
        catch(Exception e){
            System.out.println("Error al guardar el archivo");
            e.printStackTrace();
        }
    }
    
    static public boolean CrearExcel(){
        try {
            //Leo lo que tenía guardado
            Scanner scanner = new Scanner(new File("\\temp\\save.proyecto"));
            int cantidad;
            
            //Todo lo de aquí abajo prepara el excel a escribir -Pencho
            HSSFWorkbook workbook = new HSSFWorkbook(); //Creamos el Excel Virtual -Pencho
            HSSFSheet hojaHorarios = workbook.createSheet("Horarios"); //Le Creamos una hoja -Pencho
            HSSFSheet hojaListaActividades = workbook.createSheet("Actividades");
            HSSFSheet hojaListaSalasLaboratorios = workbook.createSheet("Salas y Laboratorios");
                       
            //Asignación de Actividades a ListaActividades
            cantidad = Integer.parseInt(scanner.nextLine());
            ArrayList<Ramo> ramos = new ArrayList<>();
            
            hojaListaActividades.createRow(0).getCell(1).setCellValue("Nombre del Ramo");
            hojaListaActividades.createRow(0).getCell(2).setCellValue("Cantidad de Alumnos");
            hojaListaActividades.createRow(0).getCell(3).setCellValue("Tipo de Aula Requerida");
            
            for (int i = 0; i < cantidad; i++){
                String nombre = scanner.nextLine();
                int cantidadAlumnos = Integer.parseInt(scanner.nextLine());
                Ramo ramo = new Ramo(nombre, cantidadAlumnos);
                
                if (ramos.indexOf(ramo) != -1){
                    ramos.add(ramo);
                    Row filaActiva = hojaListaActividades.createRow(ramos.indexOf(ramo) + 1);
                    filaActiva.getCell(1).setCellValue(nombre);
                    filaActiva.getCell(2).setCellValue(cantidadAlumnos);
                }
                
                Row filaActiva = hojaListaActividades.createRow(ramos.indexOf(ramo) + 1);
                
                String diaActividad = scanner.nextLine();
                diaActividad = diaActividad.toUpperCase();
                int bloque = Integer.parseInt(scanner.nextLine());
                String tipoRequerido = scanner.nextLine();
                tipoRequerido = tipoRequerido.toUpperCase();
                filaActiva.getCell(3).setCellValue(tipoRequerido);
                switch (diaActividad){
                    case "LUNES":
                        filaActiva.getCell(3 + bloque).setCellValue("x");
                        break;
                    case "MARTES":
                        filaActiva.getCell(13 + bloque).setCellValue("x");
                        break;
                    case "MIERCOLES":
                        filaActiva.getCell(23 + bloque).setCellValue("x");
                        break;
                    case "JUEVES":
                        filaActiva.getCell(33 + bloque).setCellValue("x");
                        break;
                    case "VIERNES":
                        filaActiva.getCell(43 + bloque).setCellValue("x");
                        break;
                }
            }
            
            ArrayList<Aula> aulas = new ArrayList<>();
            hojaListaSalasLaboratorios.createRow(0).createCell(1).setCellValue("Nombre");
            hojaListaSalasLaboratorios.createRow(0).createCell(2).setCellValue("Capacidad de Alumnos");
            
            //Asignacion de Sala a la Lista de Salas/Laboratorios, además de la creación del horario en la Hoja Adecuada
            cantidad = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < cantidad; i++){
                String nombre = scanner.nextLine();
                int capacidadAlumnos = Integer.parseInt(scanner.nextLine());
                Sala sala = new Sala(nombre, capacidadAlumnos);
                aulas.add(sala);
                Row aulaActual = hojaListaSalasLaboratorios.createRow(aulas.size() + 1);
                
                aulaActual.createCell(1).setCellValue(nombre);
                aulaActual.createCell(2).setCellValue(capacidadAlumnos);
                
                hojaHorarios.createRow(13*i + 1).createCell(1).setCellValue(nombre);
                Row Dias = hojaHorarios.createRow(13*i + 2);
                for (int j = 0; j < 5; j++){
                    Cell dia = Dias.createCell(i+1);
                    switch(j){
                        case 0:
                            dia.setCellValue("Lunes");
                            break;
                        case 1:
                            dia.setCellValue("Martes");
                            break;
                        case 2:
                            dia.setCellValue("Miercoles");
                            break;
                        case 3:
                            dia.setCellValue("Jueves");
                            break;
                        case 4:
                            dia.setCellValue("Viernes");
                            break;
                    }
                }
                
                int cantidadActividades = Integer.parseInt(scanner.nextLine());
                for (int j = 0; j < cantidadActividades; j++){
                    String nombreActividad = scanner.nextLine();
                    String diaActividad = scanner.nextLine();
                    diaActividad = diaActividad.toUpperCase();
                    int bloque = Integer.parseInt(scanner.nextLine());
                    
                    switch (diaActividad){
                        case "LUNES":
                            hojaHorarios.createRow(13*i + bloque).createCell(1).setCellValue(nombreActividad);
                            break;
                        case "MARTES":
                            hojaHorarios.createRow(13*i + bloque).createCell(2).setCellValue(nombreActividad);
                            break;
                        case "MIERCOLES":
                            hojaHorarios.createRow(13*i + bloque).createCell(3).setCellValue(nombreActividad);
                            break;
                        case "JUEVES":
                            hojaHorarios.createRow(13*i + bloque).createCell(4).setCellValue(nombreActividad);
                            break;
                        case "VIERNES":
                            hojaHorarios.createRow(13*i + bloque).createCell(5).setCellValue(nombreActividad);
                            break;
                    }
                }
                
                
                
            }
            
            //Asociación del Laboratorio con el Horario, y su añadidura a la Lista Salas/Laboratorio
            cantidad = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < cantidad; i++){
                String nombre = scanner.nextLine();
                int capacidadAlumnos = Integer.parseInt(scanner.nextLine());
                
                Laboratorio laboratorio = new Laboratorio(nombre, capacidadAlumnos);
                aulas.add(laboratorio);
                Row aulaActual = hojaListaSalasLaboratorios.createRow(aulas.size() + 1);
                
                aulaActual.createCell(1).setCellValue(nombre);
                aulaActual.createCell(2).setCellValue(capacidadAlumnos);
                
                hojaHorarios.createRow(13*i + 1).createCell(1 + 7).setCellValue(nombre);
                Row Dias = hojaHorarios.createRow(13*i + 2);
                for (int j = 0; j < 5; j++){
                    Cell dia = Dias.createCell(i+1 + 7);
                    switch(j){
                        case 0:
                            dia.setCellValue("Lunes");
                            break;
                        case 1:
                            dia.setCellValue("Martes");
                            break;
                        case 2:
                            dia.setCellValue("Miercoles");
                            break;
                        case 3:
                            dia.setCellValue("Jueves");
                            break;
                        case 4:
                            dia.setCellValue("Viernes");
                            break;
                    }
                }
                
                int cantidadActividades = Integer.parseInt(scanner.nextLine());
                for (int j = 0; j < cantidadActividades; j++){
                    String nombreActividad = scanner.nextLine();
                    String diaActividad = scanner.nextLine();
                    diaActividad = diaActividad.toUpperCase();
                    int bloque = Integer.parseInt(scanner.nextLine());
                    
                    switch (diaActividad){
                        case "LUNES":
                            hojaHorarios.createRow(13*i + bloque).createCell(1+7).setCellValue(nombreActividad);
                            break;
                        case "MARTES":
                            hojaHorarios.createRow(13*i + bloque).createCell(2+7).setCellValue(nombreActividad);
                            break;
                        case "MIERCOLES":
                            hojaHorarios.createRow(13*i + bloque).createCell(3+7).setCellValue(nombreActividad);
                            break;
                        case "JUEVES":
                            hojaHorarios.createRow(13*i + bloque).createCell(4+7).setCellValue(nombreActividad);
                            break;
                        case "VIERNES":
                            hojaHorarios.createRow(13*i + bloque).createCell(5+7).setCellValue(nombreActividad);
                            break;
                    }
                }
                
                int cantidadInstrumentos = Integer.parseInt(scanner.nextLine());
                String instrumentos = "";
                for (int j = 0; j < cantidadInstrumentos; j++){
                    instrumentos += scanner.nextLine().trim();
                    if (j != cantidadInstrumentos -1){
                        instrumentos += ", ";
                    }
                }
                aulaActual.createCell(3).setCellValue(instrumentos);
            }          
            
            // Escribimos el archivo
            // Esto de aquí es lo más importante de saber, todo esto crea el archivo -Pencho
            try {
                //Nombre del archivo excel a crear -Pencho
                File archivo = new File("Horario.xls");
                //Asignamos el Excel virtual al archivo real -Pencho
                FileOutputStream out = new FileOutputStream(archivo);
                workbook.write(out);
                //Cerramos el archivo -Pencho
                out.close();
                
                System.out.println("Archivo creado exitosamente!");
                return true;
                
            } catch (Exception e) {
                System.out.println("Error de escritura");
                e.printStackTrace();
                return false;
            }
        } catch (FileNotFoundException ex) {
            return false;
        }
    }
}
