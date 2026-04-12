package com.blog.blogrbac_system.service.Impl;


import com.blog.blogrbac_system.dto.request.CategoryRequest;
import com.blog.blogrbac_system.dto.response.CategoryResponse;
import com.blog.blogrbac_system.entity.Category;
import com.blog.blogrbac_system.exception.exceptions.AlreadyExistException;
import com.blog.blogrbac_system.exception.exceptions.CategoryNotFoundException;
import com.blog.blogrbac_system.mapper.CategoryMapper;
import com.blog.blogrbac_system.repository.CategoryRepository;
import com.blog.blogrbac_system.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponse saveCategory(CategoryRequest request) { //TODO check if user can edit thisCategory
        Category category;
        this.validateExistCategory(request.getName(), request.getId());
        if(request.getId() != null){
            category = this.getCategory(request.getId());
        }else{
            category = new Category();
            category.setCreatedAt(Instant.now());
        }
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        return categoryMapper.apply(categoryRepository.save(category));
    }


    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.delete(this.getCategory(id));
    }

    @Override
    public List<CategoryResponse> getAll() {  //TODO add pagination concept
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper)
                .toList();
    }

    private Category getCategory(Integer id){
        return categoryRepository.findById(id).orElseThrow(
                ()-> new CategoryNotFoundException(id)
        );
    }

    private void validateExistCategory(String name, Integer id){
        boolean exist;
        if(id == null){
            exist = categoryRepository.existsByName(name);
        }else{
            exist = categoryRepository.existsByNameAndIdNot(name, id);
        }
        if(exist){
            throw new AlreadyExistException("Category", name);
        }
    }
}
