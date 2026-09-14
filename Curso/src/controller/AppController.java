
package Controller;

// Importamos JOptionPane para mostrar mensajes.
import javax.swing.JOptionPane;

// Importamos las clases del modelo.
import model.CursoModel;

// Esta clase conecta la interfaz con el modelo.
public class AppController {

    // Guardamos una referencia al modelo.
    private CursoModel model;

    // Constructor del controlador.
    public AppController(CursoModel model) {

        // Recibimos el modelo y lo guardamos.
        this.model = model;
    }

    // Método para registrar un curso.
    public void registrarCurso(String codigo, String nombre, String tutor) {

        // Verificamos que ningún campo esté vacío.
        if (codigo.isEmpty() || nombre.isEmpty() || tutor.isEmpty()) {

            // Mostramos un mensaje indicando el error.
            JOptionPane.showMessageDialog(
                    null,
                    "Todos los campos del curso son obligatorios."
            );

            // Terminamos el método.
            return;
        }

        // Enviamos los datos directamente al modelo.
        boolean registrado = model.registrarCurso(
                codigo,
                nombre,
                tutor
        );

        // Verificamos si el registro fue exitoso.
        if (registrado) {

            // Mostramos mensaje de confirmación.
            JOptionPane.showMessageDialog(
                    null,
                    "Curso registrado correctamente."
            );

        } else {

            // Avisamos si el arreglo está lleno.
            JOptionPane.showMessageDialog(
                    null,
                    "No hay espacio para registrar más cursos."
            );
        }
    }

    // Método para registrar una tarea.
    public void registrarTarea(
            String titulo,
            String descripcion,
            String fechaEntrega,
            String codigoCurso) {

        // Verificamos que ningún campo esté vacío.
        if (titulo.isEmpty()
                || descripcion.isEmpty()
                || fechaEntrega.isEmpty()
                || codigoCurso.isEmpty()) {

            // Mostramos mensaje de error.
            JOptionPane.showMessageDialog(
                    null,
                    "Todos los campos de la tarea son obligatorios."
            );

            // Terminamos el método.
            return;
        }

        // Verificamos que el curso indicado exista.
        boolean cursoExiste = false;

        // Recorremos los cursos registrados.
        for (int i = 0; i < model.getCantidadCursos(); i++) {

            // Comparamos el código escrito con el código del curso.
            if (model.getCursos()[i].getCodigo().equals(codigoCurso)) {

                // Encontramos el curso.
                cursoExiste = true;

                // Ya no necesitamos seguir buscando.
                break;
            }
        }

        // Si el curso no existe, no registramos la tarea.
        if (!cursoExiste) {

            // Mostramos el mensaje de error.
            JOptionPane.showMessageDialog(
                    null,
                    "El código del curso no existe."
            );

            // Terminamos el método.
            return;
        }

        // Enviamos los datos directamente al modelo.
        boolean registrada = model.registrarTarea(
                titulo,
                descripcion,
                fechaEntrega,
                codigoCurso
        );

        // Verificamos si se pudo guardar.
        if (registrada) {

            // Mostramos mensaje de confirmación.
            JOptionPane.showMessageDialog(
                    null,
                    "Tarea registrada correctamente."
            );

        } else {

            // Avisamos si el arreglo está lleno.
            JOptionPane.showMessageDialog(
                    null,
                    "No hay espacio para registrar más tareas."
            );
        }
    }
}




