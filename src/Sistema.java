




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
    
    public void eliminarActividad(Actividad actividad){
        
        this.actividades.remove(actividad);
    }
    
    public int cantidadActividades()
    {
        return this.actividades.size();
    }
    
    public Actividad obtenerActividad(int index)
    {
        return this.actividades.get(index);
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
    public void eliminarLaboratorio(Laboratorio laboratorio){
        
        this.laboratorios.remove(laboratorio);
    
    }
    
    public int cantidadLaboratorios()
    {
        return this.laboratorios.size();
    }
    
    public Laboratorio obtenerLaboratorio(int index)
    {
        return this.laboratorios.get(index);
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
    
    public void eliminarSala(String id){
        
        this.salas.remove(id);
    }
    
    public int cantidadSalas()
    {
        return this.salas.size();
    }
    
    public Sala obtenerSala(int index)
    {
        return this.salas.get(index);
    }
 
 }
