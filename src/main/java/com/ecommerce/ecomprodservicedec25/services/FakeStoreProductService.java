package com.ecommerce.ecomprodservicedec25.services;

import com.ecommerce.ecomprodservicedec25.dtos.FakeStoreProductDto;
import com.ecommerce.ecomprodservicedec25.exceptions.ProductNotFoundException;
import com.ecommerce.ecomprodservicedec25.models.Category;
import com.ecommerce.ecomprodservicedec25.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")    // here, we named this bean as "fakeStoreProductService"
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreDtoToProduct (FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());
        //Method 1: To set the Category
        //Category category = new Category();
        //category.setName(fakeStoreProductDto.getCategory());
        //product.setCategory(category);

        //Method 2:
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProductDto.getCategory());

        return product;

    }

    //this service implementation uses FakeStoreApi to fetch products
    @Override
    public Product getProductById(Long productId) throws ProductNotFoundException {
        //Make an API call to the FakeStoreApi to get the product with the given id
        //https://fakestoreapi.com/products/10

        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDto.class
        );

        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException(
                    "Product with id:- " + productId + " doesn't exist."
            );

        }

        //convert FakeStoreDto object into a Product object
        return convertFakeStoreDtoToProduct(fakeStoreProductDto);

        ////throw new RuntimeException("Something went wrong!!");
    }

    @Override
    public List<Product> getAllProducts() {
        //Method 1: by converting the api response into array as at runtime, type of array is preserved as Generics is only valid for Collections class and not to arrays
        FakeStoreProductDto[]  fakeStoreProductDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products", FakeStoreProductDto[].class
        );
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            products.add(convertFakeStoreDtoToProduct(fakeStoreProductDto));
        }

         //Method 2: by converting api response to general list, this solves the compilation error, but we get runtime error as ClassCastException.
        //I did this just to try out.
        /*
        List<FakeStoreProductDto> fakeStoreProductDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                List.class
        );
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertFakeStoreDtoToProduct(fakeStoreProductDto));
        }

         */
        return products;
    }
}
