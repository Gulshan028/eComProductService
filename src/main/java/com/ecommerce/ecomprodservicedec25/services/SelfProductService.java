package com.ecommerce.ecomprodservicedec25.services;

import com.ecommerce.ecomprodservicedec25.exceptions.ProductNotFoundException;
import com.ecommerce.ecomprodservicedec25.models.Product;
import com.ecommerce.ecomprodservicedec25.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")    // here, we named this bean as "selfProductService"
//@Primary     ----> if we choose this "Primary" annotation then at all the reference of ProductService, this class' object will only be used
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(Long productId) throws ProductNotFoundException {
        //make a DB call to get the product with the given id
        //select * from product where id = 10;

        Optional<Product> optionalProduct = productRepository.findById(productId);

        //look, requested productId can be invalid. Hence, the jpaRepository returns the Optional<Product> which contains
        //the product, if the productId is valid. Otherwise, it is empty.
        //if this method had returned Product object instead. Then, in case of invalid productId, we would have gotten NullPointerException.

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with id:- "+productId+" doesn't exist.");
        }

        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
