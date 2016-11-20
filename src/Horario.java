

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
        nuevaActividad.setSalaAsignada(true);
        this.actividades.add(nuevaActividad);
        return true;
    }
    
    public int bloquesLibres()
    {
        return (50-(this.actividades.size()));
    }
    
    public boolean eliminarBloques (Actividad eliminarActividad)
    {
       eliminarActividad.setSalaAsignada(false);
       return this.actividades.remove(eliminarActividad);
    }
    
    public Actividad getActividad (Dia dia, int bloques){
        

        for (Actividad existente: this.actividades)
        {
            if (existente.getDia()== dia && existente.getBloque() == bloques)
            {
                return existente;
            }
        }
        return null;
    }
}