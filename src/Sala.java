
import java.util.ArrayList;

public class Sala {

    private String nombre;
    private ArrayList<Demanda> demandas;

    public Sala(String nombre, ArrayList<Demanda> demandas) {
        this.nombre = nombre;
        this.demandas = demandas;
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

    public boolean tieneDemanda(Demanda demanda) {
        return demandas.contains(demanda);
    }

    public Demanda get(int index) {
        return demandas.get(index);
    }

    public boolean agregarDemanda(Demanda demanda) {
        return demandas.add(demanda);
    }

    public boolean quitarDemanda(Demanda demanda) {
        return demandas.remove(demanda);
    }

}
