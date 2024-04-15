package co.edu.uniquindio.poo;

public class NotaParcial {
    public final String nombre;
    public final double porcentaje;

    public NotaParcial(String nombre, double porcentaje) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni vacío");
        }
        if (porcentaje <= 0.0) {
            throw new IllegalArgumentException("El porcentaje no puede ser negativo");
        }
        if (porcentaje > 1.0) {
            throw new IllegalArgumentException("El porcentaje no puede ser mayor que 1.0 (100%)");
        }
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public String nombre() {
        return nombre;
    }

    public double porcentaje() {
        return porcentaje;
    }
}

