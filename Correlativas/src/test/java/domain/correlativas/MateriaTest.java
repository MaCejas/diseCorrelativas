package domain.correlativas;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {

    @Test
    @DisplayName("Alumno tiene todas las correlativas necesarias para las materias seleccionadas")
    void aprobada() {

        Materia algoritmos = new Materia("Algoritmos");
        Materia paradigmas = new Materia("Paradigmas");
        Materia diseño = new Materia("Diseño");

        paradigmas.getCorrelativas().add(algoritmos);
        diseño.getCorrelativas().add(paradigmas);

        Alumno alumno = new Alumno("Juan");
        alumno.getMateriasAprobadas().add(algoritmos);
        alumno.getMateriasAprobadas().add(paradigmas);

        List<Materia> materias = new ArrayList<>();
        materias.add(diseño);

        Inscripcion inscripcion = new Inscripcion(materias, alumno);
        assertTrue(inscripcion.aprobada());
    }


@Test
@DisplayName("Alumno no tiene todas las correlativas necesarias para las materias seleccionadas")
public void inscripcionConMultiplesMateriasAlgunasIncorrectas() {
    Materia algoritmos = new Materia("Algoritmos");
    Materia paradigmas = new Materia("Paradigmas");
    Materia diseño = new Materia("Diseño");

    paradigmas.getCorrelativas().add(algoritmos);
    diseño.getCorrelativas().add(paradigmas);

    Alumno alumno = new Alumno("Carlos");
    alumno.getMateriasAprobadas().add(algoritmos); // Le falta paradigmas

    List<Materia> materias = new ArrayList<>();
    materias.add(paradigmas);
    materias.add(diseño);

    Inscripcion inscripcion = new Inscripcion(materias, alumno);
    assertFalse(inscripcion.aprobada());
}
}