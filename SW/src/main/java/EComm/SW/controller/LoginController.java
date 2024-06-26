package EComm.SW.controller;

import EComm.SW.entity.LoginRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
                 if ("username".equals(loginRequest.getUsername()) && "password".equals(loginRequest.getPassword())) {
            return "Login successful";
        } else {
            return "Invalid username or password";
        }
    }
}
