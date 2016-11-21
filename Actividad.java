public class Actividad implements Comparable<Actividad>{

    private Ramo ramo;
    private int bloque;
    private Dia dia;
    private TipoSala tipoRequerido;
    private boolean salaAsignada;

    public Actividad(Ramo ramo, int bloque, Dia dia, TipoSala tipoRequerido) {
        this.ramo = ramo;
        this.bloque = bloque;
        this.dia = dia;
        this.tipoRequerido = tipoRequerido;
        this.salaAsignada = false;
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

    public TipoSala getTipoRequerido() {
        return tipoRequerido;
    }

    public void setTipoRequerido(TipoSala tipoRequerido) {
        this.tipoRequerido = tipoRequerido;
    }
    
    public void setSalaAsignada (boolean salaAsignada)
    {
        this.salaAsignada = salaAsignada;
    }
    public boolean isSalaAsignada ()
    {
        return this.salaAsignada;
    }
    public String toString()
    {
        return ramo.toString() +
               "Dia: " + dia.toString() + "\n" +
               "Bloque: " + bloque + "\n" + 
               "Tipo de Aula Requerida: " + tipoRequerido + "\n";
    }

    @Override
    public int compareTo(Actividad actividadComparar) {
        if (this.dia.ordinal() < actividadComparar.getDia().ordinal()){
            return 1;
        } else if (this.dia.ordinal() > actividadComparar.getDia().ordinal()){
            return -1;
        } else {
            if (this.bloque < actividadComparar.getBloque()){
                return 1;
            } else if (this.bloque > actividadComparar.getBloque()){
                return -1;
            } else {
                return 0;
            }
        }
    }
    
    public String toSave(){
        return ramo.toSave() + "\n" +
               dia.toString() + "\n" +
               bloque + "\n" +
               tipoRequerido + "\n";
    }
}
