package ms.reclamation.microservice.services;

import ms.reclamation.microservice.entities.Equipement;

import java.util.List;

public interface IEquipementService {
    Equipement addEquipement(Equipement equipement);

    public List<Equipement> getAllEquipements();
    List<Equipement> mesEquipements(int id);

    public Equipement getEquipementById(long idEquipement);

    public void deleteEquipement(long idEquipement);

    public Equipement updateEquipement(Equipement equipement);


}
