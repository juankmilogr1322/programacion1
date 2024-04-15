package co.edu.uniquindio.poo;

//import java.time.LocalDateTime;

//public record ClaseCurso(LocalDateTime fechaClase) {

//public ClaseCurso {
//assert fechaClase != null;
//}
//} 

import java.time.LocalDateTime;

public class ClaseCurso {
    private final LocalDateTime fechaClase;

    public ClaseCurso(LocalDateTime fechaClase) {
        assert fechaClase != null : "La fecha de la clase no puede ser nula.";
        this.fechaClase = fechaClase;
    }

    public LocalDateTime getFechaClase() {
        return fechaClase;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ClaseCurso that = (ClaseCurso) obj;
        return fechaClase.equals(that.fechaClase);
    }

    @Override
    public int hashCode() {
        return fechaClase.hashCode();
    }

    @Override
    public String toString() {
        return "ClaseCurso{" +
                "fechaClase=" + fechaClase +
                '}';
    }
}
