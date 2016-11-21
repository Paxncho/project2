
import java.util.ArrayList;
/**
 * @author Luis Aburto, M. Fernanda Matera, Jose F. Riffo
 * @version 

*/
public class Laboratorio extends Aula{
    
    private ArrayList<String> instrumentos;
    /**
     * 
     * @param nombre corresponde a un String, y se refiere al nombre del Laboratorio
     * @param capacidadAlumnos corresponde a un numero entereo, y corresponde a la capacidad de alumnos que caben en el Laboratorio
     */
    public Laboratorio(String nombre, int capacidadAlumnos) {
        super(nombre, capacidadAlumnos);
        this.instrumentos = new ArrayList<>();
    }
    /**
     * 
     * @param instrumento corresponde a un boolean, se refiere si el Laboratorio tiene un implemento
     * @return Agrega el nuevo instrumento
     */
    public boolean agregarInstrumento(String instrumento) {
        return instrumentos.add(instrumento);
    }
    /**
     * 
     * @param instrumento corresponde a un boolean, se refiere si el Laboratorio tiene un implemento
     * @return Elimina el instrumento 
     */
    public boolean eliminarInstrumento(String instrumento) {
        return instrumentos.remove(instrumento);
    }
    /**
     * 
     * @return corresponde al tamaño del ArrayList que posee los instrumentos, devuelve la cantidad de instrumentos del laboratorio
     */
    public int cantidadInstrumentos() {
        return instrumentos.size();
    }
    /**
     * 
     * @param index Es un numero entero, corresponde a la posicion del Isntrumento en el ArrayList
     * @return Se devuelve un String, con el Instrumento requerido
     */
    public String obtenerInstrumento(int index) {
        return instrumentos.get(index);
    }
    /**
     * 
     * @return  devuelve un String (save), que contiene el ArrayList instrumentos en forma de String de forma ordenada
     */
    @Override
    public String toSave(){
        String save = super.toSave();
        save += this.instrumentos.size() + "\n";
        for (String instrumento : this.instrumentos){
            save += instrumento + "\n";
        }
        
        return save;
    }
    
}
