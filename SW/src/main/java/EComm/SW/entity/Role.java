package EComm.SW.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Role {

    @Id
    private String roleName;
    private String roleDescription;

}
