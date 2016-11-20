
public class Main {

    private static Lector donLector = new Lector();
    private static Sistema sistema = new Sistema();

    
    
    public static void main(String[] args) {
        int opcion;
        
        do{
            Menu.mostrarMenuPrincipal();
            opcion = donLector.leerOpcion("Ingresa tu opcion: ", 0, 4);

            switch (opcion)
            {
                case 1:
                    Menu.mostrarMenuIngresarRemover("Sala");
                    opcion = donLector.leerOpcion("Ingresa tu opcion: ",0, 2);
                    switch (opcion)
                    {
                        case 1:
                            Ingresar_Sala();
                            break;
                        case 2:
                            Remover_Sala();
                            break;
                        case 0:
                            opcion=7;
                            break;
                    }
                    break;
                case 2:
                    Menu.mostrarMenuIngresarRemover("Laboratorio");
                    opcion = donLector.leerOpcion("Ingresa tu opcion: ",0, 2);
                    switch (opcion)
                    {
                        case 1:
                            Ingresar_Laboratorio();
                            break;
                        case 2:
                            Remover_Laboratorio();
                            break;
                        case 0:
                            opcion=7;
                            break;
                    }
                    break;
                case 3:
                    CargarDemanda_Aula();
                    break;
                case 4:
                    Menu.mostrarMenu1();
                    opcion = donLector.leerOpcion ("Ingresa tu opcion: ",0,2);
                    switch (opcion)
                    {
                        case 1:
                            VerListadoDemanda_Aula();
                            break;
                        case 2:
                            Menu.mostrarMenu2();
                            opcion = donLector.leerOpcion ("Ingresa tu opcion: ",0,2);
                            switch (opcion)
                            {
                                case 1:
                                    Menu.mostrarMenuSalaLaboratorio();
                                    opcion = donLector.leerOpcion ("Ingresa tu opcion :",0,1);
                                    switch (opcion)
                                    {
                                        case 1:
                                            Asignar_Sala();
                                            break;
                                        case 2:
                                            Asignar_Laboratorio();
                                            break;
                                        case 0:
                                            opcion = 7;
                                            break;
                                    }
                                    
                                    break;
                                case 2:
                                    break;
                                case 0:
                                    break;
                                    
                            }
                            break;
                        case 0:
                            Menu.mostrarMenuPrincipal();
                            opcion=7;
                            break;
                    }
                    break;
                case 0:
                    System.out.println("Gracias por usar el programa!!");
                    System.out.println("---FIN---");
                    break;
            }
            
        }while(opcion != 0);

    }
    private static void CargarDemanda(){
        
    }
    private static void ResolverDemanda (){
    
    }
    private static void Ingresar_Sala(){
        String nombre;
        int capacidadAlumnos;
        nombre =donLector.leerLinea("Ingresa el nombre de la Sala");
        capacidadAlumnos = donLector.leerNumeroEntero("Ingresa la Capacidad de Alumnos de la Sala");
        Sala sala = new Sala (nombre,capacidadAlumnos);
        if (sistema.agregarSala(sala) == true)
        {
            System.out.println("Felicidades, se ha creado la Sala Exitosamente");
        }else{
            System.out.println("Lo sentimos, hubo un error al tratar de crear la Sala");
        }
        
    }
    
    private static void Remover_Sala(){
        String nombreSala;
        nombreSala = donLector.leerLinea("Ingrese el nombre de la sala: ");
        if (sistema.eliminarSala(nombreSala))
        {
            System.out.println("La Sala ha sido eliminada exitosamente!!");
        }
        else
        {
            System.out.println("Error: La sala no pudo ser eliminada");
        }
    }
    
    private static void Ingresar_Laboratorio(){
        String nombre;
        int capacidadAlumnos;
        String instrumento;
        nombre =donLector.leerLinea("Ingresa el nombre del Laboratorio :");
        capacidadAlumnos = donLector.leerNumeroEntero("Ingresa la Capacidad de Alumnos del Laboratorio :");
        Laboratorio laboratorio = new Laboratorio (nombre, capacidadAlumnos);
        if(sistema.agregarLaboratorio(laboratorio)==true)
        {
            do{
            instrumento = donLector.leerLinea("Ingrese el nombre del Instrumento (o 0 para Salir)");
            if (!instrumento.equals("0")){
                laboratorio.agregarInstrumento(instrumento);
            }
            }while (!instrumento.equals("0"));
            
        }   
    }
    
    private static void Remover_Laboratorio(){
        String nombreLaboratorio;
        nombreLaboratorio = donLector.leerLinea("Ingrese el nombre de la laboratorio: ");
        if (sistema.eliminarLaboratorio(nombreLaboratorio))
        {
            System.out.println("El laboratorio ha sido eliminado exitosamente!!");
        }
        else
        {
            System.out.println("Error: El laboratorio no pudo ser eliminado");
        }
    
        
    }
    private static void CargarDemanda_Aula (){
        
    }
    private static void VerListadoDemanda_Aula(){
        
    }
    private static void Asignar_Sala(){
        String nombreActividad;
        String diaActividad;
        int bloqueActividad;
        nombreActividad = donLector.leerLinea ("Ingrese nombre de la Actividad: ");
        diaActividad = donLector.leerLinea ("Ingrese dia de la Actividad: ");
        bloqueActividad = donLector.leerNumeroEntero("Ingrese bloque de la Actividad: ");
        
    }
    private static void Asignar_Laboratorio(){
        
    }

    

}
