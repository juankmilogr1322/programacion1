package co.edu.uniquindio.poo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class Estudiante {
    public final String nombres;
    public final String apellidos;
    public final String numeroIdentificacion;
    public final String correo;
    public final String telefono;
    public final int edad;
    public final Collection<NotaObtenida> notasObtenidas;

    public Estudiante(String nombres, String apellidos, String numeroIdentificacion, String correo, String telefono, int edad) {
        if (nombres == null || nombres.isBlank()) {
            throw new IllegalArgumentException("El nombre debe ser diferente de null o vacío");
        }
        if (apellidos == null || apellidos.isBlank()) {
            throw new IllegalArgumentException("El apellido debe ser diferente de null o vacío");
        }
        if (numeroIdentificacion == null || numeroIdentificacion.isBlank()) {
            throw new IllegalArgumentException("El número de identificación debe ser diferente de null o vacío");
        }
        if (correo == null || !correo.contains("@")) {
            throw new IllegalArgumentException("El correo electrónico debe contener el símbolo @");
        }
        if (telefono == null) {
            throw new IllegalArgumentException("El teléfono no puede ser null");
        }
        if (edad <= 0) {
            throw new IllegalArgumentException("La edad debe ser mayor a cero");
        }

        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numeroIdentificacion = numeroIdentificacion;
        this.correo = correo;
        this.telefono = telefono;
        this.edad = edad;

        this.notasObtenidas = new ArrayList<>();
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void adicionarNotaObtenida(NotaObtenida notaObtenida) {
        verificarExistenciaNotaObtenida(notaObtenida);
        notasObtenidas.add(notaObtenida);
    }

    public void verificarExistenciaNotaObtenida(NotaObtenida notaObtenida) {
        for (NotaObtenida nota : notasObtenidas) {
            if (nota.getNotaParcial().nombre().equals(notaObtenida.getNotaParcial().nombre())) {
                throw new IllegalArgumentException("La nota parcial ya ha sido agregada");
            }
        }
    }

    public NotaObtenida getNotaObtenida(String nombreNotaParcial) {
        Optional<NotaObtenida> posibleNotaObtenida = buscarNotaParcial(nombreNotaParcial);
        if (posibleNotaObtenida.isPresent()) {
            return posibleNotaObtenida.get();
        } else {
            throw new IllegalArgumentException("No se encontró la nota parcial con el nombre especificado.");
        }
    }

    public Optional<NotaObtenida> buscarNotaParcial(String nombreNotaParcial) {
        for (NotaObtenida nota : notasObtenidas) {
            if (nota.getNotaParcial().nombre().equals(nombreNotaParcial)) {
                return Optional.of(nota);
            }
        }
        return Optional.empty();
    }

    public Collection<NotaObtenida> getNotasObtenidas() {
        return Collections.unmodifiableCollection(notasObtenidas);
    }

    public void setNotaObtenida(String nombreNotaParcial, double notaObtenida) {
        if (notaObtenida < 0.0 || notaObtenida > 5.0) {
            throw new IllegalArgumentException("La nota obtenida debe estar entre 0.0 y 5.0");
        }
        Optional<NotaObtenida> posibleNotaObtenida = buscarNotaParcial(nombreNotaParcial);
        if (posibleNotaObtenida.isPresent()) {
            posibleNotaObtenida.get().setNotaObtenida(notaObtenida);
        } else {
            throw new IllegalArgumentException("No se encontró la nota parcial con el nombre especificado.");
        }
    }

    public double getDefinitiva() {
        validarNotas100Porciento();

        double definitiva = 0.0;
        for (NotaObtenida nota : notasObtenidas) {
            definitiva += (nota.getNotaObtenida() * nota.getNotaParcial().porcentaje());
        }

        return definitiva;
    }

    

    public void validarNotas100Porciento() {
        double pesoNotas = 0.0;
        for (NotaObtenida nota : notasObtenidas) {
            pesoNotas += nota.getNotaParcial().porcentaje();
        }
        if ((1.0 - pesoNotas) > App.PRECISION) {
            throw new IllegalArgumentException("Las notas parciales no suman 1.0 (100%)");
        }
    }

    public double calcularNotaTotal(Object notasObtenidas2) {
        throw new UnsupportedOperationException("Unimplemented method 'calcularNotaTotal'");
    }
}

