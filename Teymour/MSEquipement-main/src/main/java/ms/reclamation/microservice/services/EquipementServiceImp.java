package ms.reclamation.microservice.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.reclamation.microservice.entities.Equipement;


import ms.reclamation.microservice.repositories.IEquipementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j

@Service
@AllArgsConstructor
public class EquipementServiceImp implements IEquipementService {


    private IEquipementRepository equipementReposiory;



    @Override
    public Equipement addEquipement(Equipement equipement) {

        return equipementReposiory.save(equipement);
    }

    @Override
    public List<Equipement> getAllEquipements() {
        return equipementReposiory.findAll();
    }

    @Override
    public List<Equipement> mesEquipements(int id) {
        return equipementReposiory.findByUserId(id);

    }


    @Override
    public void deleteEquipement(long idEquipement) {
        equipementReposiory.deleteById(idEquipement);
    }

    @Override
    public Equipement updateEquipement(Equipement equipement) {
        return equipementReposiory.save(equipement);
    }

    @Override
    public Equipement getEquipementById(long idEquipement) {
        return equipementReposiory.findById(idEquipement).orElse(null);
    }


}