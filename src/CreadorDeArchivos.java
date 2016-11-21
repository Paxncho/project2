import java.io.File;
import java.io.FileWriter;
/**
 * @author Luis Aburto, M. Fernanda Matera, Jose F. Riffo
 * @version 

*/

public class CreadorDeArchivos {
    /**
     * 
     * @param save 
     */
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
