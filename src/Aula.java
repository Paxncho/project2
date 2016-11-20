
public abstract class Aula implements Comparable<Aula>{
    private String nombre;
    private Horario horario;
    private int capacidadAlumnos;
    
    public Aula(String nombre, int capacidadAlumnos) {
        this.nombre = nombre;
        this.horario = new Horario();
        this.capacidadAlumnos = capacidadAlumnos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Horario getHorario (){
        return horario;
    }
    
    public void setHorario (Horario horario){
        this.horario = horario;
    }
    
    public int getCapacidadAlumnos () {
        return capacidadAlumnos;
    }
    
    public void setCapacidadAlumnos (int capacidadAlumnos)
    {
        this.capacidadAlumnos = capacidadAlumnos;        
    }
    
    public int compareTo(Aula aula){
        return this.getNombre().compareTo(aula.getNombre());
    }
    
    public String toString(){
        return "Nombre: " + nombre + "\n" +
               "Capacidad de Alumnos: " + capacidadAlumnos + "\n" +
                horario.toString();
    }
}
