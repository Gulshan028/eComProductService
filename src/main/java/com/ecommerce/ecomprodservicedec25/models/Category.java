package com.ecommerce.ecomprodservicedec25.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity      //here, i didn;t give the name to the table, hence the table name will be 'category', i.e. the name of the model itself
public class Category extends BaseModel {
    @Column(unique = true)
    private String name;

//    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)     //mappedBy can only be used on @OneToMany side
//    private List<Product> products;
}
