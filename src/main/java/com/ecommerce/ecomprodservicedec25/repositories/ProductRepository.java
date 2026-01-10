package com.ecommerce.ecomprodservicedec25.repositories;

import com.ecommerce.ecomprodservicedec25.models.Category;
import com.ecommerce.ecomprodservicedec25.models.Product;
import com.ecommerce.ecomprodservicedec25.projections.ProductWithTitleAndPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long productId);
    //this method is equivalent to the query: "select * from products where id = productId;"


    Page<Product> findAll(Pageable pageable);     //select * from products;

    Optional<Product> findByTitleContains(String str);
    //QUERY: select * from products where title like '%str%';

    Optional<Product> findByCategory(Category category);

    Optional<Product> findByCategory_Id(Long categoryId);
    //"categoryId" is not the direct attribute of the Product model. However, it is the attribute of the
    //Category model. Hence, the above method shows this thing as "Category_Id", where Category is the model and 'Id' is its attribute.


    @Override
    Product save(Product product);

    @Override
    void deleteById(Long aLong);

    //// CUSTOM QUERIES
    //Ex:- SELECT title, price FROM products WHERE id = 10;
    //these kind of queries, where we are asking for only 2 attributes aren't present with JPA.
    //Thus, we need to write them manually. Let's look into this. There are two ways to do this,
    //viz. (i) HQL --> Hibernate Query Language; (ii) SQL --> Native Query / Structured Query Language
    //Let's see HQL first.

//    @Query("select p.title as title, p.price as price from Product p where p.title = :title and p.price = :price")
//    List<ProductWithTitleAndPrice> getProductTitleAndPrice(String title, Double price);


    //now, let's see the SQL Query; Remember, Native Query = SQL Query
    @Query(value = "select p.title as title, p.price as price from products p where p.title = :title and p.price = :price",  nativeQuery = true)
    List<ProductWithTitleAndPrice> getProductTitleAndPriceSQL(String title, Double price);
}
