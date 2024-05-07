package EComm.SW.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class User {

    @Id
    @NotBlank
    @NotNull
    private String userName;

    private String userFirstName;

    private String userLastName;

    private String Password;

    private String email;

    // Setter for Roles
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            }
    )
    private Set<Role> roles;

    public User(String userName, String userFirstName, String userLastName, String Password) {
        this.userName = userName;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.Password = Password;

        this.roles = new HashSet<>(); // Initialize roles to an empty set
    }

    // Empty Constructor
    public User() {
        this.roles = new HashSet<>();
    }
}
