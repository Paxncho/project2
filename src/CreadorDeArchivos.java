import java.io.File;
import java.io.FileWriter;


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
            
        }
    }
    
    public static void ExportarExcel(){
    
    }
}
