
package model;

// Esta clase administra los cursos y las tareas del programa.
public class CursoModel {

    // Arreglo donde se almacenarán los cursos.
    private Curso[] cursos;

    // Arreglo donde se almacenarán las tareas.
    private TareaAcademica[] tareas;

    // Cantidad de cursos registrados.
    private int cantidadCursos;

    // Cantidad de tareas registradas.
    private int cantidadTareas;

    // Cantidad máxima de cursos que podremos guardar.
    private static final int MAX_CURSOS = 100;

    // Cantidad máxima de tareas que podremos guardar.
    private static final int MAX_TAREAS = 100;

    // Constructor del modelo.
    public CursoModel() {

        // Creamos el arreglo de cursos.
        cursos = new Curso[MAX_CURSOS];

        // Creamos el arreglo de tareas.
        tareas = new TareaAcademica[MAX_TAREAS];

        // Al comenzar no hay cursos.
        cantidadCursos = 0;

        // Al comenzar no hay tareas.
        cantidadTareas = 0;
    }

    // Registra un nuevo curso.
    public boolean registrarCurso(String codigo, String nombre, String tutor) {

        // Verificamos que todavía haya espacio.
        if (cantidadCursos >= MAX_CURSOS) {
            return false;
        }

        // Creamos el nuevo curso.
        Curso nuevoCurso = new Curso(codigo, nombre, tutor);

        // Lo guardamos en el arreglo.
        cursos[cantidadCursos] = nuevoCurso;

        // Aumentamos la cantidad de cursos.
        cantidadCursos++;

        return true;
    }

    // Registra una nueva tarea.
    public boolean registrarTarea(
            String titulo,
            String descripcion,
            String fechaEntrega,
            String codigoCurso) {

        // Verificamos que todavía haya espacio.
        if (cantidadTareas >= MAX_TAREAS) {
            return false;
        }

        // Creamos la nueva tarea.
        TareaAcademica nuevaTarea = new TareaAcademica(
                titulo,
                descripcion,
                fechaEntrega,
                codigoCurso
        );

        // La guardamos en el arreglo.
        tareas[cantidadTareas] = nuevaTarea;

        // Aumentamos la cantidad de tareas.
        cantidadTareas++;

        return true;
    }

    // Devuelve el arreglo de cursos.
    public Curso[] getCursos() {
        return cursos;
    }

    // Devuelve la cantidad de cursos registrados.
    public int getCantidadCursos() {
        return cantidadCursos;
    }

    // Devuelve el arreglo de tareas.
    public TareaAcademica[] getTareas() {
        return tareas;
    }

    // Devuelve la cantidad de tareas registradas.
    public int getCantidadTareas() {
        return cantidadTareas;
    }
}

