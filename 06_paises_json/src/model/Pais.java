package model;
import com.google.gson.annotations.SerializedName;

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

	@SerializedName("name")
	private String nombre;
	@SerializedName("region")
	private String continente;
	private String capital;
	@SerializedName("population")
	private Long habitantes;
	
	
}
