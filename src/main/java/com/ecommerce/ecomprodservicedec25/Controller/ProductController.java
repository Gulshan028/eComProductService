package com.ecommerce.ecomprodservicedec25.Controller;

import com.ecommerce.ecomprodservicedec25.models.Product;
import com.ecommerce.ecomprodservicedec25.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product){
        return null;
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long productId, @RequestBody Product product){
        return null;
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long productId, @RequestBody Product product){
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long productId){

    }

}
