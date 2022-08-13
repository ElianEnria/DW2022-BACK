package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Jugador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioJugador extends CrudRepository<Jugador, Integer> {
    Iterable<Jugador> findByNombre(String nombre);
    Iterable<Jugador> findByNombreIgnoreCase(String nombre);
}