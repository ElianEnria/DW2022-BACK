package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.web;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica.ServicioNacionalidad;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Nacionalidad;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(value = "/nacionalidades")
@RestController
public class ControladorNacionalidad {

    private ServicioNacionalidad servicio;

    public ControladorNacionalidad(ServicioNacionalidad servicio) {
        this.servicio = servicio;
    }

    //GET todas
    @RequestMapping()
    public Object getNacionalidades() {
        return this.servicio.getNacionalidades();
    }
    @RequestMapping(params = {"filtro"})
    public Object getNacionalidades(@RequestParam(name = "filtro") String filtro) {
        log.info(filtro);
        System.out.println(filtro);
        return this.servicio.getNacionalidades();
    }

    //GET una
    @RequestMapping(value = "/{id}")
    public Nacionalidad getNacionalidad(@PathVariable("id") Integer id) {
        return this.servicio.getNacionalidad(id);
    }
    //DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        this.servicio.eliminar(id);
    }

    //POST
    @RequestMapping(method = RequestMethod.POST)
    public Nacionalidad guardar(@RequestBody Nacionalidad n) {
        return this.servicio.guardar(n);
    }

    //PUT
    public Nacionalidad actualizar(@RequestBody Nacionalidad n) {
        return this.servicio.actualizar(n);
    }
}