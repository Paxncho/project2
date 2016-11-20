

public class Menu
{
    
   static public void mostrarMenuPrincipal()
   {
       /*
      el Menú Principal (Ingresar/Remover Sala, Ingresar/Remover Laboratorio, Cargar Demanda, Resolver Demanda, Volver),
       Resolver Demanda (Ver listado de demandas cumplidas,Seleccionar actividad, Volver) y Seleccionar Actividad 
       (Asignar sala/laboratorio, Remover sala/laboratorio asignado, Volver).*/
        System.out.println ("Menú");
        System.out.println ("\n");
        System.out.println ("1) Ingresar/Remover Sala");
        System.out.println ("2) Ingresar/Remover Laboratorio");
        System.out.println ("3) Cargar Demanda desde Excel");
        System.out.println ("4) Resolver Demanda");
        System.out.println ("5) Ingresar/Remover Actividad");
        System.out.println ("6) Exportar Horario a Excel");
        System.out.println ("7) Listar Salas y Laboratorios");
        System.out.println ("0) Salir");
        System.out.println ("\n");
   }
  
   static public void mostrarMenuResolverDemanda()
   {
        System.out.println ("Resolver Demanda");
        System.out.println ("1) Ver Listado de Demandas Incumplidas");
        System.out.println ("2) Seleccionar Actividad");
        System.out.println ("0) Volver");
        System.out.println ("\n");
   }
   
   static public void mostrarMenuSeleccionarActividad()
   {
        System.out.println ("Seleccionar Actividad");
        System.out.println ("\n");
        System.out.println ("1) Asignar Sala/Laboratorio");
        System.out.println ("2) Remover Sala/Laboratorio Asignado");
        System.out.println ("0) Volver");
        System.out.println ("\n");

   }
   
   static public void mostrarMenuIngresarRemover(String aula)
   {
       System.out.println ("Ingresar o Remover " + aula);
       System.out.println ("1) Ingresar " + aula);
       System.out.println ("2) Remover " + aula);
       System.out.println ("0) Volver");
       System.out.println ("\n");
   }
   
   static public void mostrarMenuSalaLaboratorio ()
   {
       System.out.println("Sala o Laboratorio ");
       System.out.println("1) Sala ");
       System.out.println("2) Laboratorio ");
       System.out.println("0) Volver");
       System.out.println("\n");
   }
   
   static public void mostrarMenuListados ()
   {
       System.out.println("Listar Salas y Laboratorios ");
       System.out.println("1) En forma Ascendente");
       System.out.println("2) En forma Descendente");
       System.out.println("0) Volver");
       System.out.println("\n");
   }
}

