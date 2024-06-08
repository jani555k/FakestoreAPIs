package com.jr.fakestoreapis.Services;

import com.jr.fakestoreapis.DTO.FakestoreCategoryDTO;
import com.jr.fakestoreapis.DTO.FakestoreProductDTO;
import com.jr.fakestoreapis.Model.Category;
import com.jr.fakestoreapis.Model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FakestoreService implements ProductService{

    private final RestTemplate restTemplate;

    public FakestoreService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(long ID) {
        FakestoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + ID, FakestoreProductDTO.class);

        return fakeStoreProductDTO.ToProduct();
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        FakestoreProductDTO[] fakestoreProductDTOList = restTemplate.getForObject("https://fakestoreapi.com/products/category/" + category, FakestoreProductDTO[].class);
        List<Product> products = new ArrayList<>();
        for(int i=0; i<fakestoreProductDTOList.length; i++) {
            products.add(fakestoreProductDTOList[i].ToProduct());
        }

        return products;
    }

    @Override
    public List<Product> getAllProducts() {
        FakestoreProductDTO[] fakestoreProductDTOList = restTemplate.getForObject("https://fakestoreapi.com/products", FakestoreProductDTO[].class);
        List<Product> products = new ArrayList<>();
        for(int i=0; i<fakestoreProductDTOList.length; i++) {
            products.add(fakestoreProductDTOList[i].ToProduct());
        }

        return products;
    }

    @Override
    public List<String> getAllCategories() {
       //FakestoreCategoryDTO[] fakestoreCategoryDTOList = restTemplate.getForObject("https://fakestoreapi.com/products/categories", FakestoreCategoryDTO[].class);
        String[] fakestoreCategoryDTOList = restTemplate.getForObject("https://fakestoreapi.com/products/categories", String[].class);

       /* List<FakestoreCategoryDTO> categories = new ArrayList<>();
        for(int i=0; i<fakestoreCategoryDTOList.length; i++) {
            categories.add(fakestoreCategoryDTOList[i]);
        }*/

        return Arrays.asList(fakestoreCategoryDTOList);
    }

    @Override
    public void deleteProductById(long ID) {
        restTemplate.delete("https://fakestoreapi.com/products/" + ID);
    }

    @Override
    public Product addProduct(Product product) {
        FakestoreProductDTO fakestoreProductDTO =new FakestoreProductDTO();
            fakestoreProductDTO.setId(product.getID());
            fakestoreProductDTO.setTitle(product.getTitle());
            fakestoreProductDTO.setDescription(product.getDescription());
            fakestoreProductDTO.setPrice(product.getPrice());
            fakestoreProductDTO.setImage(product.getImageURL());
            fakestoreProductDTO.setCategory(product.getCategory().getCategoryName());

        FakestoreProductDTO productee = restTemplate.postForObject("https://fakestoreapi.com/products/", fakestoreProductDTO, FakestoreProductDTO.class);

        return productee.ToProduct();
    }

    @Override
    public Product updateProduct(long ID, Product product) {
        FakestoreProductDTO fakestoreProductDTO =new FakestoreProductDTO();
        fakestoreProductDTO.setId(product.getID());
        fakestoreProductDTO.setTitle(product.getTitle());
        fakestoreProductDTO.setDescription(product.getDescription());
        fakestoreProductDTO.setPrice(product.getPrice());
        fakestoreProductDTO.setImage(product.getImageURL());
        fakestoreProductDTO.setCategory(product.getCategory().getCategoryName());

        restTemplate.put("https://fakestoreapi.com/products/"+ID, fakestoreProductDTO);

        return getProductById(ID);
    }


}
