package EComm.SW.service;

import EComm.SW.entity.OrderDetail;
import EComm.SW.entity.OrderInput;
import EComm.SW.entity.Product;
import EComm.SW.entity.User;
import EComm.SW.repository.CartRepo;
import EComm.SW.repository.OrderDetailRepo;
import EComm.SW.repository.ProductRepo;
import EComm.SW.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import EComm.SW.entity.OrderProductQuantity;


import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {

    private static final String ORDER_PLACED = "Placed";

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CartRepo cartRepo;

    public List<OrderDetail> getAllOrderDetails() {
        return (List<OrderDetail>) orderDetailRepo.findAll();
    }

    public List<OrderDetail> getOrderDetailsForUser(String userId) {
        Optional<User> userOptional = userRepo.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return orderDetailRepo.findByUser(user);
        } else {
            // Handle case where user with given ID doesn't exist
            return null;
        }
    }

    public void placeOrder(OrderInput orderInput, boolean isSingleProductCheckout, String userId) {
        Optional<User> userOptional = userRepo.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            List<OrderInput.OrderProductQuantity> productQuantityList = orderInput.getOrderProductQuantityList();

            for (OrderInput.OrderProductQuantity o : productQuantityList) {
                Optional<Product> productOptional = productRepo.findById(o.getProductId());

                if (productOptional.isPresent()) {
                    Product product = productOptional.get();
                    double totalPrice = product.getPrice() * o.getQuantity();

                    OrderDetail orderDetail = new OrderDetail(
                            orderInput.getFullName(),
                            orderInput.getFullAddress(),
                            orderInput.getContactNumber(),
                            orderInput.getAlternateContactNumber(),
                            ORDER_PLACED,
                            totalPrice,
                            product,
                            user);

                    orderDetailRepo.save(orderDetail);
                }
            }

            if (!isSingleProductCheckout) {
                cartRepo.deleteAllByUser(user);
            }
        } else {
            // Handle case where user with given ID doesn't exist
        }
    }
}
