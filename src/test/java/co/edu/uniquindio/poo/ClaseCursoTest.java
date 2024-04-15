package co.edu.uniquindio.poo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class ClaseCursoTest {

    @Test
    public void crearClaseCurso_Valido() {
        LocalDateTime fecha = LocalDateTime.of(2024, 4, 15, 10, 30);
        ClaseCurso claseCurso = new ClaseCurso(fecha);

        Assertions.assertEquals(fecha, claseCurso.getFechaClase());
    }

    @Test
    public void equals_ClasesIguales_True() {
        LocalDateTime fecha1 = LocalDateTime.of(2024, 4, 15, 10, 30);
        ClaseCurso claseCurso1 = new ClaseCurso(fecha1);

        LocalDateTime fecha2 = LocalDateTime.of(2024, 4, 15, 10, 30);
        ClaseCurso claseCurso2 = new ClaseCurso(fecha2);

        Assertions.assertEquals(claseCurso1, claseCurso2);
    }

    @Test
    public void equals_ClasesDiferentes_False() {
        LocalDateTime fecha1 = LocalDateTime.of(2024, 4, 15, 10, 30);
        ClaseCurso claseCurso1 = new ClaseCurso(fecha1);

        LocalDateTime fecha2 = LocalDateTime.of(2024, 4, 16, 9, 30);
        ClaseCurso claseCurso2 = new ClaseCurso(fecha2);

        Assertions.assertNotEquals(claseCurso1, claseCurso2);
    }
}
