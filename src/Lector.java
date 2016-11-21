import java.util.Scanner;
/**
 * @author Luis Aburto, M. Fernanda Matera, Jose F. Riffo
 * @version 

*/

public class Lector
{
    private final Scanner scanner;
    
    public Lector()
    {
        this.scanner = new Scanner(System.in);
    }
    /**
     * 
     * @param mensaje Es del tipo String, corresponde al texto para interactuar con el usuario
     * @return Se devuelve un String que fue ingresado por el usuario
     */
    public String leerLinea(String mensaje)
    {
        System.out.print(mensaje + ": ");
        return this.scanner.nextLine();
    }
    /**
     * 
     * @param mensaje Es del tipo String, corresponde al texto para interactuar con el usuario
     * @return Se devuelve un numero entero, corresponde a la opcion ingresada por el usuario
     */
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
    /**
     * 
     * @param mensaje Es del tipo String, corresponde al texto para interactuar con el usuario
     * @return Se devuelve un numero decimal, corresponde a la opcion ingresada por el usuario
     */
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
    /**
     * 
     * @param mensaje Es del tipo String, corresponde al texto para interactuar con el usuario
     * @param minimo Es un numero entero, corresponde al minimo del intervalo, de las opciones del usuario
     * @param maximo Es un numero entero, corresponde al maximo del intervalo, de las opciones del usuario
     * @return  Se devuelve un numero entero, corresponde a la opcion ingresada por el usuario
     */
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
    /**
     * 
     * @param mensaje Es del tipo String, corresponde al texto para interactuar con el usuario
     * @return devuelve un tipo Enum Dia, corresponde al dia ingresado por el usuario
     */
    public Dia leerDia (String mensaje)
    {
        boolean continuar = true;
        String dia = null;
        Dia diaActividad = null;
        while (continuar)
        {
            dia = leerLinea(mensaje);
            dia = dia.toUpperCase();
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
    /**
     * 
     * @param mensaje Es del tipo String, corresponde al texto para interactuar con el usuario
     * @return Devuelve un Enum TipoSala, corresponde al tipo de aula ingresado por el usuario (SALA/LABORATORIO)
     */
    public TipoSala leerTipo (String mensaje)
    {
        boolean continuar = true;
        String tipo = null;
        TipoSala tipoActividad = null;
        while (continuar)
        {
            tipo = leerLinea(mensaje);
            tipo = tipo.toUpperCase();
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
    /**
     * 
     * @param mensaje Es del tipo String, corresponde al texto para interactuar con el usuario
     * @return Devuelve un numero entero, corresponde al bloque ingresado por el usuario
     */
    public int leerBloque(String mensaje)
    {
        int bloque = 0;
        boolean continuar = true; 
        while(continuar)
        {
            bloque = leerNumeroEntero(mensaje);
            if(bloque < 1 || bloque > 10)
            {
                System.out.println("No existe el Bloque Ingresado <(1-10)>");
            }
            if(bloque <= 10 && bloque >= 1)
            {
                continuar = false;
            }
        }
        return bloque;
    }
}
    
