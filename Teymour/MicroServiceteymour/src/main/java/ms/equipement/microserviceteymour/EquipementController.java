package ms.equipement.microserviceteymour;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Equipement")
@RestController
@AllArgsConstructor
public class EquipementController {
    private IEquipementService iEquipementService ;

    @PostMapping("/{id}")
    public Equipement addEquipement(
            @RequestBody Equipement equipement){
        return iEquipementService.addEquipement(equipement);
    }
    @GetMapping("/user/{id}")
    public List<Equipement> getMesEquipements(@PathVariable int id) {
        return iEquipementService.mesEquipements(id);
    }



    @GetMapping("/")
    public List<Equipement> getAllEquipement(){

        return iEquipementService.getAllEquipements();
    }

    @PutMapping("/")
    public Equipement updateEquipement(@RequestBody Equipement equipement) {
        return iEquipementService.updateEquipement(equipement);
    }

    @GetMapping("/{idEquipement}")
    public Equipement findById(@PathVariable long idEquipement) {
        return iEquipementService.getEquipementById(idEquipement);
    }

    @DeleteMapping("/{idEquipement}")
    public void deleteEquipement(@PathVariable long idEquipement) {

        iEquipementService.deleteEquipement(idEquipement);
    }




}

