package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Jugador;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioJugador;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioJugador {

    private ServicioRol servicioRol;
    private RepositorioJugador repositorio;

    public ServicioJugador(RepositorioJugador repositorio, ServicioRol servicioRol) {
        this.repositorio = repositorio;
        this.servicioRol = servicioRol;
    }

    public Iterable<Jugador> getJugadores() {
        return this.repositorio.findAll();
    }

    public Iterable<Jugador> getJugadores(String filtro) {
        return this.repositorio.findByNombre(filtro);
    }

    public Jugador getJugador(Integer id) {
        Optional<Jugador> rta = this.repositorio.findById(id);
        if (rta.isPresent()) {
            return rta.get();
        }
        return null;
    }

    public Jugador guardar(Jugador j) {
        j.setRol(this.servicioRol.getRolEstudiante());
        return this.repositorio.save(j);
    }

    public Jugador actualizar(Jugador j) {
        return this.guardar(j);
    }

    public void eliminar(Integer id) {
        this.repositorio.deleteById(id);
    }
}