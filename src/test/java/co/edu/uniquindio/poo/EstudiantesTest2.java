package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class EstudiantesTest2 {
    private static final Logger LOG = Logger.getLogger(EstudiantesTest2.class.getName());

    @Test
    public void obtenerNotaObtenidaExistente() {
        LOG.info("Inicio obtenerNotaObtenidaExistente");

        var estudiante = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co",
                "315635674", 15);

        var notaParcial = new NotaParcial("Parcial 1", 0.2);
        var notaObtenida = new NotaObtenida(notaParcial, 3.5);
        estudiante.adicionarNotaObtenida(notaObtenida);

        assertEquals(notaObtenida, estudiante.getNotaObtenida("Parcial 1"));

        LOG.info("Finalización obtenerNotaObtenidaExistente");
    }

    @Test
    public void registrarMasUnaNotaParcial() {
        LOG.info("Inicio registrarMasUnaNotaParcial");

        var estudiante = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co",
                "315635674", 15);

        var notaParcial = new NotaParcial("Parcial 1", 0.2);
        var notaObtenida1 = new NotaObtenida(notaParcial, 3.5);
        var notaObtenida2 = new NotaObtenida(notaParcial, 4.2);
        estudiante.adicionarNotaObtenida(notaObtenida1);

        assertThrows(Throwable.class, () -> estudiante.adicionarNotaObtenida(notaObtenida2));

        LOG.info("Finalización registrarMasUnaNotaParcial");
    }

    @Test
    public void obtenerNotaObtenidaNOExistente() {
        LOG.info("Inicio obtenerNotaObtenidaNOExistente");

        var estudiante = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co",
                "315635674", 15);

        assertThrows(Throwable.class, () -> estudiante.getNotaObtenida("Parcial 2"));

        LOG.info("Finalización obtenerNotaObtenidaNOExistente");
    }

    @Test
    public void actualizarNotaObtenidaExistente() {
        LOG.info("Inicio obtenerNotaObtenidaExistente");

        var estudiante = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co",
                "315635674", 15);

        var notaParcial = new NotaParcial("Parcial 1", 0.2);
        var notaObtenida = new NotaObtenida(notaParcial, 3.5);
        estudiante.adicionarNotaObtenida(notaObtenida);
        estudiante.setNotaObtenida("Parcial 1", 4.8);

        assertEquals(notaObtenida, estudiante.getNotaObtenida("Parcial 1"));
        assertEquals(4.8, estudiante.getNotaObtenida("Parcial 1").getNotaObtenida(), App.PRECISION);

        LOG.info("Finalización obtenerNotaObtenidaExistente");
    }

    @Test
    public void actualizarNotaObtenidaInexistente() {
        LOG.info("Inicio actualizarNotaObtenidaInexistente");

        var estudiante = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co",
                "315635674", 15);

        assertThrows(Throwable.class, () -> estudiante.setNotaObtenida("Parcial 2", 2.5));

        LOG.info("Finalización actualizarNotaObtenidaInexistente");
    }

    @Test
    public void actualizarNotaObtenidaMayorCinco() {
        LOG.info("Inicio actualizarNotaObtenidaMayorCinco");

        var estudiante = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co",
                "315635674", 15);

        var notaParcial = new NotaParcial("Parcial 1", 0.2);
        var notaObtenida = new NotaObtenida(notaParcial, 3.5);
        estudiante.adicionarNotaObtenida(notaObtenida);

        assertThrows(Throwable.class, () -> estudiante.setNotaObtenida("Parcial 1", 9.2));

        LOG.info("Finalización actualizarNotaObtenidaMayorCinco");
    }

    @Test
    public void actualizarNotaObtenidaMenorCero() {
        LOG.info("Inicio actualizarNotaObtenidaMenorCero");

        var estudiante = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co",
                "315635674", 15);

        var notaParcial = new NotaParcial("Parcial 1", 0.2);
        var notaObtenida = new NotaObtenida(notaParcial, 3.5);
        estudiante.adicionarNotaObtenida(notaObtenida);

        assertThrows(Throwable.class, () -> estudiante.setNotaObtenida("Parcial 1", -2.1));

        LOG.info("Finalización actualizarNotaObtenidaMenorCero");
    }

    @Test
    public void notaDefinitivaVariasNotas() {
        LOG.info("Inicio notaDefinitivaVariasNotas");

        var estudiante = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co",
                "315635674", 15);

        var notaParcial1 = new NotaParcial("Parcial 1", 0.2);
        var notaParcial2 = new NotaParcial("Parcial 2", 0.3);
        var notaParcial3 = new NotaParcial("Parcial 3", 0.5);

        var notaObtenida1 = new NotaObtenida(notaParcial1, 3.2);
        var notaObtenida2 = new NotaObtenida(notaParcial2, 4.2);
        var notaObtenida3 = new NotaObtenida(notaParcial3, 4.0);

        estudiante.adicionarNotaObtenida(notaObtenida1);
        estudiante.adicionarNotaObtenida(notaObtenida2);
        estudiante.adicionarNotaObtenida(notaObtenida3);

        assertEquals(3.9000000000000004, estudiante.getDefinitiva(), App.PRECISION);

        LOG.info("Finalización notaDefinitivaVariasNotas");
    }

    @Test
    public void notaDefinitivaSinNotas() {
        LOG.info("Inicio notaDefinitivaSinNotas");

        var estudiante = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co",
                "315635674", 15);

        assertThrows(Throwable.class, () -> estudiante.getDefinitiva());

        LOG.info("Finalización notaDefinitivaSinNotas");
    }

    @Test
    public void notaDefinitivaVariasNotasNo100Porciento() {
        LOG.info("Inicio notaDefinitivaVariasNotasNo100Porciento");

        var estudiante = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co",
                "315635674", 15);

        var notaParcial1 = new NotaParcial("Parcial 1", 0.1);
        var notaParcial2 = new NotaParcial("Parcial 2", 0.2);
        var notaParcial3 = new NotaParcial("Parcial 3", 0.3);

        var notaObtenida1 = new NotaObtenida(notaParcial1, 3.2);
        var notaObtenida2 = new NotaObtenida(notaParcial2, 4.2);
        var notaObtenida3 = new NotaObtenida(notaParcial3, 4.0);

        estudiante.adicionarNotaObtenida(notaObtenida1);
        estudiante.adicionarNotaObtenida(notaObtenida2);
        estudiante.adicionarNotaObtenida(notaObtenida3);

        assertThrows(Throwable.class, () -> estudiante.getDefinitiva());

        LOG.info("Finalización notaDefinitivaVariasNotasNo100Porciento");
    }

}
