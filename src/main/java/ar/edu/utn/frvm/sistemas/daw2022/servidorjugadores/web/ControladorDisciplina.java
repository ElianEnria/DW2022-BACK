package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.web;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica.ServicioDisciplina;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Disciplina;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(value = "/disciplinas")
@RestController
public class ControladorDisciplina {

    private ServicioDisciplina servicio;

    public ControladorDisciplina(ServicioDisciplina servicio) {
        this.servicio = servicio;
    }

    //GET todas
    @RequestMapping()
    public Object getDisciplinas() {
        return this.servicio.getDisciplinas();
    }
    @RequestMapping(params = {"filtro"})
    public Object getDisciplinas(@RequestParam(name = "filtro") String filtro) {
        log.info(filtro);
        System.out.println(filtro);
        return this.servicio.getDisciplinas();
    }

    //GET una
    @RequestMapping(value = "/{id}")
    public Disciplina getDisciplina(@PathVariable("id") Integer id) {
        return this.servicio.getDisciplina(id);
    }
    //DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        this.servicio.eliminar(id);
    }

    //POST
    @RequestMapping(method = RequestMethod.POST)
    public Disciplina guardar(@RequestBody Disciplina d) {
        return this.servicio.guardar(d);
    }

    //PUT
    public Disciplina actualizar(@RequestBody Disciplina d) {
        return this.servicio.actualizar(d);
    }
}