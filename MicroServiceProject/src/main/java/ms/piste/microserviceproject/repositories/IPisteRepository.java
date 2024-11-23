package ms.piste.microserviceproject.repositories;

import ms.piste.microserviceproject.entities.Piste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPisteRepository extends JpaRepository<Piste, Long> {
    List<Piste> findByUserId(int id);
}
