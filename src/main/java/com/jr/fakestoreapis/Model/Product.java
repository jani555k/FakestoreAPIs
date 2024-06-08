package com.jr.fakestoreapis.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private long ID;
    private String title;
    private String Description;
    private String Price;
    private String ImageURL;
    private Category category;
}
