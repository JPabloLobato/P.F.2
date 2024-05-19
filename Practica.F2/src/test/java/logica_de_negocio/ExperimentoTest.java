package logica_de_negocio;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExperimentoTest {

    @Test
    public void testGettersAndSetters() {
        Experimento experimento = new Experimento();
        experimento.setNombre("Experimento1");
        experimento.setFechaInicio(LocalDate.of(2023, 1, 1));
        experimento.setDuracion(30);
        experimento.setFoodInMicrograms(300000);

        assertEquals("Experimento1", experimento.getNombre());
        assertEquals(LocalDate.of(2023, 1, 1), experimento.getFechaInicio());
        assertEquals(30, experimento.getDuracion());
        assertEquals(300000, experimento.getFoodInMicrograms());
    }
}