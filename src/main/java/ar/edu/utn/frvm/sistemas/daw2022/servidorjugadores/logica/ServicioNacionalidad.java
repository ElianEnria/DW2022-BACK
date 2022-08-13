package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Nacionalidad;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioDisciplina;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioJugador;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioNacionalidad;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioNacionalidad {

    private RepositorioNacionalidad repositorio;

    public ServicioNacionalidad(RepositorioNacionalidad repositorio) {
        this.repositorio = repositorio;
    }

    public Iterable<Nacionalidad> getNacionalidades() {
        return this.repositorio.findAll();
    }

    public Iterable<Nacionalidad> getNacionalidades(String filtro) {
        return this.repositorio.findByNombre(filtro);
    }

    public Nacionalidad getNacionalidad(Integer id) {
        Optional<Nacionalidad> rta = this.repositorio.findById(id);
        if (rta.isPresent()) {
            return rta.get();
        }
        return null;
    }

    public Nacionalidad guardar(Nacionalidad d) {
        return this.repositorio.save(d);
    }

    public Nacionalidad actualizar(Nacionalidad d) {
        return this.guardar(d);
    }

    public void eliminar(Integer id) {
        this.repositorio.deleteById(id);
    }
}