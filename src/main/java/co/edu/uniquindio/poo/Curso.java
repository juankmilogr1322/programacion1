package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Curso {
    private final String nombre;
    private final Collection<Estudiante> estudiantes;
    private final Collection<ClaseCurso> clases;

    public Curso(String nombre) {
        assert nombre != null : "El nombre no puede ser nulo";
        this.nombre = nombre;
        estudiantes = new LinkedList<>();
        clases = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        assert validarNumeroIdentificacionExiste(estudiante.getNumeroIdentificacion()) == false
                : "El número de identificación ya existe.";
        estudiantes.add(estudiante);
    }

    public Estudiante getEstudiante(String numeroIdenficacion) {
        Estudiante estudianteInteres = null;

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNumeroIdentificacion().equals(numeroIdenficacion)) {
                estudianteInteres = estudiante;
                break; // Salir del bucle una vez encontrado el estudiante
            }
        }
        return estudianteInteres;
    }

    public Collection<Estudiante> getEstudiantes() {
        return Collections.unmodifiableCollection(estudiantes);
    }

    private boolean validarNumeroIdentificacionExiste(String numeroIdentificacion) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNumeroIdentificacion().equals(numeroIdentificacion)) {
                return true; // Si se encuentra el número de identificación, se retorna verdadero
            }
        }
        return false; // Si no se encuentra, se retorna falso
    }

    public void programarClase(ClaseCurso claseCurso) {
        clases.add(claseCurso);
    }

    public Collection<ClaseCurso> getClases() {
        return Collections.unmodifiableCollection(clases);
    }

    public Collection<Estudiante> getAsistentes(ClaseCurso claseCurso) {
        Collection<Estudiante> asistentes = new LinkedList<>();

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.asistioClase(claseCurso)) {
                asistentes.add(estudiante);
            }
        }

        return Collections.unmodifiableCollection(asistentes);
    }

    public Collection<Estudiante> getAusentes(ClaseCurso claseCurso) {
        Collection<Estudiante> ausentes = new LinkedList<>();

        for (Estudiante estudiante : estudiantes) {
            if (!estudiante.asistioClase(claseCurso)) {
                ausentes.add(estudiante);
            }
        }

        return Collections.unmodifiableCollection(ausentes);
    }

    public double calcularPorcentajeAsistencia(ClaseCurso claseCurso) {
        int cantidadEstudiantes = estudiantes.size();
        int cantidadAsistentes = 0;

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.asistioClase(claseCurso)) {
                cantidadAsistentes++;
            }
        }

        return (double) cantidadAsistentes / cantidadEstudiantes;
    }
}
