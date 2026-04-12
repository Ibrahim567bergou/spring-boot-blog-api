package com.blog.blogrbac_system.controller;


import com.blog.blogrbac_system.dto.request.CategoryRequest;
import com.blog.blogrbac_system.service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blog.blogrbac_system.constant.RESPONSE;

@RestController
@AllArgsConstructor
@RequestMapping("${REST_NAME}/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<?> saveCategory(
            @Valid @RequestBody CategoryRequest request
    ){
        return RESPONSE.SUCCESS_MESSAGE(categoryService.saveCategory(request));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return RESPONSE.SUCCESS_MESSAGE(categoryService.getAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        categoryService.deleteCategory(id);
        return RESPONSE.DELETED_SUCCESS_MSG();
    }
}
