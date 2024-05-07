package EComm.SW.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import EComm.SW.entity.Product;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
@EnableJpaRepositories
public interface ProductRepo extends JpaRepository<Product, Long> {

    Page<Product> findByProductNameContainingIgnoreCaseOrProductDescriptionContainingIgnoreCase(String name, String description, Pageable pageable);
    Optional<Product> findByIdAndCategoryName(Long id, String categoryName);

    List<Product> findByCategoryName(String categoryName);
}

