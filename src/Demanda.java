
public class Demanda {

    private String ramo;
    private int bloque;
    private Dia dia;
    private TipoActividad actividad;

    public Demanda(String ramo, int bloque, Dia dia, TipoActividad actividad) {
        this.ramo = ramo;
        this.bloque = bloque;
        this.dia = dia;
        this.actividad = actividad;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public int getBloque() {
        return bloque;
    }

    public void setBloque(int bloque) {
        this.bloque = bloque;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public TipoActividad getActividad() {
        return actividad;
    }

    public void setActividad(TipoActividad actividad) {
        this.actividad = actividad;
    }
}
