package logica_de_negocio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ComidaDialogo extends JDialog {
    public ComidaDialogo(Poblacion poblacion) {
        setTitle("Comida Diaria");
        setSize(300, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        String[] columnNames = {"Día", "Comida"};
        Object[][] data = new Object[30][2];
        for (int i = 0; i < 30; i++) {
            data[i][0] = i + 1;
            data[i][1] = poblacion.getPatronDeComida().getFoodAmount(i + 1);
        }

        JTable tablaComida = new JTable();
        tablaComida.setModel(new DefaultTableModel(data, columnNames));
        JScrollPane scrollPane = new JScrollPane(tablaComida);

        add(scrollPane, BorderLayout.CENTER);
    }
}
