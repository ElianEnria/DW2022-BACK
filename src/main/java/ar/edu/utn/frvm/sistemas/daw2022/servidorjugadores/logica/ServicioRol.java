package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Rol;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioDisciplina;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioJugador;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioNacionalidad;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioRol;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioRol {

    private RepositorioRol repositorio;

    public ServicioRol(RepositorioRol repositorio) {
        this.repositorio = repositorio;
    }

    public Iterable<Rol> getRoles() {
        return this.repositorio.findAll();
    }

    public Iterable<Rol> getRoles(String filtro) {
        return this.repositorio.findByNombreContaining(filtro);
    }

    public Rol getRol(Integer id) {
        Optional<Rol> rta = this.repositorio.findById(id);
        if (rta.isPresent()) {
            return rta.get();
        }
        return null;
    }

    public Rol getRolEstudiante() {
        Rol rta = this.repositorio.findByNombre("estudiante");
        if (rta != null) {
            return rta;
        }
        return null;
    }
    public Rol guardar(Rol d) {
        return this.repositorio.save(d);
    }

    public Rol actualizar(Rol d) {
        return this.guardar(d);
    }

    public void eliminar(Integer id) {
        this.repositorio.deleteById(id);
    }
}