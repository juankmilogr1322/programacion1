//package co.edu.uniquindio.poo;

//public enum TipoAsistencia {
//PRESENTE,
//AUSENTE
//}

package co.edu.uniquindio.poo;

public class TipoAsistencia {
    public static final TipoAsistencia PRESENTE = new TipoAsistencia("Presente");
    public static final TipoAsistencia AUSENTE = new TipoAsistencia("Ausente");

    private final String nombre;

    private TipoAsistencia(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public static TipoAsistencia[] values() {
        return new TipoAsistencia[] { PRESENTE, AUSENTE };
    }

    public static TipoAsistencia valueOf(String nombre) {
        if (nombre == null) {
            throw new NullPointerException("El nombre no puede ser nulo");
        }
        if (nombre.equalsIgnoreCase("Presente")) {
            return PRESENTE;
        } else if (nombre.equalsIgnoreCase("Ausente")) {
            return AUSENTE;
        } else {
            throw new IllegalArgumentException("Tipo de asistencia desconocido: " + nombre);
        }
    }

    @Override
    public String toString() {
        return nombre;
    }
}
