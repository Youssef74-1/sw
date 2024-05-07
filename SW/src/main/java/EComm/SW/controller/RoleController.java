package EComm.SW.controller;

import EComm.SW.entity.Role;
import EComm.SW.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/createNewRole")
    public ResponseEntity<Role> createNewRole(@RequestBody Role role) {
        // Check if the role name is provided
        if (role.getRoleName() == null || role.getRoleName().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // Call the service method to create the new role
        Role newRole = roleService.createNewRole(role);

        // Check if the role was created successfully
        if (newRole != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(newRole);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
