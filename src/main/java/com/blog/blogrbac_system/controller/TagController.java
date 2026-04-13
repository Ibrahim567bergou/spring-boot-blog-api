package com.blog.blogrbac_system.controller;


import com.blog.blogrbac_system.constant.RESPONSE;
import com.blog.blogrbac_system.dto.request.TagRequest;
import com.blog.blogrbac_system.service.TagService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${REST_NAME}/tag")
@AllArgsConstructor
public class TagController {

    private final TagService tagService;

    @PostMapping("/create")
    public ResponseEntity<?> createTag(
            @RequestBody @Valid TagRequest request
    ){
        return RESPONSE.SUCCESS_MESSAGE(tagService.createTag(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTag(
            @PathVariable(required = true) Integer id,
            @RequestBody @Valid TagRequest request
    ){
        return RESPONSE.SUCCESS_MESSAGE(tagService.updateTag(id, request));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return RESPONSE.SUCCESS_MESSAGE(tagService.getAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        tagService.deleteTag(id);
        return RESPONSE.DELETED_SUCCESS_MSG();
    }
}
