package EComm.SW.service;

import EComm.SW.entity.Cart;
import EComm.SW.entity.Product;
import EComm.SW.entity.User;
import EComm.SW.repository.CartRepo;
import EComm.SW.repository.ProductRepo;
import EComm.SW.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private UserRepo userRepo;

    public void deleteCartItem(Integer cartId) {
        cartRepo.deleteById(cartId);
    }

    public Cart addToCart(Integer productId, String username) {
        Product product = productRepo.findById(Long.valueOf(productId)).orElse(null);
        User user = userRepo.findById(username).orElse(null);

        if (product != null && user != null) {
            List<Cart> cartList = cartRepo.findByUser(user);
            boolean alreadyInCart = cartList.stream()
                    .anyMatch(cart -> cart.getProduct().getId().equals(productId));

            if (alreadyInCart) {

                return null;
            }

            Cart cart = new Cart(product, user);
            return cartRepo.save(cart);
        }

        return null;
    }
}
