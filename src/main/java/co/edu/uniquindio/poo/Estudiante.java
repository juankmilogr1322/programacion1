package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Estudiante {
    private final String nombres;
    private final String apellidos;
    private final String numeroIdentificacion;
    private final String correo;
    private final String telefono;
    private final int edad;
    private final List<Asistencia> asistencias;

    public Estudiante(String nombres, String apellidos, String numeroIdentificacion, String correo, String telefono,
            int edad) {
        assert nombres != null && !nombres.isBlank() : "El nombre debe ser diferente de null";
        assert apellidos != null && !apellidos.isBlank() : "El apellido debe ser diferente de null";
        assert numeroIdentificacion != null && !numeroIdentificacion.isBlank()
                : "El número de identificación debe ser diferente de null";
        assert correo != null && correo.contains("@") : "El correo electrónico debe contener el símbolo @";
        assert telefono != null : "El teléfono no puede ser null";
        assert edad > 0 : "La edad debe ser mayor a cero";

        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numeroIdentificacion = numeroIdentificacion;
        this.correo = correo;
        this.telefono = telefono;
        this.edad = edad;

        this.asistencias = new ArrayList<>();
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

    public void agregarAsistencia(Asistencia asistencia) {
        assert asistencia != null : "Error la asistencia no puede ser nula";
        asistencias.add(asistencia);
    }

    public Collection<Asistencia> getAsistencias() {
        return Collections.unmodifiableCollection(asistencias);
    }

    public boolean asistioClase(ClaseCurso claseCurso) {
        for (Asistencia asistencia : asistencias) {
            if (asistencia.getClaseCurso().getFechaClase().isEqual(claseCurso.getFechaClase())
                    && asistencia.getTipoAsistencia() == TipoAsistencia.PRESENTE) {
                return true;
            }
        }
        return false;
    }
}
