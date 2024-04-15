package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Optional;

public class Curso {
    public final String nombre;
    public final Collection<Estudiante> estudiantes;
    public final Collection<NotaParcial> notasParciales;

    public Curso(String nombre) {
        assert nombre != null : "El nombre no puede ser nulo";
        this.nombre = nombre;
        estudiantes = new LinkedList<>();
        notasParciales = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        assert validarNumeroIdentificacionExiste(estudiante.getNumeroIdentificacion()) == false
                : "El número de identificación ya existe.";
        estudiantes.add(estudiante);
    }

    public boolean validarNumeroIdentificacionExiste(String numeroIdentificacion) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNumeroIdentificacion().equals(numeroIdentificacion)) {
                return true;
            }
        }
        return false;
    }

    public Optional<Estudiante> obtenerEstudiante(String numeroIdenficacion) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNumeroIdentificacion().equals(numeroIdenficacion)) {
                return Optional.of(estudiante);
            }
        }
        return Optional.empty();
    }

    public Collection<Estudiante> getEstudiantes() {
        return Collections.unmodifiableCollection(estudiantes);
    }

    public Collection<Estudiante> obtenerListadoAlfabetico() {
        ArrayList<Estudiante> estudiantesOrdenados = new ArrayList<>(estudiantes);
        estudiantesOrdenados.sort(Comparator.comparing(Estudiante::getNombres));
        return Collections.unmodifiableCollection(estudiantesOrdenados);
    }

    public Collection<Estudiante> obtenerListadoEdadDescendente() {
        ArrayList<Estudiante> estudiantesOrdenados = new ArrayList<>(estudiantes);
        estudiantesOrdenados.sort(Comparator.comparing(Estudiante::getEdad).reversed());
        return Collections.unmodifiableCollection(estudiantesOrdenados);
    }

    public Collection<Estudiante> obtenerListadoMenoresEdad() {
        ArrayList<Estudiante> menoresEdad = new ArrayList<>();
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getEdad() < 18) {
                menoresEdad.add(estudiante);
            }
        }
        return Collections.unmodifiableCollection(menoresEdad);
    }

    public void adicionarNotaParcial(NotaParcial notaParcial) {
        notasParciales.add(notaParcial);
    }

    public NotaParcial getNotaParcial(String nombreNotaParcial) {
        for (NotaParcial notaParcial : notasParciales) {
            if (notaParcial.nombre().equals(nombreNotaParcial)) {
                return notaParcial;
            }
        }
        throw new IllegalArgumentException("No se encontró la nota parcial con el nombre especificado.");
    }

    public Collection<Estudiante> obtenerListadoMayorNota() {
        double mayorNota = obtenerMayorNota();
        ArrayList<Estudiante> estudiantesMayorNota = new ArrayList<>();
        for (Estudiante estudiante : estudiantes) {
            if (mayorNota - estudiante.getDefinitiva() <= App.PRECISION) {
                estudiantesMayorNota.add(estudiante);
            }
        }
        return Collections.unmodifiableCollection(estudiantesMayorNota);
    }

    public double obtenerMayorNota() {
        double mayorNota = Double.MIN_VALUE;
        for (Estudiante estudiante : estudiantes) {
            mayorNota = Math.max(mayorNota, estudiante.getDefinitiva());
        }
        return mayorNota;
    }

    public Collection<Estudiante> obtenerListadoAlfabeticoPerdieron() {
        ArrayList<Estudiante> estudiantesPerdieron = new ArrayList<>();
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getDefinitiva() < App.MINIMA_NOTA) {
                estudiantesPerdieron.add(estudiante);
            }
        }
        estudiantesPerdieron.sort(Comparator.comparing(Estudiante::getNombres));
        return Collections.unmodifiableCollection(estudiantesPerdieron);
    }

    public boolean validarPorcentajes() {
        double pesoNotas = 0.0;
        for (NotaParcial notaParcial : notasParciales) {
            pesoNotas += notaParcial.porcentaje();
        }
        return (1.0 - pesoNotas) <= App.PRECISION;
    }

    public Object getNotasObtenidas() {
        throw new UnsupportedOperationException("Unimplemented method 'getNotasObtenidas'");
    }

    public Collection<NotaParcial> getNotasParciales() {
        return Collections.unmodifiableCollection(notasParciales);
    }
    
}
