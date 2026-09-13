
package model;

// Esta clase representa una tarea académica.
public class TareaAcademica {

    // Guarda el título de la tarea.
    private String titulo;

    // Guarda la descripción de la tarea.
    private String descripcion;

    // Guarda la fecha de entrega de la tarea.
    private String fechaEntrega;

    // Guarda el código del curso al que pertenece la tarea.
    private String codigoCurso;

    // Constructor de la clase TareaAcademica.
    // Recibe todos los datos necesarios para crear una tarea.
    public TareaAcademica(String titulo, String descripcion,
            String fechaEntrega, String codigoCurso) {

        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaEntrega = fechaEntrega;
        this.codigoCurso = codigoCurso;
    }

    // Devuelve el título de la tarea.
    public String getTitulo() {
        return titulo;
    }

    // Permite modificar el título.
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Devuelve la descripción de la tarea.
    public String getDescripcion() {
        return descripcion;
    }

    // Permite modificar la descripción.
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Devuelve la fecha de entrega.
    public String getFechaEntrega() {
        return fechaEntrega;
    }

    // Permite modificar la fecha de entrega.
    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    // Devuelve el código del curso asociado.
    public String getCodigoCurso() {
        return codigoCurso;
    }

    // Permite modificar el código del curso.
    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }
}

