package com.ecommerce.ecomprodservicedec25.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import javax.xml.crypto.Data;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass //this annotation makes sure that the table for this class isn't created however its attributes are passed on to the child classes of this particular class
public class BaseModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //AUTO INCREMENT
    private Long id;
//    private Date createdAt;
//    private Date lastModifiedAt;
}
