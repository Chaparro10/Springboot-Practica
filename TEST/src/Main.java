import java.util.*;
import java.util.stream.*;

 class FiltrarEstudiantes {
    public static void main(String[] args) {

        List<Integer> calificaciones = Arrays.asList(85, 60, 72, 90, 45, 100);

        List<Integer> aprobados = calificaciones.stream()
                .filter(nota -> nota >= 70)
                .collect(Collectors.toList());

        if (aprobados.size() > 0) {
            System.out.println("Estudiantes aprobados:");
            aprobados.forEach(n -> System.out.println("Calificación: " + n));
        } else {
            System.out.println("Nadie aprobó 😢");
        }
    }
}