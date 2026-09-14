
package model;

// Esta clase representa un curso dentro del sistema.
public class Curso {

    // Guarda el código del curso.
    private String codigo;

    // Guarda el nombre del curso.
    private String nombre;

    // Guarda el nombre del tutor responsable.
    private String tutor;

    // Constructor de la clase Curso.
    // Recibe los datos necesarios para crear un curso.
    public Curso(String codigo, String nombre, String tutor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tutor = tutor;
    }

    // Devuelve el código del curso.
    public String getCodigo() {
        return codigo;
    }

    // Permite modificar el código del curso.
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // Devuelve el nombre del curso.
    public String getNombre() {
        return nombre;
    }

    // Permite modificar el nombre del curso.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Devuelve el tutor responsable.
    public String getTutor() {
        return tutor;
    }

    // Permite modificar el tutor responsable.
    public void setTutor(String tutor) {
        this.tutor = tutor;
    }
}


