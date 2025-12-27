package com.ecommerce.ecomprodservicedec25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "products")    //here, defining the name of the table is completely optional. I did it, just to be informed about this.
public class Product extends BaseModel{
    private String title;
    private String description;
    private String imageUrl;
    private double price;
    @ManyToOne
    private Category category;

}
