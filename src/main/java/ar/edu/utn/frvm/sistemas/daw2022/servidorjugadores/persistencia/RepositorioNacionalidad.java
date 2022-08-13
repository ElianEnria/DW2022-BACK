package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Nacionalidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioNacionalidad extends CrudRepository<Nacionalidad, Integer> {
    Iterable<Nacionalidad> findByNombre(String nombre);
    Iterable<Nacionalidad> findByNombreIgnoreCase(String nombre);
}