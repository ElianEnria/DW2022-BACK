package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Disciplina;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDisciplina extends CrudRepository<Disciplina, Integer> {
    Iterable<Disciplina> findByNombre(String nombre);
    Iterable<Disciplina> findByNombreIgnoreCase(String nombre);
}