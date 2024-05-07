package EComm.SW.controller;

import EComm.SW.entity.Cart;
import EComm.SW.entity.User;
import EComm.SW.repository.CartRepo;
import EComm.SW.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/details/{username}")
    public ResponseEntity<List<Cart>> getCartDetails(@PathVariable String username) {
        User user = userRepo.findById(username).orElse(null);
        if (user != null) {
            List<Cart> carts = cartRepo.findByUser(user);
            return new ResponseEntity<>(carts, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestBody Cart cart) {
        User user = userRepo.findById(cart.getUser().getUserName()).orElse(null);
        if (user != null) {
            cart.setUser(user);
            cartRepo.save(cart);
            return new ResponseEntity<>("Item added to cart", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete/{cartId}")
    public ResponseEntity<String> deleteCartItem(@PathVariable("cartId") Integer cartId) {
        Cart cart = cartRepo.findById(cartId).orElse(null);
        if (cart != null) {
            cartRepo.delete(cart);
            return new ResponseEntity<>("Item deleted from cart", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cart item not found", HttpStatus.NOT_FOUND);
        }
    }
}
