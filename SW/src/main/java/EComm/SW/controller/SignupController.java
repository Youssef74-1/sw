package EComm.SW.controller;

import EComm.SW.Dto.UserDto;
import EComm.SW.entity.User;
import EComm.SW.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SignupController {

    @Autowired
    private UserRepo userRepository;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserDto userDto) {
        if (userRepository.findByUserName(userDto.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        User user = new User();
        user.setUserName(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setUserFirstName(userDto.getFirstName());
        user.setUserLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());

        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }
}
