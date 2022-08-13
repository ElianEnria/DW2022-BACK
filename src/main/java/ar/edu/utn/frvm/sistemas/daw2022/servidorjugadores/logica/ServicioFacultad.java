package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Facultad;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioFacultad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ServicioFacultad {

    private RepositorioFacultad repositorio;
    public ServicioFacultad(RepositorioFacultad repositorio){
        this.repositorio = repositorio;

    }
    public Iterable<Facultad> getFacultades(){
        return this.repositorio.findAll();
    }
    public Iterable<Facultad> getFacultades(String filtro){
        return this.repositorio.findByNombre(filtro);
    }
//    public Iterable<Facultad> getFacultades(String filtro){
//        return this.repositorio.findByNombreIgnoreCase(filtro);
//    }
    public Facultad getFacultad(Integer id){
        //return new Facultad(1,"Mendoza", "FRM");
        Optional<Facultad> rta = this.repositorio.findById(id);
        if (rta.isPresent()){
            return rta.get();
        }
        return null;
    }

    public Facultad guardar(Facultad f) {
        return this.repositorio.save(f);
    }
    public Facultad actualizar(Facultad f) {
        return this.guardar(f);
    }
    public void eliminar(Integer id) {
        this.repositorio.deleteById(id);
    }

    public Page<Facultad> getFacultades(Pageable pagina) {
        return this.repositorio.findAll(pagina);
    }
}
