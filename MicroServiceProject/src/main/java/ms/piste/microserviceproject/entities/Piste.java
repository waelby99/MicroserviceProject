package ms.piste.microserviceproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Piste implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long numPiste;
    String namePiste;
    @Enumerated(EnumType.STRING)
    Color color;
    int length;
    int slope;
    int userId;
}
