package ms.reclamation.microserviceproject.controllers;

import lombok.AllArgsConstructor;

import ms.reclamation.microserviceproject.entities.Reclamation;
import ms.reclamation.microserviceproject.services.IReclamationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/Reclamation")
@RestController
@AllArgsConstructor
public class ReclamationController {
    private IReclamationService iReclamationService;

    @PostMapping("/{id}")
    public Reclamation addReclamation(
            @RequestBody Reclamation r,@PathVariable int id){
        return iReclamationService.addReclamation(r,id);
    }

    @GetMapping("/")
    public List<Reclamation> getAllReclamation(){
        return iReclamationService.getAllReclamations();
    }

    @PutMapping("/")
    public Reclamation updateReclamation(@RequestBody Reclamation r) {
        return iReclamationService.updateReclamation(r);
    }

    @GetMapping("/{idReclamation}")
    public Reclamation findById(@PathVariable long idReclamation) {
        return iReclamationService.getReclamationById(idReclamation);
    }

    @DeleteMapping("/{idReclamation}")
    public void deleteReclamation(@PathVariable long idReclamation) {
        iReclamationService.deleteReclamation(idReclamation);
    }

    @GetMapping("/user/{id}")
    public List<Reclamation> getMesReclamations(@PathVariable int id) {
        return iReclamationService.getMesReclamations(id);
    }


}
