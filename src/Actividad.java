
/**
 * @author Luis Aburto, M. Fernanda Matera, Jose F. Riffo
 * @version 
*/




public class Actividad implements Comparable<Actividad>{

    private Ramo ramo;
    private int bloque;
    private Dia dia;
    private TipoSala tipoRequerido;
    private boolean salaAsignada;
    
    
    /**
     * 
     * Se inician los atributos
     * @param ramo Corresponde al ramo al que pertenece la actividad
     * @param bloque Correspoende al 
     * @param dia  Es el día de la Semana en el que se imparte la actividad
     * @param tipoRequerido Se refiere al tipo de sala donde se realizará la (Sala/Laboratorio) Actividad
     */

    public Actividad(Ramo ramo, int bloque, Dia dia, TipoSala tipoRequerido) {
        this.ramo = ramo;
        this.bloque = bloque;
        this.dia = dia;
        this.tipoRequerido = tipoRequerido;
        this.salaAsignada = false;
    }
    /**
     * 
     * @return retorna el valor que tiene ramo (nombre y cantidad de alumnos) de la Actividad que se asignó
     */
    public Ramo getRamo() {
        return ramo;
    }
    /**
     * 
     * @param ramo Se define el ramo de la Actividad 
     */
    public void setRamo(Ramo ramo) {
        this.ramo = ramo;
    }
    /**
     * 
     * @return Retorna un entero correspondiente al bloque 
     */
    public int getBloque() {
        return bloque;
    }
    /**
     * 
     * @param bloque se define como bloque en el que estará la actividad
     */
    public void setBloque(int bloque) {
        this.bloque = bloque;
    }
    /**
     * 
     * @return Se devuelve el valor del dia (un enum), LUNES, MARTES, MIERCOLES, JUEVES,  VIERNES
     */
    public Dia getDia() {
        return dia;
    }
    /**
     * 
     * @param dia se establece el día
     */
    public void setDia(Dia dia) {
        this.dia = dia;
    }
    /**
     * 
     * @return devuele un tipo, en este caso devolvería SALA o LABORATORIO
     */
    public TipoSala getTipoRequerido() {
        return tipoRequerido;
    }
    /**
     * 
     * @param tipoRequerido Se Establece el tipo de Aula donde se realizá la Actividad
     */
    public void setTipoRequerido(TipoSala tipoRequerido) {
        this.tipoRequerido = tipoRequerido;
    }
    /**
     * 
     * @param salaAsignada Se le da un valor true o false
     */
    public void setSalaAsignada (boolean salaAsignada)
    {
        this.salaAsignada = salaAsignada;
    }
    
    /**
     * 
     * @return devuelve un true o un false, esto indicará si se tiene una Aula asignada en la Actividad
     */
    public boolean isSalaAsignada ()
    {
        return this.salaAsignada;
    }
    
    /**
     * 
     * @return Devuelve los datos que no son String, en String para poder pasarlos al archivo Excel
     */
    public String toString()
    {
        return ramo.toString() +
               "Dia: " + dia.toString() + "\n" +
               "Bloque: " + bloque + "\n" + 
               "Tipo de Aula Requerida: " + tipoRequerido + "\n";
    }
    /**
     * 
     * @param actividadComparar 
     * @return 
     */
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
    
    /**
     * 
     * @return 
     */
    public String toSave(){
        return ramo.toSave() + "\n" +
               dia.toString() + "\n" +
               bloque + "\n" +
               tipoRequerido + "\n";
    }
}
