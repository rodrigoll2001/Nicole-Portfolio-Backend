package com.nicole_portfolio.service;

import com.nicole_portfolio.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    Category createCategory(Category category);
    Category updateCategory(Long id, Category categoryDetails);
    void deleteCategory(Long id);
}
