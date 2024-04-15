package co.edu.uniquindio.poo;

public class NotaObtenida {
    public final NotaParcial notaParcial;
    public double notaObtenida;

    public NotaObtenida(NotaParcial notaParcial, double notaObtenida) {
        if (notaParcial == null) {
            throw new IllegalArgumentException("La nota parcial no puede ser null");
        }
        validarValorNota(notaObtenida);

        this.notaParcial = notaParcial;
        this.notaObtenida = notaObtenida;
    }

    public NotaParcial getNotaParcial() {
        return notaParcial;
    }

    public double getNotaObtenida() {
        return notaObtenida;
    }

    public void setNotaObtenida(double notaObtenida) {
        validarValorNota(notaObtenida);
        this.notaObtenida = notaObtenida;
    }

    public void validarValorNota(double notaObtenida) {
        if (notaObtenida < 0.0) {
            throw new IllegalArgumentException("La nota obtenida no puede ser menor que 0.0");
        }
        if (notaObtenida > 5.0) {
            throw new IllegalArgumentException("La nota obtenida no puede ser mayor que 5.0");
        }
    }
}
