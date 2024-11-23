package ms.reclamation.microservice.entities;

import lombok.*;

import java.io.Serializable;
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
