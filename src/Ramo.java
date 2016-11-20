public class Ramo {
    private String nombre;
    private int cantidadAlumnos;

    public Ramo(String nombre, int cantidadAlumnos) {
        this.nombre = nombre;
        this.cantidadAlumnos = cantidadAlumnos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public void setCantidadAlumnos(int cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }
    public String toString()
    {
        return "Nombre: " + nombre + "\n" +
               "Cantidad de Alumnos: " + cantidadAlumnos + "\n";
    }
}
