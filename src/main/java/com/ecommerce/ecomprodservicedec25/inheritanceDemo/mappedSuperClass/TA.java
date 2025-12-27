package com.ecommerce.ecomprodservicedec25.inheritanceDemo.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_tas")
public class TA extends User{
    private int noOfHelpRequests;
}
