package com.ecommerce.ecomprodservicedec25.services;

import com.ecommerce.ecomprodservicedec25.exceptions.ProductNotFoundException;
import com.ecommerce.ecomprodservicedec25.models.Category;
import com.ecommerce.ecomprodservicedec25.models.Product;
import com.ecommerce.ecomprodservicedec25.repositories.CategoryRepository;
import com.ecommerce.ecomprodservicedec25.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")    // here, we named this bean as "selfProductService".
//@Primary     ----> if we choose this "Primary" annotation then at all the references of ProductService, this class' object will be used, only.
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
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
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();
        //before saving the product in the DB, we must first check if the category is present in the DB or not
        //if YES then no need to do extra work or else we will need to save the category first in the DB

        Optional<Category> optionalCategory = categoryRepository.findByName(category.getName());
        if(optionalCategory.isEmpty()){
            //save the category in the DB
           category = categoryRepository.save(category);
        }else{
            category = optionalCategory.get();
        }
        product.setCategory(category);
        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException(
                    "Product with given id = " + id + "doesn't exist."
            );
        }

        Product productFromDB = optionalProduct.get();
        Category category = product.getCategory();
        if(category.getId() == null){
            category = categoryRepository.save(category);
        }
        productFromDB.setCategory(category);
        productFromDB.setDescription(product.getDescription());
        productFromDB.setPrice(product.getPrice());
        productFromDB.setTitle(product.getTitle());
        productFromDB.setImageUrl(product.getImageUrl());

        return productRepository.save(productFromDB);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
