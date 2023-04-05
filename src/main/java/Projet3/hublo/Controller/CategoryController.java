package Projet3.hublo.Controller;

import Projet3.hublo.Entity.Category;
import Projet3.hublo.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;
    @GetMapping("/categories")
    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable Long categoryId) {
        return categoryRepository.findById(categoryId).get();
    }
    @PostMapping("/categories")
    public Category create(@RequestBody Category category){
        return categoryRepository.save(category);
    }
    @PutMapping("/category/{id}")
    public  Category update(@PathVariable Long CategoryId, @RequestBody Category body) {
        Category categoryToUpdate = categoryRepository.findById(CategoryId).get();
        categoryToUpdate.setName(body.getName());
        return categoryRepository.save(categoryToUpdate);
    }
    @DeleteMapping("/category/{id}")
    public boolean deleteCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);
        return true;
    }
}
