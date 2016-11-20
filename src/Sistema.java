import java.util.ArrayList;

public class Sistema {
    private ArrayList <Actividad> actividades;
    private ArrayList <Laboratorio> laboratorios;
    private ArrayList <Sala> salas; 
    
    
    public Sistema() {
        this.actividades = new ArrayList <Actividad>();
        this.laboratorios = new ArrayList <Laboratorio>();
        this.salas = new ArrayList <Sala>();
    }

    public boolean agregarActividad (Actividad actividad)
    {
        return this.actividades.add(actividad);    
    }
    
    public void eliminarActividad(Actividad actividad)
    {
        this.actividades.remove(actividad);
    }
    
    public int cantidadActividades()
    {
        return this.actividades.size();
    }
    
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
    
    public int cantidadLaboratorios()
    {
        return this.laboratorios.size();
    }
    
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
    
    public int cantidadSalas()
    {
        return this.salas.size();
    }
    
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
 }
 
