//package co.edu.uniquindio.poo;

//public record Asistencia(ClaseCurso claseCurso, TipoAsistencia tipoAsistencia) {

//public Asistencia {
//assert claseCurso != null;
//}
//}

package co.edu.uniquindio.poo;

public class Asistencia {
    private final ClaseCurso claseCurso;
    private final TipoAsistencia tipoAsistencia;

    public Asistencia(ClaseCurso claseCurso, TipoAsistencia tipoAsistencia) {
        assert claseCurso != null : "La clase de curso no puede ser nula.";
        this.claseCurso = claseCurso;
        this.tipoAsistencia = tipoAsistencia;
    }

    public ClaseCurso getClaseCurso() {
        return claseCurso;
    }

    public TipoAsistencia getTipoAsistencia() {
        return tipoAsistencia;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Asistencia that = (Asistencia) obj;
        return claseCurso.equals(that.claseCurso) && tipoAsistencia == that.tipoAsistencia;
    }

    @Override
    public int hashCode() {
        int result = claseCurso.hashCode();
        result = 31 * result + tipoAsistencia.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Asistencia{" +
                "claseCurso=" + claseCurso +
                ", tipoAsistencia=" + tipoAsistencia +
                '}';
    }
}