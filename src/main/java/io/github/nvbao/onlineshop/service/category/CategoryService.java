package io.github.nvbao.onlineshop.service.category;


import io.github.nvbao.onlineshop.dto.request.category.CategoryCreateRequest;
import io.github.nvbao.onlineshop.dto.request.category.CategoryUpdateRequest;
import io.github.nvbao.onlineshop.entity.Category;
import io.github.nvbao.onlineshop.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category createCategory(CategoryCreateRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        return categoryRepository.save(category);
    }
    public Category findOrCreateCategory(Long categoryId) {
        if (categoryId != null) {
            return categoryRepository.findById(categoryId)
                    .orElseGet(() -> createCategory(new CategoryCreateRequest()));
        }
        return categoryRepository.findByName(new Category().getName())
                .orElseGet(() -> createCategory(new CategoryCreateRequest()));
    }
    public Optional<Category> updateCategory(Long categoryId, CategoryUpdateRequest request) {
        return getCategoryById(categoryId).map(category -> {
            category.setName(request.getName());
            return categoryRepository.save(category);
        });
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }


}
