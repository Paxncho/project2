
import java.util.ArrayList;
import java.util.Collections;
/**
 * @author Luis Aburto, M. Fernanda Matera, Jose F. Riffo
 * @version 

*/
public class Horario {
       
    private ArrayList<Actividad> actividades;
    
    public Horario(){
        this.actividades = new ArrayList <Actividad>();
    }
    /**
     * 
     * @param nuevaActividad corresponde a una variable del tipo Clase Actividad
     * @return retorna un false si la nueva actividad existe, si choca con el con el bloque y dia en la misma Aula o un true si no lo esta
     */
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
    /**
     * 
     * @return retorna un entero con el tamaño del arraylist de actividades, y se le resta a 50 para sacar la cantidad de bloques disponibles
     */
    public int bloquesLibres()
    {
        return (50-(this.actividades.size()));
    }
    /**
     * 
     * @param eliminarActividad 
     * @return 
     */
    public boolean eliminarBloque(Actividad eliminarActividad)
    {
       eliminarActividad.setSalaAsignada(false);
       return this.actividades.remove(eliminarActividad);
    }
    /**
     * 
     * @param dia Es un Enum del tipo Dia, corresponde al dia de la actividad que se quiere obtener
     * @param bloques Es un numero entero, corresponde a los bloques de la actividad
     * @return Se retorna la clase Actividad existente, se obtiene la actividad deseada
     */
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
    /**
     * 
     * @return devuelve un String string contiene el ArrayList actividades en forma de String, hace la conversión de las variables
     */
    @Override
    public String toString(){
        String string = "";
        Collections.sort(this.actividades);
        for (int i=0; i < this.actividades.size(); i++){
            string += this.actividades.get(i).toString() + "\n";
        }
        
        return string;
    }
    /**
     * 
     * @return devuelve un String (save), que contiene el ArrayList actividades en forma de String de forma ordenada
     */
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