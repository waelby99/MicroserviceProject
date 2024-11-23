package ms.reclamation.microservice.services;

import ms.reclamation.microservice.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "MicroserviceEnCommun",url = "http://MicroserviceEnCommun:5000")
public interface UserClient {
    @GetMapping("/users/getUser/{id}")
    User getUserById(@PathVariable("id") int id);

    @GetMapping("/users/getAll")
    List<User> getAllUsers();

    @PostMapping("/users/addUser")
    User addUser(@RequestBody User user);
}
