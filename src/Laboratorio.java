
import java.util.ArrayList;

public class Laboratorio extends Aula{

    private ArrayList<String> instrumentos;

    public Laboratorio(String nombre, String id) {
        super(nombre, id);
        this.instrumentos = new ArrayList<String>();
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
    
}
