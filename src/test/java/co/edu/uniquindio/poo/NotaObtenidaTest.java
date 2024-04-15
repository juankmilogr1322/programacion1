package co.edu.uniquindio.poo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NotaObtenidaTest {

    @Test
    public void constructor_Valido() {

        NotaParcial notaParcial = new NotaParcial("Parcial 1", 0.3);

        NotaObtenida notaObtenida = new NotaObtenida(notaParcial, 4.5);

        Assertions.assertEquals(notaParcial, notaObtenida.getNotaParcial());
        Assertions.assertEquals(4.5, notaObtenida.getNotaObtenida());
    }

    @Test
    public void constructor_NotaMenorQueCero() {

        NotaParcial notaParcial = new NotaParcial("Parcial 1", 0.3);

        Assertions.assertThrows(IllegalArgumentException.class, () -> new NotaObtenida(notaParcial, -1.0));
    }

    @Test
    public void constructor_NotaMayorQueCinco() {

        NotaParcial notaParcial = new NotaParcial("Parcial 1", 0.3);

        Assertions.assertThrows(IllegalArgumentException.class, () -> new NotaObtenida(notaParcial, 6.0));
    }

    @Test
    public void setNotaObtenida_Valido() {

        NotaParcial notaParcial = new NotaParcial("Parcial 1", 0.3);
        NotaObtenida notaObtenida = new NotaObtenida(notaParcial, 4.5);

        notaObtenida.setNotaObtenida(3.5);

        Assertions.assertEquals(3.5, notaObtenida.getNotaObtenida());
    }

    @Test
    public void setNotaObtenida_NotaMenorQueCero() {

        NotaParcial notaParcial = new NotaParcial("Parcial 1", 0.3);
        NotaObtenida notaObtenida = new NotaObtenida(notaParcial, 4.5);

        Assertions.assertThrows(IllegalArgumentException.class, () -> notaObtenida.setNotaObtenida(-1.0));
    }

    @Test
    public void setNotaObtenida_NotaMayorQueCinco() {

        NotaParcial notaParcial = new NotaParcial("Parcial 1", 0.3);
        NotaObtenida notaObtenida = new NotaObtenida(notaParcial, 4.5);

        Assertions.assertThrows(IllegalArgumentException.class, () -> notaObtenida.setNotaObtenida(6.0));
    }
}