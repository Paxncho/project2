
import java.util.ArrayList;

public class Laboratorio extends Aula{

    private ArrayList<String> instrumentos;

    public Laboratorio(String nombre, int capacidadAlumnos) {
        super(nombre, capacidadAlumnos);
        this.instrumentos = new ArrayList<>();
    }

    public boolean agregarInstrumento(String instrumento) {
        return instrumentos.add(instrumento);
    }

    public boolean eliminarInstrumento(String instrumento) {
        return instrumentos.remove(instrumento);
    }
    
    public int cantidadInstrumentos() {
        return instrumentos.size();
    }

    public String obtenerInstrumento(int index) {
        return instrumentos.get(index);
    }
    
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
