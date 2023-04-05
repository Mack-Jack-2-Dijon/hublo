package Projet3.hublo.Controller;

import Projet3.hublo.Entity.Category;
import Projet3.hublo.Entity.Product;
import Projet3.hublo.Repository.CategoryRepository;
import Projet3.hublo.Repository.ProductRepository;
import Projet3.hublo.Tools.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    CategoryRepository categoryRepository;
/*    @GetMapping("/products")
    public List<Product> getAll() { return  productRepository.findAll(); }
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Long productId) {
        return productRepository.findById(productId).get();
    } */

    //test
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @GetMapping("product/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @PutMapping("product/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        return productRepository.save(product);
    }

    @DeleteMapping("product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        productRepository.delete(product);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/categories/{categoryId}/products")
    public ResponseEntity<Product> createProduct(@PathVariable(value = "categoryId") Long categoryId, @RequestBody Product product) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            product.setCategory(category);
            Product createdProduct = productRepository.save(product);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(createdProduct.getId()).toUri();
            return ResponseEntity.created(location).body(createdProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
