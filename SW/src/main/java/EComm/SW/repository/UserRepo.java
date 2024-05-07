package EComm.SW.repository;

import EComm.SW.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, String> {


    boolean existsByUserName(String UserName);
    User findByUserName(String userName);
}
