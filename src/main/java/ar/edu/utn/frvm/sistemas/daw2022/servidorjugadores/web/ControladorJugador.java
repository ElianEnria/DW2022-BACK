package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.web;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica.ServicioJugador;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Jugador;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
//@CrossOrigin(origins = "http://localhost:4200", methods = (RequestMethod.GET, RequestMethod.OPTIONS), maxAge = 3600)
@RequestMapping(value = "/jugadores")
@RestController
public class ControladorJugador {

    private ServicioJugador servicio;

    public ControladorJugador(ServicioJugador servicio) {
        this.servicio = servicio;
    }

    //GET todas
    @RequestMapping()
    public Object getJugadores() {
        return this.servicio.getJugadores();
    }
    @RequestMapping(params = {"filtro"})
    public Object getJugadores(@RequestParam(name = "filtro") String filtro) {
        log.info(filtro);
        System.out.println(filtro);
        return this.servicio.getJugadores();
    }
    //GET una
    @RequestMapping(value = "/{id}")
    public Jugador getJugador(@PathVariable("id") Integer id) {
        return this.servicio.getJugador(id);
    }
    //DELETE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable("id") Integer id) {
        this.servicio.eliminar(id);
    }
    //POST
    @RequestMapping(method = RequestMethod.POST)
    public Jugador guardar(@RequestBody Jugador j) {

        return this.servicio.guardar(j);
    }
    //PUT
    public Jugador actualizar(@RequestBody Jugador j) {
        return this.servicio.actualizar(j);
    }
}