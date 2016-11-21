/**
 * @author Luis Aburto, M. Fernanda Matera, Jose F. Riffo
 * @version 

*/
public abstract class Aula implements Comparable<Aula>{
    private String nombre;
    private Horario horario;
    private int capacidadAlumnos;
    /**
     * 
     * @param nombre corresponde al nombre de la sala
     * @param capacidadAlumnos  es un entero que indica la cantidad de alumnos que caben en el Aula
     */
    public Aula(String nombre, int capacidadAlumnos) {
        this.nombre = nombre;
        this.horario = new Horario();
        this.capacidadAlumnos = capacidadAlumnos;
    }
    /**
     * 
     * @return se duvuelve un String con el nombre del Aula
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * 
     * @param nombre se le asigna un String al nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * 
     * @return Se devuelve una clase Horario, con el horario correspondiente al Aula
     */
    public Horario getHorario (){
        return horario;
    }
    /**
     * 
     * @param horario Se define el horario del aula
     */
    public void setHorario (Horario horario){
        this.horario = horario;
    }
    /**
     * 
     * @return Se devuelve un entero, correspondiente a la capacidad de alumnos del aula
     */
    public int getCapacidadAlumnos () {
        return capacidadAlumnos;
    }
    /**
     * 
     * @param capacidadAlumnos Se le asigna un entero a capacidadAlumnos
     */
    public void setCapacidadAlumnos (int capacidadAlumnos)
    {
        this.capacidadAlumnos = capacidadAlumnos;        
    }
    /**
     * 
     * @param aula Es una variable del tipo clase Aula
     * @return 
     */
    @Override
    public int compareTo(Aula aula){
        return this.getNombre().compareTo(aula.getNombre());
    }
    /**
     * 
     * @return Se retornan las variables en forma de String, para más tarde pasarlas al archivo
     */
    @Override
    public String toString(){
        return "Nombre: " + nombre + "\n" +
               "Capacidad de Alumnos: " + capacidadAlumnos + "\n" +
                horario.toString();
    }
    /**
     * 
     * @return 
     */
    public String toSave(){
        return nombre + "\n" +
               capacidadAlumnos + "\n" +
               horario.toSave();
    }
}
