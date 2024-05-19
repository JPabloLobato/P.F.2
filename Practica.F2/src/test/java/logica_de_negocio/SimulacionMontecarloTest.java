package logica_de_negocio;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulacionMontecarloTest {

    @Test
    public void testEjecutarSimulacion() {
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

        double[] resultados = SimulacionMontecarlo.ejecutarSimulacion(experimento, 1000);

        // Verificar que la simulación devuelve el número correcto de resultados
        assertEquals(1000, resultados.length);
    }
}