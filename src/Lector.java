import java.util.Scanner;

public class Lector
{
    private final Scanner scanner;
    
    public Lector()
    {
        this.scanner = new Scanner(System.in);
    }
    
    public String leerLinea(String mensaje)
    {
        System.out.print(mensaje + ": ");
        return this.scanner.nextLine();
    }
    
    public int leerNumeroEntero(String mensaje)
    {
        int opcion = 0;
        boolean continuar = true;
        while(continuar)
        {
            try
            {
                opcion = Integer.parseInt(leerLinea(mensaje));
                continuar = false;
            }
            catch(NumberFormatException e)
            {
                System.out.println("Ingresa nuevamente");
            }
        }
        return opcion;
    }
    
    public float leerNumeroReal(String mensaje)
    {
        float opcion = 0;
        boolean continuar = true;
        while(continuar)
        {
            try
            {
                opcion = Float.valueOf(leerLinea(mensaje));
                continuar = false;
            }
            catch(NumberFormatException e)
            {
                System.out.println("Ingresa nuevamente");
            }
        }
        return opcion;
    }
    
    public int leerOpcion(String mensaje, int minimo, int maximo)
    {
        int opcion = 0;
        boolean continuar = true; 
        while(continuar)
        {
            try
            {
                opcion = Integer.parseInt(leerLinea(mensaje));
                if(opcion < minimo || opcion > maximo)
                {
                    System.out.println("No existe esta opcion");
                }
                if(opcion <= maximo && opcion >= minimo)
                {
                    continuar = false;
                }
            }
            catch(NumberFormatException e)
            {
                System.out.println("No existe esta opcion");
            }
        }
        return opcion;
    }
}
    
