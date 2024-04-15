package co.edu.uniquindio.poo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EstudianteTest {
    @Test
    public void agregarNotaObtenida_Valido() {

        Estudiante estudiante = new Estudiante("Juan", "Perez", "123456789", "juan@example.com", "1234567890", 20);
        NotaParcial notaParcial = new NotaParcial("Parcial 1", 0.3);
        NotaObtenida notaObtenida = new NotaObtenida(notaParcial, 0);

        estudiante.adicionarNotaObtenida(notaObtenida);

        Assertions.assertTrue(estudiante.getNotasObtenidas().contains(notaObtenida));
    }

    @Test
    public void agregarNotaObtenida_Repetida() {

        Estudiante estudiante = new Estudiante("Juan", "Perez", "123456789", "juan@example.com", "1234567890", 20);
        NotaParcial notaParcial = new NotaParcial("Parcial 1", 0.3);
        NotaObtenida notaObtenida1 = new NotaObtenida(notaParcial, 0);
        NotaObtenida notaObtenida2 = new NotaObtenida(notaParcial, 0);

        estudiante.adicionarNotaObtenida(notaObtenida1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> estudiante.adicionarNotaObtenida(notaObtenida2));
    }

    @Test
    public void setNotaObtenida_Valido() {

        Estudiante estudiante = new Estudiante("Juan", "Perez", "123456789", "juan@example.com", "1234567890", 20);
        NotaParcial notaParcial = new NotaParcial("Parcial 1", 0.3);
        estudiante.adicionarNotaObtenida(new NotaObtenida(notaParcial, 0));

        estudiante.setNotaObtenida("Parcial 1", 4.5);

        Assertions.assertEquals(4.5, estudiante.getNotaObtenida("Parcial 1").getNotaObtenida());
    }

    @Test
    public void setNotaObtenida_FueraRango() {

        Estudiante estudiante = new Estudiante("Juan", "Perez", "123456789", "juan@example.com", "1234567890", 20);
        NotaParcial notaParcial = new NotaParcial("Parcial 1", 0.3);
        estudiante.adicionarNotaObtenida(new NotaObtenida(notaParcial, 0));

        Assertions.assertThrows(IllegalArgumentException.class, () -> estudiante.setNotaObtenida("Parcial 1", 6.0));
    }

    @Test
    public void getDefinitiva_Valido() {

        Estudiante estudiante = new Estudiante("Juan", "Perez", "123456789", "juan@example.com", "1234567890", 20);
        NotaParcial notaParcial1 = new NotaParcial("Parcial 1", 0.3);
        NotaParcial notaParcial2 = new NotaParcial("Parcial 2", 0.4);
        NotaParcial notaParcial3 = new NotaParcial("Parcial 3", 0.3);
        estudiante.adicionarNotaObtenida(new NotaObtenida(notaParcial1, 4.5));
        estudiante.adicionarNotaObtenida(new NotaObtenida(notaParcial2, 3.8));
        estudiante.adicionarNotaObtenida(new NotaObtenida(notaParcial3, 3.9));

        double definitiva = estudiante.getDefinitiva();

        Assertions.assertEquals(4.04, definitiva, 0.01);
    }
}