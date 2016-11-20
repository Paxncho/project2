public class Actividad {

    private Ramo ramo;
    private int bloque;
    private Dia dia;
    private TipoSala tipoRequerido;

    public Actividad(Ramo ramo, int bloque, Dia dia, TipoSala tipoRequerido) {
        this.ramo = ramo;
        this.bloque = bloque;
        this.dia = dia;
        this.tipoRequerido = tipoRequerido;
    }
    
    public Ramo getRamo() {
        return ramo;
    }

    public void setRamo(Ramo ramo) {
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
}
