package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.web;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica.ServicioFacultad;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Facultad;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@Slf4j
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(value = "/facultades")
@RestController
public class ControladorFacultad {

    private ServicioFacultad servicio;
    public ControladorFacultad(ServicioFacultad servicio){
        this.servicio = servicio;
    }

    //GET todas
    @RequestMapping()
    public Object getFacultades() {
        return this.servicio.getFacultades();
    }
    @RequestMapping(params = {"page"})
    public Page<Facultad> getFacultades(Pageable pagina) {
        return this.servicio.getFacultades(pagina);
    }
    @RequestMapping(params={"filtro"})
    public Iterable<Facultad> getFacultades(@RequestParam(name="filtro") String filtro){
        log.info(filtro);
        System.out.println(filtro);
        return this.servicio.getFacultades();
    }
    //GET una
    @RequestMapping(value = "/{id}")
    public Facultad getFacultad(@PathVariable("id") Integer id){
       // return new Facultad("Tucuman", "FRT");
        return this.servicio.getFacultad(id);
    }


    //DELETE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable("id") Integer id) {
        this.servicio.eliminar(id);
    }

    //POST
    @RequestMapping(method = RequestMethod.POST)
    public Facultad guardar(@RequestBody Facultad f){
        return this.servicio.guardar(f);
    }
    //PUT
    public Facultad actualizar(@RequestBody Facultad f){
        return this.servicio.actualizar(f);
    }
}
