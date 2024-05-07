package EComm.SW.service;

import EComm.SW.entity.Category;
import EComm.SW.exception.ResourceNotFoundException;
import EComm.SW.repository.CategoryRepo;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private static final Logger logger = LogManager.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryRepo categoryrepository;

    @Override
    public List<Category> getAllCategory() {
        logger.info("getAllCategory() method in service started");
        return categoryrepository.findAll();
    }

    @Override
    public ResponseEntity<?> deleteCategory(String categoryName) throws ResourceNotFoundException {
        return categoryrepository.findById(categoryName).map(category -> {
            logger.info("deleteCategory() method in service started");
            categoryrepository.delete(category);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("category Name " + categoryName + " not found"));

    }

    @Override
    public Category createCategory(Category category) {
        logger.info("createCategory() method in service started");
        return categoryrepository.save(category);
    }

    @Override
    public Category updatecatgegory(String categoryName, Category category) throws ResourceNotFoundException {
        return categoryrepository.findById(categoryName).map(c -> {
            logger.info("updatecatgegory() method in service started");
            c.setDescription(category.getDescription());
            return categoryrepository.save(category);
        }).orElseThrow(() -> new ResourceNotFoundException("categoryName " + categoryName + " not found"));
    }

}
