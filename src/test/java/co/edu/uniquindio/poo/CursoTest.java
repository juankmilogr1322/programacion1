package co.edu.uniquindio.poo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CursoTest {
    @Test
    public void agregarEstudiante_Valido() {

        Curso curso = new Curso("Programación I");
        Estudiante estudiante = new Estudiante("Juan", "Perez", "123456789", "juan@example.com", "1234567890", 20);

        curso.agregarEstudiante(estudiante);

        Assertions.assertTrue(curso.getEstudiantes().contains(estudiante));
    }

    @Test
    public void agregarEstudiante_Repetido() {

        Curso curso = new Curso("Programación I");
        Estudiante estudiante1 = new Estudiante("Juan", "Perez", "123456789", "juan@example.com", "1234567890", 20);
        Estudiante estudiante2 = new Estudiante("Juan", "Perez", "123456789", "juan@example.com", "1234567890", 20);

        curso.agregarEstudiante(estudiante1);

        Assertions.assertThrows(AssertionError.class, () -> curso.agregarEstudiante(estudiante2));
    }

    @Test
    public void obtenerEstudiante_Existente() {

        Curso curso = new Curso("Programación I");
        Estudiante estudiante = new Estudiante("Juan", "Perez", "123456789", "juan@example.com", "1234567890", 20);
        curso.agregarEstudiante(estudiante);

        var estudianteObtenido = curso.obtenerEstudiante("123456789");

        Assertions.assertTrue(estudianteObtenido.isPresent());
        Assertions.assertEquals(estudiante, estudianteObtenido.get());
    }

    @Test
    public void obtenerEstudiante_NoExistente() {

        Curso curso = new Curso("Programación I");
        Estudiante estudiante = new Estudiante("Juan", "Perez", "123456789", "juan@example.com", "1234567890", 20);
        curso.agregarEstudiante(estudiante);

        var estudianteObtenido = curso.obtenerEstudiante("987654321");

        Assertions.assertTrue(estudianteObtenido.isEmpty());
    }
}
