package com.ecommerce.ecomprodservicedec25.services;

import com.ecommerce.ecomprodservicedec25.exceptions.ProductNotFoundException;
import com.ecommerce.ecomprodservicedec25.models.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Long productId) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product createProduct(Product product);

    Product replaceProduct(Long id, Product product) throws ProductNotFoundException;

    void deleteProduct(Long id);

}
