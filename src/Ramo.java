
/**
 * @author Luis Aburto, M. Fernanda Matera, Jose F. Riffo
 * @version 

*/

public class Ramo {
    private String nombre;
    private int cantidadAlumnos;
    /**
     * 
     * @param nombre Es un String, y corresponde al nombre del ramo que se esta impartiendo
     * @param cantidadAlumnos Es un numero entero, corresponde a la cantidad de alumnos del curso
     */
    public Ramo(String nombre, int cantidadAlumnos) {
        this.nombre = nombre;
        this.cantidadAlumnos = cantidadAlumnos;
    }
    /**
     * 
     * @return retorna un String, con el nombre del ramo
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * 
     * @param nombre Es un String, situa el valor del nombre del ramo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * 
     * @return retorna un numero entero, con la cantidad del alumnos del curso
     */
    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }
    /**
     * 
     * @param cantidadAlumnos se asigna un numero entero a CantidadAlumnos, que será la cantidad de alumnos del curso
     */
    public void setCantidadAlumnos(int cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }
    /**
     * 
     * @return convierte las variables nombre y cantidadAlumnos en un String, para pasarlos al archivo Excel
     */
    @Override
    public String toString()
    {
        return "Nombre: " + nombre + "\n" +
               "Cantidad de Alumnos: " + cantidadAlumnos + "\n";
    }
    /**
     * 
     * @return 
     */
    public String toSave(){
        return nombre + "\n" +
               cantidadAlumnos + "\n";
    }
}
