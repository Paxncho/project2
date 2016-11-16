import java.io.File;
import java.util.Scanner;

public class Cargador {
    
    public static Sistema readFile ()
    {
        try
        {
            Sistema sistema = new Sistema ();
            Scanner scanner = new Scanner (new File(/*ruta de archivo*/ ""));
            
            scanner.close();
            return sistema;
       
        }
        catch (Exception e)
        {
                System.out.println("No se pudo leer el archivo"+e);
                return new Sistema();
        }
    }
}