package ms.reclamation.microserviceproject.repositories;


import ms.reclamation.microserviceproject.entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReclamationRepository extends JpaRepository<Reclamation,Long> {
    List<Reclamation> findByUserId(int id);

}
