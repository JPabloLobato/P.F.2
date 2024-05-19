package persistencia;

import logica_de_negocio.Experimento;
import logica_de_negocio.Poblacion;
import logica_de_negocio.PatronAlimentacionConstante;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GestorDatosTest {

    @Test
    public void testGuardarYCargarExperimento() {
        // Crear experimento y poblaciones
        Experimento experimento = new Experimento("TestExperimento", LocalDate.now(), 30, 300000, new PatronAlimentacionConstante(1000));
        Poblacion poblacion = new Poblacion();
        poblacion.setNombre("PoblacionTest");
        poblacion.setFechaInicio("01/01/2023");
        poblacion.setFechaFin("31/01/2023");
        poblacion.setNumBacteriasIniciales(1000);
        poblacion.setTemperatura(37.5);
        poblacion.setLuminosidad("Alta");
        poblacion.setComidaInicial(50000);
        poblacion.setDiaIncrementoComida(15);
        poblacion.setComidaDiaIncremento(2000);
        poblacion.setComidaFinal(60000);
        poblacion.setPatronDeComida(new PatronAlimentacionConstante(1000));
        experimento.getPoblaciones().add(poblacion);

        // Guardar experimento
        GestorDatos.guardarExperimentos("TestExperimento.txt", experimento);

        // Cargar experimento
        Experimento experimentoCargado = GestorDatos.cargarExperimento("TestExperimento");

        // Verificar datos
        assertNotNull(experimentoCargado);
        assertEquals(experimento.getNombre(), experimentoCargado.getNombre());
        assertEquals(experimento.getDuracion(), experimentoCargado.getDuracion());
        assertEquals(experimento.getPoblaciones().size(), experimentoCargado.getPoblaciones().size());

        // Verificar si el archivo existe
        File file = new File("./experimentos/TestExperimento.txt");
        assertTrue(file.exists());
    }
}