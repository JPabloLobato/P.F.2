package org.example.UI;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InterfazGraficaTest {

    private FrameFixture window;

    @BeforeEach
    public void setUp() {
        InterfazGrafica frame = GuiActionRunner.execute(() -> new InterfazGrafica());
        window = new FrameFixture(frame);
        window.show(); // muestra la ventana de la interfaz gráfica
    }

    @AfterEach
    public void tearDown() {
        window.cleanUp();
    }

    @Test
    public void testInterfazGrafica() {
        // Verificar la existencia de los botones
        window.button("btnAbrirArchivo").requireVisible();
        window.button("btnNuevoExperimento").requireVisible();
        window.button("btnAgregarPoblacion").requireVisible();
        window.button("btnVisualizarPoblaciones").requireVisible();
        window.button("btnBorrarPoblacion").requireVisible();
        window.button("btnVerDetalle").requireVisible();
        window.button("btnSimulacionMontecarlo").requireVisible();
    }
}

