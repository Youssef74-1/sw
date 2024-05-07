package EComm.SW.repository;

import EComm.SW.entity.OrderDetail;
import EComm.SW.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepo extends CrudRepository<OrderDetail, Integer> {

    public List<OrderDetail> findByUser(User user);

}