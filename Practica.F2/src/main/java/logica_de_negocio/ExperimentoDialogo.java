package logica_de_negocio;

import persistencia.GestorDatos;

import javax.swing.*;
import java.awt.*;

public class ExperimentoDialogo extends JDialog {
    private final Experimento experimento;
    private JTextArea txtAreaDetalles;
    private JButton btnGuardar;
    private JButton btnGuardarComo;

    public ExperimentoDialogo(Experimento experimento) {
        this.experimento = experimento;
        setTitle("Información del experimento");
        setSize(600, 400);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setModal(true);

        txtAreaDetalles = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(txtAreaDetalles);

        btnGuardar = new JButton("Guardar");
        btnGuardarComo = new JButton("Guardar como");

        btnGuardar.addActionListener(e -> guardarExperimento());
        btnGuardarComo.addActionListener(e -> guardarComo());

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnGuardar);
        panelBotones.add(btnGuardarComo);

        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        cargarDetalles();
    }

    private void cargarDetalles() {
        StringBuilder detalles = new StringBuilder();
        detalles.append("Nombre del experimento: ").append(experimento.getNombre()).append("\n");
        detalles.append("Duración: ").append(experimento.getDuracion()).append("\n");
        detalles.append("Poblaciones:\n");

        for (Poblacion poblacion : experimento.getPoblaciones()) {
            detalles.append("Nombre de la población: ").append(poblacion.getNombre()).append("\n");
            detalles.append("Fecha de inicio: ").append(poblacion.getFechaInicio()).append("\n");
            detalles.append("Fecha de fin: ").append(poblacion.getFechaFin()).append("\n");
            detalles.append("Número de bacterias iniciales: ").append(poblacion.getNumBacteriasIniciales()).append("\n");
            detalles.append("Temperatura: ").append(poblacion.getTemperatura()).append("\n");
            detalles.append("Luminosidad: ").append(poblacion.getLuminosidad()).append("\n");
            detalles.append("Comida inicial: ").append(poblacion.getComidaInicial()).append("\n");
            detalles.append("Día de incremento de comida: ").append(poblacion.getDiaIncrementoComida()).append("\n");
            detalles.append("Comida día incremento: ").append(poblacion.getComidaDiaIncremento()).append("\n");
            detalles.append("Comida final: ").append(poblacion.getComidaFinal()).append("\n");
            detalles.append("Patrón de comida: ").append(poblacion.getPatronDeComida() != null ? poblacion.getPatronDeComida().getClass().getSimpleName() : "null").append("\n\n");
        }

        txtAreaDetalles.setText(detalles.toString());
    }

    /**
     * Este método recoge los detalles del experimento desde la UI de usuario
     * y llama al método guardarExperimentos() de la clase GestorDatos para guardar estos
     * detalles en un archivo.
     */
    private void guardarExperimento() {
        try {
            String[] lineas = txtAreaDetalles.getText().split("\n");
            experimento.setNombre(obtenerValorDeLinea(lineas[0], "Nombre del experimento: "));
            experimento.setDuracion(Integer.parseInt(obtenerValorDeLinea(lineas[1], "Duración: ")));

            experimento.getPoblaciones().clear();
            for (int i = 3; i < lineas.length; i += 12) {
                Poblacion poblacion = new Poblacion();
                poblacion.setNombre(obtenerValorDeLinea(lineas[i], "Nombre de la población: "));
                poblacion.setFechaInicio(obtenerValorDeLinea(lineas[i + 1], "Fecha de inicio: "));
                poblacion.setFechaFin(obtenerValorDeLinea(lineas[i + 2], "Fecha de fin: "));
                poblacion.setNumBacteriasIniciales(Integer.parseInt(obtenerValorDeLinea(lineas[i + 3], "Número de bacterias iniciales: ")));
                poblacion.setTemperatura(Double.parseDouble(obtenerValorDeLinea(lineas[i + 4], "Temperatura: ")));
                poblacion.setLuminosidad(obtenerValorDeLinea(lineas[i + 5], "Luminosidad: "));
                poblacion.setComidaInicial(Integer.parseInt(obtenerValorDeLinea(lineas[i + 6], "Comida inicial: ")));
                poblacion.setDiaIncrementoComida(Integer.parseInt(obtenerValorDeLinea(lineas[i + 7], "Día de incremento de comida: ")));
                poblacion.setComidaDiaIncremento(Integer.parseInt(obtenerValorDeLinea(lineas[i + 8], "Comida día incremento: ")));
                poblacion.setComidaFinal(Integer.parseInt(obtenerValorDeLinea(lineas[i + 9], "Comida final: ")));

                // Seleciona el praton de comida nuevo.
                String patron = obtenerValorDeLinea(lineas[i + 10], "Patrón de comida: ");
                PatronDeComida patronDeComida;
                switch (patron) {
                    case "PatronAlimentacionConstante":
                        patronDeComida = new PatronAlimentacionConstante(poblacion.getComidaInicial());
                        break;
                    case "PatronAlimentacionIncremento":
                        patronDeComida = new PatronAlimentacionIncremento(poblacion.getComidaInicial(), poblacion.getComidaFinal(), experimento.getDuracion());
                        break;
                    case "PatronAlimentacionAlterno":
                        patronDeComida = new PatronAlimentacionAlterno(poblacion.getComidaInicial());
                        break;
                    case "PatronAlimentacionDecrementoIncremento":
                        patronDeComida = new PatronAlimentacionDecrementoIncremento(poblacion.getComidaInicial(), poblacion.getComidaFinal(), experimento.getDuracion());
                        break;
                    default:
                        patronDeComida = null;
                }
                poblacion.setPatronDeComida(patronDeComida);

                experimento.getPoblaciones().add(poblacion);
            }

            GestorDatos.guardarExperimentos(experimento.getNombre() + ".txt", experimento);
            JOptionPane.showMessageDialog(this, "Experimento guardado.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar el experimento: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void guardarComo() {
        try {
            String nuevoNombre = JOptionPane.showInputDialog(this, "Introduce el nuevo nombre para el experimento:", experimento.getNombre());
            if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
                experimento.setNombre(nuevoNombre);
                guardarExperimento();
            } else {
                JOptionPane.showMessageDialog(this, "Error: se esperaba un nombre de experimento.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar el experimento: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String obtenerValorDeLinea(String linea, String prefijo) {
        if (linea.startsWith(prefijo)) {
            return linea.substring(prefijo.length()).trim();
        } else {
            throw new IllegalArgumentException("Línea no coincide con el prefijo esperado: " + prefijo);
        }
    }
}
