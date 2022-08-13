package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Disciplina;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioDisciplina;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioJugador;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioDisciplina {

    private RepositorioDisciplina repositorio;

    public ServicioDisciplina(RepositorioDisciplina repositorio) {
        this.repositorio = repositorio;
    }

    public Iterable<Disciplina> getDisciplinas() {
        return this.repositorio.findAll();
    }

    public Iterable<Disciplina> getDisciplinas(String filtro) {
        return this.repositorio.findByNombre(filtro);
    }

    public Disciplina getDisciplina(Integer id) {
        Optional<Disciplina> rta = this.repositorio.findById(id);
        if (rta.isPresent()) {
            return rta.get();
        }
        return null;
    }

    public Disciplina guardar(Disciplina d) {
        return this.repositorio.save(d);
    }

    public Disciplina actualizar(Disciplina d) {
        return this.guardar(d);
    }

    public void eliminar(Integer id) {
        this.repositorio.deleteById(id);
    }
}