package com.jr.fakestoreapis.DTO;

import com.jr.fakestoreapis.Model.Category;
import com.jr.fakestoreapis.Model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FakestoreProductDTO {
    private long id;
    private String title;
    private String price;
    private String description;
    private String category;
    private String image;

    public Product ToProduct(){
        Product product = new Product();
        product.setID(this.id);
        product.setTitle(this.title);
        product.setPrice(this.price);
        product.setDescription(this.description);
        product.setImageURL(this.image);

        Category category = new Category();
        category.setCategoryName(this.category);
        product.setCategory(category);

        return product;
    }
}


