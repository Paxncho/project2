
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
                    Menu.mostrarMenuResolverDemanda();
                    opcion = donLector.leerOpcion ("Ingresa tu opcion: ",0,2);
                    switch (opcion)
                    {
                        case 1:
                            VerListadoDemanda_Aula();
                            break;
                        case 2:
                            Menu.mostrarMenuSeleccionarActividad();
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
                                    Menu.mostrarMenuSalaLaboratorio();
                                    opcion = donLector.leerOpcion ("Ingresa tu opcion :",0,2);
                                    switch (opcion)
                                    {
                                        case 1:
                                            Remover_Sala_Asignada();
                                            break;
                                        case 2:
                                            Remover_Laboratorio_Asignado();
                                            break;
                                        case 0:
                                            opcion = 7;
                                            break;
                                    }
                                    break;
                                case 0:
                                    opcion=7;
                                    break;
                                    
                            }
                            break;
                        case 0:
                            opcion=7;
                            break;
                    }
                    break;
                case 5:
                    Menu.mostrarMenuIngresarRemover("Actividad");
                    opcion= donLector.leerOpcion("Ingrese su opcion: ", 0, 2);
                    switch (opcion)
                    {
                        case 1:
                            Ingresar_Actividad();
                            break;
                        case 2:
                            Remover_Actividad();
                            break;
                        case 0:
                            opcion= 7;
                            break;
                    }
                    break;
                case 6:
                    Exportar_Horario();
                    break;
                case 7:
                    Menu.mostrarMenuListados();
                    opcion = donLector.leerOpcion("Ingrese su opcion: ", 0, 2);
                    switch(opcion){
                        case 1:
                            Listar_Ascendente();
                            break;
                        case 2:
                            Listar_Descendente();
                            break;
                        case 0:
                            opcion = 7;
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
        String rutaArchivo;
        rutaArchivo = donLector.leerLinea("Ingrese la ruta del archivo Excel que desea Leer");
        LectorDeArchivos.LeerExcel(rutaArchivo, sistema);
    }
    private static void VerListadoDemanda_Aula(){
        String listado = sistema.mostrarDemandasIncompletas();
        if (listado.equals(""))
        {
            System.out.println("No hay Demandas incompletas");
        }else{
            System.out.println("" + listado);
        }
        
    }
    private static void Asignar_Sala(){
        String nombreActividad;
        Dia diaActividad;
        int bloqueActividad;
        String nombreSala;
        nombreActividad = donLector.leerLinea ("Ingrese nombre de la Actividad: ");
        diaActividad = donLector.leerDia ("Ingrese dia de la Actividad: ");
        bloqueActividad = donLector.leerNumeroEntero("Ingrese bloque de la Actividad: ");
        
        Actividad actividadNueva = sistema.obtenerActividad(nombreActividad, diaActividad, bloqueActividad);
        
        if (actividadNueva.equals(null))
        {
            System.out.println("La Actividad ingresada no existe ");
            return;
        }
        nombreSala = donLector.leerLinea("Ingrese el nombre de la sala para la actividad: ");
        
        Sala salaNueva = sistema.obtenerSala(nombreSala);
        
        if (salaNueva == null)
        {
            System.out.println("La sala Ingresada no existe ");
            return;
        }
        if (salaNueva.getHorario().agregarActividad(actividadNueva))
        {
            System.out.println("La asignacion fue realizada exitosamente!!");
        }
        else
        {
            System.out.println("Error: este bloque ya se encontraba ocupado");
        }
    }
    private static void Asignar_Laboratorio(){
        String nombreActividad;
        Dia diaActividad;
        int bloqueActividad;
        String nombreLaboratorio;
        nombreActividad = donLector.leerLinea ("Ingrese nombre de la Actividad: ");
        diaActividad = donLector.leerDia ("Ingrese dia de la Actividad: ");
        bloqueActividad = donLector.leerNumeroEntero("Ingrese bloque de la Actividad: ");
        
        Actividad actividadNueva = sistema.obtenerActividad(nombreActividad, diaActividad, bloqueActividad);
        
        if (actividadNueva == null)
        {
            System.out.println("La Actividad ingresada no existe ");
            return;
        }
        nombreLaboratorio = donLector.leerLinea("Ingrese el nombre del laboratorio para la actividad: ");
        
        Laboratorio laboratorioNuevo = sistema.obtenerLaboratorio(nombreLaboratorio);
        
        if (laboratorioNuevo == null)
        {
            System.out.println("El laboratorio ingresado no existe ");
            return;
        }
        if (laboratorioNuevo.getHorario().agregarActividad(actividadNueva))
        {
            System.out.println("La asignacion fue realizada exitosamente!!");
        }
        else
        {
            System.out.println("Error: este bloque ya se encontraba ocupado");
        }        
    }
    
    private static void Remover_Laboratorio_Asignado(){
        String nombreActividad;
        Dia diaActividad;
        int bloqueActividad;
        String nombreLaboratorio;
        nombreActividad = donLector.leerLinea ("Ingrese nombre de la Actividad: ");
        diaActividad = donLector.leerDia ("Ingrese dia de la Actividad: ");
        bloqueActividad = donLector.leerNumeroEntero("Ingrese bloque de la Actividad: ");
        
        Actividad actividadNueva = sistema.obtenerActividad(nombreActividad, diaActividad, bloqueActividad);
        
        if (actividadNueva.equals(null))
        {
            System.out.println("La Actividad ingresada no existe ");
            return;
        }
        nombreLaboratorio = donLector.leerLinea("Ingrese el nombre del laboratorio para la actividad: ");
        
        Laboratorio laboratorioNuevo = sistema.obtenerLaboratorio(nombreLaboratorio);
        
        if (laboratorioNuevo.equals(null))
        {
            System.out.println("El laboratorio ingresado no existe ");
            return;
        }
        if (laboratorioNuevo.getHorario().eliminarBloque(actividadNueva))
        {
            System.out.println("La eliminacion fue realizada exitosamente!!");
        }
        else
        {
            System.out.println("Error: este bloque ya se encontra desocupado");
        } 
    
    }
    
    private static void Remover_Sala_Asignada(){
        String nombreActividad;
        Dia diaActividad;
        int bloqueActividad;
        String nombreSala;
        nombreActividad = donLector.leerLinea ("Ingrese nombre de la Actividad: ");
        diaActividad = donLector.leerDia ("Ingrese dia de la Actividad: ");
        bloqueActividad = donLector.leerNumeroEntero("Ingrese bloque de la Actividad: ");
        
        Actividad actividadNueva = sistema.obtenerActividad(nombreActividad, diaActividad, bloqueActividad);
        
        if (actividadNueva.equals(null))
        {
            System.out.println("La Actividad ingresada no existe ");
            return;
        }
        nombreSala = donLector.leerLinea("Ingrese el nombre de la sala para la actividad: ");
        
        Sala salaNueva = sistema.obtenerSala(nombreSala);
        
        if (salaNueva.equals(null))
        {
            System.out.println("La sala Ingresada no existe ");
            return;
        }
        if (salaNueva.getHorario().eliminarBloque(actividadNueva))
        {
            System.out.println("La eliminacion fue realizada exitosamente!!");
        }
        else
        {
            System.out.println("Error: este bloque ya se encuentra desocupado");
        }
    
    }
    
    private static void Ingresar_Actividad(){
    
    }
    
    private static void Remover_Actividad(){
    
    }
    
    private static void Exportar_Horario(){
        
    }
    
    private static void Listar_Ascendente(){
        
    }
    
    private static void Listar_Descendente(){
        
    }

}
