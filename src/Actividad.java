
public class Actividad {

    private String id;
    private String ramo;
    private int bloque;
    private Dia dia;
    private TipoActividad tipo;
    private Aula aulaAsignada;

    public Actividad(String ramo, int bloque, Dia dia, TipoActividad tipo, String id, Aula aulaAsignada) {
        this.id = id;
        this.ramo = ramo;
        this.bloque = bloque;
        this.dia = dia;
        this.tipo = tipo;
        this.aulaAsignada = aulaAsignada;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public TipoActividad getTipo() {
        return tipo;
    }

    public void setActividad(TipoActividad tipo) {
        this.tipo = tipo;
    }

    public Aula getAulaAsignada() {
        return aulaAsignada;
    }

    public void setAulaAsignada(Aula aulaAsignada) {
        this.aulaAsignada = aulaAsignada;
    }
    
 }
