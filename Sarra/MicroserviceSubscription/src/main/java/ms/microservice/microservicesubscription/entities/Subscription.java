package ms.microservice.microservicesubscription.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Builder
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Entity
public class Subscription implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long numSub;
    LocalDate startDate;
    LocalDate endDate;
    Float price;
    //@Enumerated(EnumType.STRING)
    TypeSubscription typeSub;

    int userId;
}
