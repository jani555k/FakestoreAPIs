package com.jr.fakestoreapis.Services;

import com.jr.fakestoreapis.DTO.FakestoreCategoryDTO;
import com.jr.fakestoreapis.Model.Category;
import com.jr.fakestoreapis.Model.Product;

import java.util.List;

public interface ProductService {
    public Product getProductById(long ID);
    public List<Product> getProductByCategory(String category);
    public List<Product> getAllProducts();
    public List<String> getAllCategories();
    public void deleteProductById(long ID);
    public Product addProduct(Product product);
    public Product updateProduct(long ID, Product product);
}
