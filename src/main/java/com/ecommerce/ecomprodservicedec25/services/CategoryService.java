package com.ecommerce.ecomprodservicedec25.services;

import com.ecommerce.ecomprodservicedec25.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
