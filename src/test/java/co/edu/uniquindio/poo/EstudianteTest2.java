package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class EstudianteTest2 {
    private static final Logger LOG = Logger.getLogger(EstudianteTest2.class.getName());

    @Test
    public void registrarClases() {
        LOG.info("Inicio registrarClases");

        // Arrange
        Curso curso = new Curso("Programación 1");
        List<ClaseCurso> clases = new ArrayList<>();
        clases.add(new ClaseCurso(LocalDateTime.now().minusDays(15)));
        clases.add(new ClaseCurso(LocalDateTime.now().minusDays(8)));
        clases.add(new ClaseCurso(LocalDateTime.now()));
        // Act
        for (ClaseCurso clase : clases) {
            curso.programarClase(clase);
        }

        // Assert
        assertEquals(3, curso.getClases().size());

        LOG.info("Finalización registrarClases");
    }

    @Test
    public void listaAsistentes() {
        LOG.info("Inicio listaAsistentes");

        // Arrange
        Curso curso = new Curso("Programación 1");
        Estudiante xiomara = new Estudiante("Xiomara", "Gomez", "109445634", "xiomara@uniquindio.edu.co", "3148763412",
                31);
        Estudiante ana = new Estudiante("Ana", "Quintero", "109498764", "ana@uniquindio.edu.co", "3137442312", 28);
        Estudiante juan = new Estudiante("Juan", "Botero", "1092394924", "juan@uniquindio.edu.co", "3218341234", 17);

        curso.agregarEstudiante(xiomara);
        curso.agregarEstudiante(ana);
        curso.agregarEstudiante(juan);

        List<ClaseCurso> clases = new ArrayList<>();
        clases.add(new ClaseCurso(LocalDateTime.now().minusDays(15)));
        clases.add(new ClaseCurso(LocalDateTime.now().minusDays(8)));
        clases.add(new ClaseCurso(LocalDateTime.now()));

        for (ClaseCurso clase : clases) {
            curso.programarClase(clase);
        }

        xiomara.agregarAsistencia(new Asistencia(clases.get(0), TipoAsistencia.PRESENTE));
        xiomara.agregarAsistencia(new Asistencia(clases.get(1), TipoAsistencia.PRESENTE));
        xiomara.agregarAsistencia(new Asistencia(clases.get(2), TipoAsistencia.PRESENTE));

        ana.agregarAsistencia(new Asistencia(clases.get(0), TipoAsistencia.PRESENTE));
        ana.agregarAsistencia(new Asistencia(clases.get(2), TipoAsistencia.PRESENTE));

        juan.agregarAsistencia(new Asistencia(clases.get(1), TipoAsistencia.AUSENTE));
        juan.agregarAsistencia(new Asistencia(clases.get(2), TipoAsistencia.PRESENTE));

        // Act
        Collection<Estudiante> listaEsperada = new ArrayList<>();
        listaEsperada.add(xiomara);
        listaEsperada.add(ana);

        // Assert
        assertTrue(listaEsperada.containsAll(curso.getAsistentes(clases.get(0))));
        assertTrue(listaEsperada.containsAll(curso.getAsistentes(clases.get(1))));

        LOG.info("Finalización listaAsistentes");
    }

    @Test
    public void listaAusentes() {
        LOG.info("Inicio listaAusentes");

        // Arrange
        Curso curso = new Curso("Programación 1");
        Estudiante xiomara = new Estudiante("Xiomara", "Gomez", "109445634", "xiomara@uniquindio.edu.co", "3148763412",
                31);
        Estudiante ana = new Estudiante("Ana", "Quintero", "109498764", "ana@uniquindio.edu.co", "3137442312", 28);
        Estudiante juan = new Estudiante("Juan", "Botero", "1092394924", "juan@uniquindio.edu.co", "3218341234", 17);

        curso.agregarEstudiante(xiomara);
        curso.agregarEstudiante(ana);
        curso.agregarEstudiante(juan);

        List<ClaseCurso> clases = new ArrayList<>();
        clases.add(new ClaseCurso(LocalDateTime.now().minusDays(15)));
        clases.add(new ClaseCurso(LocalDateTime.now().minusDays(8)));
        clases.add(new ClaseCurso(LocalDateTime.now()));

        for (ClaseCurso clase : clases) {
            curso.programarClase(clase);
        }

        xiomara.agregarAsistencia(new Asistencia(clases.get(0), TipoAsistencia.PRESENTE));
        xiomara.agregarAsistencia(new Asistencia(clases.get(1), TipoAsistencia.PRESENTE));
        xiomara.agregarAsistencia(new Asistencia(clases.get(2), TipoAsistencia.PRESENTE));

        ana.agregarAsistencia(new Asistencia(clases.get(0), TipoAsistencia.PRESENTE));
        ana.agregarAsistencia(new Asistencia(clases.get(2), TipoAsistencia.PRESENTE));

        juan.agregarAsistencia(new Asistencia(clases.get(1), TipoAsistencia.AUSENTE));
        juan.agregarAsistencia(new Asistencia(clases.get(2), TipoAsistencia.PRESENTE));

        // Act
        Collection<Estudiante> listaEsperada = new ArrayList<>();
        listaEsperada.add(ana);
        listaEsperada.add(juan);

        // Assert
        assertTrue(listaEsperada.containsAll(curso.getAusentes(clases.get(0))));
        assertTrue(listaEsperada.containsAll(curso.getAusentes(clases.get(2))));

        LOG.info("Finalización listaAusentes");
    }

    @Test
    public void porcentajeAsistencia() {
        LOG.info("Inicio porcentajeAsistencia");

        // Arrange
        Curso curso = new Curso("Programación 1");
        Estudiante xiomara = new Estudiante("Xiomara", "Gomez", "109445634", "xiomara@uniquindio.edu.co", "3148763412",
                31);
        Estudiante ana = new Estudiante("Ana", "Quintero", "109498764", "ana@uniquindio.edu.co", "3137442312", 28);
        Estudiante juan = new Estudiante("Juan", "Botero", "1092394924", "juan@uniquindio.edu.co", "3218341234", 17);

        curso.agregarEstudiante(xiomara);
        curso.agregarEstudiante(ana);
        curso.agregarEstudiante(juan);

        List<ClaseCurso> clases = new ArrayList<>();
        clases.add(new ClaseCurso(LocalDateTime.now().minusDays(15)));
        clases.add(new ClaseCurso(LocalDateTime.now().minusDays(8)));
        clases.add(new ClaseCurso(LocalDateTime.now()));

        for (ClaseCurso clase : clases) {
            curso.programarClase(clase);
        }

        xiomara.agregarAsistencia(new Asistencia(clases.get(0), TipoAsistencia.PRESENTE));
        xiomara.agregarAsistencia(new Asistencia(clases.get(1), TipoAsistencia.PRESENTE));
        xiomara.agregarAsistencia(new Asistencia(clases.get(2), TipoAsistencia.PRESENTE));

        ana.agregarAsistencia(new Asistencia(clases.get(0), TipoAsistencia.PRESENTE));
        ana.agregarAsistencia(new Asistencia(clases.get(2), TipoAsistencia.PRESENTE));

        juan.agregarAsistencia(new Asistencia(clases.get(1), TipoAsistencia.AUSENTE));
        juan.agregarAsistencia(new Asistencia(clases.get(2), TipoAsistencia.PRESENTE));

        // Act
        double porcentajeAsistencia = curso.calcularPorcentajeAsistencia(clases.get(0));

        // Assert
        assertEquals(0.6666666666666666, porcentajeAsistencia);

        LOG.info("Finalización porcentajeAsistencia");
    }

}
