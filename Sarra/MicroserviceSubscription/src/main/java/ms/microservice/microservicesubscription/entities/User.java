package ms.microservice.microservicesubscription.entities;

import java.io.Serializable;
import lombok.*;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {
    int id;
    String username;
    String phone;
    String cin;
    String verificationCode;
    String email;
    String password;

}

