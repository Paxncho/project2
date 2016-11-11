
import java.util.ArrayList;

public class Laboratorio {

    private String nombre;
    private ArrayList<Demanda> demandas;
    private ArrayList<String> instrumentos;

    public Laboratorio(String nombre) {
        this.nombre = nombre;
        this.demandas = new ArrayList<>();
        this.instrumentos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int cantidadDemandas() {
        return demandas.size();
    }

    public Demanda obtenerDemanda(int index) {
        return demandas.get(index);
    }

    public boolean agregarDemanda(Demanda demanda) {
        return demandas.add(demanda);
    }

    public boolean quitarDemanda(Demanda demanda) {
        return demandas.remove(demanda);
    }

    public int cantidadInstrumentos() {
        return instrumentos.size();
    }

    public String obtenerInstrumento(int index) {
        return instrumentos.get(index);
    }

    public boolean agregarInstrumento(String instrumento) {
        return instrumentos.add(instrumento);
    }

    public boolean quitarInstrumento(String instrumento) {
        return instrumentos.remove(instrumento);
    }

}
