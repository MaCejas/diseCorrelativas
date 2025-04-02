package domain.correlativas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materias;


    public Inscripcion(List<Materia> materias, Alumno alumno) {
        this.materias = new ArrayList<>();
        this.alumno = alumno;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public Boolean aprobada() {

        return materias.stream().allMatch(materia -> materia.cumpleCorrelativas(new HashSet<>(alumno.getMateriasAprobadas())));
    }


}
