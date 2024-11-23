package ms.reclamation.microserviceproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Reclamation implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long idReclamation ;
    String Description ;
    LocalDate dateDeReclamation ;
    boolean status ;

    int userId;


}
