
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
        nombre =donLector.leerLinea("Ingresa el nombre");
        capacidadAlumnos = donLector.leerNumeroEntero("Ingresa la Capacidad de Alumnos de la Sala");
        
        
    }
    
    private static void Remover_Sala(){
        
    }
    
    private static void Ingresar_Laboratorio(){
        
    }
    
    private static void Remover_Laboratorio(){
        
    }
    private static void CargarDemanda_Aula (){
        
    }
    private static void VerListadoDemanda_Aula(){
        
    }
    private static void Asignar_Sala(){
        
    }
    private static void Asignar_Laboratorio(){
        
    }

    

}
