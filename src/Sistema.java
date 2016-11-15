
import java.util.ArrayList;

public class Sistema {
    private ArrayList <Actividad> actividades;
    private ArrayList <Laboratorio> laboratorios;
    private ArrayList <Sala> salas; 
    
    public Sistema(ArrayList<Actividad> actividades, ArrayList<Laboratorio> laboratorios, ArrayList<Sala> salas) {
        this.actividades = actividades;
        this.laboratorios = laboratorios;
        this.salas = salas;
    }

    public boolean agregarActividad (Actividad actividad)
    {
    
       for (Actividad existente : this.actividades)
       {
           if (existente.getId() == actividad.getId () )
           {
               return false;
            }
        }
        this.actividades.add(actividad);
        return true;
    
    }
    
    public void eliminarActividad(String id){
        
        this.actividades.remove (id);    
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
           if (existente.getId() == laboratorio.getId () )
           {
               return false;
            }
        }
        this.laboratorios.add(laboratorio);
        return true;
    
    }
    public void eliminarLaboratorio(String id){
        
        this.laboratorios.remove (id);
    
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
           if (existente.getId() == sala.getId () )
           {
               return false;
            }
        }
        this.salas.add(sala);
        return true;
    
    }
    
    public void eliminarSala(String id){
        
        this.salas.remove (id);
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
