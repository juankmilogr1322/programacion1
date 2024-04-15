package co.edu.uniquindio.poo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class EstudianteTest {

    @Test
    public void agregarAsistencia_Valido() {
        Estudiante estudiante = new Estudiante("Juan", "Perez", "123456789", "juan@gmail.com", "1234567890", 20);
        ClaseCurso claseCurso = new ClaseCurso(LocalDateTime.of(2024, 4, 14, 9, 0));
        Asistencia asistencia = new Asistencia(claseCurso, TipoAsistencia.PRESENTE);

        estudiante.agregarAsistencia(asistencia);

        Assertions.assertTrue(estudiante.getAsistencias().contains(asistencia));
    }

    @Test
    public void asistioClase_Asistio_True() {
        Estudiante estudiante = new Estudiante("Juan", "Perez", "123456789", "juan@gmail.com", "1234567890", 20);
        ClaseCurso claseCurso = new ClaseCurso(LocalDateTime.of(2024, 4, 14, 9, 0));
        Asistencia asistencia = new Asistencia(claseCurso, TipoAsistencia.PRESENTE);
        estudiante.agregarAsistencia(asistencia);

        Assertions.assertTrue(estudiante.asistioClase(claseCurso));
    }

    @Test
    public void asistioClase_NoAsistio_False() {
        Estudiante estudiante = new Estudiante("Juan", "Perez", "123456789", "juan@gmail.com", "1234567890", 20);
        ClaseCurso claseCurso = new ClaseCurso(LocalDateTime.of(2024, 4, 14, 9, 0));

        Assertions.assertFalse(estudiante.asistioClase(claseCurso));
    }
}
