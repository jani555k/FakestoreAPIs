package com.jr.fakestoreapis.Controller;

import com.jr.fakestoreapis.DTO.FakestoreCategoryDTO;
import com.jr.fakestoreapis.Model.Category;
import com.jr.fakestoreapis.Model.Product;
import com.jr.fakestoreapis.Services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/ProductByID/{ID}")
    public Product GetProductByID(@PathVariable ("ID")  long ID){
        return productService.getProductById(ID);
    }

    @GetMapping("/ProductByCategory/{category}")
    public List<Product> GetProductByTitle(@PathVariable ("category") String category){
        return productService.getProductByCategory(category);
    }

    @GetMapping("/GetAllProducts")
    public List<Product> GetAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/GetAllCategories")
    public List<String> GetAllCategories(){
        return productService.getAllCategories();
    }

    @DeleteMapping("DeleteProductByID/{ID}")
    public void DeleteProductByID(@PathVariable ("ID") long ID){
        productService.deleteProductById(ID);
    }

    @PostMapping("/AddProduct")
    public Product AddProduct(@RequestBody Product product){
       return productService.addProduct(product);
    }

    @PutMapping("/UpdateProduct/{ID}")
    public Product UpdateProduct(@PathVariable ("ID") long ID, @RequestBody Product product){
        return productService.updateProduct(ID, product);
    }

}

