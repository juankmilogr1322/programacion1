
//Este trabajo fue hecho por Maicol Stiwen Ochoa y Sebastian Fernandez//

package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.util.Collection;

public class Problema4 {

    public static void main(String[] args) {
        // Crear algunas instancias de ClaseCurso con fechas
        LocalDateTime fechaClase1 = LocalDateTime.of(2024, 4, 10, 18, 0); // Año, mes, día, hora, minuto
        LocalDateTime fechaClase2 = LocalDateTime.of(2024, 4, 17, 16, 0);
        LocalDateTime fechaClase3 = LocalDateTime.of(2024, 4, 24, 8, 0);

        ClaseCurso clase1 = new ClaseCurso(fechaClase1);
        ClaseCurso clase2 = new ClaseCurso(fechaClase2);
        ClaseCurso clase3 = new ClaseCurso(fechaClase3);

        // Crear instancias de Estudiante
        Estudiante estudiante1 = new Estudiante("Juan", "Pérez", "123456", "juan@gmail.com", "123456789", 20);
        Estudiante estudiante2 = new Estudiante("María", "Gómez", "654321", "maria@gmail.com", "987654321", 22);
        Estudiante estudiante3 = new Estudiante("Carla", "Medina", "554321", "carla@gmail.com", "887654321", 21);
        Estudiante estudiante4 = new Estudiante("Pirlo", "Ochoa", "664321", "pirlo@gmail.com", "777654321", 23);
        Estudiante estudiante5 = new Estudiante("Esteban", "Rojas", "444321", "esteban@gmail.com", "667654321", 25);

        // Crear instancias de Curso
        Curso curso = new Curso("Programación I");
        curso.agregarEstudiante(estudiante1);
        curso.agregarEstudiante(estudiante2);
        curso.agregarEstudiante(estudiante3);
        curso.agregarEstudiante(estudiante4);
        curso.agregarEstudiante(estudiante5);

        // Programar clases en el curso
        curso.programarClase(clase1);
        curso.programarClase(clase2);
        curso.programarClase(clase3);

        // Registrar asistencias
        estudiante1.agregarAsistencia(new Asistencia(clase1, TipoAsistencia.PRESENTE));
        estudiante1.agregarAsistencia(new Asistencia(clase2, TipoAsistencia.AUSENTE));
        estudiante2.agregarAsistencia(new Asistencia(clase1, TipoAsistencia.PRESENTE));
        estudiante2.agregarAsistencia(new Asistencia(clase3, TipoAsistencia.PRESENTE));

        // Mostrar información de las clases
        System.out.println("Información de las clases:");
        mostrarInformacionClase(clase1);
        mostrarInformacionClase(clase2);
        mostrarInformacionClase(clase3);

        // Obtener lista de asistentes y ausentes para una clase específica
        Collection<Estudiante> asistentes = curso.getAsistentes(clase1);
        Collection<Estudiante> ausentes = curso.getAusentes(clase1);

        // Mostrar resultados
        System.out.println("\nAsistentes a la clase 1:");
        mostrarListaEstudiantes(asistentes);

        System.out.println("\nAusentes en la clase 1:");
        mostrarListaEstudiantes(ausentes);

        // Mostrar asistentes y ausentes para clase 2 y clase 3
        System.out.println("\nAsistentes y ausentes para la clase 2:");
        mostrarInformacionAsistencia(curso, clase2);

        System.out.println("\nAsistentes y ausentes para la clase 3:");
        mostrarInformacionAsistencia(curso, clase3);
    }

    public static void mostrarInformacionClase(ClaseCurso clase) {
        LocalDateTime fecha = clase.getFechaClase();
        int year = fecha.getYear();
        int month = fecha.getMonthValue();
        int day = fecha.getDayOfMonth();

        System.out.println("Clase: " + day + "/" + month + "/" + year);
    }

    public static void mostrarListaEstudiantes(Collection<Estudiante> estudiantes) {
        if (estudiantes.isEmpty()) {
            System.out.println("Ninguno");
        } else {
            for (Estudiante estudiante : estudiantes) {
                System.out.println(estudiante.getNombres() + " " + estudiante.getApellidos());
            }
        }
    }

    public static void mostrarInformacionAsistencia(Curso curso, ClaseCurso clase) {
        Collection<Estudiante> asistentes = curso.getAsistentes(clase);
        Collection<Estudiante> ausentes = curso.getAusentes(clase);

        System.out.println("\nAsistentes:");
        mostrarListaEstudiantes(asistentes);

        System.out.println("\nAusentes:");
        mostrarListaEstudiantes(ausentes);
    }
}
