package ms.reclamation.microservice.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Entity
@Table(name = "equipement")
public class Equipement implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long idEquipement ;
    String typeEquipement ;
    LocalDate dateAchat ;
    boolean etatEquipement ;

    int userId;




}
