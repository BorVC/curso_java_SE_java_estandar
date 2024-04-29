package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Curso {
	private int idCurso;
	private String curso;
	private int duracion;
	private double precio;
	private List<Alumno> Alumnos;
}
