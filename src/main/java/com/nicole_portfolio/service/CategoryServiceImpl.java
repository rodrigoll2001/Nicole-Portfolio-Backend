package com.nicole_portfolio.service;

import com.nicole_portfolio.entity.Category;
import com.nicole_portfolio.entity.Projects;
import com.nicole_portfolio.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findByActive("Y");
    }

    @Override
    public Category createCategory(Category category) {
        category.setActive("Y");
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category categoryDetails) {
        return categoryRepository.findById(id).map(category -> {
            category.setCategory(categoryDetails.getCategory());
            category.setActive(categoryDetails.getActive());
            return categoryRepository.save(category);
        }).orElse(null);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.findById(id).ifPresent(project -> {
            project.setActive("N");
            categoryRepository.save(project);
        });
    }
}
