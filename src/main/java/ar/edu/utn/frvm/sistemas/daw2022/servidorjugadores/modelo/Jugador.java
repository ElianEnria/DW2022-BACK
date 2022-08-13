package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jugador {
    @Id
    @GeneratedValue()
    private Integer id;
    @NonNull
    private String nombre;
    @NonNull
    private String apellido;
    @NonNull
    private Integer legajo;
    @ManyToOne
    private Nacionalidad nacionalidad;
    @ManyToOne
    private Disciplina disciplina;
    @ManyToOne
    private Rol rol;
    @ManyToOne
    private Facultad facultad;

}