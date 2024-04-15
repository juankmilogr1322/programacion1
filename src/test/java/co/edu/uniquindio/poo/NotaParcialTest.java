package co.edu.uniquindio.poo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NotaParcialTest {

    @Test
    public void constructor_Valido() {

        NotaParcial notaParcial = new NotaParcial("Parcial 1", 0.3);

        Assertions.assertEquals("Parcial 1", notaParcial.nombre());
        Assertions.assertEquals(0.3, notaParcial.porcentaje());
    }

    @Test
    public void constructor_NombreNulo() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> new NotaParcial(null, 0.3));
    }

    @Test
    public void constructor_NombreVacio() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> new NotaParcial("", 0.3));
    }

    @Test
    public void constructor_PorcentajeNegativo() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> new NotaParcial("Parcial 1", -0.3));
    }

    @Test
    public void constructor_PorcentajeMayorQueCien() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> new NotaParcial("Parcial 1", 1.1));
    }
}
