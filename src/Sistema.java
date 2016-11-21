import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Luis Aburto, M. Fernanda Matera, Jose F. Riffo


*/

public class Sistema {
    private ArrayList <Actividad> actividades;
    private ArrayList <Laboratorio> laboratorios;
    private ArrayList <Sala> salas; 
    
    
    public Sistema() {
        this.actividades = new ArrayList <>();
        this.laboratorios = new ArrayList <>();
        this.salas = new ArrayList <>();
    }
    /**
     * 
     * @param actividad Es del tipo clase Actividad
     * @return retorna un boolean, si es true, la clase Actividad se agrega al ArrayList actividades
     */
    public boolean agregarActividad (Actividad actividad)
    {
        return this.actividades.add(actividad);
    }
    /**
     * 
     * @param nombre Es del tipo String, corresponde al nombre de la actividad que se quiere remover
     * @param dia Es del tipo Enum Dia, corresponde al dia de la actividad que se quiere remover
     * @param bloque Es un numero entero, corresponde al bloque de la actividad que se quiere remover
     * @return  retorna un boolean, si es true, la clase Laboratorio se remueve del ArrayList laboratorios
     */
    public boolean eliminarActividad(String nombre, Dia dia, int bloque)
    {
        for(Actividad existente: this.actividades){
            if (existente.getRamo().getNombre().equals(nombre)&& existente.getDia().equals(dia) && existente.getBloque() == bloque )
            {
                desasociarActividad(existente);
                this.actividades.remove(existente);
                return true;
            }
        }
        return false;
    }
    /**
     * 
     * @return Se retorna un numero entero, correspondiente a la cantidad de actividades dentro del arreglo actividades
     */
    public int cantidadActividades()
    {
        return this.actividades.size();
    }
    /**
     * 
     * @param nombre Es del tipo String, corresponde al nombre de la actividad que se quiere obtener
     * @param dia Es del tipo Enum Dia, corresponde al dia de la actividad que se quiere obtener
     * @param bloque Es un numero entero, corresponde al bloque de la actividad que se quiere obtener
     * @return Se retorna la actividad con los datos ingresados, si no se encuentra, se retorna un null
     */
    public Actividad obtenerActividad(String nombre, Dia dia, int bloque)
    {
         
        for (Actividad existente: this.actividades)
        {
            if (existente.getRamo().getNombre().equals(nombre) && existente.getDia().equals(dia) && existente.getBloque() == (bloque))
            {
                return existente;
            }
        }
        return null;
    }
    /**
     * 
     * @param laboratorio
     * @return retorna un boolean, si es true, la clase Laboratorio se agrega al ArrayList laboratorios
     */
    public boolean agregarLaboratorio (Laboratorio laboratorio)
    {
       for (Laboratorio existente : this.laboratorios)
       {
           if (existente.getNombre().equals(laboratorio.getNombre()) )
           {
               return false;
            }
        }
        this.laboratorios.add(laboratorio);
        return true;
    }
    /**
     * 
     * @param nombre Es del tipo String, corresponde al nombre del Laboratorio
     * @return Se retorna un boolean, si es true remueve el Laboratorio con el nombre existente (ingresado)
     */
    public boolean eliminarLaboratorio(String nombre){
        
      for(Laboratorio existente: this.laboratorios){
            if (existente.getNombre().equals(nombre))
            {
                this.laboratorios.remove(existente);
                return true;
            }
        }
        return false;
        
    }
    /**
     * 
     * @return Se retorna la el tamaño del ArrayList laboratorios, corresponde a la cantidad de laboratorios registrados, si no se encuentra se retorna un null
     */
    public int cantidadLaboratorios()
    {
        return this.laboratorios.size();
    }
    /**
     * 
     * @param nombre Es un String, corresponde al nombre del laboratorio que se desea obtener
     * @return Se retorna el laboratorio con el nombre ingresado, si no se encuentra, se retorna un null
     */
    public Laboratorio obtenerLaboratorio(String nombre)
    {
        for (Laboratorio existente: this.laboratorios)
        {
            if (existente.getNombre().equals(nombre))
            {
                return existente;
            }
        }
        return null;
    }
    
    /**
     * 
     * @param sala Es un objeto del tipo clase Sala, corresponde a la sala que se desea agregar
     * @return retorna un boolean, si es true, la clase Sala se agrega al ArrayList salas
     */
    public boolean agregarSala (Sala sala)
    {
       for (Sala existente : this.salas)
       {
           if (existente.getNombre().equals(sala.getNombre ()) )
           {
               return false;
            }
        }
        this.salas.add(sala);
        return true;
    }
    
    /**
     * 
     * @param nombre Es un objeto del tipo clase Sala, corresponde a la sala que se desea remover
     * @return retorna un boolean, si es true, la clase Sala se remueve del ArrayList salas
     */
    public boolean eliminarSala(String nombre)
    {
        for(Sala existente: this.salas){
            if (existente.getNombre().equals(nombre))
            {
                this.salas.remove(existente);
                return true;
            }
        }
        return false;        
    }
    /**
     * 
     * @return se retorna un numero entero, correspondiente al tamaño del ArrayList salas, corresponde al numero de salas registradas
     */
    public int cantidadSalas()
    {
        return this.salas.size();
    }
    /**
     * 
     * @param nombre Es un String, corresponde a al nombre de la sala que se desea obtener
     * @return Se retorna la actividad con los datos ingresados, si no se encuentra, se retorna un null
     */
    public Sala obtenerSala(String nombre)
    {
        for (Sala existente: this.salas)
        {
            if (existente.getNombre().equals(nombre))
            {
                return existente;
            }
        }
        return null;
    }
    /**
     * 
     * @param desasociar Es una clase Actividad, se refiere a la activdad que se desea asociar
     * @return Retorna un boolean, si es true, se obtiene el bloque, y queda asociada una actividad a la Sala o Laboratorio
     */
    public boolean AsignacionActividadSala (Actividad demanda)
    {
        if (demanda.getTipoRequerido() == TipoSala.SALA)
        {
            ArrayList<Sala> salasDisponibles = new ArrayList<>();
            for (Sala existente : this.salas)
            {
                if (existente.getCapacidadAlumnos() == demanda.getRamo().getCantidadAlumnos() && existente.getHorario().getActividad(demanda.getDia(), demanda.getBloque()) != null)
                {
                    salasDisponibles.add(existente);
                }
            }
            
            Sala menor = new Sala("", Integer.MAX_VALUE);
            
            for (int i=0; i < salasDisponibles.size(); i++)
            {
                if (salasDisponibles.get(i).getCapacidadAlumnos() < menor.getCapacidadAlumnos())
                {
                    menor = salasDisponibles.get(i);
                }
            }
            
            if (!menor.getNombre().equals("")){
                return menor.getHorario().agregarActividad(demanda);
            }
            else{
                return false;
            }
        }
        else
        {
            ArrayList<Laboratorio> laboratoriosDisponibles = new ArrayList<>();
            for (Laboratorio existente : this.laboratorios)
            {
                if (existente.getCapacidadAlumnos() == demanda.getRamo().getCantidadAlumnos() && existente.getHorario().getActividad(demanda.getDia(), demanda.getBloque()) != null)
                {
                    laboratoriosDisponibles.add(existente);
                }
            }
            
            Laboratorio menor = new Laboratorio("", Integer.MAX_VALUE);
            
            for (int i=0; i < laboratoriosDisponibles.size(); i++)
            {
                if (laboratoriosDisponibles.get(i).getCapacidadAlumnos() < menor.getCapacidadAlumnos())
                {
                    menor = laboratoriosDisponibles.get(i);
                }
            }
            
            if (!menor.getNombre().equals("")){
                return menor.getHorario().agregarActividad(demanda);
            } else {
                return false;
            }
        }
    }
    /**
     * 
     * @param desasociar Es una clase Actividad, se refiere a la activdad que se desea desasociar
     * @return Retorna un boolean, si es true, se elimina el bloque, y no queda asociada una actividad a la Sala o Laboratorio
     */
     public boolean desasociarActividad (Actividad desasociar)
     {
        if (desasociar.getTipoRequerido() == TipoSala.SALA)
        {
            for (Sala existente : this.salas)
            {
                Actividad actividadSala = existente.getHorario().getActividad(desasociar.getDia(),desasociar.getBloque());
                
                if(desasociar.equals(actividadSala))
                {
                    return existente.getHorario().eliminarBloque(desasociar);
                    
                }
            }
            return false;
            
        }
        else
        {
            for (Laboratorio existente : this.laboratorios)
            {
                Actividad actividadLaboratorio = existente.getHorario().getActividad(desasociar.getDia(),desasociar.getBloque());
                
                if(desasociar.equals(actividadLaboratorio))
                {
                    return existente.getHorario().eliminarBloque(desasociar);
                    
                }
            }
            return false;
        
        }
    }
    /**
     * 
     * @return Se devuelve un ArrayList del tipo String, corresponde al listado de demandas incompletas que no tienen una sala asignada
     */
    public String mostrarDemandasIncompletas(){
        String listadoDemandas = "";
        for(Actividad existente: this.actividades)
        {
            if(!existente.isSalaAsignada())
            {
                listadoDemandas += existente.toString() + "\n";
            }
        }
        return listadoDemandas;
    }
    /**
     * 
     * @return Devuelve un listado del tipo String, con los ArrayList salas y laboratorios ordenados de forma Ascendente
     */
    public String listarAscendente ()            
    {
        String listado = "";
        ArrayList<Aula> aulasDisponibles = new ArrayList<>();
        for (Aula existente : this.salas)
        {
            aulasDisponibles.add(existente);              
        }
        for (Aula existente : this.laboratorios)
        {
            aulasDisponibles.add(existente);
        }
        Collections.sort(aulasDisponibles);
        for (int i = 0; i < aulasDisponibles.size(); i++){
            listado+= aulasDisponibles.get(i).toString() + "\n";
        }
        return listado;
    }
    /**
     * 
     * @return Devuelve un listado del tipo String, con los ArrayList salas y laboratorios ordenados de forma Descendente
     */
    public String listarDescendente ()
    {
        String listado = "";
        ArrayList<Aula> aulasDisponibles = new ArrayList<>();
        for (Aula existente : this.salas)
        {
            aulasDisponibles.add(existente);              
        }
        for (Aula existente : this.laboratorios)
        {
            aulasDisponibles.add(existente);
        }
        Collections.sort(aulasDisponibles);
        for (int i = aulasDisponibles.size()-1; i > 0; i--){
            listado+= aulasDisponibles.get(i).toString() + "\n";
        }
        return listado;
        
    }
    /**
     * 
     * @return Devuelve los ArrayList actividades, laboratorio y salas en forma de String
     */
    public String toSave(){
        String save = "";
        save += this.actividades.size() + "\n";
        for (Actividad actividad : this.actividades){
            save += actividad.toSave();
        }
        save += this.salas.size() + "\n";
        for (Sala sala : this.salas){
            save += sala.toSave();
        }
        save += this.laboratorios.size() + "\n";
        for (Laboratorio laboratorio : this.laboratorios){
            save += laboratorio.toSave();
        }
        
        return save;
    }
}
 
