package com.blog.blogrbac_system.controller;


import com.blog.blogrbac_system.constant.RESPONSE;
import com.blog.blogrbac_system.dto.request.ArticleCreateRequest;
import com.blog.blogrbac_system.dto.request.ArticleUpdateRequest;
import com.blog.blogrbac_system.service.ArticleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("${REST_NAME}/article")
@RestController
@AllArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping(value = "/create")
    public ResponseEntity<?> CreateArticle(
            @Valid @ModelAttribute ArticleCreateRequest request
    ){
        return RESPONSE.SUCCESS_MESSAGE(articleService.createArticle(request));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> updateArticle(
            @Valid @ModelAttribute ArticleUpdateRequest request
    ){
        return RESPONSE.SUCCESS_MESSAGE(articleService.updateArticle((request)));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> deleteArticle(
            @Valid @RequestParam(value ="reference", required = true) Integer id
    ){
        articleService.deleteArticle(id);
        return RESPONSE.DELETED_SUCCESS_MSG();
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllArticle(){
        return RESPONSE.SUCCESS_MESSAGE(articleService.getAllArticle());
    }
}
