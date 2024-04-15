package co.edu.uniquindio.poo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class AsistenciaTest {

    @Test
    public void crearAsistencia_Valido() {
        ClaseCurso claseCurso = new ClaseCurso(LocalDateTime.now());
        Asistencia asistencia = new Asistencia(claseCurso, TipoAsistencia.PRESENTE);

        Assertions.assertEquals(claseCurso, asistencia.getClaseCurso());
        Assertions.assertEquals(TipoAsistencia.PRESENTE, asistencia.getTipoAsistencia());
    }

    @Test
    public void equals_AsistenciasIguales_True() {
        ClaseCurso claseCurso1 = new ClaseCurso(LocalDateTime.now());
        Asistencia asistencia1 = new Asistencia(claseCurso1, TipoAsistencia.PRESENTE);

        ClaseCurso claseCurso2 = new ClaseCurso(LocalDateTime.now());
        Asistencia asistencia2 = new Asistencia(claseCurso2, TipoAsistencia.PRESENTE);

        Assertions.assertEquals(asistencia1, asistencia2);
    }

    @Test
    public void equals_AsistenciasDiferentes_False() {
        ClaseCurso claseCurso1 = new ClaseCurso(LocalDateTime.now());
        Asistencia asistencia1 = new Asistencia(claseCurso1, TipoAsistencia.PRESENTE);

        ClaseCurso claseCurso2 = new ClaseCurso(LocalDateTime.now().plusHours(1));
        Asistencia asistencia2 = new Asistencia(claseCurso2, TipoAsistencia.AUSENTE);

        Assertions.assertNotEquals(asistencia1, asistencia2);
    }
}
