package EComm.SW.repository;

import EComm.SW.entity.Cart;
import EComm.SW.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends CrudRepository<Cart, Integer> {

    public List<Cart> findByUser(User user);

    void deleteAllByUser(User user);
}
