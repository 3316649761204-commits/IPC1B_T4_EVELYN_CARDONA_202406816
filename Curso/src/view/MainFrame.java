
package view;

import Controller.AppController;
import model.Curso;
import model.CursoModel;
import model.TareaAcademica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    // Instancias del modelo y controlador
    private CursoModel modelo;
    private AppController controlador;

    // Campos Módulo Cursos
    private JTextField txtCodCurso, txtNomCurso, txtTutorCurso;
    private JButton btnRegistrarCurso;

    // Campos Módulo Tareas
    private JTextField txtTituloTarea, txtDescTarea, txtFechaTarea, txtCodCursoTarea;
    private JButton btnRegistrarTarea;

    // Botón de Visualización
    private JButton btnMostrarInfo;

    // Campos Módulo Conversión
    private JTextField txtCelsius;
    private JButton btnFahrenheit, btnKelvin;

    // Área de texto para mostrar información
    private JTextArea txtAreaReportes;

    public MainFrame() {
        // Inicializar modelo y controlador
        modelo = new CursoModel();
        controlador = new AppController(modelo);

        // Configuración de la ventana principal
        setTitle("Gestión de Cursos, Tareas y Conversor");
        setSize(850, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // --- PANEL SUPERIOR ---
        JPanel panelSuperior = new JPanel(new GridLayout(1, 3, 10, 10));

        // 1. Módulo Cursos
        JPanel panelCursos = new JPanel(new GridLayout(4, 2, 5, 5));
        panelCursos.setBorder(BorderFactory.createTitledBorder("Módulo de Cursos"));
        panelCursos.add(new JLabel("Código:"));
        txtCodCurso = new JTextField();
        panelCursos.add(txtCodCurso);
        panelCursos.add(new JLabel("Nombre:"));
        txtNomCurso = new JTextField();
        panelCursos.add(txtNomCurso);
        panelCursos.add(new JLabel("Tutor:"));
        txtTutorCurso = new JTextField();
        panelCursos.add(txtTutorCurso);
        
        btnRegistrarCurso = new JButton("Registrar Curso");
        btnRegistrarCurso.addActionListener(this); // Asignación directa del evento
        panelCursos.add(new JLabel("")); 
        panelCursos.add(btnRegistrarCurso);

        // 2. Módulo Tareas
        JPanel panelTareas = new JPanel(new GridLayout(5, 2, 5, 5));
        panelTareas.setBorder(BorderFactory.createTitledBorder("Módulo de Tareas"));
        panelTareas.add(new JLabel("Título:"));
        txtTituloTarea = new JTextField();
        panelTareas.add(txtTituloTarea);
        panelTareas.add(new JLabel("Descripción:"));
        txtDescTarea = new JTextField();
        panelTareas.add(txtDescTarea);
        panelTareas.add(new JLabel("Fecha entrega:"));
        txtFechaTarea = new JTextField();
        panelTareas.add(txtFechaTarea);
        panelTareas.add(new JLabel("Código curso:"));
        txtCodCursoTarea = new JTextField();
        panelTareas.add(txtCodCursoTarea);
        
        btnRegistrarTarea = new JButton("Registrar Tarea");
        btnRegistrarTarea.addActionListener(this); // Asignación directa del evento
        panelTareas.add(new JLabel("")); 
        panelTareas.add(btnRegistrarTarea);

        // 3. Módulo de Visualización
        JPanel panelMostrar = new JPanel(new GridBagLayout());
        panelMostrar.setBorder(BorderFactory.createTitledBorder("Visualización"));
        btnMostrarInfo = new JButton("Mostrar información");
        btnMostrarInfo.setPreferredSize(new Dimension(160, 40));
        btnMostrarInfo.addActionListener(this); // Asignación directa del evento
        panelMostrar.add(btnMostrarInfo);

        panelSuperior.add(panelCursos);
        panelSuperior.add(panelTareas);
        panelSuperior.add(panelMostrar);

        add(panelSuperior, BorderLayout.NORTH);

        // --- PANEL CENTRAL ---
        txtAreaReportes = new JTextArea();
        txtAreaReportes.setEditable(false);
        JScrollPane scrollArea = new JScrollPane(txtAreaReportes);
        scrollArea.setBorder(BorderFactory.createTitledBorder("Información Registrada"));
        add(scrollArea, BorderLayout.CENTER);

        // --- PANEL INFERIOR: Conversión ---
        JPanel panelConversion = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panelConversion.setBorder(BorderFactory.createTitledBorder("Módulo de Conversión de Temperatura"));
        panelConversion.add(new JLabel("Celsius (°C):"));
        txtCelsius = new JTextField(8);
        panelConversion.add(txtCelsius);

        btnFahrenheit = new JButton("Convertir a Fahrenheit");
        btnKelvin = new JButton("Convertir a Kelvin");
        
        btnFahrenheit.addActionListener(this); // Asignación directa del evento
        btnKelvin.addActionListener(this);     // Asignación directa del evento
        
        panelConversion.add(btnFahrenheit);
        panelConversion.add(btnKelvin);

        add(panelConversion, BorderLayout.SOUTH);
    }

    // Método único para capturar los eventos de todos los botones
    public void actionPerformed(ActionEvent e) {
        Object origen = e.getSource();

        if (origen == btnRegistrarCurso) {
            controlador.registrarCurso(
                txtCodCurso.getText().trim(),
                txtNomCurso.getText().trim(),
                txtTutorCurso.getText().trim()
            );
            txtCodCurso.setText("");
            txtNomCurso.setText("");
            txtTutorCurso.setText("");

        } else if (origen == btnRegistrarTarea) {
            controlador.registrarTarea(
                txtTituloTarea.getText().trim(),
                txtDescTarea.getText().trim(),
                txtFechaTarea.getText().trim(),
                txtCodCursoTarea.getText().trim()
            );
            txtTituloTarea.setText("");
            txtDescTarea.setText("");
            txtFechaTarea.setText("");
            txtCodCursoTarea.setText("");

        } else if (origen == btnMostrarInfo) {
            mostrarInformacion();

        } else if (origen == btnFahrenheit) {
            convertirTemperatura(true);

        } else if (origen == btnKelvin) {
            convertirTemperatura(false);
        }
    }

    private void mostrarInformacion() {
        StringBuilder sb = new StringBuilder();

        sb.append("===== CURSOS =====\n\n");
        if (modelo.getCantidadCursos() == 0) {
            sb.append("No hay cursos registrados.\n");
        } else {
            for (int i = 0; i < modelo.getCantidadCursos(); i++) {
                Curso c = modelo.getCursos()[i];
                sb.append("Código: ").append(c.getCodigo()).append("\n")
                  .append("Nombre: ").append(c.getNombre()).append("\n")
                  .append("Tutor: ").append(c.getTutor()).append("\n\n");
            }
        }

        sb.append("===== TAREAS =====\n\n");
        if (modelo.getCantidadTareas() == 0) {
            sb.append("No hay tareas registradas.\n");
        } else {
            for (int i = 0; i < modelo.getCantidadTareas(); i++) {
                TareaAcademica t = modelo.getTareas()[i];
                sb.append("Título: ").append(t.getTitulo()).append("\n")
                  .append("Descripción: ").append(t.getDescripcion()).append("\n")
                  .append("Fecha entrega: ").append(t.getFechaEntrega()).append("\n")
                  .append("Código curso asociado: ").append(t.getCodigoCurso()).append("\n\n");
            }
        }

        txtAreaReportes.setText(sb.toString());
    }

    private void convertirTemperatura(boolean esFahrenheit) {
        String texto = txtCelsius.getText().trim();

        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un valor numérico para la temperatura en Celsius.", "Campo Vacío", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double celsius = Double.parseDouble(texto);
            if (esFahrenheit) {
                double fahrenheit = (celsius * 9.0 / 5.0) + 32;
                JOptionPane.showMessageDialog(this, celsius + " °C equivalen a " + fahrenheit + " °F", "Resultado Conversión", JOptionPane.INFORMATION_MESSAGE);
            } else {
                double kelvin = celsius + 273.15;
                JOptionPane.showMessageDialog(this, celsius + " °C equivalen a " + kelvin + " K", "Resultado Conversión", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese únicamente datos numéricos válidos para la temperatura.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }
}





