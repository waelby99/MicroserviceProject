package ms.piste.microserviceproject.controllers;

import lombok.AllArgsConstructor;
import ms.piste.microserviceproject.entities.Piste;
import ms.piste.microserviceproject.services.IPisteServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/piste")
@RestController
@AllArgsConstructor
public class PisteRestController {

    private IPisteServices pisteServices;

    @PostMapping("/{id}")
    public Piste addPiste(@RequestBody Piste piste,@PathVariable int id){
        return  pisteServices.addPiste(piste,id);
    }

    @GetMapping("/")
    public List<Piste> getAllPistes(){
        return pisteServices.retrieveAllPistes();
    }

    @PutMapping("/")
    public Piste updatePiste(@RequestBody Piste piste){
        return  pisteServices.updatePiste(piste);
    }

    @GetMapping("/{id-piste}")
    public Piste getById(@PathVariable("id-piste") Long numPiste){
        return pisteServices.retrievePiste(numPiste);
    }

    @DeleteMapping("/{id-piste}")
    public void deleteById(@PathVariable("id-piste") Long numPiste){
        pisteServices.removePiste(numPiste);
    }

    @GetMapping("/user/{id}")
    public List<Piste> getMesCourses(@PathVariable int id) {
        return pisteServices.mesPistes(id);
    }

}

