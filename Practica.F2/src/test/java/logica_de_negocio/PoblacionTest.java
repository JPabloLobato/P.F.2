package logica_de_negocio;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PoblacionTest {

    @Test
    public void testGettersAndSetters() {
        Poblacion poblacion = new Poblacion();
        poblacion.setNombre("Poblacion1");
        poblacion.setFechaInicio("01/01/2023");
        poblacion.setFechaFin("31/01/2023");
        poblacion.setNumBacteriasIniciales(1000);
        poblacion.setTemperatura(37.5);
        poblacion.setLuminosidad("Alta");
        poblacion.setComidaInicial(50000);
        poblacion.setDiaIncrementoComida(15);
        poblacion.setComidaDiaIncremento(2000);
        poblacion.setComidaFinal(60000);

        assertEquals("Poblacion1", poblacion.getNombre());
        assertEquals("01/01/2023", poblacion.getFechaInicio());
        assertEquals("31/01/2023", poblacion.getFechaFin());
        assertEquals(1000, poblacion.getNumBacteriasIniciales());
        assertEquals(37.5, poblacion.getTemperatura());
        assertEquals("Alta", poblacion.getLuminosidad());
        assertEquals(50000, poblacion.getComidaInicial());
        assertEquals(15, poblacion.getDiaIncrementoComida());
        assertEquals(2000, poblacion.getComidaDiaIncremento());
        assertEquals(60000, poblacion.getComidaFinal());
    }
}