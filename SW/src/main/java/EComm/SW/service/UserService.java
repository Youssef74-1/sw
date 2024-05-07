package EComm.SW.service;

import EComm.SW.entity.Role;
import EComm.SW.entity.User;
import EComm.SW.repository.RoleRepo;
import EComm.SW.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    public User createUser(User user) {
        // Validate user data
        if (user.getUserName() == null || user.getUserName().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        // Check if the user already exists
        if (userRepo.existsByUserName(user.getUserName())) {
            throw new RuntimeException("User with the provided username already exists");
        }

        // Retrieve the 'User' role
        Optional<Role> roleOptional = roleRepo.findByRoleName("User");

        if (roleOptional.isPresent()) {
            Role role = roleOptional.get();
            Set<Role> userRoles = new HashSet<>();
            userRoles.add(role);
            user.setRoles(userRoles);

            // Save the user
            return userRepo.save(user);
        } else {
            // Handle case where user role is not found
            throw new RuntimeException("User role not found");
        }
    }
    // Method to get user by ID
    public User getUserById(String id) {
        return userRepo.findById(id).orElse(null);
    }

    // Method to update user details
    public User updateUser(String id, User newUserDetails) {
        User existingUser = userRepo.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUserName(newUserDetails.getUserName());
            existingUser.setUserFirstName(newUserDetails.getUserFirstName());
            existingUser.setUserLastName(newUserDetails.getUserLastName());
            return userRepo.save(existingUser);
        }
        return null;
    }
    public void deleteUser(String id) {
        userRepo.deleteById(id);
    }



}