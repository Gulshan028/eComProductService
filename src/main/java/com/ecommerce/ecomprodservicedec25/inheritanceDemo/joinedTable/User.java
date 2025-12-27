package com.ecommerce.ecomprodservicedec25.inheritanceDemo.joinedTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @Column(name = "user_id")
    private Long id;
    private String name;
    private String email;
    private String password;
}
