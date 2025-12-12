package com.ecommerce.ecomprodservicedec25.services;

import com.ecommerce.ecomprodservicedec25.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long productId);
    List<Product> getAllProducts();
}
