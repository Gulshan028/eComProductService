package com.ecommerce.ecomprodservicedec25;

import com.ecommerce.ecomprodservicedec25.models.Category;
import com.ecommerce.ecomprodservicedec25.models.Product;
import com.ecommerce.ecomprodservicedec25.projections.ProductWithTitleAndPrice;
import com.ecommerce.ecomprodservicedec25.repositories.CategoryRepository;
import com.ecommerce.ecomprodservicedec25.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class EcomProdServiceDec25ApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Test
    void contextLoads() {
//        List<ProductWithTitleAndPrice> products = productRepository.getProductTitleAndPriceSQL("iphone 15 pro", 100000.0);
//
//        for(ProductWithTitleAndPrice product : products){
//            System.out.println(product.getTitle() + "-->" + product.getPrice());
//        }

        Optional<Product> optionalProduct = productRepository.findById(8L);
        //System.out.println(optionalProduct.get());

        //Optional<Category> optionalCategory = categoryRepository.findById(4L);
    }

}
