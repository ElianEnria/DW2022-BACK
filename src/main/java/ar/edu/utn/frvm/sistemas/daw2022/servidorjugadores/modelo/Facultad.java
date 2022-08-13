package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Facultad {
	@Id
	@GeneratedValue
	private Integer id;

	@NonNull
	private String nombre;
	@NonNull
	private String codigo;

}
