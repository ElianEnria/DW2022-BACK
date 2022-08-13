package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.web;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica.ServicioRol;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Rol;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(value = "/roles")
@RestController
public class ControladorRol {

    private ServicioRol servicio;

    public ControladorRol(ServicioRol servicio) {
        this.servicio = servicio;
    }

    //GET todas
    @RequestMapping()
    public Object getRoles() {
        return this.servicio.getRoles();
    }
    @RequestMapping(params = {"filtro"})
    public Object getRoles(@RequestParam(name = "filtro") String filtro) {
        log.info(filtro);
        System.out.println(filtro);
        return this.servicio.getRoles();
    }

    //GET una
    @RequestMapping(value = "/{id}")
    public Rol getRol(@PathVariable("id") Integer id) {
        return this.servicio.getRol(id);
    }
    //DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        this.servicio.eliminar(id);
    }

    //POST
    @RequestMapping(method = RequestMethod.POST)
    public Rol guardar(@RequestBody Rol r) {
        return this.servicio.guardar(r);
    }

    //PUT
    public Rol actualizar(@RequestBody Rol r) {
        return this.servicio.actualizar(r);
    }
}