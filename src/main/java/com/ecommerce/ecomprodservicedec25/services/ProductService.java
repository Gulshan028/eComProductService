package com.ecommerce.ecomprodservicedec25.services;

import com.ecommerce.ecomprodservicedec25.exceptions.ProductNotFoundException;
import com.ecommerce.ecomprodservicedec25.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public interface ProductService {

    Product getProductById(Long productId) throws ProductNotFoundException;

    Page<Product> getAllProducts(int pageNumber, int pageSize);

    Product createProduct(Product product);

    Product replaceProduct(Long id, Product product) throws ProductNotFoundException;

    void deleteProduct(Long id);

}
