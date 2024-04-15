package co.edu.uniquindio.poo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;


public class CursoTest2 {
    public static final Logger LOG = Logger.getLogger(CursoTest2.class.getName());

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void obtenterNotaParcialExistente() {
        LOG.info("Inicio obtenterNotaParcialExistente");

        var curso = new Curso("Programación I");
        var notaParcial = new NotaParcial("Parcial 3", 0.5);

        curso.adicionarNotaParcial(notaParcial);

        assertEquals(notaParcial, curso.getNotaParcial("Parcial 3"));

        LOG.info("Finalización obtenterNotaParcialExistente");
    }

    @Test
    public void obtenterNotaParcialInexistente() {
        LOG.info("Inicio obtenterNotaParcialInexistente");

        var curso = new Curso("Programación I");
        var notaParcial = new NotaParcial("Parcial 3", 0.5);

        curso.adicionarNotaParcial(notaParcial);

        assertThrows(Throwable.class, () -> curso.getNotaParcial("Parcial 1"));

        LOG.info("Finalización obtenterNotaParcialInexistente");
    }


    @Test
    public void validarPorcentaje100Porciento() {
        LOG.info("Inicio validarPorcentaje100Porciento");

        var curso = new Curso("Programación I");

        curso.adicionarNotaParcial(new NotaParcial("Parcial 1", 0.1));
        curso.adicionarNotaParcial(new NotaParcial("Parcial 2", 0.2));
        curso.adicionarNotaParcial(new NotaParcial("Parcial 3", 0.3));
        curso.adicionarNotaParcial(new NotaParcial("Parcial 4", 0.4));

        assert (curso.validarPorcentajes());

        LOG.info("Finalización validarPorcentaje100Porciento");
    }

    @Test
    public void validarPorcentajeDiferente100Porciento() {
        LOG.info("Inicio validarPorcentajeDiferente100Porciento");

        var curso = new Curso("Programación I");

        curso.adicionarNotaParcial(new NotaParcial("Parcial 1", 0.3));
        curso.adicionarNotaParcial(new NotaParcial("Parcial 2", 0.2));
        curso.adicionarNotaParcial(new NotaParcial("Parcial 3", 0.01));
        curso.adicionarNotaParcial(new NotaParcial("Parcial 4", 0.4));
        System.out.println(curso.validarPorcentajes());

        assert (!curso.validarPorcentajes());

        LOG.info("Finalización validarPorcentajeDiferente100Porciento");
    }
}
