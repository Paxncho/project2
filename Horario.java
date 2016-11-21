
import java.util.ArrayList;
import java.util.Collections;

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
    
    public boolean eliminarBloque(Actividad eliminarActividad)
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
    
    @Override
    public String toString(){
        String string = "";
        Collections.sort(this.actividades);
        for (int i=0; i < this.actividades.size(); i++){
            string += this.actividades.get(i).toString() + "\n";
        }
        
        return string;
    }
    
    public String toSave(){
        String save = "";
        save += this.actividades.size() + "\n";
        for (Actividad actividad : this.actividades){
            save += actividad.getRamo().getNombre() + "\n" + 
                    actividad.getDia() + "\n" +
                    actividad.getBloque() + "\n";
        }
        return save;
    }
}