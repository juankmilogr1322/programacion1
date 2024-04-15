package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class CursoTest2 {
    private static final Logger LOG = Logger.getLogger(CursoTest2.class.getName());

    @Test
    public void datosCompletos() {
        LOG.info("Inicio datosCompletos");

        // Arrange
        String nombreCurso = "Programación I";
        Curso curso = new Curso(nombreCurso);

        // Act
        String nombreObtenido = curso.getNombre();

        // Assert
        assertEquals(nombreCurso, nombreObtenido);

        LOG.info("Finalización datosCompletos");
    }

    @Test
    public void agregarEstudiante() {
        LOG.info("Inicio agregarEstudiante");

        // Arrange
        Curso curso = new Curso("Programación I");
        Estudiante estudiante = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co",
                "315635674", 18);

        // Act
        curso.agregarEstudiante(estudiante);
        List<Estudiante> estudiantes = new ArrayList<>(curso.getEstudiantes());

        // Assert
        assertTrue(estudiantes.contains(estudiante));
        assertEquals(1, estudiantes.size());

        LOG.info("Finalización agregarEstudiante");
    }

    @Test
    public void datosNulos() {
        LOG.info("Inicio datosNulos");

        // Assert
        assertThrows(Throwable.class, () -> new Curso(null));

        LOG.info("Finalización datosNulos");
    }

    @Test
    public void agregarEstudianteRepetido() {
        LOG.info("Inicio agregarEstudianteRepetido");

        // Arrange
        Curso curso = new Curso("Programación I");
        Estudiante estudiante1 = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co",
                "315635674", 18);
        Estudiante estudiante2 = new Estudiante("Rodrigo", "Calderon", "109453264", "rodrigo@uniquindio.edu.co",
                "3223451278", 19);

        // Act
        curso.agregarEstudiante(estudiante1);

        // Assert
        assertThrows(Throwable.class, () -> curso.agregarEstudiante(estudiante2));

        LOG.info("Finalización agregarEstudianteRepetido");
    }

}
