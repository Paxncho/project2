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
            opcion = leerNumeroEntero(mensaje);
            if(opcion < minimo || opcion > maximo)
            {
                System.out.println("No existe esta opcion");
            }
            if(opcion <= maximo && opcion >= minimo)
            {
                continuar = false;
            }
        }
        return opcion;
    }
    
    public Dia leerDia (String mensaje)
    {
        boolean continuar = true;
        String dia = null;
        Dia diaActividad = null;
        while (continuar)
        {
            dia = leerLinea(mensaje);
            dia.toUpperCase();
            if (dia.equals("LUNES")|| dia.equals ("MARTES")|| dia.equals("MIERCOLES")||dia.equals("JUEVES")||dia.equals("VIERNES"))
            {
                continuar = false;
            }
            else
            {
                System.out.println("Dia inexistente, por favor tratar nuevamente");
            }
            
        }
        switch (dia){
            case "LUNES":
                diaActividad = Dia.LUNES;
                break;
            case "MARTES":
                diaActividad = Dia.MARTES;
                break;
            case "MIERCOLES":
                diaActividad = Dia.MIERCOLES;
                break;
            case "JUEVES":
                diaActividad = Dia.JUEVES;
                break;
            case "VIERNES":
                diaActividad = Dia.VIERNES;
                break;
        }
        return diaActividad;
        
    }
    public TipoSala leerTipo (String mensaje)
    {
        boolean continuar = true;
        String tipo = null;
        TipoSala tipoActividad = null;
        while (continuar)
        {
            tipo = leerLinea(mensaje);
            tipo.toUpperCase();
            if (tipo.equals("SALA")||tipo.equals("LABORATORIO"))
            {
                continuar = false;
            }
            else
            {
                System.out.println("Tipo Requerido inexistente, por favor tratar nuevamente");
            }
            
        }
        switch (tipo){
            case "SALA":
                tipoActividad = TipoSala.SALA;
                break;
            case "LABORATORIO":
                tipoActividad = TipoSala.LABORATORIO;
                break;
        }
        
        return tipoActividad;
    }
}
    
