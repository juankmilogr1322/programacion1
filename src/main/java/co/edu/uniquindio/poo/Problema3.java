package co.edu.uniquindio.poo;

//Este trabajo fue hecho por Maicol Ochoa y Sebastian Fernandez

public class Problema3 {

    public static void main(String[] args) {

        NotaParcial parcial1 = new NotaParcial("Parcial 1", 0.3);
        NotaParcial parcial2 = new NotaParcial("Parcial 2", 0.3);
        NotaParcial parcial3 = new NotaParcial("Parcial 3", 0.4);

        Estudiante estudiante1 = new Estudiante("Juan", "Perez", "12345", "juan@gmail.com", "123456789", 20);

        estudiante1.adicionarNotaObtenida(new NotaObtenida(parcial1, 4.5));
        estudiante1.adicionarNotaObtenida(new NotaObtenida(parcial2, 3.8));
        estudiante1.adicionarNotaObtenida(new NotaObtenida(parcial3, 3.2));

        System.out.println("Notas obtenidas por " + estudiante1.getNombres() + ":");
        for (NotaObtenida notaObtenida : estudiante1.getNotasObtenidas()) {
            System.out.println("- " + notaObtenida.getNotaParcial().nombre() + ": " + notaObtenida.getNotaObtenida());
        }

        double definitiva = estudiante1.getDefinitiva();
        System.out.println("Nota definitiva de " + estudiante1.getNombres() + ": " + definitiva);
    }
}

