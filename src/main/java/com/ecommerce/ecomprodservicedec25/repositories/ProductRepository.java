package com.ecommerce.ecomprodservicedec25.repositories;

import com.ecommerce.ecomprodservicedec25.models.Category;
import com.ecommerce.ecomprodservicedec25.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long productId);
    //this method is equivalent to the query: "select * from products where id = productId;"

    @Override
    List<Product> findAll();

    Optional<Product> findByTitleContains(String str);
    //QUERY: select * from products where title like '%str%';

    Optional<Product> findByCategory(Category category);

    Optional<Product> findByCategory_Id(Long categoryId);
    //"categoryId" is not the direct attribute of the Product model. However, it is the attribute of the
    //Category model. Hence, the above method shows this thing as "Category_Id", where Category is the model and 'Id' is its attribute.





}
