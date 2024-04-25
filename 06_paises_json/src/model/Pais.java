package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
public class Pais {

	private String nombre;
	private String continente;
	private String capital;
	private int habitantes;
	
	
}
