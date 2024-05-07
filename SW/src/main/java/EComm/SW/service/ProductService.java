package EComm.SW.service;

import EComm.SW.entity.Product;
import EComm.SW.entity.User;
import EComm.SW.repository.CartRepo;
import EComm.SW.repository.ProductRepo;
import EComm.SW.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepository;

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private CartRepo cartRepository;

    public Product addNewProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(int pageNumber, String searchKey) {
        Pageable pageable = PageRequest.of(pageNumber, 8);

        if (searchKey == null || searchKey.isEmpty()) {
            return productRepository.findAll(pageable).getContent();
        } else {
            return (List<Product>) productRepository.findByProductNameContainingIgnoreCaseOrProductDescriptionContainingIgnoreCase(searchKey, searchKey, pageable);
        }
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    public List<Product> getProductDetails(boolean isSingleProductCheckout, Long productId, String username) {
        if (isSingleProductCheckout && productId != null && productId > 0) {
            Optional<Product> product = productRepository.findById(productId);
            return product.map(List::of).orElseGet(ArrayList::new);
        } else {
            Optional<User> userOptional = userRepository.findById(username);
            if (userOptional.isPresent()) {
                List<Product> productsInCart = cartRepository.findByUser(userOptional.get())
                        .stream()
                        .map(cart -> cart.getProduct())
                        .collect(Collectors.toList());
                return productsInCart;
            } else {
                return new ArrayList<>();
            }
        }
    }
}