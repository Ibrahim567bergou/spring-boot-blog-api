package com.blog.blogrbac_system.service;

import com.blog.blogrbac_system.dto.request.CategoryRequest;
import com.blog.blogrbac_system.dto.response.CategoryResponse;
import java.util.List;
import java.util.Map;

public interface CategoryService {

    CategoryResponse saveCategory(CategoryRequest request);
    void deleteCategory(Integer id);
    List<CategoryResponse> getAll();
}
