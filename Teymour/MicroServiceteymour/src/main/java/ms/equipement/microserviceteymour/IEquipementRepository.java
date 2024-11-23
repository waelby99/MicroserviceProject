package ms.equipement.microserviceteymour;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEquipementRepository extends JpaRepository<Equipement,Long> {
    List<Equipement> findByUserId(int id);
}