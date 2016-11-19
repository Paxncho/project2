

import java.util.ArrayList;

public class Horario {
       
    private ArrayList<Actividad> actividades;

    public Horario(){
        this.actividades = new ArrayList <Actividad>();
    }
    
    public boolean agregarActividad (Actividad nuevaActividad){
        for (Actividad existente: this.actividades)
        {
           if (existente.getDia()== nuevaActividad.getDia() && existente.getBloque() == nuevaActividad.getBloque())
           {
               return false;
           }
        }
        this.actividades.add(nuevaActividad);
        return true;
    }
    
    public int bloquesLibres()
    {
        return (50-(this.actividades.size()));
    }
    
    public boolean eliminarBloques (Actividad eliminarActividad)
    {
       return this.actividades.remove(eliminarActividad);
    }
    
    public Actividad getActividad (Dia dia, int bloques){
        
        for (Actividad existente: this.actividades)
        {
            if (existente.getDia()== dia && existente.getBloque() == bloques)
            {
                return existente;
            }else{
                return null;
                
                //aqui vivía el print del Luis que nadie quizo
                //System.out.println("No se ha encontrado ");
                
            }
        }
        
        
       
        
    }
}