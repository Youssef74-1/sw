package EComm.SW.service;

import java.util.List;

import EComm.SW.entity.Category;
import EComm.SW.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;



public interface CategoryService {
    List<Category> getAllCategory();

    Category updatecatgegory(String categoryName, Category category) throws ResourceNotFoundException;

    ResponseEntity<?> deleteCategory(String categoryName) throws ResourceNotFoundException;

    Category createCategory(Category category);
}
