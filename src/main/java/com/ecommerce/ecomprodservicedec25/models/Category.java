package com.ecommerce.ecomprodservicedec25.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity      //here, i didn;t give the name to the table, hence the table name will be 'category', i.e. the name of the model itself
public class Category extends BaseModel {
    private String name;
}
