package EComm.SW.controller;

import EComm.SW.entity.Category;
import EComm.SW.exception.ResourceNotFoundException;
import EComm.SW.service.CategoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorys")
public class CategoryController {

    private static final Logger logger = LogManager.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryservice;

    @GetMapping("/category")
    public List<Category> getAllCategory(Pageable pageable) {
        logger.info("getAllCategory() method started");
        return (List<Category>) categoryservice.getAllCategory();
    }

    @PostMapping("/category")
    public Category createCategory(@RequestBody Category category) {
        logger.info("createCategory() method started");
        return categoryservice.createCategory(category);
    }

    @DeleteMapping("/category/{categoryName}")
    public ResponseEntity<?> deleteCategory(@PathVariable String categoryName) throws ResourceNotFoundException {
        logger.info("deleteCategory() method started");
        return categoryservice.deleteCategory(categoryName);
    }

    @PutMapping("/category/{categoryName}")
    public Category updateCategory(@PathVariable String categoryName, @RequestBody Category category)
            throws ResourceNotFoundException {
        logger.info("updateCategory() method started");
        return categoryservice.updatecatgegory(categoryName, category);
    }
}