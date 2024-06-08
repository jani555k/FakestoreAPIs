package com.jr.fakestoreapis.DTO;

import com.jr.fakestoreapis.Model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FakestoreCategoryDTO {
    private int categoryID;
    private String categoryName;

    public Category ToCategory(){
        Category category = new Category();

        category.setCategoryName( this.categoryName);

        return category;
    }
}

